package view.question;

import common.FormatHelper;
import model.Question;
import view.PuzzleEx;
import view.SwingDnDFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * ChoiceView class is an abstract class
 * contains displayChoice and getUserAnswer functions
 */
public abstract class ChoiceView extends JPanel {

    //display choice according to different question types
    public abstract void displayChoice(Question question);

    //get user answers according to different question types
    public abstract ArrayList<String> getUserAnswer();
}


//single choice implementation
class SingleChoiceImpl extends ChoiceView {
    private ButtonGroup choiceGroup;
    private ArrayList<JRadioButton> choiceButtons;

    public SingleChoiceImpl() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
    }

    @Override
    public void displayChoice(Question question) {
        choiceGroup = new ButtonGroup();
        choiceButtons = new ArrayList<>();

        for (String choice : question.getChoices()) {
            JRadioButton button = new JRadioButton(choice);
            button.setFont(FormatHelper.setTextFont(15));
            choiceGroup.add(button);
            choiceButtons.add(button);
            add(button);
        }
    }

    @Override
    public ArrayList<String> getUserAnswer() {
        ArrayList<String> userAnswer = new ArrayList<>();
        for (JRadioButton button : choiceButtons) {
            if (button.isSelected()) {
                userAnswer.add(button.getText().trim());
            }
        }
        return userAnswer;
    }
}


//multiple choice implementation
class MultipleChoiceImpl extends ChoiceView {
    private ArrayList<JCheckBox> checkBoxes;

    public MultipleChoiceImpl() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
    }
    @Override
    public void displayChoice(Question question) {
        checkBoxes = new ArrayList<>();
        for (String choice: question.getChoices()) {
            System.out.println(choice);
            JCheckBox box = new JCheckBox(choice);
            box.setFont(FormatHelper.setTextFont(15));
            checkBoxes.add(box);
            add(box);
        }
    }

    @Override
    public ArrayList<String> getUserAnswer() {
        ArrayList<String> userAnswer = new ArrayList<>();

        for (JCheckBox box : checkBoxes) {
            if (box.isSelected()) {
                String choice = box.getText();
                userAnswer.add(choice);
            }
        }

        return userAnswer;
    }
}

//input text implementation
class InputTextImpl extends ChoiceView {

    private JTextArea inputArea;

    public InputTextImpl() {
        FormatHelper.setSubPanelBorder(this, "Your Answer");
        setBackground(new Color(255,255,255));
        inputArea = new JTextArea(10, 20);

        inputArea.setFont(FormatHelper.setTextFont(15));
        inputArea.setLineWrap(true);

        add(inputArea);
    }

    @Override
    public void displayChoice(Question question) {
        inputArea.setFont(FormatHelper.setTextFont(20));
    }

    @Override
    public ArrayList<String> getUserAnswer() {
        ArrayList<String> userAnswer = new ArrayList<>();
        userAnswer.add(inputArea.getText().trim());
        return userAnswer;
    }
}

//puzzle game implementation
class PuzzleImpl extends ChoiceView {

    private PuzzleEx puzzle;

    public PuzzleImpl() {
        setBackground(new Color(255,255,255));
    }

    @Override
    public void displayChoice(Question question) {
        //use multi-threading to run puzzle game
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                puzzle = new PuzzleEx(question.getPictureFilePath());
                puzzle.setVisible(true);
                add(puzzle);
            }
        });
    }

    @Override
    public ArrayList<String> getUserAnswer() {
        return puzzle.checkSolution();
    }
}


//drag and drop implementation
class DAndDImpl extends ChoiceView {
    private JTextArea inputArea;
    private SwingDnDFrame swingDnDFrame;

    public DAndDImpl() {
        setBackground(new Color(255,255,255));
    }

    @Override
    public void displayChoice(Question question) {

        //use multi-threading to run drag and drop
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingDnDFrame = new SwingDnDFrame(question.getChoices());
                add(swingDnDFrame);
            }
        });
    }

    @Override
    public ArrayList<String> getUserAnswer() {

        ArrayList<String> userAnswer = new ArrayList<>();
        userAnswer.add(swingDnDFrame.getTextArea().getText().trim());
        return userAnswer;
    }
}