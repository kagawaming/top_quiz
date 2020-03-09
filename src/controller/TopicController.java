package controller;

import model.QuestionBank;
import view.main.ButtonView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TopicController class controls topics
 */
public class TopicController implements ActionListener {
    private QuestionBank questionBank;
    private ButtonView buttonView;
    private SubmitController submitController;

    public TopicController(QuestionBank questionBank, ButtonView buttonView, SubmitController submitController) {

        this.questionBank = questionBank;
        this.buttonView = buttonView;
        this.submitController = submitController;
    }

    //once topic has been selected, enable start button and disable other buttons
    public void actionPerformed(ActionEvent event) {
        String topic = event.getActionCommand();
        if (!submitController.getIsSubmitted()) {
            buttonView.enableStartButton();
        } else {
            buttonView.disableStartButton();
        }
        buttonView.disableButton();
    }
}