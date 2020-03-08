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

    /**
     * ControlView class controls the switch between LoginView and QuestionView
     */
    public ControlView() {
        cardLayout = new CardLayout();
        controlPanel = new JPanel();
        loginView = new LoginView();
        questionView = new QuestionView();


        controlPanel.setLayout(cardLayout);
        controlPanel.add(loginView, "1");
        controlPanel.add(questionView, "2");

        cardLayout.show(controlPanel, "1");

        ActionListener okListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginView.setUsername(loginView.getLoginTextField().getText());
                MainFrame.getTopicView().setNameLabel("Hi " + loginView.getUsername());
                cardLayout.show(controlPanel, "2");
            }
        };
        loginView.addOkButtonListener(okListener);

    }
    public QuestionView getQuestionView() {
        return questionView;
    }
}
