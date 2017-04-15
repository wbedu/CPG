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
    private JButton card1;
    private JButton card2;
    private JButton card3;
    private JButton card4;
    private JButton card5;
    private JTextArea messageText;
    private JScrollPane messageScroll;
    private JScrollPane cardScroll;
    private ImageIcon cardBack[];
    private int cardSelect;
    private boolean cardWaiting;
    private JButton bossButton;    //checks when to start boss battle
    private JButton shopButton;
    private JButton battleButton;
    private JButton exitButton;
    private int startGame;
    private int shopFlag;
    private int exitFlag;
    private JPanel roamGrid;

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
        bossButton.validate();
        shopButton.validate();
        battleButton.validate();
        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void createShopUI(){
        exitFlag = 0;
        mainFrame.setLayout(new BorderLayout());
        cardScroll = new JScrollPane();
        cardFrame = new JPanel();
        exitButton = new JButton();

        cardFrame.setLayout(new GridLayout(1, 5,100,0));
        cardFrame.setPreferredSize(new Dimension(1024, 200));
        exitButton.addActionListener(new ButtonListener());
        exitButton.setText("Exit");

        cardOverhead();

        cardFrame.add(card1, 0);
        cardFrame.add(card2, 1);
        cardFrame.add(card3, 2);
        cardFrame.add(card4, 3);
        cardFrame.add(card5, 4);

        mainFrame.add(cardFrame, BorderLayout.SOUTH);
        mainFrame.add(cardScroll, BorderLayout.CENTER);
        mainFrame.add(exitButton,BorderLayout.NORTH);
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

    void cardOverhead(){
        card1 = new JButton(cardBack[0]);
        card2 = new JButton(cardBack[1]);
        card3 = new JButton(cardBack[2]);
        card4 = new JButton(cardBack[3]);
        card5 = new JButton(cardBack[4]);

        card1.setPreferredSize(new Dimension(125,200));
        card2.setPreferredSize(new Dimension(125,200));
        card3.setPreferredSize(new Dimension(125,200));
        card4.setPreferredSize(new Dimension(125,200));
        card5.setPreferredSize(new Dimension(125,200));

        card1.setText("card1");
        card2.setText("card2");
        card3.setText("card3");
        card4.setText("card4");
        card5.setText("card5");

        card1.addActionListener(new buttonListener());
        card2.addActionListener(new buttonListener());
        card3.addActionListener(new buttonListener());
        card4.addActionListener(new buttonListener());
        card5.addActionListener(new buttonListener());

        cardFrame.add(card1, 0);
        cardFrame.add(card2, 1);
        cardFrame.add(card3, 2);
        cardFrame.add(card4, 3);
        cardFrame.add(card5, 4);
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
        }

        cardBack[0] = new ImageIcon(playerCards[0]);
        cardBack[1] = new ImageIcon(playerCards[1]);
        cardBack[2] = new ImageIcon(playerCards[2]);
        cardBack[3] = new ImageIcon(playerCards[3]);
        cardBack[4] = new ImageIcon(playerCards[4]);
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
            }
            //setMessage("\n"+buttonPress.getActionCommand());
        }
    }
}
