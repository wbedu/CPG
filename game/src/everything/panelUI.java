package everything;
/**
 * Created by Aaron on 3/4/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class panelUI {
    private JFrame mainFrame;
    private JPanel cardFrame;
    private JButton shopLib[];
    private JButton cards[];
    private JTextArea messageText;
    private JScrollPane messageScroll;
    private JScrollPane cardScroll;
    private ImageIcon cardBack[];
    private ImageIcon cardDisplay;
    private int cardSelect;
    private boolean cardWaiting;
    private JButton bossButton;    //checks when to start boss battle
    private JButton shopButton;
    private JButton battleButton;
    private JButton exitButton;
    private JButton buyButton;
    private JButton swapButton;
    private int startGame;
    private int shopFlag;
    private int exitFlag;
    private JPanel shopPanel;
    private JPanel cardDisplayPanel;

    public panelUI() {
        startGame = 0;
        shopFlag = 0;
        exitFlag = 0;
        mainFrame = new JFrame("CPG");
        mainFrame.setResizable(false);
        mainFrame.setPreferredSize(new Dimension(1024,600));
        mainFrame.setSize(1024,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Checks when window is closed and exits java
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });

        createStartUI();
    }

    void createStartUI(){
        exitFlag = 0;
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER,50,100));
        bossButton = new JButton();
        shopButton = new JButton();
        battleButton = new JButton();
        bossButton.setText("Boss Battle");
        shopButton.setText("Shop");
        battleButton.setText("Battle");
        bossButton.addActionListener(new buttonListener());
        shopButton.addActionListener(new buttonListener());
        battleButton.addActionListener(new buttonListener());

        mainFrame.add(bossButton);
        mainFrame.add(shopButton);
        mainFrame.add(battleButton);

        bossButton.setVisible(true);
        shopButton.setVisible(true);
        battleButton.setVisible(true);
        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void createShopUI(){
        exitFlag = 0;
        mainFrame.setLayout(new BorderLayout());
        cardFrame = new JPanel();
        exitButton = new JButton();
        cardDisplayPanel = new JPanel();

        exitButton.setText("Exit");
        cardFrame.setLayout(new GridLayout(1, 5,100,0));
        cardFrame.setPreferredSize(new Dimension(1024, 200));
        //cardDisplayPanel.setPreferredSize(new Dimension(250,400));
        exitButton.addActionListener(new buttonListener());

        cardOverhead();

        for(int x=0;x<5;x++){
            cardFrame.add(cards[x],x);
        }

        mainFrame.add(cardDisplayPanel, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);
        mainFrame.add(exitButton, BorderLayout.NORTH);
        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
        shopFlag = 0;
    }

    void createBattleUI(){
        exitFlag = 0;
        System.out.println("create battle");
        mainFrame.setLayout(new BorderLayout());

        messageText = new JTextArea("Hello, Welcome to CPG!",20,200);
        messageScroll = new JScrollPane(messageText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cardFrame = new JPanel();

        messageScroll.setLayout(new ScrollPaneLayout());
        cardFrame.setLayout(new GridLayout(1, 5,100,0));
        cardFrame.setPreferredSize(new Dimension(1024, 200));

        mainFrame.add(messageScroll, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);

        cardOverhead();

        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
        cardWaiting = true;
        startGame = 0;
        System.out.println("end of create battle "+canStartGame());
    }

    void setShopLibrary(SaveState save){
        shopPanel = new JPanel();
        shopLib = new JButton[5];
        shopPanel.setLayout(new GridLayout(5,1));
        for(int x=0;x<5;x++){
            shopLib[x] = new JButton();
            shopLib[x].setText("card");
            shopLib[x].setPreferredSize(new Dimension(400,50));
            shopPanel.add(shopLib[x],x);
        }
        cardScroll = new JScrollPane(shopPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cardScroll.setPreferredSize(new Dimension(400,400));
        mainFrame.add(cardScroll, BorderLayout.WEST);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void cardOverhead(){
        cards = new JButton[5];
        for(int x=0;x<5;x++){
            cards[x] = new JButton(cardBack[x]);
            cards[x].setPreferredSize(new Dimension(125,200));
            cards[x].setText("card1");
            cards[x].addActionListener(new buttonListener());
            cardFrame.add(cards[x], x);
        }
    }

    void startTearDown(){
        mainFrame.remove(battleButton);
        mainFrame.remove(shopButton);
        mainFrame.remove(bossButton);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void shopTearDown(){
        mainFrame.remove(cardScroll);
        mainFrame.remove(cardFrame);
        mainFrame.remove(exitButton);
        mainFrame.remove(cardDisplayPanel);
        //mainFrame.remove(buyButton);
        //mainFrame.remove(swapButton);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void battleTearDown(){
        mainFrame.remove(messageScroll);
        mainFrame.remove(cardFrame);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setCardBackFromPlayer(String playerCards[]){    //assume hand size is 5
        cardBack = new ImageIcon[5];

        for(int x = 0;x<5;x++){
            System.out.println(playerCards[x]);
            cardBack[x] = new ImageIcon(playerCards[x]);
        }
    }

    void updateFrame(){
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setMessage(String inputMessage){
        messageText.append(inputMessage);
        messageText.setCaretPosition(messageText.getDocument().getLength());
        mainFrame.revalidate();
    }

    void displayPlayerTurn(){
        if(cardSelect == 0){
            setMessage("\nBlock has been played: Adds 100 armour negating all incoming damage :1 Turn CD");
        } else if(cardSelect == 1){
            setMessage("\nCleave has been played: Deal 3 Damage :0 Turn CD");
        } else if(cardSelect == 2){
            setMessage("\nMutton has been played: Restore 4 HP :3 Turn CD");
        } else if(cardSelect == 3){
            setMessage("\nNordic Blood has been played: Increase Defense :2 Turn CD");
        } else if(cardSelect == 4){
            setMessage("\nSavage Strike has been played: Deal 8 Damage :3 Turn CD");
        }
    }

    void displayEnemyTurn(String message){
        setMessage("\n\nEnemy Turn!!!\n"+message);
    }

    void updateCardSelect(int cardNum){
        cardSelect = cardNum;
    }

    public int getCardSelect(){
        return cardSelect;
    }

    public boolean getCardWaiting(){
        return cardWaiting;
    }

    public void setCardWaitingTrue(){
        cardWaiting = true;
    }

    int canStartGame(){ return startGame; }

    int canShop(){ return shopFlag; }

    int getExitFlag(){ return exitFlag; }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent buttonPress){
            if(buttonPress.getActionCommand() == "card1"){
                //setMessage("\nCleave: 2 DMG dealt - 1 turn CD");
                updateCardSelect(0);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card2"){
                //setMessage("\nSavage Strike: 3 DMG dealt - 3 turn CD");
                updateCardSelect(1);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card3"){
                //setMessage("\nBlock: Blocking incoming DMG - 1 turn CD");
                updateCardSelect(2);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card4"){
                //setMessage("\nMutton: Restore 4 HP - 3 turn CD");
                updateCardSelect(3);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card5"){
                //setMessage("\nShield Bash: Enemy is STUNNED - 1 turn CD");
                updateCardSelect(4);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "Boss Battle"){

            }
            else if(buttonPress.getActionCommand() == "Shop"){
                startTearDown();
                createShopUI();
                shopFlag = 1;
            }
            else if(buttonPress.getActionCommand() == "Battle"){
                startTearDown();
                createBattleUI();
                startGame = 1;
            }
            else if(buttonPress.getActionCommand() == "Exit"){
                exitFlag = 1;
                shopTearDown();
                createStartUI();
                System.out.println("exited exit");
            }
            //setMessage("\n"+buttonPress.getActionCommand());
        }
    }
}
