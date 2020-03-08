package view.main;

import common.FormatHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginView class contains login view to ask user enter username
 */
public class LoginView extends JPanel {

    private JLabel loginInfoLabel;
    private JTextField loginTextField;
    private JPanel loginButtonPanel;
    private JButton cancelButton;
    private JButton okButton;
    private String username;

    public LoginView() {

        loginInfoLabel = new JLabel();
        loginTextField = new JTextField();

        loginButtonPanel = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();


        setLayout(new BorderLayout());
        loginInfoLabel.setText("Please enter your name: ");
        loginInfoLabel.setFont(new Font("black",Font.BOLD ,15));
        FormatHelper.setHeight(loginInfoLabel, 50);
        cancelButton.setText("Cancel");
        okButton.setText("OK");
        add(loginInfoLabel, BorderLayout.NORTH);
        add(loginTextField, BorderLayout.CENTER);
        add(loginButtonPanel, BorderLayout.SOUTH);
        loginButtonPanel.setLayout(new FlowLayout());
        loginButtonPanel.add(cancelButton);
        loginButtonPanel.add(okButton);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginTextField.setText("");
            }
        });

    }
    public void addOkButtonListener(ActionListener listener){
        okButton.addActionListener(listener);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }

}
