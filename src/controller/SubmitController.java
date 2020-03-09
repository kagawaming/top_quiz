package controller;

import common.Utils;
import model.QuestionStatistic;
import model.QuestionTime;
import view.main.ButtonView;
import view.performance.ResultView;
import view.performance.TimeView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SubmitController class controls end button
 */
public class SubmitController implements ActionListener {

    private QuestionStatistic questionStatistic;
    private QuestionTime questionTime;
    private ButtonView buttonView;
    private TimeView timeView;
    private boolean isSubmitted = false;

    public SubmitController(QuestionTime questionTime, QuestionStatistic questionStatistic, TimeView timeView, ButtonView buttonView) {
        this.questionTime = questionTime;
        this.questionStatistic = questionStatistic;
        this.timeView = timeView;
        this.buttonView = buttonView;
    }

    //once submit, stop timer, enable start and view result buttons
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("submit")){
            Utils.setSound("resources/audios/piston-1.wav");
            timeView.stopTimer();
            buttonView.disableButton();
            buttonView.disableStartButton();
            buttonView.enableViewResultButton();
            showResultDialog();

        }
    }

    public void reset() {
        this.isSubmitted = false;
    }

    public boolean getIsSubmitted() {
        return this.isSubmitted;
    }

    //show dialog to ask users if they are sure to end the quiz
    private void showResultDialog() {
        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
        JLabel msgLabel = new JLabel("Are you sure to submit the quiz?");

        int dialogRes = JOptionPane.showConfirmDialog(null, msgLabel, "", dialogButton);

        if (dialogRes == JOptionPane.OK_OPTION) {
            showResultView();
            this.isSubmitted = true;
        } else {
            timeView.startTimer();
            buttonView.enableButton();
            buttonView.disableStartButton();
            buttonView.disableViewResultButton();
        }
    }

    //show quiz result with text and chart
    private void showResultView(){
        JPanel resultView = new ResultView(questionStatistic);
        final JOptionPane pane = new JOptionPane(resultView);
        final JDialog dialog = pane.createDialog(null, "Your Answering Result");
        dialog.setPreferredSize(new Dimension(450, 450));
        dialog.setVisible(true);
    }
}

