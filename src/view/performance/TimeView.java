package view.performance;

import javax.swing.*;
import java.awt.*;

public class TimeView extends JPanel {
    private JLabel timeLabel;

    public TimeView() {
        timeLabel = new JLabel();
        timeLabel.setText("Time : \n" + 0);
        timeLabel.setFont(new Font("black",Font.BOLD ,15));
        timeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(timeLabel);
        displayTime(0);
    }

    private void displayTime(int totalTime){
        removeAll();

//        cntTimer.start(currentQuestion.getGivenTime());
        timeLabel.setFont(new Font("Comic Sans",Font.BOLD ,18));
        timeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        displayGif(urlname);
        add(timeLabel);
//        add(panelGif);

        revalidate();
        repaint();
    }
}
