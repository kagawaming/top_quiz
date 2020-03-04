package view.performance;

import model.QuestionStatistic;

import javax.swing.*;
import java.awt.*;

public class ResultView extends JPanel {
    public ResultView(QuestionStatistic questionStatistic) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(Box.createVerticalStrut(10));
//
        ScoreView scoreView = new ScoreView();
        scoreView.update(questionStatistic);
        add(scoreView);

        add(Box.createVerticalStrut(10));

        ChartView chartView = new ChartView();
        chartView.update(questionStatistic);
        add(chartView);

//        add(Box.createVerticalStrut(10));

        TotalView dataView = new TotalView(questionStatistic);
        add(dataView);
    }
}
