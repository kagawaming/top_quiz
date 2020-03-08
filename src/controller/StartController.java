package controller;

import common.Utils;
import model.QuestionBank;
import view.main.ButtonView;
import view.main.TopicView;
import view.performance.TimeView;
import view.question.AnswerView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * StartController class controls start button
 */
public class StartController implements ActionListener {
    private QuestionBank questionBank;
    private TopicView topicView;
    private TimeView timeView;
    private ButtonView buttonView;
    private AnswerView answerView;

    public StartController(QuestionBank questionBank, TopicView topicView, TimeView timeView, ButtonView buttonView, AnswerView answerView) {
        this.questionBank = questionBank;
        this.topicView = topicView;
        this.timeView = timeView;
        this.buttonView = buttonView;
        this.answerView = answerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        answerView.setVisible(true);
        //if topic has been selected
        if (topicView.getTopic() != null) {
            questionBank.publish(topicView.getTopic());
            timeView.startTimer();
            buttonView.enableButton();
            //once start disable start and view result buttons
            buttonView.disableStartButton();
            buttonView.disableViewResultButton();
        }
        //if topic has not been selected, pop up a dialogue to ask user
        //to select a topic before start the quiz
        else {
            int dialogButton = JOptionPane.CLOSED_OPTION;
            JLabel msgLabel = new JLabel("Please select a topic before start the quiz ^^");
            int dialogRes = JOptionPane.showConfirmDialog(null, msgLabel, "", dialogButton);
        }
        Utils.setSound("resources/audios/moon.wav");

    }
}