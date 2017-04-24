package everything;
/**
 * Created by Aaron on 3/4/17.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private ImageIcon playerImage;
    private ImageIcon enemyImage;
    private int cardSelect;
    private boolean cardWaiting;
    private JButton bossButton;    //checks when to start boss battle
    private JButton shopButton;
    private JButton battleButton;
    private JButton exitButton;
    private JButton buyButton;
    private JButton swapButton;
    private JButton continueButton;
    private int startGame;
    private int shopFlag;
    private int shopLibFlag;
    private int exitFlag;
    private int winner;
    private int continueFlag;
    private JPanel healthPanel;
    private JPanel spritePanel;
    private JPanel shopPanel;
    private JPanel cardDisplayPanel;
    private JLabel playerSprite;
    private JLabel enemySprite;
    private JLabel playerHealth;
    private JLabel enemyHealth;
    private JLabel playerArmor;
    private JLabel enemyArmor;
    private JLabel winLabel;
    private JLabel lootLabel;
    private ArrayList<String> cardNameList;
    private ArrayList<String> cardPathList;
    private int[] isOwnList;
    private String enemyImagePath;

    public panelUI() {
        shopFlag = 0;
        exitFlag = 0;
        shopLibFlag = 1;
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
        continueFlag = 0;
        startGame = 0;
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
        shopLibFlag = 1;
        mainFrame.setLayout(new BorderLayout());
        cardFrame = new JPanel();
        exitButton = new JButton();
        cardDisplayPanel = new JPanel();
        shopPanel = new JPanel();
        cardScroll = new JScrollPane(shopPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        exitButton.setText("Exit");
        cardFrame.setLayout(new GridLayout(1, 5,50,200));
        cardFrame.setPreferredSize(new Dimension(1024, 200));
        cardScroll.setPreferredSize(new Dimension(400,400));
        //cardDisplayPanel.setPreferredSize(new Dimension(250,400));
        exitButton.addActionListener(new buttonListener());

        cardOverhead();

        for(int x=0;x<5;x++){
            cardFrame.add(cards[x],x);
        }

        mainFrame.add(cardDisplayPanel, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);
        mainFrame.add(cardScroll, BorderLayout.WEST);
        mainFrame.add(exitButton, BorderLayout.NORTH);
        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void createBattleUI(){
        exitFlag = 0;
        winner = -1;
        System.out.println("create battle");
        mainFrame.setLayout(new BorderLayout());

        messageText = new JTextArea("FIGHT!",20,30);
        messageScroll = new JScrollPane(messageText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cardFrame = new JPanel();
        playerImage = new ImageIcon("images/UserSprite.png");
        enemyImage = new ImageIcon(enemyImagePath);
        playerSprite = new JLabel(playerImage);
        enemySprite = new JLabel(enemyImage);
        playerArmor = new JLabel();
        enemyArmor = new JLabel();
        playerHealth = new JLabel();
        enemyHealth = new JLabel();
        healthPanel = new JPanel();
        spritePanel = new JPanel();

        messageScroll.setLayout(new ScrollPaneLayout());
        cardFrame.setLayout(new GridLayout(1, 5, 50,200));
        cardFrame.setPreferredSize(new Dimension(1024, 200));

        healthPanel.setLayout(new GridLayout(5,1));
        healthPanel.add(enemyHealth,0);
        healthPanel.add(enemyArmor,1);
        healthPanel.add(new JLabel(),2);
        healthPanel.add(playerHealth,3);
        healthPanel.add(playerArmor,4);

        spritePanel.setLayout(new GridLayout(2,1));
        spritePanel.add(enemySprite,0);
        spritePanel.add(playerSprite,1);

        mainFrame.add(messageScroll, BorderLayout.WEST);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);
        mainFrame.add(healthPanel, BorderLayout.EAST);
        mainFrame.add(spritePanel, BorderLayout.CENTER);

        cardOverhead();

        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
        cardWaiting = true;
        System.out.println("end of create battle "+canStartGame());
    }

    void createContinue(){
        continueFlag = 0;
        mainFrame.setLayout(new BorderLayout());

        continueButton = new JButton();
        winLabel = new JLabel();
        lootLabel = new JLabel();

        if(winner == 1){
            winLabel.setText("You Win!");
        } else {
            winLabel.setText("You have lost..");
        }

        lootLabel.setText("Loot: +50 Gold");
        lootLabel.setVerticalAlignment(JLabel.CENTER);
        lootLabel.setHorizontalAlignment(JLabel.CENTER);
        winLabel.setHorizontalAlignment(JLabel.CENTER);
        winLabel.setHorizontalAlignment(JLabel.CENTER);
        continueButton.setText("Continue");
        continueButton.addActionListener(new buttonListener());

        mainFrame.add(continueButton, BorderLayout.SOUTH);
        mainFrame.add(winLabel, BorderLayout.NORTH);
        mainFrame.add(lootLabel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setShopLibrary(){
        SaveState save = new SaveState();
        cardNameList = save.getCards();
        cardPathList = save.getCardPath();
        int size = cardNameList.size();
        shopLib = new JButton[size];
        shopPanel.setLayout(new GridLayout(size,1));
        for(int x=0;x<size;x++){
            shopLib[x] = new JButton();
            shopLib[x].setText(cardNameList.get(x));
            shopLib[x].setPreferredSize(new Dimension(400,50));
            shopLib[x].addActionListener(new buttonListener());
            shopLib[x].setActionCommand("shopCard");
            shopPanel.add(shopLib[x],x);
        }
        shopLibFlag = 0;
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void cardOverhead(){
        cards = new JButton[5];
        for(int x=0;x<5;x++){
            cards[x] = new JButton(cardBack[x]);
            cards[x].setPreferredSize(new Dimension(50,200));
            cards[x].setText("card"+Integer.toString(x+1));
            cards[x].addActionListener(new buttonListener());
            cardFrame.add(cards[x], x);
            cards[x].setOpaque(false);
            cards[x].setContentAreaFilled(false);
            cards[x].setBorderPainted(false);
            cards[x].setForeground(new Color(1f,0f,0f,0f ));
        }
    }

    int needShopLib(){
        return shopLibFlag;
    }

    void startTearDown(){
        mainFrame.remove(battleButton);
        mainFrame.remove(shopButton);
        mainFrame.remove(bossButton);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void shopTearDown(){
        shopFlag = 0;
        shopPanel.removeAll();
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
        healthPanel.removeAll();
        spritePanel.remove(playerSprite);
        spritePanel.remove(enemySprite);
        mainFrame.remove(messageScroll);
        mainFrame.remove(cardFrame);
        mainFrame.remove(healthPanel);
        mainFrame.remove(spritePanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void continueTearDown(){
        mainFrame.remove(continueButton);
        mainFrame.remove(winLabel);
        mainFrame.remove(lootLabel);
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

    void setEnemyImagePath(String path){
        spritePanel.remove(enemySprite);
        enemyImagePath = path;
        enemyImage = new ImageIcon(enemyImagePath);
        enemySprite = new JLabel(enemyImage);
        spritePanel.add(enemySprite,0);
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

    void setPlayerHealth(int newHealth){
        playerHealth.setText("Player HP: "+Integer.toString(newHealth));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setEnemyHealth(int newHealth){
        enemyHealth.setText("Enemy HP: "+Integer.toString(newHealth));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setPlayerArmor(int newArmor){
        playerArmor.setText("Armor: "+newArmor);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void setEnemyArmor(int newArmor){
        enemyArmor.setText("Armor: "+newArmor);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    void displayPlayerTurn(String message){
        setMessage(message);
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

    int getContinue(){ return continueFlag;  }

    int canStartGame(){ return startGame; }

    void setStartGame0(){ startGame = 0; }

    int canShop(){ return shopFlag; }

    int getExitFlag(){ return exitFlag; }

    void setExitFlag0(){ exitFlag=0; }

    void setWinner(int battleWinner){ winner = battleWinner;  }

    int getWinner(){ return winner; }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent buttonPress){
            if(buttonPress.getActionCommand().equals("card1")){
                //setMessage("\nCleave: 2 DMG dealt - 1 turn CD");
                updateCardSelect(0);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand().equals("card2")){
                //setMessage("\nSavage Strike: 3 DMG dealt - 3 turn CD");
                updateCardSelect(1);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand().equals("card3")){
                //setMessage("\nBlock: Blocking incoming DMG - 1 turn CD");
                updateCardSelect(2);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand().equals("card4")){
                //setMessage("\nMutton: Restore 4 HP - 3 turn CD");
                updateCardSelect(3);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand().equals("card5")){
                //setMessage("\nShield Bash: Enemy is STUNNED - 1 turn CD");
                updateCardSelect(4);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand().equals("Boss Battle")){

            }
            else if(buttonPress.getActionCommand().equals("Shop")){
                startTearDown();
                createShopUI();
                shopFlag = 1;
            }
            else if(buttonPress.getActionCommand().equals("Battle")){
                startTearDown();
                createBattleUI();
                startGame = 1;
            }
            else if(buttonPress.getActionCommand().equals("Exit")){
                exitFlag = 1;
                shopLibFlag = 1;
                shopTearDown();
                createStartUI();
                System.out.println("exited exit");
            }
            else if(buttonPress.getActionCommand().equals("Continue")){
                continueFlag = 1;
                continueTearDown();
                winner = -1;
            }
            else if(buttonPress.getActionCommand().equals("shopCard")){
                int index = buttonPress.getID();
            }
            //setMessage("\n"+buttonPress.getActionCommand());
        }
    }
}
