package view.performance;

import common.FormatHelper;
import model.QuestionStatistic;

import javax.swing.*;

/**
 * ScoreView class contains totals score, right number, wrong number
 * and total answered question number
 */
public class ScoreView extends JPanel {
    private JLabel scoreLabel;
    private JLabel rightNumberLabel;
    private JLabel wrongNumberLabel;
    private JLabel totalNumberLabel;

    public ScoreView()  {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        scoreLabel = new JLabel("Score: " + 0, JLabel.LEFT);
        scoreLabel.setFont(FormatHelper.setTextFont(15));
        add(scoreLabel);

        add(Box.createVerticalStrut(10));

        rightNumberLabel = new JLabel("Right: " + 0, JLabel.LEFT);
        rightNumberLabel.setFont(FormatHelper.setTextFont(15));
        add(rightNumberLabel);

        add(Box.createVerticalStrut(10));

        wrongNumberLabel = new JLabel("Wrong: " + 0, JLabel.LEFT);
        wrongNumberLabel.setFont(FormatHelper.setTextFont(15));
        add(wrongNumberLabel);

        add(Box.createVerticalStrut(10));

        totalNumberLabel = new JLabel("Total: " + 0, JLabel.LEFT);
        totalNumberLabel.setFont(FormatHelper.setTextFont(15));
        add(totalNumberLabel);

    }

    public void update(QuestionStatistic questionStatistic) {
        scoreLabel.setText("Score: " + questionStatistic.getScore());
        rightNumberLabel.setText("Right: " + questionStatistic.getRightAns());
        int wrong = questionStatistic.getTotalAnsweredNum() - questionStatistic.getRightAns();
        wrongNumberLabel.setText("Wrong: " + wrong);
        totalNumberLabel.setText("Total: " + questionStatistic.getTotalAnsweredNum());
    }


}
