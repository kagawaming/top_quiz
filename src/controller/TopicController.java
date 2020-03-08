package controller;

import model.QuestionBank;
import view.main.ButtonView;
import view.question.AnswerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TopicController class controls topics
 */
public class TopicController implements ActionListener {
    private QuestionBank questionBank;
    private ButtonView buttonView;
    private AnswerView answerView;

    public TopicController(QuestionBank questionBank, ButtonView buttonView, AnswerView answerView) {

        this.questionBank = questionBank;
        this.buttonView = buttonView;
    }

    //once topic has been selected, enable start button and disable other buttons
    public void actionPerformed(ActionEvent event) {
        String topic = event.getActionCommand();
        buttonView.enableStartButton();
        buttonView.disableButton();
    }
}