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
    private JLabel messageLabel;

    public panelUI() {
        mainFrame = new JFrame("CPG");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Checks when window is closed and exits java
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });

        messageLabel = new JLabel("HELLO!\nWelcome to CPG!\nBest of Luck!");
        cardFrame = new JPanel();
        card1 = new JButton();
        card2 = new JButton();
        card3 = new JButton();
        card4 = new JButton();
        card5 = new JButton();

        mainFrame.setLayout(new BorderLayout());
        messageLabel.setLayout(new BorderLayout());
        cardFrame.setLayout(new GridLayout(1, 5, 100, 50));
        cardFrame.setPreferredSize(new Dimension(100, 200));
        mainFrame.setSize(1024, 576);

        mainFrame.add(messageLabel, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);

        card1.setText("everything.Card 1");
        card2.setText("everything.Card 2");
        card3.setText("everything.Card 3");
        card4.setText("everything.Card 4");
        card5.setText("everything.Card 5");

        cardFrame.add(card1, 0);
        cardFrame.add(card2, 1);
        cardFrame.add(card3, 2);
        cardFrame.add(card4, 3);
        cardFrame.add(card5, 4);

        mainFrame.setVisible(true);
    }

    void setMessage(String inputMessage){
        messageLabel.setText(inputMessage);
    }

}
