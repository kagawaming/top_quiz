package view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlView {
    private CardLayout cardLayout;
    public JPanel controlPanel;
    private LoginView loginView;
    private QuestionView questionView;

    public ControlView() {
        cardLayout = new CardLayout();
        controlPanel = new JPanel();
        loginView = new LoginView();
        questionView = new QuestionView();

        controlPanel.setLayout(cardLayout);

        controlPanel.add(loginView, "1");
        controlPanel.add(questionView, "2");

        cardLayout.show(controlPanel, "1");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(controlPanel, "2");
            }
        };
        loginView.addOkButtonListener(listener);
    }
}
