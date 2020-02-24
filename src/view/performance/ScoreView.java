package view.performance;

import util.FormatHelper;

import javax.swing.*;

public class ScoreView extends JPanel {
    private JLabel scoreLable;
    private JLabel rightNumberLable;
    private JLabel wrongNumberLable;
    private JLabel totalNumberLabel;

    public ScoreView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        scoreLable = new JLabel("Score: " + 0, JLabel.LEFT);
        scoreLable.setFont(FormatHelper.setTextFont(15));
        add(scoreLable);

        add(Box.createVerticalStrut(10));

        rightNumberLable = new JLabel("Right: " + 0, JLabel.LEFT);
        rightNumberLable.setFont(FormatHelper.setTextFont(15));
        add(rightNumberLable);

        add(Box.createVerticalStrut(10));

        wrongNumberLable = new JLabel("Wrong: " + 0, JLabel.LEFT);
        wrongNumberLable.setFont(FormatHelper.setTextFont(15));
        add(wrongNumberLable);

        add(Box.createVerticalStrut(10));

        totalNumberLabel = new JLabel("Total: " + 0, JLabel.LEFT);
        totalNumberLabel.setFont(FormatHelper.setTextFont(15));
        add(totalNumberLabel);


    }


}
