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

        messageText = new JTextArea("Hello, Welcome to CPG!",20,200);
        messageScroll = new JScrollPane(messageText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cardFrame = new JPanel();
        card1 = new JButton();
        card2 = new JButton();
        card3 = new JButton();
        card4 = new JButton();
        card5 = new JButton();

        mainFrame.setLayout(new BorderLayout());
        messageScroll.setLayout(new ScrollPaneLayout());
        cardFrame.setLayout(new GridLayout(1, 5, 100, 50));
        cardFrame.setPreferredSize(new Dimension(100, 200));
        mainFrame.setSize(1024, 576);

        mainFrame.add(messageScroll, BorderLayout.CENTER);
        mainFrame.add(cardFrame, BorderLayout.SOUTH);

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
    }

    void setMessage(String inputMessage){
        messageText.append(inputMessage);
    }

    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent buttonPress){
            System.out.println(buttonPress.getActionCommand());
        }
    }
}
