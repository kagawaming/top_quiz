package controller;

import common.Utils;
import model.QuestionStatistic;
import model.QuestionTime;
import view.performance.ResultView;
import view.performance.TimeView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ViewResultController class controls view result button
 */
public class ViewResultController implements ActionListener {
    private QuestionStatistic questionStatistic;
    private QuestionTime questionTime;
    private TimeView timeView;

    public ViewResultController(QuestionTime questionTime, QuestionStatistic questionStatistic, TimeView timeView) {
        this.questionTime = questionTime;
        this.questionStatistic = questionStatistic;
        this.timeView = timeView;
    }

    //show quiz result once view result button has been selected after end the quiz
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("view result")){
            Utils.setSound("resources/audios/bubbles.wav");
            timeView.stopTimer();
            showResultView();

        }
    }

    private void showResultView(){
        JPanel resultView = new ResultView(questionStatistic);
        final JOptionPane pane = new JOptionPane(resultView);
        final JDialog dialog = pane.createDialog(null, "Your Answering Result");
        dialog.setPreferredSize(new Dimension(450, 450));
        dialog.setVisible(true);
    }
}
