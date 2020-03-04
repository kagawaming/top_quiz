package controller;

import model.QuestionStatistic;
import model.QuestionTime;
import view.performance.ResultView;
import view.performance.TimeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewResultController implements ActionListener {
    private QuestionStatistic questionStatistic;
    private QuestionTime questionTime;
    private TimeView timeView;

    public ViewResultController(QuestionTime questionTime, QuestionStatistic questionStatistic, TimeView timeView) {
        this.questionTime = questionTime;
        this.questionStatistic = questionStatistic;
        this.timeView = timeView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("view result")){
            timeView.stopTimer();
            showResultView();
        }
//        else if(event.getActionCommand().equals("continue")){
//            timeView.startTimer();
//        }
//
    }

//    private void showResultDialog() {
//        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
//        JLabel msgLabel = new JLabel("Are you sure to submit the quiz?");
////        msgLabel.setFont(Utils.getFormatFont(Font.BOLD | Font.ITALIC, 16));
//
//        int dialogRes = JOptionPane.showConfirmDialog(null, msgLabel, "", dialogButton);
//
//        if (dialogRes == JOptionPane.OK_OPTION) {
//            showResultView();
//        } else {
//            timeView.startTimer();
//        }
//    }

    private void showResultView(){
        JPanel resultView = new ResultView(questionStatistic);
        final JOptionPane pane = new JOptionPane(resultView);
        final JDialog dialog = pane.createDialog(null, "Your Answering Result");
        dialog.setPreferredSize(new Dimension(450, 450));
        dialog.setVisible(true);
    }
}
