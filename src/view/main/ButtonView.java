package view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * ButtonView class contains the views of start, next, submit
 * and view result buttons
 */
public class ButtonView extends JPanel {
    private JButton startButton;
    private JButton nextButton;
    private JButton submitButton;
    private JButton viewResultButton;
    private JButton resetButton;

    public ButtonView() {
        setLayout(new FlowLayout());

        startButton = new JButton("Start");

        add(startButton);

        nextButton = new JButton("Next");
        nextButton.setActionCommand("next");

        add(nextButton);

        submitButton = new JButton("End");
        submitButton.setActionCommand("submit");

        add(submitButton);


        viewResultButton = new JButton("View Result");
        viewResultButton.setActionCommand("view result");

        add(viewResultButton);

        resetButton = new JButton("Reset");
        resetButton.setActionCommand("reset");

        add(resetButton);
    }

    public void enableButton() {
        nextButton.setEnabled(true);
        submitButton.setEnabled(true);
    }

    public void disableButton() {
        nextButton.setEnabled(false);
        submitButton.setEnabled(false);
        viewResultButton.setEnabled(false);
    }

    public void enableStartButton() {
        startButton.setEnabled(true);
    }
    public void disableStartButton() {
        startButton.setEnabled(false);
    }

    public void enableViewResultButton() {
        viewResultButton.setEnabled(true);
    }
    public void disableViewResultButton() {
        viewResultButton.setEnabled(false);
    }

    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addNextListener(ActionListener listener){
        nextButton.addActionListener(listener);
    }

    public void addSubmitListener(ActionListener listener){
        submitButton.addActionListener(listener);
        nextButton.addActionListener(listener);
    }

    public void addViewResultListener(ActionListener listener){
        viewResultButton.addActionListener(listener);
    }
    public void addResetListener(ActionListener listener){
        resetButton.addActionListener(listener);
    }

}
