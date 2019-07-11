import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

//public class Client extends JFrame implements MouseListener,MouseMotionListener {

class Actor {
    public static float hp;
    public static int Maxhp;

    void status(float hp, int maxhp) {
        this.hp = hp;
        this.Maxhp = maxhp;
    }
}

class PieceA {
    boolean exist = true;
    int x;
    int y;
    final int num = 4;

    void put(int x , int y) {
        this.x = x;
        this.y = y;
    }
}


public class Client extends JFrame implements MouseListener {

    private Container c;

    private JPanel player_Panel;
    private JLabel player_HPGAUGE;
    private String player_hp;
    private String player_maxhp;
    private JLabel player_MAXHP;
    private JLabel player_NAME;
    private JLabel player_HP;

    private JButton othello_piece_A;
    private JButton othello_piece_B;
    private JButton othello_piece_C;
    private JButton othello_piece_D;
    private JButton othello_piece_Normal;


    private JLayeredPane mainPane;
    private JLabel str_main;
    private JLabel pieceDescription;

    private JButton buttonArray[][];//ボタン用の配列

    private JPanel enemy_Panel;
    private JLabel enemy_HPGAUGE;
    private float hpWidth = 375;
    private String enemy_hp;
    private String enemy_maxhp;
    private JLabel enemy_MAXHP;
    private JLabel enemy_NAME;
    private JLabel enemy_HP;
    private double maxHpGaugeWidth;

    private ImageIcon blackIcon, whiteIcon, boardIcon, canPutIcon;
    private ImageIcon background_black;

    private ImageIcon reverseIcon1 = new ImageIcon("../assets/reverse/reverse_0001.jpg");
    private ImageIcon reverseIcon2 = new ImageIcon("../assets/reverse/reverse_0002.jpg");
    private ImageIcon reverseIcon3 = new ImageIcon("../assets/reverse/reverse_0003.jpg");
    private ImageIcon reverseIcon4 = new ImageIcon("../assets/reverse/reverse_0004.jpg");
    private ImageIcon reverseIcon5 = new ImageIcon("../assets/reverse/reverse_0005.jpg");
    private ImageIcon reverseIcon6 = new ImageIcon("../assets/reverse/reverse_0006.jpg");
    private ImageIcon reverseIcon7 = new ImageIcon("../assets/reverse/reverse_0007.jpg");
    private ImageIcon reverseIcon8 = new ImageIcon("../assets/reverse/reverse_0008.jpg");
    private ImageIcon reverseIcon9 = new ImageIcon("../assets/reverse/reverse_0009.jpg");
    private ImageIcon reverseIcon10 = new ImageIcon("../assets/reverse/reverse_0010.jpg");
    private ImageIcon reverseIcon11 = new ImageIcon("../assets/reverse/reverse_0011.jpg");
    private ImageIcon reverseIcon12 = new ImageIcon("../assets/reverse/reverse_0012.jpg");
    private ImageIcon reverseIcon13 = new ImageIcon("../assets/reverse/reverse_0013.jpg");
    private ImageIcon reverseIcon14 = new ImageIcon("../assets/reverse/reverse_0014.jpg");
    private ImageIcon reverseIcon15 = new ImageIcon("../assets/reverse/reverse_0015.jpg");
    private ImageIcon reverseIcon16 = new ImageIcon("../assets/reverse/reverse_0016.jpg");
    private ImageIcon reverseIcon17 = new ImageIcon("../assets/reverse/reverse_0017.jpg");
    private ImageIcon reverseIcon18 = new ImageIcon("../assets/reverse/reverse_0018.jpg");
    private ImageIcon reverseIcon19 = new ImageIcon("../assets/reverse/reverse_0019.jpg");
    private ImageIcon reverseIcon20 = new ImageIcon("../assets/reverse/reverse_0020.jpg");
    private ImageIcon reverseIcon21 = new ImageIcon("../assets/reverse/reverse_0021.jpg");
    private ImageIcon reverseIcon22 = new ImageIcon("../assets/reverse/reverse_0022.jpg");
    private ImageIcon reverseIcon23 = new ImageIcon("../assets/reverse/reverse_0023.jpg");
    private ImageIcon reverseIcon24 = new ImageIcon("../assets/reverse/reverse_0024.jpg");
    private ImageIcon[] reverseIcon = {reverseIcon1,reverseIcon2,reverseIcon3,reverseIcon4,reverseIcon5,reverseIcon6,reverseIcon7,reverseIcon8,reverseIcon9,reverseIcon10,reverseIcon11,reverseIcon12,reverseIcon13,reverseIcon14,reverseIcon15,reverseIcon16,reverseIcon17,reverseIcon18,reverseIcon19,reverseIcon20,reverseIcon21,reverseIcon22,reverseIcon23,reverseIcon24};

    private ImageIcon yourturnIcon1 = new ImageIcon("../assets/yourturn/yourturn_0001.png");
    private ImageIcon yourturnIcon2 = new ImageIcon("../assets/yourturn/yourturn_0002.png");
    private ImageIcon yourturnIcon3 = new ImageIcon("../assets/yourturn/yourturn_0003.png");
    private ImageIcon yourturnIcon4 = new ImageIcon("../assets/yourturn/yourturn_0004.png");
    private ImageIcon yourturnIcon5 = new ImageIcon("../assets/yourturn/yourturn_0005.png");
    private ImageIcon yourturnIcon6 = new ImageIcon("../assets/yourturn/yourturn_0006.png");
    private ImageIcon yourturnIcon7 = new ImageIcon("../assets/yourturn/yourturn_0007.png");
    private ImageIcon yourturnIcon8 = new ImageIcon("../assets/yourturn/yourturn_0008.png");
    private ImageIcon yourturnIcon9 = new ImageIcon("../assets/yourturn/yourturn_0009.png");
    private ImageIcon yourturnIcon10 = new ImageIcon("../assets/yourturn/yourturn_0010.png");
    private ImageIcon yourturnIcon11 = new ImageIcon("../assets/yourturn/yourturn_0011.png");
    private ImageIcon yourturnIcon12 = new ImageIcon("../assets/yourturn/yourturn_0012.png");
    private ImageIcon yourturnIcon13 = new ImageIcon("../assets/yourturn/yourturn_0013.png");
    private ImageIcon yourturnIcon14 = new ImageIcon("../assets/yourturn/yourturn_0014.png");
    private ImageIcon yourturnIcon15 = new ImageIcon("../assets/yourturn/yourturn_0015.png");
    private ImageIcon yourturnIcon16 = new ImageIcon("../assets/yourturn/yourturn_0016.png");
    private ImageIcon yourturnIcon17 = new ImageIcon("../assets/yourturn/yourturn_0017.png");
    private ImageIcon yourturnIcon18 = new ImageIcon("../assets/yourturn/yourturn_0018.png");
    private ImageIcon yourturnIcon19 = new ImageIcon("../assets/yourturn/yourturn_0019.png");
    private ImageIcon yourturnIcon20 = new ImageIcon("../assets/yourturn/yourturn_0020.png");
    private ImageIcon yourturnIcon21 = new ImageIcon("../assets/yourturn/yourturn_0021.png");
    private ImageIcon yourturnIcon22 = new ImageIcon("../assets/yourturn/yourturn_0022.png");
    private ImageIcon yourturnIcon23 = new ImageIcon("../assets/yourturn/yourturn_0023.png");
    private ImageIcon yourturnIcon24 = new ImageIcon("../assets/yourturn/yourturn_0024.png");
    private ImageIcon yourturnIcon25 = new ImageIcon("../assets/yourturn/yourturn_0025.png");
    private ImageIcon[] yourturnIcon = {yourturnIcon1,yourturnIcon2,yourturnIcon3,yourturnIcon4,yourturnIcon5,yourturnIcon6,yourturnIcon7,yourturnIcon8,yourturnIcon9,yourturnIcon10,yourturnIcon11,yourturnIcon12,yourturnIcon13,yourturnIcon14,yourturnIcon15,yourturnIcon16,yourturnIcon17,yourturnIcon18,yourturnIcon19,yourturnIcon20,yourturnIcon21,yourturnIcon22,yourturnIcon23,yourturnIcon24,yourturnIcon25} ;

    private ImageIcon myIcon, yourIcon, hpGauge_green, hpGauge_yellow, hpGauge_red;
    private int myColor;
    private boolean myTurn;
    private final int MASU = 8;
    private int reversedSum;
    private String msg;
    private boolean endGame = false;
    private Actor player = new Actor();
    private Actor enemy = new Actor();

    private float player0_hp;
    private float player1_hp;
    private float enemy0_hp;
    private float enemy1_hp;

    private int selected = 70;

    PrintWriter out;//出力用のライター

    public Client() {
        //名前の入力ダイアログを開く
        String myName = JOptionPane.showInputDialog(null, "名前を入力してください", "名前の入力", JOptionPane.QUESTION_MESSAGE);
        if (myName.equals("")) {
            myName = "No name";//名前がないときは，"No name"とする
        }

        //ウィンドウを作成する
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じるときに，正しく閉じるように設定する
        setTitle("Client");//ウィンドウのタイトルを設定する
        setSize(375, 500);//ウィンドウのサイズを設定する
        c = getContentPane();//フレームのペインを取得する

        //アイコンの設定
        whiteIcon = new ImageIcon("../assets/white.jpg");
        blackIcon = new ImageIcon("../assets/black.jpg");
        boardIcon = new ImageIcon("../assets/frame.jpg");
        hpGauge_green = new ImageIcon("../assets/hpguage/hp_green.jpg");
        hpGauge_yellow = new ImageIcon("../assets/hpguage/hp_yellow.jpg");
        hpGauge_red = new ImageIcon("../assets/hpguage/hp_red.jpg");
        canPutIcon = new ImageIcon("../assets/can-put-down.jpg");
        background_black = new ImageIcon("../assets/blackout.jpg");


        c.setLayout(null);//自動レイアウトの設定を行わない

        player.status(1000, 1000);
        enemy.status(1000, 1000);

        maxHpGaugeWidth = hpWidth / player.hp;

        player0_hp = player.hp;
        player1_hp = player.hp;
        enemy0_hp = enemy.hp;
        enemy1_hp = enemy.hp;

        //敵
        enemy_Panel = new JPanel();
        enemy_Panel.setLayout(null);

        enemy_NAME = new JLabel("enemy");
        enemy_NAME.setPreferredSize(new Dimension(130, 80));
        enemy_NAME.setBounds(10, 5, 80, 20);

        enemy_maxhp = Integer.toString(enemy.Maxhp);
        enemy_MAXHP = new JLabel("/" + (enemy_maxhp));
        enemy_MAXHP.setBounds(320, 55, 100, 10);

        enemy_hp = String.valueOf(enemy.hp);
        enemy_HP = new JLabel(enemy_hp);
        enemy_HP.setBounds(280, 55, 100, 10);

        enemy_HPGAUGE = new JLabel(hpGauge_green);
        int IntEnemy_hpWidth = (int) hpWidth;
        enemy_HPGAUGE.setBounds(0, 55, IntEnemy_hpWidth, 10);

        enemy_Panel.add(enemy_HP);
        enemy_Panel.add(enemy_MAXHP);
        enemy_Panel.add(enemy_NAME);
        enemy_Panel.add(enemy_HPGAUGE);
        enemy_Panel.setBounds(0, 0, IntEnemy_hpWidth, 70);
        c.add(enemy_Panel);


        mainPane = new JLayeredPane();

        //ボタンの生成
        buttonArray = new JButton[MASU][MASU];

        for (int y = 0; y < MASU; y++) {
            for (int x = 0; x < MASU; x++) {
                buttonArray[y][x] = new JButton(boardIcon);//ボタンにアイコンを設定する
                buttonArray[y][x].setBounds(x * 45, y * 45, 45, 45);//ボタンの大きさと位置を設定する．(x座標，y座標,xの幅,yの幅）
                mainPane.add(buttonArray[y][x]);
                mainPane.setLayer(buttonArray[y][x], 0);
                buttonArray[y][x].addMouseListener(this);//ボタンをマウスでさわったときに反応するようにする
                //               buttonArray[y][x].addMouseMotionListener(this);//ボタンをマウスで動かそうとしたときに反応するようにする
                buttonArray[y][x].setActionCommand(Integer.toString(y * MASU + x));
            }
        }

        //文字表示

        str_main = new JLabel();
        str_main.setPreferredSize(new Dimension(200, 200));
        str_main.setBounds(20, 20, 300, 300);
        mainPane.setLayer(str_main, 1);


        pieceDescription = new JLabel();
        pieceDescription.setPreferredSize(new Dimension(200, 200));
        pieceDescription.setBounds(80, 80, 200, 200);
        mainPane.setLayer((pieceDescription), 1);

        mainPane.add(str_main);
        mainPane.add(pieceDescription);

        mainPane.setBounds(0, 70, 375, 360);
        c.add(mainPane);

        //player
        player_Panel = new JPanel();
        player_Panel.setLayout(null);

//        player_NAME = new JLabel(myName);
//        player_NAME.setPreferredSize(new Dimension(130,80));
//        player_NAME.setBounds(5,10,80,20);

        player_maxhp = Integer.toString(player.Maxhp);
        player_MAXHP = new JLabel("/" + (player_maxhp));
        player_MAXHP.setBounds(320, 5, 100, 10);

        player_hp = String.valueOf(player.hp);
        player_HP = new JLabel(player_hp);
        player_HP.setBounds(280, 5, 100, 10);

        player_HPGAUGE = new JLabel(hpGauge_green);
        int IntPlayer_hpWidth = IntEnemy_hpWidth;
        player_HPGAUGE.setBounds(0, 5, IntPlayer_hpWidth, 10);

        othello_piece_Normal = new JButton(boardIcon);
        othello_piece_Normal.setBounds(15, 20, 50, 50);
        othello_piece_Normal.addMouseListener(this);
        othello_piece_Normal.setActionCommand(Integer.toString(70));

        othello_piece_A = new JButton(boardIcon);
        othello_piece_A.setBounds(85, 20, 50, 50);
        othello_piece_A.addMouseListener(this);
        othello_piece_A.setActionCommand(Integer.toString(71));

        othello_piece_B = new JButton(boardIcon);
        othello_piece_B.setBounds(155, 20, 50, 50);
        othello_piece_B.addMouseListener(this);
        othello_piece_B.setActionCommand(Integer.toString(72));

        othello_piece_C = new JButton(boardIcon);
        othello_piece_C.setBounds(225, 20, 50, 50);
        othello_piece_C.addMouseListener(this);
        othello_piece_C.setActionCommand(Integer.toString(73));

        othello_piece_D = new JButton(boardIcon);
        othello_piece_D.setBounds(295, 20, 50, 50);
        othello_piece_D.addMouseListener(this);
        othello_piece_D.setActionCommand(Integer.toString(74));


        player_Panel.add(player_HP);
        player_Panel.add(player_MAXHP);
//        player_Panel.add(player_NAME);
        player_Panel.add(player_HPGAUGE);

        player_Panel.add(othello_piece_Normal);
        player_Panel.add(othello_piece_A);
        player_Panel.add(othello_piece_B);
        player_Panel.add(othello_piece_C);
        player_Panel.add(othello_piece_D);

        player_Panel.setBounds(0, 430, 375, 70);

        c.add(player_Panel);

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

        private void sleep() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void longSleep() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //通信状況を監視し，受信データによって動作する
        public void run() {
            try {
                InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(sisr);
                out = new PrintWriter(socket.getOutputStream(), true);
                String myNumber = br.readLine();
                int myNumberInt = Integer.parseInt(myNumber);

                whichCome(myNumberInt);
                whichColor(myColor);

                othello_piece_Normal.setIcon(reverseIcon14);
                othello_piece_A.setIcon(myIcon);
                othello_piece_B.setIcon(myIcon);
                othello_piece_C.setIcon(myIcon);
                othello_piece_D.setIcon(myIcon);

                buttonArray[3][3].setIcon(whiteIcon);
                buttonArray[4][3].setIcon(blackIcon);
                buttonArray[4][4].setIcon(whiteIcon);
                buttonArray[3][4].setIcon(blackIcon);

                if (myTurn) {
                    buttonArray[3][2].setIcon(canPutIcon);
                    buttonArray[2][3].setIcon(canPutIcon);
                    buttonArray[5][4].setIcon(canPutIcon);
                    buttonArray[4][5].setIcon(canPutIcon);
                }

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
                                if (countPutDownStone()) {
                                    String msg = "RESULT";
                                    endGame = true;
                                    out.println(msg);
                                    out.flush();
                                }

                            }

                        }

                        if (cmd.equals("CANPUT")) {

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);

                            if (myTurn) {
                                if (buttonArray[y][x].getIcon() != blackIcon && buttonArray[y][x].getIcon() != whiteIcon) {
                                    buttonArray[y][x].setIcon(canPutIcon);
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
                            reversedSum = 0;

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);

                            if (myTurn) {
                                //送信元クライアントでの処理
                                buttonArray[y][x].setIcon(myIcon);
                            } else {
                                //送信先クライアントでの処理
                                buttonArray[y][x].setIcon(yourIcon);
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

                                for(ImageIcon i : reverseIcon) {
                                    buttonArray[y][x].setIcon(i);
                                    sleep();
                                }

                                buttonArray[y][x].setIcon(whiteIcon);

                            } else {

                                for(int i=reverseIcon.length-1 ; i>=0;i--) {
                                    buttonArray[y][x].setIcon(reverseIcon[i]);
                                    sleep();
                                }

                                buttonArray[y][x].setIcon(blackIcon);
                            }
                            reversedSum++;

                        }

                        if (cmd.equals("REVERSED")) {
                            if(selected==71){
                                PieceA pieceA = new PieceA();
  //                              pieceA.put(x,90);
                            }
                            double OffensivePower = 200;
                            double attackMagnification = 1.2;
                            for (int i = 0; i < reversedSum; i++) {
                                OffensivePower *= attackMagnification;
                            }
                            int damege = (int) OffensivePower;

                            if (myTurn == true) {
                                if (myColor == 0) {
                                    enemy1_hp -= damege;
                                    String strEnemy1_hp = String.valueOf((int) enemy1_hp);
                                    enemy_HP.setText(strEnemy1_hp);

                                    enemy_HPGAUGE.setBounds(0, 55, (int) (maxHpGaugeWidth * enemy1_hp), 10);
                                } else {
                                    enemy0_hp -= damege;
                                    String strEnemy0_hp = String.valueOf((int) enemy0_hp);
                                    enemy_HP.setText(strEnemy0_hp);

                                    enemy_HPGAUGE.setBounds(0, 55, (int) (maxHpGaugeWidth * enemy0_hp), 10);
                                }
                                myTurn = false;
                                for (int i = 0; i < MASU; i++) {
                                    for (int j = 0; j < MASU; j++) {
                                        if (buttonArray[i][j].getIcon() == canPutIcon) {
                                            buttonArray[i][j].setIcon(boardIcon);
                                        }
                                    }
                                }
                            } else {
                                if (myColor == 0) {
                                    player1_hp -= damege;
                                    String strPlayer1_hp = String.valueOf((int) player1_hp);
                                    player_HP.setText(strPlayer1_hp);

                                    player_HPGAUGE.setBounds(0, 5, (int) (maxHpGaugeWidth * player1_hp), 10);
                                } else {
                                    player0_hp -= damege;
                                    String strPlayer0_hp = String.valueOf((int) player0_hp);
                                    player_HP.setText(strPlayer0_hp);
                                    player_HPGAUGE.setBounds(0, 5, (int) (maxHpGaugeWidth * player0_hp), 10);
                                }


                                if (hpCheaker()) {
                                    String msg = "RESULT";
                                    endGame = true;
                                    out.println(msg);
                                    out.flush();
                                }
                                myTurn = true;
                                countPutDownStone();
                                if (endGame == false) {





                                    for(ImageIcon  i : yourturnIcon){
                                        str_main.setIcon(i);
                                        longSleep();
                                    }





                                    str_main.setIcon(null);
                                }
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
                    if (counter.blackCount > counter.blackCount || player1_hp < 0) {
                        System.out.println("you win");
                    } else {
                        System.out.println("you lose");
                    }
                } else {
                    if (counter.whiteCount > counter.blackCount || player0_hp < 0) {
                        System.out.println("you win");
                    } else {
                        System.out.println("you lose");
                    }
                }
                socket.close();
            } catch (IOException e) {
                System.err.println("エラーが発生しました: " + e);
            }
        }
    }


    public static void main(String[] args) {
        Client net = new Client();
        net.setVisible(true);
    }


    //----------------------------------------------------------------------------------------------

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

            countPutDownStone();

        }
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
            whiteCount = 1;
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
        // (x,y)に打てるのは確認済みなので相手の石は必ず
        x += vecX;
        y += vecY;
        while (buttonArray[y][x].getIcon() != myIcon) {
            // ひっくり返す
            msg = "REVERSE" + " " + myColor + " " + x + " " + y;
            out.println(msg);
            out.flush();

            x += vecX;
            y += vecY;
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

        int count = 0;
        int canPutX, canPutY;
        while (x >= 0 && x < MASU && y >= 0 && y < MASU) {

            count++;
            // 空白が見つかったら打てない（1つもはさめないから)
            if (buttonArray[y][x].getIcon() == boardIcon || buttonArray[y][x].getIcon() == canPutIcon)
                return false;
            // 自分の石があればはさめるので打てる
            if (buttonArray[y][x].getIcon() == myIcon) {
                canPutX = x - (vecX * (count + 1));
                canPutY = y - (vecY * (count + 1));
                String msg = "CANPUT" + " " + canPutX + " " + canPutY;
                out.println(msg);
                out.flush();
                return true;
            }
            x += vecX;
            y += vecY;
        }
        // 相手の石しかない場合はいずれ盤面の外にでてしまうのでこのfalse
        return false;
    }


    public boolean countPutDownStone() {
        int count = 0;

        for (int y = 0; y < MASU; y++) {
            for (int x = 0; x < MASU; x++) {
                if (canPutDown(x, y)) {
                    count++;
                }
            }
        }
        if (count == 0) {
            msg = "PASS";
            out.println(msg);//送信データをバッファに書き出す
            out.flush();
            return true;
        }
        return false;
    }

    public boolean hpCheaker() {

        if (player0_hp < 0 || player1_hp < 0) {
            return true;
        }
        return false;
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


        if (!endGame) {
            if (theArrayIndexInt == 70) {
                othello_piece_Normal.setIcon(reverseIcon14);
                othello_piece_A.setIcon(myIcon);
                othello_piece_B.setIcon(myIcon);
                othello_piece_C.setIcon(myIcon);
                othello_piece_D.setIcon(myIcon);
                selected = 70;
            }
            else if (theArrayIndexInt == 71) {
                othello_piece_Normal.setIcon(myIcon);
                othello_piece_A.setIcon(reverseIcon14);
                othello_piece_B.setIcon(myIcon);
                othello_piece_C.setIcon(myIcon);
                othello_piece_D.setIcon(myIcon);
                selected = 71;
            } else if (theArrayIndexInt == 72) {
                othello_piece_Normal.setIcon(myIcon);
                othello_piece_A.setIcon(myIcon);
                othello_piece_B.setIcon(reverseIcon14);
                othello_piece_C.setIcon(myIcon);
                othello_piece_D.setIcon(myIcon);
                selected = 72;
            } else if (theArrayIndexInt == 73) {
                othello_piece_Normal.setIcon(myIcon);
                othello_piece_A.setIcon(myIcon);
                othello_piece_B.setIcon(myIcon);
                othello_piece_C.setIcon(reverseIcon14);
                othello_piece_D.setIcon(myIcon);
                selected = 73;
            } else if (theArrayIndexInt == 74) {
                othello_piece_Normal.setIcon(myIcon);
                othello_piece_A.setIcon(myIcon);
                othello_piece_B.setIcon(myIcon);
                othello_piece_C.setIcon(myIcon);
                othello_piece_D.setIcon(reverseIcon14);
                selected = 74;
            }

            if (myTurn) {
                if (canPutDown(x, y)) {
                    msg = "PUSH" + " " + x + " " + y;
                    out.println(msg);//送信データをバッファに書き出す
                    out.flush();
                    msg = "FLIP" + " " + myColor + " " + x + " " + y;
                    out.println(msg);
                    out.flush();
                    reverse(x, y);
                    msg = "REVERSED";
                    out.println(msg);//送信データをバッファに書き出す
                    out.flush();
                } else {
                    System.out.println("そこには配置できません");
                }
            } else {
                System.out.println("今あなた違う");
            }
        }
    }

    public void mouseEntered(MouseEvent e) {//マウスがオブジェクトに入ったときの処理
        JButton theButton = (JButton) e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
        String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す
        int theArrayIndexInt = Integer.parseInt(theArrayIndex);
        if (theArrayIndexInt == 74) {
            pieceDescription.setIcon(background_black);
        }
    }

    public void mouseExited(MouseEvent e) {
        pieceDescription.setIcon(null);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

//    public void mouseDragged(MouseEvent e) {//マウスでオブジェクトとをドラッグしているときの処理
//    }

//    public void mouseMoved(MouseEvent e) {//マウスがオブジェクト上で移動したときの処理
//    }


}