import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

//public class MyClient extends JFrame implements MouseListener,MouseMotionListener {
public class MyClient extends JFrame implements MouseListener {
    private JButton buttonArray[][];//ボタン用の配列
    private Container c;
    private ImageIcon blackIcon, whiteIcon, boardIcon, canPutIcon;
    private ImageIcon myIcon, yourIcon;
    private int myColor;
    private boolean myTurn;
    private final int MASU = 8;
    private static final int END_NUMBER = 64;
    private String msg;
    private int count = 0;

    private int putNumber;

    PrintWriter out;//出力用のライター

    public MyClient() {
        //名前の入力ダイアログを開く
        String myName = JOptionPane.showInputDialog(null, "名前を入力してください", "名前の入力", JOptionPane.QUESTION_MESSAGE);
        if (myName.equals("")) {
            myName = "No name";//名前がないときは，"No name"とする
        }

        //ウィンドウを作成する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じるときに，正しく閉じるように設定する
        setTitle("MyClient");//ウィンドウのタイトルを設定する
        setSize(500, 500);//ウィンドウのサイズを設定する
        c = getContentPane();//フレームのペインを取得する

        //アイコンの設定
        whiteIcon = new ImageIcon("../assets/white.jpg");
        blackIcon = new ImageIcon("../assets/black.jpg");
        boardIcon = new ImageIcon("../assets/green-frame.jpg");
        canPutIcon = new ImageIcon("../assets/can-put-down.png");

        c.setLayout(null);//自動レイアウトの設定を行わない
        //ボタンの生成
        buttonArray = new JButton[MASU][MASU];//ボタンの配列を５個作成する[0]から[4]まで使える

        for (int y = 0; y < MASU; y++) {
            for (int x = 0; x < MASU; x++) {
                buttonArray[y][x] = new JButton(boardIcon);//ボタンにアイコンを設定する
                c.add(buttonArray[y][x]);//ペインに貼り付ける
                buttonArray[y][x].setBounds(x * 45, 10 + y * 45, 45, 45);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
                buttonArray[y][x].addMouseListener(this);//ボタンをマウスでさわったときに反応するようにする
                //               buttonArray[y][x].addMouseMotionListener(this);//ボタンをマウスで動かそうとしたときに反応するようにする
                buttonArray[y][x].setActionCommand(Integer.toString(y * MASU + x));
            }
        }

        //サーバに接続する
        Socket socket = null;
        try {
            //"localhost"は，自分内部への接続．localhostを接続先のIP Address（"133.42.155.201"形式）に設定すると他のPCのサーバと通信できる
            //10000はポート番号．IP Addressで接続するPCを決めて，ポート番号でそのPC上動作するプログラムを特定する
            socket = new Socket("localhost", 10000);
        } catch (UnknownHostException e) {
            System.err.println("ホストの IP アドレスが判定できません: " + e);
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e);
        }

        MesgRecvThread mrt = new MesgRecvThread(socket, myName);//受信用のスレッドを作成する
        mrt.start();//スレッドを動かす（Runが動く）
    }

    //メッセージ受信のためのスレッド
    public class MesgRecvThread extends Thread {

        Socket socket;
        String myName;

        public MesgRecvThread(Socket s, String n) {
            socket = s;
            myName = n;
        }

        //通信状況を監視し，受信データによって動作する
        public void run() {
            try {
                InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(sisr);
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(myName);//接続の最初に名前を送る
                String myNumber = br.readLine();
                int myNumberInt = Integer.parseInt(myNumber);

                whichCome(myNumberInt);
                whichColor(myColor);

                buttonArray[3][3].setIcon(whiteIcon);
                buttonArray[4][3].setIcon(blackIcon);
                buttonArray[4][4].setIcon(whiteIcon);
                buttonArray[3][4].setIcon(blackIcon);


                while (true) {

                    String inputLine = br.readLine();//データを一行分だけ読み込んでみる
                    if (inputLine != null) {//読み込んだときにデータが読み込まれたかどうかをチェックする
                        System.out.println(inputLine);//デバッグ（動作確認用）にコンソールに出力する
                        String[] inputTokens = inputLine.split(" ");    //入力データを解析するために、スペースで切り分ける
                        String cmd = inputTokens[0];//コマンドの取り出し．１つ目の要素を取り出す

                        if (cmd.equals("PASS")) {

                            if (myTurn == true) {
                                myTurn = false;
                            } else {
                                myTurn = true;
                            }

                        }

                        if (cmd.equals("CANPUT")) {

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);
                            int ax = x - (2 * Integer.parseInt(inputTokens[3]));
                            int ay = y - (2 * Integer.parseInt(inputTokens[4]));

                            if (myTurn) {
                                if (buttonArray[ay][ax].getIcon() != blackIcon && buttonArray[ay][ax].getIcon() != whiteIcon) {
                                    buttonArray[ay][ax].setIcon(canPutIcon);
                                }
                            } else {
                                for (int i = 0; i < MASU; i++) {
                                    for (int j = 0; j < MASU; j++) {
                                        if (buttonArray[i][j].getIcon() == canPutIcon) {
                                            buttonArray[i][j].setIcon(boardIcon);
                                        }
                                    }
                                }
                            }

                        }

                        if (cmd.equals("PUSH")) {

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);
                            putNumber++;
                            System.out.println(putNumber);

                            if (buttonArray[y][x].getIcon() != blackIcon && buttonArray[y][x].getIcon() != whiteIcon) {
                                if (myTurn == true) {
                                    //送信元クライアントでの処理
                                    buttonArray[y][x].setIcon(myIcon);
                                    myTurn = false;
                                    count = 0;
                                } else {
                                    //送信先クライアントでの処理
                                    buttonArray[y][x].setIcon(yourIcon);
                                    myTurn = true;
                                }
                            }
                        }

                        if (cmd.equals("FLIP")) {
                            String colorNum = inputTokens[1];//ボタンの名前（番号）の取得
                            int colorNumInt = Integer.parseInt(colorNum);//ボタンの名前を数値に変換する

                            int x = Integer.parseInt(inputTokens[2]);
                            int y = Integer.parseInt(inputTokens[3]);

                            if (colorNumInt == 1) {
                                buttonArray[y][x].setIcon(whiteIcon);
                            } else {
                                buttonArray[y][x].setIcon(blackIcon);
                            }
                        }

                        if (cmd.equals("REVERSE")) {
                            String colorNum = inputTokens[1];//ボタンの名前（番号）の取得
                            int colorNumInt = Integer.parseInt(colorNum);//ボタンの名前を数値に変換する

                            int x = Integer.parseInt(inputTokens[2]);
                            int y = Integer.parseInt(inputTokens[3]);

                            if (colorNumInt == 1) {
                                buttonArray[y][x].setIcon(whiteIcon);
                            } else {
                                buttonArray[y][x].setIcon(blackIcon);
                            }

                            if (countPutDownStone() == 0) {
                                count++;
                                if (count >= 2) {
                                    endGame();
                                }
                                msg = "PASS";
                                out.println(msg);//送信データをバッファに書き出す
                                out.flush();
                            }
                            if (putNumber == END_NUMBER) {
                                endGame();
                            }
                        }
                        if (cmd.equals("RESULT")) {
                            break;
                        }

                    } else {
                        break;
                    }
                }

                Counter counter;
                counter = countStone();
                if (myIcon == blackIcon) {
                    if (counter.blackCount > 32) {
                        System.out.println("you win");
                    } else if (counter.blackCount < 32) {
                        System.out.println("you lose");
                    } else {
                        System.out.println("引き分け");
                    }
                } else {
                    if (counter.whiteCount > 32) {
                        System.out.println("you win");
                    } else if (counter.whiteCount < 32) {
                        System.out.println("you lose");
                    } else {
                        System.out.println("引き分け");
                    }
                }

                socket.close();
            } catch (IOException e) {
                System.err.println("エラーが発生しました: " + e);
            }
        }
    }


    public static void main(String[] args) {
        MyClient net = new MyClient();
        net.setVisible(true);
    }

    private void whichCome(int num) {
        if (num % 2 != 0) {
            myColor = 0;
            myTurn = true;
        } else if (num % 2 == 0) {
            myColor = 1;
            myTurn = false;
        }
    }

    private void whichColor(int num) {
        if (num == 0) {
            myIcon = blackIcon;
            yourIcon = whiteIcon;
        } else if (num == 1) {
            myIcon = whiteIcon;
            yourIcon = blackIcon;
        }
    }

    private boolean endGame() {
        // 打たれた石の数が60個（全部埋まった状態）以外は何もしない
            String msg = "RESULT";
            out.println(msg);
            out.flush();
            return true;
    }

    private Counter countStone() {
        Counter counter = new Counter();

        for (int y = 0; y < MASU; y++) {
            for (int x = 0; x < MASU; x++) {
                if (buttonArray[y][x].getIcon() == blackIcon)
                    counter.blackCount++;
                if (buttonArray[y][x].getIcon() == whiteIcon)
                    counter.whiteCount++;
            }
        }

        return counter;
    }

    private class Counter {
        public int blackCount;
        public int whiteCount;

        public Counter() {
            blackCount = 0;
            whiteCount = 0;
        }
    }

    private void reverse(int x, int y) {
        // ひっくり返せる石がある方向はすべてひっくり返す
        if (canPutDown(x, y, 1, 0)) reverse(x, y, 1, 0);
        if (canPutDown(x, y, 0, 1)) reverse(x, y, 0, 1);
        if (canPutDown(x, y, -1, 0)) reverse(x, y, -1, 0);
        if (canPutDown(x, y, 0, -1)) reverse(x, y, 0, -1);
        if (canPutDown(x, y, 1, 1)) reverse(x, y, 1, 1);
        if (canPutDown(x, y, -1, -1)) reverse(x, y, -1, -1);
        if (canPutDown(x, y, 1, -1)) reverse(x, y, 1, -1);
        if (canPutDown(x, y, -1, 1)) reverse(x, y, -1, 1);
    }

    private void reverse(int x, int y, int vecX, int vecY) {
        // 相手の石がある間ひっくり返し続ける
        // (x,y)に打てるのは確認済みなので相手の石は必ずある
        x += vecX;
        y += vecY;
        while (buttonArray[y][x].getIcon() != myIcon) {
            // ひっくり返す
            buttonArray[y][x].setIcon(myIcon);
            msg = "REVERSE" + " " + myColor + " " + x + " " + y;
            out.println(msg);

            //    update(getGraphics());
            // 小休止を入れる（入れないと複数の石が一斉にひっくり返されてしまう）
            sleep();
            x += vecX;
            y += vecY;
        }
    }

    private static final int SLEEP_TIME = 50;

    private void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean canPutDown(int x, int y) {
        // (x,y)にすでに石が打たれてたら打てない
        if (buttonArray[y][x].getIcon() == whiteIcon || buttonArray[y][x].getIcon() == blackIcon)
            return false;
        // 8方向のうち一箇所でもひっくり返せればこの場所に打てる
        // ひっくり返せるかどうかはもう1つのcanPutDownで調べる

        if (canPutDown(x, y, 1, -1))
            return true; // 右上
        if (canPutDown(x, y, 1, 0))
            return true; // 右
        if (canPutDown(x, y, 1, 1))
            return true; // 右下
        if (canPutDown(x, y, 0, 1))
            return true; // 下
        if (canPutDown(x, y, -1, 1))
            return true; // 左下
        if (canPutDown(x, y, -1, 0))
            return true; // 左
        if (canPutDown(x, y, -1, -1))
            return true; // 左上
        if (canPutDown(x, y, 0, -1))
            return true; // 上

        // どの方向もだめな場合はここには打てない
        return false;
    }

    private boolean canPutDown(int x, int y, int vecX, int vecY) {

        // 隣の場所へ。どの隣かは(vecX, vecY)が決める。
        x += vecX;
        y += vecY;
        // 盤面外だったら打てない
        if (x < 0 || x >= MASU || y < 0 || y >= MASU)
            return false;
        // 隣が自分の石の場合は打てない
        if (buttonArray[y][x].getIcon() == myIcon)
            return false;
        // 隣が空白の場合は打てない
        if (buttonArray[y][x].getIcon() == boardIcon || buttonArray[y][x].getIcon() == canPutIcon)
            return false;
        // さらに隣を調べていく

        x += vecX;
        y += vecY;
        // となりに石がある間ループがまわる
        while (x >= 0 && x < MASU && y >= 0 && y < MASU) {

            // 空白が見つかったら打てない（1つもはさめないから）
            if (buttonArray[y][x].getIcon() == boardIcon || buttonArray[y][x].getIcon() == canPutIcon)
                return false;
            // 自分の石があればはさめるので打てる
            if (buttonArray[y][x].getIcon() == myIcon) {
                if (myTurn) {
                    String msg = "CANPUT" + " " + x + " " + y + " " + vecX + " " + vecY;
                    out.println(msg);
                    out.flush();
                }
                return true;
            }
            x += vecX;
            y += vecY;
        }
        // 相手の石しかない場合はいずれ盤面の外にでてしまうのでこのfalse
        return false;
    }

    public int countPutDownStone() {
        int count = 0;

        for (int y = 0; y < MASU; y++) {
            for (int x = 0; x < MASU; x++) {
                if (canPutDown(x, y)) {
                    count++;
                }
            }
        }
        return count;
    }


    public void mouseClicked(MouseEvent e) {//ボタンをクリックしたときの処理
        System.out.println("クリック");
        JButton theButton = (JButton) e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
        String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す
        int theArrayIndexInt = Integer.parseInt(theArrayIndex);
        int y = theArrayIndexInt / MASU;
        int x = theArrayIndexInt % MASU;

        Icon theIcon = theButton.getIcon();//theIconには，現在のボタンに設定されたアイコンが入る
        System.out.println(theIcon);//デバッグ（確認用）に，クリックしたアイコンの名前を出力する

        if (myTurn && !endGame()) {
            if (canPutDown(x, y)) {

                msg = "PUSH" + " " + x + " " + y;
                out.println(msg);//送信データをバッファに書き出す
                msg = "FLIP" + " " + myColor + " " + x + " " + y;
                out.println(msg);
                reverse(x, y);
                out.flush();

            } else {
                System.out.println("そこには配置できません");
            }
        } else {
            System.out.println("今あなた違う");
        }

    }


    public void mouseEntered(MouseEvent e) {//マウスがオブジェクトに入ったときの処理
        //    System.out.println("マウスが入った");
    }

    public void mouseExited(MouseEvent e) {//マウスがオブジェクトから出たときの処理
        //    System.out.println("マウス脱出");
    }

    public void mousePressed(MouseEvent e) {//マウスでオブジェクトを押したときの処理（クリックとの違いに注意）
        //    System.out.println("マウスを押した");
    }

    public void mouseReleased(MouseEvent e) {//マウスで押していたオブジェクトを離したときの処理
        //    System.out.println("マウスを放した");
    }

//    public void mouseDragged(MouseEvent e) {//マウスでオブジェクトとをドラッグしているときの処理
//        System.out.println("マウスをドラッグ");
//        JButton theButton = (JButton)e.getComponent();//型が違うのでキャストする
//        String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す
//
//        Point theMLoc = e.getPoint();//発生元コンポーネントを基準とする相対座標
//        System.out.println(theMLoc);//デバッグ（確認用）に，取得したマウスの位置をコンソールに出力する
//        Point theBtnLocation = theButton.getLocation();//クリックしたボタンを座標を取得する
//        theBtnLocation.x += theMLoc.x-15;//ボタンの真ん中当たりにマウスカーソルがくるように補正する
//        theBtnLocation.y += theMLoc.y-15;//ボタンの真ん中当たりにマウスカーソルがくるように補正する
//
//        //送信情報を作成する（受信時には，この送った順番にデータを取り出す．スペースがデータの区切りとなる）
//        String msg = "MOVE"+" "+theArrayIndex+" "+theBtnLocation.x+" "+theBtnLocation.y;
//
//        //サーバに情報を送る
//        out.println(msg);//送信データをバッファに書き出す
//        out.flush();//送信データをフラッシュ（ネットワーク上にはき出す）する
//
//        repaint();//オブジェクトの再描画を行う
//    }

//    public void mouseMoved(MouseEvent e) {//マウスがオブジェクト上で移動したときの処理
//        System.out.println("マウス移動");
//        int theMLocX = e.getX();//マウスのx座標を得る
//        int theMLocY = e.getY();//マウスのy座標を得る
//        System.out.println(theMLocX+","+theMLocY);//コンソールに出力する
//    }
}