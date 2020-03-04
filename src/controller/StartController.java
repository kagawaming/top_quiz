package controller;

import model.QuestionBank;
import view.main.ButtonView;
import view.main.TopicView;
import view.performance.TimeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController implements ActionListener {
    private QuestionBank questionBank;

    private TopicView topicView;
    private TimeView timeView;
    private ButtonView buttonView;

    public StartController(QuestionBank questionBank, TopicView topicView, TimeView timeView, ButtonView buttonView) {
        this.questionBank = questionBank;
        this.topicView = topicView;
        this.timeView = timeView;
        this.buttonView = buttonView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("In start handler");
        if (topicView.getTopic() != null) {
            questionBank.publish(topicView.getTopic());
            timeView.startTimer();
            buttonView.enableButton();
            buttonView.disableStartButton();
            buttonView.disableViewResultButton();
        } else {
            int dialogButton = JOptionPane.CLOSED_OPTION;
            JLabel msgLabel = new JLabel("Please select a topic before start the quiz ^^");

            int dialogRes = JOptionPane.showConfirmDialog(null, msgLabel, "", dialogButton);
        }

    }

}