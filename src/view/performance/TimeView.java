package view.performance;

import model.QuestionTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * TimeView class contains time count down
 * which will change color when 1/3 time left
 */
public class TimeView extends JPanel implements Observer {
    private JLabel timeLabel;
    private Timer timer;

    public TimeView() {
        timeLabel = new JLabel();

        timeLabel.setText("<html><font size='5' color=blue> Time: </font> <font size='5'color=green>" + QuestionTime.TOTAL_TIME+ "</font></html>");
        timeLabel.setFont(new Font("black",Font.BOLD ,15));
        timeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(timeLabel);
    }

    public void addTimingListener(ActionListener listener) {
        timer = new Timer(QuestionTime.DELAY_TIME * 1000, listener);
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer(){
        timer.stop();
    }

    @Override
    public void update(Observable o, Object arg) {
        QuestionTime questionTime = (QuestionTime) o;

        int leftTime = questionTime.getLeftTime();
        timeLabel.setText("<html><font size='5' color=blue> Time: </font> <font size='5'color=green>" + leftTime + "</font></html>");
        if (questionTime.isRedAlert()) {
            timeLabel.setText("<html><font size='5' color=blue> Time: </font> <font size='5'color=red>" + leftTime + "</font></html>");
        }
    }

}
