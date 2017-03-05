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
    private JLabel messageLabel;

    public panelUI(){
        mainFrame = new JFrame("CPG");
        messageLabel = new JLabel("HELLO!\nWelcome to CPG!\nBest of Luck!");
        cardFrame = new JPanel();
        card1 = new JButton();
        card2 = new JButton();
        card3 = new JButton();
        card4 = new JButton();
        card5 = new JButton();
        mainFrame.setLayout(new BorderLayout());
        messageLabel.setLayout(new BorderLayout());
        cardFrame.setLayout(new GridLayout(1,5));
        mainFrame.setSize(600,400);
        mainFrame.add(messageLabel, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);
        card1.setText("Card 1");
        card2.setText("Card 2");
        card3.setText("Card 3");
        card4.setText("Card 4");
        card5.setText("Card 5");
        cardFrame.add(card1,0);
        cardFrame.add(card2,1);
        cardFrame.add(card3,2);
        cardFrame.add(card4,3);
        cardFrame.add(card5,4);
        mainFrame.setVisible(true);
        fart;
    }

    public void actionPerformed(ActionEvent getComm){
        if(getComm.getSource()==null) {

        }
    }
}
