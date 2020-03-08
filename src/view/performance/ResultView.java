package view.performance;

import common.FormatHelper;
import common.Utils;
import model.QuestionStatistic;
import javax.swing.*;
import java.util.List;

/**
 * ResultView class contains ScoreView, ChartView and TotalView with bar chart
 * to show all results
 */
public class ResultView extends JPanel {
    public ResultView(QuestionStatistic questionStatistic) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(Box.createVerticalStrut(10));
//
//        ScoreView scoreView = new ScoreView();
//        scoreView.update(questionStatistic);
//        add(scoreView);

        JLabel resultLabel = new JLabel();
        String result = update(questionStatistic);
        resultLabel.setText(result);
        resultLabel.setFont(FormatHelper.setTextFont(15));
        add(resultLabel);

        add(Box.createVerticalStrut(10));

        ChartView chartView = new ChartView();
        chartView.update(questionStatistic);
        add(chartView);


        TotalView dataView = new TotalView(questionStatistic);
        add(dataView);
    }

    //update topic strength and weakness based on accuracy
    public String update(QuestionStatistic questionStatistic) {
        List<String> skilledTopics = questionStatistic.getSkilledTopics();
        List<String> weakedTopics = questionStatistic.getWeakedTopics();
        StringBuilder showMsgBuilder = new StringBuilder();
        if(skilledTopics.size() > 0){
            String goodAtShowMsg = String.format("Strength: %s", Utils.join(skilledTopics, ","));
            showMsgBuilder.append(goodAtShowMsg + System.getProperty("line.separator"));
        }
        if(weakedTopics.size() > 0){
            String weakAtShowMsg = String.format("Weakness: %s", Utils.join(weakedTopics, ","));
            showMsgBuilder.append(weakAtShowMsg + System.getProperty("line.separator"));

        }
        System.out.println(showMsgBuilder.toString());
        return showMsgBuilder.toString();

    }
}
