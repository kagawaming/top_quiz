package view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonView extends JPanel {
    private JButton startButton;
    private JButton nextButton;
    private JButton submitButton;
    private JButton endButton;
    private JButton viewResultButton;

    public ButtonView() {
        setLayout(new FlowLayout());

        startButton = new JButton("Start");
//        startButton.setFont(Utils.getFormatFont());
        add(startButton);

        nextButton = new JButton("Next");
        nextButton.setActionCommand("next");
//        nextButton.setFont(Utils.getFormatFont());
        add(nextButton);

        submitButton = new JButton("Submit");
        submitButton.setActionCommand("submit");
//        submitButton.setFont(Utils.getFormatFont());
        add(submitButton);

        endButton = new JButton("End");
        endButton.setActionCommand("end");
//        endButton.setFont(Utils.getFormatFont());
        add(endButton);

        viewResultButton = new JButton("View Result");
        viewResultButton.setActionCommand("View Result");
//        viewResultButton.setFont(Utils.getFormatFont());
        add(viewResultButton);
    }

    public void enableButton() {
        nextButton.setEnabled(true);
        submitButton.setEnabled(true);
        endButton.setEnabled(true);
        viewResultButton.setEnabled(true);
    }

    public void disableButton() {
        nextButton.setEnabled(false);
        submitButton.setEnabled(false);
        endButton.setEnabled(false);
        viewResultButton.setEnabled(false);
    }

    public void disableStartButton() {
        startButton.setEnabled(false);
    }

//    public void addStartListener(ActionListener listener) {
//        startButton.addActionListener(listener);
//    }
//
//    public void addSubmitSwitchListener(ActionListener listener){
//        submitButton.addActionListener(listener);
//        nextButton.addActionListener(listener);
//    }
//
//    public void addQuizEndContinueListener(ActionListener listener){
//        endButton.addActionListener(listener);
//        continueButton.addActionListener(listener);
//    }
}
