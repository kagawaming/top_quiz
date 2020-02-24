package view.main;

import util.FormatHelper;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;

public class LoginView extends JPanel {

    private JLabel loginInfoLabel;
    private JTextArea loginTextArea;
    private JPanel loginButtonPanel;
    private JButton cancelButton;
    private JButton okButton;

    public LoginView() {

        loginInfoLabel = new JLabel();
        loginTextArea = new JTextArea();

        loginButtonPanel = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();


        setLayout(new BorderLayout());
        loginInfoLabel.setText("Please enter your name: ");
        FormatHelper.setHeight(loginInfoLabel, 50);
        cancelButton.setText("Cancel");
        okButton.setText("OK");
        add(loginInfoLabel, BorderLayout.NORTH);
        add(loginTextArea, BorderLayout.CENTER);
        add(loginButtonPanel, BorderLayout.SOUTH);
        loginButtonPanel.setLayout(new FlowLayout());
        loginButtonPanel.add(cancelButton);
        loginButtonPanel.add(okButton);




    }
    public void addOkButtonListener(ActionListener listener){
        okButton.addActionListener(listener);
    }

}
