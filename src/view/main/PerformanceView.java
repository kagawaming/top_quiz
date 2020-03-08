package view.main;

import common.FormatHelper;
import model.QuestionStatistic;
import view.performance.ChartView;
import view.performance.ScoreView;
import view.performance.TimeView;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * PerformanceView class contains timer, chart and number of right and wrong questions
 */
public class PerformanceView extends JPanel implements Observer {
    private TimeView timeView;
    private ChartView chartView;
    private ScoreView scoreView;


    public PerformanceView() {
        FormatHelper.setMainPanelBorder(this, "PERFORMANCE");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setPreferredSize(new Dimension(200, 600));

        timeView = new TimeView();
        add(timeView);
        add(Box.createVerticalStrut(15));

        chartView = new ChartView();
        add(chartView);
        add(Box.createVerticalStrut(15));

        scoreView = new ScoreView();
        add(scoreView);
        add(Box.createVerticalStrut(15));

    }

    @Override
    public void update(Observable o, Object arg) {
        QuestionStatistic quesStatistic = (QuestionStatistic) o;
        scoreView.update(quesStatistic);
        chartView.update(quesStatistic);
    }

    public TimeView getTimeView() {
        return timeView;
    }
}
