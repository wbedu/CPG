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
    private ImageIcon cardBack;
    private int cardSelect;
    private boolean cardWaiting;

    public panelUI() {
        cardBack = new ImageIcon("images/Card_Placeholder.jpeg");
        mainFrame = new JFrame("CPG");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Checks when window is closed and exits java
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });

        messageText = new JTextArea("Hello, Welcome to CPG!",20,200);
        messageScroll = new JScrollPane(messageText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cardFrame = new JPanel();
        card1 = new JButton(cardBack);
        card2 = new JButton(cardBack);
        card3 = new JButton(cardBack);
        card4 = new JButton(cardBack);
        card5 = new JButton(cardBack);

        mainFrame.setLayout(new BorderLayout());
        messageScroll.setLayout(new ScrollPaneLayout());
        cardFrame.setLayout(new GridLayout(1, 5,100,0));
        cardFrame.setPreferredSize(new Dimension(1024, 200));
        mainFrame.setSize(1024, 576);

        mainFrame.add(messageScroll, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);

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

        mainFrame.setVisible(true);
        cardWaiting = true;
    }

    void setMessage(String inputMessage){
        messageText.append(inputMessage);
    }

    void prepBattle(Player user){
        System.out.println("Battle UI has been prepared");
    }

    void prepRoam(){
        System.out.println("Roam UI has been prepared");
    }

    void displayWin(){
        System.out.println("Win Popout panel has been displayed");
    }

    void disableCardFrame(){
        System.out.println("Card buttons have been disabled");
    }

    void enableCardFrame(){
        System.out.println("Card buttons have been enabled");
    }

    void displayTurn(){
        System.out.println("User has been prompted it is his/her turn");
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

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent buttonPress){
            if(buttonPress.getActionCommand() == "card1"){
                setMessage("\nCleave: 2 DMG dealt - 1 turn CD");
                updateCardSelect(1);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card2"){
                setMessage("\nSavage Strike: 3 DMG dealt - 3 turn CD");
                updateCardSelect(2);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card3"){
                setMessage("\nBlock: Blocking incoming DMG - 1 turn CD");
                updateCardSelect(3);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card4"){
                setMessage("\nMutton: Restore 4 HP - 3 turn CD");
                updateCardSelect(4);
                cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card5"){
                setMessage("\nShield Bash: Enemy is STUNNED - 1 turn CD");
                updateCardSelect(5);
                cardWaiting = false;
            }
            //setMessage("\n"+buttonPress.getActionCommand());

        }
    }
}
