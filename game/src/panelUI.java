/**
 * Created by Aaron on 3/4/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class panelUI {
    private JFrame mainFrame;
    private JLabel messageLabel;
    private JTextField inputPanel;

    public panelUI(){
        mainFrame = new JFrame("CPG");
        //mainFrame.setLayout(new BorderLayout());
        messageLabel = new JLabel("HELLO!");
        inputPanel = new JTextField("> ");
        messageLabel.setLayout(new BorderLayout());
        inputPanel.setLayout(new BorderLayout());
        mainFrame.setSize(600,400);
        mainFrame.add(messageLabel, BorderLayout.CENTER);
        mainFrame.add(inputPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    public void displayMessage(commandLine commandLineInst){

    }
}
