/**
 * Created by Aaron on 3/4/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class panelUI {
    private JFrame mainFrame;
    private JLabel messageLabel;

    public panelUI(){
        mainFrame = new JFrame("CPG");
        messageLabel = new JLabel("HELLO!",JLabel.CENTER);
        mainFrame.setSize(600,400);
        mainFrame.add(messageLabel);
        mainFrame.setVisible(true);
    }
}
