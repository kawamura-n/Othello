import java.net.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

//public class Client extends JFrame implements MouseListener,MouseMotionListener {

class Actor {
    public static int hp;
    public static int Maxhp;

    void status(int hp, int maxhp) {
        this.hp = hp;
        this.Maxhp = maxhp;
    }
}

class PieceA {
    boolean exist = true;
    int x;
    int y;
    int num = 4;
    boolean live = true;

    void put(int x, int y) {
        this.x = x;
        this.y = y;
        num--;
    }

    void die(int x, int y) {
        live = false;
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
    private ImageIcon white_selectedIcon;
    private ImageIcon black_selectedIcon;
    private ImageIcon white_noSelectedIcon;
    private ImageIcon black_noSelectedIcon;
    private ImageIcon cat_black_noSelectedIcon, cat_black_selectedIcon, cat_white_noSelectedIcon, cat_white_selectedIcon;
    private ImageIcon boar_black_noSelectedIcon, boar_black_selectedIcon, boar_white_noSelectedIcon, boar_white_selectedIcon;
    private ImageIcon horse_black_noSelectedIcon, horse_black_selectedIcon, horse_white_noSelectedIcon, horse_white_selectedIcon;
    private ImageIcon bird_black_noSelectedIcon, bird_black_selectedIcon, bird_white_noSelectedIcon, bird_white_selectedIcon;


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
    private ImageIcon[] reverseIcon = {reverseIcon1, reverseIcon2, reverseIcon3, reverseIcon4, reverseIcon5, reverseIcon6, reverseIcon7, reverseIcon8, reverseIcon9, reverseIcon10, reverseIcon11, reverseIcon12, reverseIcon13, reverseIcon14, reverseIcon15, reverseIcon16, reverseIcon17, reverseIcon18, reverseIcon19, reverseIcon20, reverseIcon21, reverseIcon22, reverseIcon23, reverseIcon24};

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
    private ImageIcon[] yourturnIcon = {yourturnIcon1, yourturnIcon2, yourturnIcon3, yourturnIcon4, yourturnIcon5, yourturnIcon6, yourturnIcon7, yourturnIcon8, yourturnIcon9, yourturnIcon10, yourturnIcon11, yourturnIcon12, yourturnIcon13, yourturnIcon14, yourturnIcon15, yourturnIcon16, yourturnIcon17, yourturnIcon18, yourturnIcon19, yourturnIcon20, yourturnIcon21, yourturnIcon22, yourturnIcon23, yourturnIcon24, yourturnIcon25};

    private ImageIcon youwinIcon1 = new ImageIcon("../assets/youwin/youwin_0000.png");
    private ImageIcon youwinIcon2 = new ImageIcon("../assets/youwin/youwin_0001.png");
    private ImageIcon youwinIcon3 = new ImageIcon("../assets/youwin/youwin_0002.png");
    private ImageIcon youwinIcon4 = new ImageIcon("../assets/youwin/youwin_0003.png");
    private ImageIcon youwinIcon5 = new ImageIcon("../assets/youwin/youwin_0004.png");
    private ImageIcon youwinIcon6 = new ImageIcon("../assets/youwin/youwin_0005.png");
    private ImageIcon youwinIcon7 = new ImageIcon("../assets/youwin/youwin_0006.png");
    private ImageIcon youwinIcon8 = new ImageIcon("../assets/youwin/youwin_0007.png");
    private ImageIcon youwinIcon9 = new ImageIcon("../assets/youwin/youwin_0008.png");
    private ImageIcon youwinIcon10 = new ImageIcon("../assets/youwin/youwin_0009.png");
    private ImageIcon youwinIcon11 = new ImageIcon("../assets/youwin/youwin_0010.png");
    private ImageIcon youwinIcon12 = new ImageIcon("../assets/youwin/youwin_0011.png");
    private ImageIcon youwinIcon13 = new ImageIcon("../assets/youwin/youwin_0012.png");
    private ImageIcon youwinIcon14 = new ImageIcon("../assets/youwin/youwin_0013.png");
    private ImageIcon youwinIcon15 = new ImageIcon("../assets/youwin/youwin_0014.png");
    private ImageIcon youwinIcon16 = new ImageIcon("../assets/youwin/youwin_0015.png");
    private ImageIcon youwinIcon17 = new ImageIcon("../assets/youwin/youwin_0016.png");
    private ImageIcon youwinIcon18 = new ImageIcon("../assets/youwin/youwin_0017.png");
    private ImageIcon youwinIcon19 = new ImageIcon("../assets/youwin/youwin_0018.png");
    private ImageIcon youwinIcon20 = new ImageIcon("../assets/youwin/youwin_0019.png");
    private ImageIcon youwinIcon21 = new ImageIcon("../assets/youwin/youwin_0020.png");
    private ImageIcon youwinIcon22 = new ImageIcon("../assets/youwin/youwin_0021.png");
    private ImageIcon youwinIcon23 = new ImageIcon("../assets/youwin/youwin_0022.png");
    private ImageIcon youwinIcon24 = new ImageIcon("../assets/youwin/youwin_0023.png");
    private ImageIcon youwinIcon25 = new ImageIcon("../assets/youwin/youwin_0024.png");
    private ImageIcon youwinIcon26 = new ImageIcon("../assets/youwin/youwin_0025.png");
    private ImageIcon youwinIcon27 = new ImageIcon("../assets/youwin/youwin_0026.png");
    private ImageIcon youwinIcon28 = new ImageIcon("../assets/youwin/youwin_0027.png");
    private ImageIcon youwinIcon29 = new ImageIcon("../assets/youwin/youwin_0028.png");
    private ImageIcon youwinIcon30 = new ImageIcon("../assets/youwin/youwin_0029.png");
    private ImageIcon youwinIcon31 = new ImageIcon("../assets/youwin/youwin_0030.png");
    private ImageIcon youwinIcon32 = new ImageIcon("../assets/youwin/youwin_0031.png");
    private ImageIcon youwinIcon33 = new ImageIcon("../assets/youwin/youwin_0032.png");
    private ImageIcon youwinIcon34 = new ImageIcon("../assets/youwin/youwin_0033.png");
    private ImageIcon youwinIcon35 = new ImageIcon("../assets/youwin/youwin_0034.png");
    private ImageIcon youwinIcon36 = new ImageIcon("../assets/youwin/youwin_0035.png");
    private ImageIcon youwinIcon37 = new ImageIcon("../assets/youwin/youwin_0036.png");
    private ImageIcon[] youwinIcon = {youwinIcon1, youwinIcon2, youwinIcon3, youwinIcon4, youwinIcon5, youwinIcon6, youwinIcon7, youwinIcon8, youwinIcon9, youwinIcon10, youwinIcon11, youwinIcon12, youwinIcon13, youwinIcon14, youwinIcon15, youwinIcon16, youwinIcon17, youwinIcon18, youwinIcon19, youwinIcon20, youwinIcon21, youwinIcon22, youwinIcon23, youwinIcon24, youwinIcon25, youwinIcon26, youwinIcon27, youwinIcon28, youwinIcon29, youwinIcon30, youwinIcon31, youwinIcon32, youwinIcon33, youwinIcon34, youwinIcon35, youwinIcon36, youwinIcon37};

    private ImageIcon youloseIcon1 = new ImageIcon("../assets/youlose/youlose_0000.png");
    private ImageIcon youloseIcon2 = new ImageIcon("../assets/youlose/youlose_0001.png");
    private ImageIcon youloseIcon3 = new ImageIcon("../assets/youlose/youlose_0002.png");
    private ImageIcon youloseIcon4 = new ImageIcon("../assets/youlose/youlose_0003.png");
    private ImageIcon youloseIcon5 = new ImageIcon("../assets/youlose/youlose_0004.png");
    private ImageIcon youloseIcon6 = new ImageIcon("../assets/youlose/youlose_0005.png");
    private ImageIcon youloseIcon7 = new ImageIcon("../assets/youlose/youlose_0006.png");
    private ImageIcon youloseIcon8 = new ImageIcon("../assets/youlose/youlose_0007.png");
    private ImageIcon youloseIcon9 = new ImageIcon("../assets/youlose/youlose_0008.png");
    private ImageIcon youloseIcon10 = new ImageIcon("../assets/youlose/youlose_0009.png");
    private ImageIcon youloseIcon11 = new ImageIcon("../assets/youlose/youlose_0010.png");
    private ImageIcon youloseIcon12 = new ImageIcon("../assets/youlose/youlose_0011.png");
    private ImageIcon youloseIcon13 = new ImageIcon("../assets/youlose/youlose_0012.png");
    private ImageIcon youloseIcon14 = new ImageIcon("../assets/youlose/youlose_0013.png");
    private ImageIcon youloseIcon15 = new ImageIcon("../assets/youlose/youlose_0014.png");
    private ImageIcon youloseIcon16 = new ImageIcon("../assets/youlose/youlose_0015.png");
    private ImageIcon youloseIcon17 = new ImageIcon("../assets/youlose/youlose_0016.png");
    private ImageIcon youloseIcon18 = new ImageIcon("../assets/youlose/youlose_0017.png");
    private ImageIcon youloseIcon19 = new ImageIcon("../assets/youlose/youlose_0018.png");
    private ImageIcon youloseIcon20 = new ImageIcon("../assets/youlose/youlose_0019.png");
    private ImageIcon youloseIcon21 = new ImageIcon("../assets/youlose/youlose_0020.png");
    private ImageIcon youloseIcon22 = new ImageIcon("../assets/youlose/youlose_0021.png");
    private ImageIcon youloseIcon23 = new ImageIcon("../assets/youlose/youlose_0022.png");
    private ImageIcon youloseIcon24 = new ImageIcon("../assets/youlose/youlose_0023.png");
    private ImageIcon youloseIcon25 = new ImageIcon("../assets/youlose/youlose_0024.png");
    private ImageIcon youloseIcon26 = new ImageIcon("../assets/youlose/youlose_0025.png");
    private ImageIcon youloseIcon27 = new ImageIcon("../assets/youlose/youlose_0026.png");
    private ImageIcon youloseIcon28 = new ImageIcon("../assets/youlose/youlose_0027.png");
    private ImageIcon youloseIcon29 = new ImageIcon("../assets/youlose/youlose_0028.png");
    private ImageIcon youloseIcon30 = new ImageIcon("../assets/youlose/youlose_0029.png");
    private ImageIcon youloseIcon31 = new ImageIcon("../assets/youlose/youlose_0030.png");
    private ImageIcon youloseIcon32 = new ImageIcon("../assets/youlose/youlose_0031.png");
    private ImageIcon youloseIcon33 = new ImageIcon("../assets/youlose/youlose_0032.png");
    private ImageIcon youloseIcon34 = new ImageIcon("../assets/youlose/youlose_0033.png");
    private ImageIcon youloseIcon35 = new ImageIcon("../assets/youlose/youlose_0034.png");
    private ImageIcon youloseIcon36 = new ImageIcon("../assets/youlose/youlose_0035.png");
    private ImageIcon youloseIcon37 = new ImageIcon("../assets/youlose/youlose_0036.png");
    private ImageIcon youloseIcon38 = new ImageIcon("../assets/youlose/youlose_0037.png");
    private ImageIcon youloseIcon39 = new ImageIcon("../assets/youlose/youlose_0038.png");
    private ImageIcon youloseIcon40 = new ImageIcon("../assets/youlose/youlose_0039.png");
    private ImageIcon[] youloseIcon = {youloseIcon1, youloseIcon2, youloseIcon3, youloseIcon4, youloseIcon5, youloseIcon6, youloseIcon7, youloseIcon8, youloseIcon9, youloseIcon10, youloseIcon11, youloseIcon12, youloseIcon13, youloseIcon14, youloseIcon15, youloseIcon16, youloseIcon17, youloseIcon18, youloseIcon19, youloseIcon20, youloseIcon21, youloseIcon22, youloseIcon23, youloseIcon24, youloseIcon25, youloseIcon26, youloseIcon27, youloseIcon28, youloseIcon29, youloseIcon30, youloseIcon31, youloseIcon32, youloseIcon33, youloseIcon34, youloseIcon35, youloseIcon36, youloseIcon37, youloseIcon38, youloseIcon39, youloseIcon40};

    private ImageIcon myIcon, yourIcon;
    private ImageIcon mySelectedIcon,yourSelectedIcon,myNoSelectedIcon,yourNoSelectedIcon;
    private ImageIcon myNoSelectdCatIcon, mySelectedCatIcon, yourNoSelectedCatIcon, yourSelectedCatIcon;
    private ImageIcon myNoSelectedBoarIcon, mySelectedBoarIcon, yourNoSelectedBoarIcon, yourSelectedBoarIcon;
    private ImageIcon myNoSelectedHorseIcon, mySelectedHorseIcon, yourHorseIcon, yourSelectedHorseIcon;
    private ImageIcon myNoSelectedBirdIcon, mySelectedBirdIcon, yourNoSelectedBirdIcon, yourSelectedBirdIcon;
    private ImageIcon hpGauge_green, hpGauge_yellow, hpGauge_red;
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

                            if (selected == 71) {
                                PieceA pieceA = new PieceA();
                                pieceA.put(x, y);
                            }

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
                Counter counter;
                counter = countStone();
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
            if (theArrayIndexInt == 70 || theArrayIndexInt == 71 || theArrayIndexInt == 72 || theArrayIndexInt == 73 || theArrayIndexInt == 74) {
                if (theArrayIndexInt == 70) {
                    othello_piece_Normal.setIcon(mySelectedIcon);
                    othello_piece_A.setIcon(myNoSelectdCatIcon);
                    othello_piece_B.setIcon(myNoSelectedBoarIcon);
                    othello_piece_C.setIcon(myNoSelectedHorseIcon);
                    othello_piece_D.setIcon(myNoSelectedBirdIcon);
                    selected = 70;
                } else if (theArrayIndexInt == 71) {
                    othello_piece_Normal.setIcon(myNoSelectedIcon);
                    othello_piece_A.setIcon(mySelectedCatIcon);
                    othello_piece_B.setIcon(myNoSelectedBoarIcon);
                    othello_piece_C.setIcon(myNoSelectedHorseIcon);
                    othello_piece_D.setIcon(myNoSelectedBirdIcon);
                    selected = 71;
                } else if (theArrayIndexInt == 72) {
                    othello_piece_Normal.setIcon(myNoSelectedIcon);
                    othello_piece_A.setIcon(myNoSelectdCatIcon);
                    othello_piece_B.setIcon(mySelectedBoarIcon);
                    othello_piece_C.setIcon(myNoSelectedHorseIcon);
                    othello_piece_D.setIcon(myNoSelectedBirdIcon);
                    selected = 72;
                } else if (theArrayIndexInt == 73) {
                    othello_piece_Normal.setIcon(myNoSelectedIcon);
                    othello_piece_A.setIcon(myNoSelectdCatIcon);
                    othello_piece_B.setIcon(myNoSelectedBoarIcon);
                    othello_piece_C.setIcon(mySelectedHorseIcon);
                    othello_piece_D.setIcon(myNoSelectedBirdIcon);
                    selected = 73;
                } else if (theArrayIndexInt == 74) {
                    othello_piece_Normal.setIcon(myNoSelectedIcon);
                    othello_piece_A.setIcon(myNoSelectdCatIcon);
                    othello_piece_B.setIcon(myNoSelectedBoarIcon);
                    othello_piece_C.setIcon(myNoSelectedHorseIcon);
                    othello_piece_D.setIcon(mySelectedBirdIcon);
                    selected = 74;
                }
            } else {

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