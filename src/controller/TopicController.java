package controller;

import model.QuestionBank;
import view.main.ButtonView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopicController implements ActionListener {
    private QuestionBank questionBank;
    private ButtonView buttonView;

    /**
     * The constructor method to create a TopicController instance
     * @param questionBank a collection to store all the question instances
     */
    public TopicController(QuestionBank questionBank, ButtonView buttonView) {

        this.questionBank = questionBank;
        this.buttonView = buttonView;
    }

    public void actionPerformed(ActionEvent event) {
        String topic = event.getActionCommand();
        buttonView.enableStartButton();
        buttonView.disableButton();
//        questionBank.publish(topic);

    }
}