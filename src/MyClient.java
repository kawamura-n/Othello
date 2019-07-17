import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//public class MyClient extends JFrame implements MouseListener,MouseMotionListener {
class Actor {
    public static int hp;
    public static int Maxhp;

    void status(int hp, int maxhp) {
        this.hp = hp;
        this.Maxhp = maxhp;
    }
}

public class MyClient extends JFrame implements MouseListener {

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
    private ImageIcon white_selectedIcon;
    private ImageIcon black_selectedIcon;
    private ImageIcon white_noSelectedIcon;
    private ImageIcon black_noSelectedIcon;
    private ImageIcon cat_black_noSelectedIcon, cat_black_selectedIcon, cat_white_noSelectedIcon, cat_white_selectedIcon;
    private ImageIcon boar_black_noSelectedIcon, boar_black_selectedIcon, boar_white_noSelectedIcon, boar_white_selectedIcon;
    private ImageIcon horse_black_noSelectedIcon, horse_black_selectedIcon, horse_white_noSelectedIcon, horse_white_selectedIcon;
    private ImageIcon bird_black_noSelectedIcon, bird_black_selectedIcon, bird_white_noSelectedIcon, bird_white_selectedIcon;
    private ImageIcon cat_white_putIcon, boar_white_putIcon, horse_white_putIcon, bird_white_putIcon, cat_black_putIcon, boar_black_putIcon, horse_black_putIcon, bird_black_putIcon;

    private final ImageIcon[] reverseIcon = new ImageIcon[24];
    private final ImageIcon[] yourturnIcon = new ImageIcon[25];
    private final ImageIcon[] youwinIcon = new ImageIcon[37];
    private final ImageIcon[] youloseIcon = new ImageIcon[40];

    private ImageIcon myIcon, yourIcon;
    private ImageIcon mySelectedIcon, yourSelectedIcon, myNoSelectedIcon, yourNoSelectedIcon;
    private ImageIcon myNoSelectdCatIcon, mySelectedCatIcon, yourNoSelectedCatIcon, yourSelectedCatIcon;
    private ImageIcon myNoSelectedBoarIcon, mySelectedBoarIcon, yourNoSelectedBoarIcon, yourSelectedBoarIcon;
    private ImageIcon myNoSelectedHorseIcon, mySelectedHorseIcon, yourHorseIcon, yourSelectedHorseIcon;
    private ImageIcon myNoSelectedBirdIcon, mySelectedBirdIcon, yourNoSelectedBirdIcon, yourSelectedBirdIcon;
    private ImageIcon myPutCatIcon, myPutBoarIcon, myPutHorseIcon, myPutBirdIcon, yourPutCatIcon, yourPutBoarIcon, yourPutHorseIcon, yourPutBirdIcon;
    private ImageIcon hpGauge_green, hpGauge_yellow, hpGauge_red;
    private int myColor;
    private boolean myTurn;
    private final int MASU = 8;
    private int reversedSum;
    private String msg;
    private boolean endGame = false;
    private Actor player = new Actor();
    private Actor enemy = new Actor();


    private int player0_hp;
    private int player1_hp;
    private int enemy0_hp;
    private int enemy1_hp;

    private ImageIcon enemyIcon;
    private JLabel enemy_Icon;

    private int mySelected = 70;
    private int yourSelected = 70;
    private int blackChange = mySelected;
    private int whiteChange = yourSelected;

    private int number = 0;
    private int selected;
    private int maxHP;

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
        setSize(375, 550);//ウィンドウのサイズを設定する
        c = getContentPane();//フレームのペインを取得する

        //アイコンの設定
        whiteIcon = new ImageIcon("../assets/white.jpg");
        blackIcon = new ImageIcon("../assets/black.jpg");
        boardIcon = new ImageIcon("../assets/frame.jpg");
        white_selectedIcon = new ImageIcon("../assets/animals/white_selected.jpg");
        black_selectedIcon = new ImageIcon("../assets/animals/black_selected.jpg");
        white_noSelectedIcon = new ImageIcon("../assets/animals/white_no_selected.jpg");
        black_noSelectedIcon = new ImageIcon("../assets/animals/black_no_selected.jpg");

        cat_white_noSelectedIcon = new ImageIcon("../assets/animals/cat_white_no_selected.jpg");
        cat_white_selectedIcon = new ImageIcon("../assets/animals/cat_white_selected.jpg");
        cat_black_noSelectedIcon = new ImageIcon("../assets/animals/cat_black_no_selected.jpg");
        cat_black_selectedIcon = new ImageIcon("../assets/animals/cat_black_selected.jpg");

        boar_white_noSelectedIcon = new ImageIcon("../assets/animals/boar_white_no_selected.jpg");
        boar_white_selectedIcon = new ImageIcon("../assets/animals/boar_white_selected.jpg");
        boar_black_noSelectedIcon = new ImageIcon("../assets/animals/boar_black_no_selected.jpg");
        boar_black_selectedIcon = new ImageIcon("../assets/animals/boar_black_selected.jpg");

        horse_white_noSelectedIcon = new ImageIcon("../assets/animals/horse_white_no_selected.jpg");
        horse_white_selectedIcon = new ImageIcon("../assets/animals/horse_white_selected.jpg");
        horse_black_noSelectedIcon = new ImageIcon("../assets/animals/horse_black_no_selected.jpg");
        horse_black_selectedIcon = new ImageIcon("../assets/animals/horse_black_selected.jpg");

        bird_white_noSelectedIcon = new ImageIcon("../assets/animals/bird_white_no_selected.jpg");
        bird_white_selectedIcon = new ImageIcon("../assets/animals/bird_white_selected.jpg");
        bird_black_noSelectedIcon = new ImageIcon("../assets/animals/bird_black_no_selected.jpg");
        bird_black_selectedIcon = new ImageIcon("../assets/animals/bird_black_selected.jpg");

        cat_white_putIcon = new ImageIcon("../assets/small_animals/cat_white_no_selected.jpg");
        cat_black_putIcon = new ImageIcon("../assets/small_animals/cat_black_no_selected.jpg");
        boar_white_putIcon = new ImageIcon("../assets/small_animals/boar_white_no_selected.jpg");
        boar_black_putIcon = new ImageIcon("../assets/small_animals/boar_black_no_selected.jpg");
        horse_white_putIcon = new ImageIcon("../assets/small_animals/horse_white_no_selected.jpg");
        horse_black_putIcon = new ImageIcon("../assets/small_animals/horse_black_no_selected.jpg");
        bird_white_putIcon = new ImageIcon("../assets/small_animals/bird_white_no_selected.jpg");
        bird_black_putIcon = new ImageIcon("../assets/small_animals/bird_black_no_selected.jpg");

        hpGauge_green = new ImageIcon("../assets/hpguage/hp_green.jpg");
        hpGauge_yellow = new ImageIcon("../assets/hpguage/hp_yellow.jpg");
        hpGauge_red = new ImageIcon("../assets/hpguage/hp_red.jpg");
        canPutIcon = new ImageIcon("../assets/can-put-down.jpg");
        background_black = new ImageIcon("../assets/blackout.jpg");

        for (int i = 0; i < reverseIcon.length; i++) {
            reverseIcon[i] = new ImageIcon(String.format("../assets/reverse/%02d.jpg", i));
        }

        for (int i = 0; i < yourturnIcon.length; i++) {
            yourturnIcon[i] = new ImageIcon(String.format("../assets/yourturn/%02d.png", i));
        }

        for (int i = 0; i < youwinIcon.length; i++) {
            youwinIcon[i] = new ImageIcon(String.format("../assets/youwin/%02d.png", i));
        }

        for (int i = 0; i < youloseIcon.length; i++) {
            youloseIcon[i] = new ImageIcon(String.format("../assets/youlose/%02d.png", i));
        }

        c.setLayout(null);//自動レイアウトの設定を行わない

        player.status(10000, 10000);
        enemy.status(10000, 10000);

        maxHpGaugeWidth = hpWidth / player.hp;

        player0_hp = player.hp;
        player1_hp = player.hp;
        enemy0_hp = enemy.hp;
        enemy1_hp = enemy.hp;
        maxHP=enemy1_hp;

        //敵
        enemy_Panel = new JPanel();
        enemy_Panel.setLayout(null);

        enemy_NAME = new JLabel("enemy");
        enemy_NAME.setPreferredSize(new Dimension(130, 80));
        enemy_NAME.setBounds(10, 5, 80, 20);

//        enemyIcon = new ImageIcon("../assets/animal_uma_horse_30960-101x101.jpg");
//
//        enemy_Icon = new JLabel(enemyIcon);
//        enemy_Icon.setBounds(0, 40, 100, 100);

        enemy_maxhp = Integer.toString(enemy.Maxhp);
        enemy_MAXHP = new JLabel("/" + (enemy_maxhp));
        enemy_MAXHP.setBounds(320, 55, 100, 10);

        enemy_hp = String.valueOf(enemy.hp);
        enemy_HP = new JLabel(enemy_hp);
        enemy_HP.setBounds(285, 55, 100, 10);

        enemy_HPGAUGE = new JLabel(hpGauge_green);
        int IntEnemy_hpWidth = (int) hpWidth;
        enemy_HPGAUGE.setBounds(0, 55, IntEnemy_hpWidth, 10);

        enemy_Panel.add(enemy_HP);
        enemy_Panel.add(enemy_MAXHP);
        enemy_Panel.add(enemy_NAME);
        enemy_Panel.add(enemy_HPGAUGE);
        //  enemy_Panel.add(enemy_Icon);
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
        str_main.setBounds(20, 20, 300, 300);
        mainPane.setLayer(str_main, 1);


        pieceDescription = new JLabel();
        pieceDescription.setPreferredSize(new Dimension(200, 200));
        pieceDescription.setBounds(0, 80, 375, 50);
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
        player_HP.setBounds(285, 5, 100, 10);

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
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void longlongSleep() {
            try {
                Thread.sleep(60);
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

                othello_piece_Normal.setIcon(mySelectedIcon);
                othello_piece_A.setIcon(myNoSelectdCatIcon);
                othello_piece_B.setIcon(myNoSelectedBoarIcon);
                othello_piece_C.setIcon(myNoSelectedHorseIcon);
                othello_piece_D.setIcon(myNoSelectedBirdIcon);

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

                while (endGame == false) {
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
                                    break;
                                }

                            }

                        }

                        if (cmd.equals("CANPUT")) {

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);

                            if (myTurn) {
                                if (buttonArray[y][x].getIcon() == boardIcon) {
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

                        if (cmd.equals("FLIP")) {
                            reversedSum = 0;

                            int x = Integer.parseInt(inputTokens[1]);
                            int y = Integer.parseInt(inputTokens[2]);

                            if (myTurn) {
                                //送信元クライアントでの処理
                                if (mySelected == 70) {
                                    buttonArray[y][x].setIcon(myIcon);
                                } else if (mySelected == 71) {
                                    buttonArray[y][x].setIcon(myPutCatIcon);
                                } else if(mySelected == 72){
                                    buttonArray[y][x].setIcon(myPutBoarIcon);
                                } else if(mySelected == 73){
                                    buttonArray[y][x].setIcon(myPutHorseIcon);
                                } else if(mySelected == 74){
                                    buttonArray[y][x].setIcon(myPutBirdIcon);
                                }
                            } else {
                                if (yourSelected == 70) {
                                    buttonArray[y][x].setIcon(yourIcon);
                                } else if (yourSelected == 71) {
                                    buttonArray[y][x].setIcon(yourPutCatIcon);
                                } else if(yourSelected == 72){
                                    buttonArray[y][x].setIcon(yourPutBoarIcon);
                                } else if(yourSelected == 73){
                                    buttonArray[y][x].setIcon(yourPutHorseIcon);
                                } else if(yourSelected == 74){
                                    buttonArray[y][x].setIcon(yourPutBirdIcon);
                                }
                            }
                        }

                        if (cmd.equals("SELECT")) {
                            String colorNum = inputTokens[1];//ボタンの名前（番号）の取得
                            int colorNumInt = Integer.parseInt(colorNum);//ボタンの名前を数値に変換する
                            int buttonNum = Integer.parseInt(inputTokens[2]);


                            if(colorNumInt==0){
                                blackChange = buttonNum;
                            }else{
                                whiteChange = buttonNum;
                            }

                            if(colorNumInt==0){
                                if(myTurn){
                                    mySelected = blackChange;
                                    yourSelected = whiteChange;
                                    selected = mySelected;
                                } else{
                                    mySelected = whiteChange;
                                    yourSelected = blackChange;
                                    selected = yourSelected;
                                }
                            }else{
                                if(myTurn){
                                    mySelected = whiteChange;
                                    yourSelected = blackChange;
                                    selected = mySelected;
                                }else{
                                    mySelected = blackChange;
                                    yourSelected = whiteChange;
                                    selected = yourSelected;
                                }
                            }
                            System.out.println(selected);
                        }

                        if (cmd.equals("REVERSE")) {
                            String colorNum = inputTokens[1];//ボタンの名前（番号）の取得
                            int colorNumInt = Integer.parseInt(colorNum);//ボタンの名前を数値に変換する
                            int x = Integer.parseInt(inputTokens[2]);
                            int y = Integer.parseInt(inputTokens[3]);
                            if (colorNumInt == 1) {

                                for (ImageIcon i : reverseIcon) {
                                    buttonArray[y][x].setIcon(i);
                                    sleep();
                                }

                                buttonArray[y][x].setIcon(whiteIcon);

                            } else {

                                for (int i = reverseIcon.length - 1; i >= 0; i--) {
                                    buttonArray[y][x].setIcon(reverseIcon[i]);
                                    sleep();
                                }

                                buttonArray[y][x].setIcon(blackIcon);
                            }
                            reversedSum++;

                        }

                        if (cmd.equals("REVERSED")) {
                            Counter counter;
                            counter = countStone();
                            Random random = new Random();
                            double OffensivePower = 300;
                            double attackMagnification = 1.4;
                            for (int i = 0; i < reversedSum; i++) {
                                OffensivePower *= attackMagnification;
                            }
                            int damege = (int) OffensivePower;

                            if(selected==71){
                                damege+=400*reversedSum;
                            }

                            int Poison;
                            if(myTurn){
                                Poison = counter.getMyPoisonCount();
                            }else{
                                Poison = counter.getYourPoisonCount();
                            }
                            damege+=Poison*300; //72 毒
                            int lifeBurst=0;

                            if(selected==73){
                                if(myTurn) {
                                    if (myColor == 1) {
                                        lifeBurst = (maxHP - player0_hp) / 100;
                                    } else {
                                        lifeBurst = (maxHP - player1_hp) / 100;
                                    }
                                }else{
                                    if (myColor == 1) {
                                        lifeBurst = (maxHP - enemy0_hp) / 100;
                                    } else {
                                        lifeBurst = (maxHP - enemy1_hp) / 100;
                                    }
                                }
                                System.out.println(player0_hp);
                                System.out.println(player1_hp);
                                System.out.println(enemy0_hp);
                                System.out.println(enemy1_hp);
                                damege+=lifeBurst*60;
                            }

                                System.out.println(damege);

                            if(selected==74){
                                damege+=(counter.getBlackCount()+counter.getWhiteCount())*50;
                            }

                            if (myTurn) {
                                if (myColor == 0) {
                                    enemy1_hp -= damege;
                                    String strEnemy1_hp = String.valueOf(enemy1_hp);
                                    enemy_HP.setText(strEnemy1_hp);

                                    enemy_HPGAUGE.setBounds(0, 55, (int) (maxHpGaugeWidth * enemy1_hp), 10);
                                } else {
                                    enemy0_hp -= damege;
                                    String strEnemy0_hp = String.valueOf(enemy0_hp);
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
                                    String strPlayer1_hp = String.valueOf(player1_hp);
                                    player_HP.setText(strPlayer1_hp);

                                    player_HPGAUGE.setBounds(0, 5, (int) (maxHpGaugeWidth * player1_hp), 10);
                                } else {
                                    player0_hp -= damege;
                                    String strPlayer0_hp = String.valueOf(player0_hp);
                                    player_HP.setText(strPlayer0_hp);
                                    player_HPGAUGE.setBounds(0, 5, (int) (maxHpGaugeWidth * player0_hp), 10);
                                }


                                if (hpCheaker()) {
                                    String msg = "RESULT";
                                    endGame = true;
                                    out.println(msg);
                                    out.flush();
                                    break;
                                }
                                myTurn = true;
                                countPutDownStone();
                                if (endGame == false) {

                                    for (ImageIcon i : yourturnIcon) {
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
                if (myIcon == blackIcon) {
                    if (player1_hp < 0) {
                        for (ImageIcon i : youloseIcon) {
                            str_main.setIcon(i);
                            longlongSleep();
                        }
                    } else {
                        for (ImageIcon i : youwinIcon) {
                            str_main.setIcon(i);
                            longSleep();
                        }
                    }
                } else {
                    if (player0_hp < 0) {
                        for (ImageIcon i : youloseIcon) {
                            str_main.setIcon(i);
                            longlongSleep();
                        }
                        str_main.setIcon(null);
                    } else {
                        for (ImageIcon i : youwinIcon) {
                            str_main.setIcon(i);
                            longSleep();
                        }
                    }
                }
                out.close();
                socket.close();
                return;
            } catch (IOException e) {
                System.err.println("エラーが発生しました: " + e);
            }
        }
    }


    public static void main(String[] args) {
        MyClient net = new MyClient();
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

    private void longSleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void whichColor(int num) {
        if (num == 0) {
            myIcon = blackIcon;
            myNoSelectedIcon = black_noSelectedIcon;
            mySelectedIcon = black_selectedIcon;
            myNoSelectdCatIcon = cat_black_noSelectedIcon;
            mySelectedCatIcon = cat_black_selectedIcon;
            myNoSelectedBoarIcon = boar_black_noSelectedIcon;
            mySelectedBoarIcon = boar_black_selectedIcon;
            myNoSelectedHorseIcon = horse_black_noSelectedIcon;
            mySelectedHorseIcon = horse_black_selectedIcon;
            myNoSelectedBirdIcon = bird_black_noSelectedIcon;
            mySelectedBirdIcon = bird_black_selectedIcon;
            myPutCatIcon = cat_black_putIcon;
            myPutBoarIcon = boar_black_putIcon;
            myPutHorseIcon = horse_black_putIcon;
            myPutBirdIcon = bird_black_putIcon;

            yourIcon = whiteIcon;
            yourNoSelectedIcon = white_noSelectedIcon;
            yourSelectedIcon = white_selectedIcon;
            yourNoSelectedCatIcon = cat_white_noSelectedIcon;
            yourSelectedCatIcon = cat_white_selectedIcon;
            yourNoSelectedBoarIcon = boar_white_noSelectedIcon;
            yourSelectedBoarIcon = boar_white_selectedIcon;
            yourHorseIcon = horse_white_noSelectedIcon;
            yourSelectedHorseIcon = horse_white_selectedIcon;
            yourNoSelectedBirdIcon = bird_white_noSelectedIcon;
            yourSelectedBirdIcon = bird_white_selectedIcon;
            yourPutCatIcon = cat_white_putIcon;
            yourPutBoarIcon = boar_white_putIcon;
            yourPutHorseIcon = horse_white_putIcon;
            yourPutBirdIcon = bird_white_putIcon;

            for (ImageIcon i : yourturnIcon) {
                str_main.setIcon(i);
                longSleep();
            }

            str_main.setIcon(null);

        } else if (num == 1) {
            myIcon = whiteIcon;
            myNoSelectedIcon = white_noSelectedIcon;
            mySelectedIcon = white_selectedIcon;
            myNoSelectdCatIcon = cat_white_noSelectedIcon;
            mySelectedCatIcon = cat_white_selectedIcon;
            myNoSelectedBoarIcon = boar_white_noSelectedIcon;
            mySelectedBoarIcon = boar_white_selectedIcon;
            myNoSelectedHorseIcon = horse_white_noSelectedIcon;
            mySelectedHorseIcon = horse_white_selectedIcon;
            myNoSelectedBirdIcon = bird_white_noSelectedIcon;
            mySelectedBirdIcon = bird_white_selectedIcon;
            myPutCatIcon = cat_white_putIcon;
            myPutBoarIcon = boar_white_putIcon;
            myPutHorseIcon = horse_white_putIcon;
            myPutBirdIcon = bird_white_putIcon;

            yourIcon = blackIcon;
            yourNoSelectedIcon = black_noSelectedIcon;
            yourSelectedIcon = black_selectedIcon;
            yourNoSelectedCatIcon = cat_black_noSelectedIcon;
            yourSelectedCatIcon = cat_black_selectedIcon;
            yourNoSelectedBoarIcon = boar_black_noSelectedIcon;
            yourSelectedBoarIcon = boar_black_selectedIcon;
            yourHorseIcon = horse_black_noSelectedIcon;
            yourSelectedHorseIcon = horse_black_selectedIcon;
            yourNoSelectedBirdIcon = bird_black_noSelectedIcon;
            yourSelectedBirdIcon = bird_black_selectedIcon;
            yourPutCatIcon = cat_black_putIcon;
            yourPutBoarIcon = boar_black_putIcon;
            yourPutHorseIcon = horse_black_putIcon;
            yourPutBirdIcon = bird_black_putIcon;

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
                if(buttonArray[y][x].getIcon() == myPutBoarIcon){
                    counter.myPoisonCount++;
                }
                if(buttonArray[y][x].getIcon() == yourPutBoarIcon){
                    counter.yourPoisonCount++;
                }
            }
        }
        return counter;
    }

    private class Counter {
        public int blackCount;
        public int whiteCount;
        public int myPoisonCount;
        public int yourPoisonCount;

        public Counter() {
            blackCount = 0;
            whiteCount = 1;
        }

        public int getBlackCount() {
            return blackCount;
        }

        public int getWhiteCount() {
            return whiteCount;
        }

        public int getMyPoisonCount() {
            return myPoisonCount;
        }

        public int getYourPoisonCount() {
            return yourPoisonCount;
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
        while (buttonArray[y][x].getIcon() != myIcon && buttonArray[y][x].getIcon() != myPutHorseIcon && buttonArray[y][x].getIcon() != myPutBirdIcon && buttonArray[y][x].getIcon() != myPutCatIcon && buttonArray[y][x].getIcon() != myPutBoarIcon) {
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
        if (buttonArray[y][x].getIcon() == myIcon ||buttonArray[y][x].getIcon() == myPutHorseIcon || buttonArray[y][x].getIcon() == myPutBirdIcon || buttonArray[y][x].getIcon() == myPutCatIcon || buttonArray[y][x].getIcon() == myPutBoarIcon || buttonArray[y][x].getIcon() == yourIcon ||buttonArray[y][x].getIcon() == yourPutHorseIcon || buttonArray[y][x].getIcon() == yourPutBirdIcon || buttonArray[y][x].getIcon() == yourPutCatIcon || buttonArray[y][x].getIcon() == yourPutBoarIcon)
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
        if (buttonArray[y][x].getIcon() == myIcon ||buttonArray[y][x].getIcon() == myPutHorseIcon || buttonArray[y][x].getIcon() == myPutBirdIcon || buttonArray[y][x].getIcon() == myPutCatIcon || buttonArray[y][x].getIcon() == myPutBoarIcon)
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
            if (buttonArray[y][x].getIcon() == myIcon ||buttonArray[y][x].getIcon() == myPutHorseIcon || buttonArray[y][x].getIcon() == myPutBirdIcon || buttonArray[y][x].getIcon() == myPutCatIcon || buttonArray[y][x].getIcon() == myPutBoarIcon) {
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

        if(myTurn) {
            if (!endGame) {
                if (theArrayIndexInt == 70 || theArrayIndexInt == 71 || theArrayIndexInt == 72 || theArrayIndexInt == 73 || theArrayIndexInt == 74) {
                    if (theArrayIndexInt == 70) {
                        othello_piece_Normal.setIcon(mySelectedIcon);
                        othello_piece_A.setIcon(myNoSelectdCatIcon);
                        othello_piece_B.setIcon(myNoSelectedBoarIcon);
                        othello_piece_C.setIcon(myNoSelectedHorseIcon);
                        othello_piece_D.setIcon(myNoSelectedBirdIcon);
                        msg = "SELECT" + " " + myColor + " " + theArrayIndexInt;
                        out.println(msg);
                        out.flush();
                    } else if (theArrayIndexInt == 71) {
                        othello_piece_Normal.setIcon(myNoSelectedIcon);
                        othello_piece_A.setIcon(mySelectedCatIcon);
                        othello_piece_B.setIcon(myNoSelectedBoarIcon);
                        othello_piece_C.setIcon(myNoSelectedHorseIcon);
                        othello_piece_D.setIcon(myNoSelectedBirdIcon);
                        msg = "SELECT" + " " + myColor + " " + theArrayIndexInt;
                        out.println(msg);
                        out.flush();
                    } else if (theArrayIndexInt == 72) {
                        othello_piece_Normal.setIcon(myNoSelectedIcon);
                        othello_piece_A.setIcon(myNoSelectdCatIcon);
                        othello_piece_B.setIcon(mySelectedBoarIcon);
                        othello_piece_C.setIcon(myNoSelectedHorseIcon);
                        othello_piece_D.setIcon(myNoSelectedBirdIcon);
                        msg = "SELECT" + " " + myColor + " " + theArrayIndexInt;
                        out.println(msg);
                        out.flush();
                    } else if (theArrayIndexInt == 73) {
                        othello_piece_Normal.setIcon(myNoSelectedIcon);
                        othello_piece_A.setIcon(myNoSelectdCatIcon);
                        othello_piece_B.setIcon(myNoSelectedBoarIcon);
                        othello_piece_C.setIcon(mySelectedHorseIcon);
                        othello_piece_D.setIcon(myNoSelectedBirdIcon);
                        msg = "SELECT" + " " + myColor + " " + theArrayIndexInt;
                        out.println(msg);
                        out.flush();
                    } else if (theArrayIndexInt == 74) {
                        othello_piece_Normal.setIcon(myNoSelectedIcon);
                        othello_piece_A.setIcon(myNoSelectdCatIcon);
                        othello_piece_B.setIcon(myNoSelectedBoarIcon);
                        othello_piece_C.setIcon(myNoSelectedHorseIcon);
                        othello_piece_D.setIcon(mySelectedBirdIcon);
                        msg = "SELECT" + " " + myColor + " " + theArrayIndexInt;
                        out.println(msg);
                        out.flush();
                    }
                } else {

                    if (myTurn) {
                        if (canPutDown(x, y)) {
                            msg = "FLIP" + " " + x + " " + y;
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
        }
    }

    public void mouseEntered(MouseEvent e) {//マウスがオブジェクトに入ったときの処理
        JButton theButton = (JButton) e.getComponent();//クリックしたオブジェクトを得る．型が違うのでキャストする
        String theArrayIndex = theButton.getActionCommand();//ボタンの配列の番号を取り出す
        int theArrayIndexInt = Integer.parseInt(theArrayIndex);
        pieceDescription.setBackground(new Color(128,128,128,128));
        pieceDescription.setForeground(new Color(255,255,0));

        if (theArrayIndexInt == 74) {
            pieceDescription.setText("        ひっくり返した後の駒数×50のダメージを与える");
            pieceDescription.setOpaque(true);
        }
        if (theArrayIndexInt == 73) {
            pieceDescription.setText("        　　自分のHPが減少する程ダメージが上昇する");
            pieceDescription.setOpaque(true);
        }
        if (theArrayIndexInt == 72) {
            pieceDescription.setText("盤面で表になっている間、毎ターン300のダメージを与える");
            pieceDescription.setOpaque(true);
        }
        if (theArrayIndexInt == 71) {
            pieceDescription.setText(" 　　ひっくり返した駒の枚数×300のダメージを与える");
            pieceDescription.setOpaque(true);
        }
        if (theArrayIndexInt == 70) {
            pieceDescription.setText(" 　                　普通の駒");
            pieceDescription.setOpaque(true);
        }

    }

    public void mouseExited(MouseEvent e) {

        pieceDescription.setText(null);
        pieceDescription.setOpaque(false);
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