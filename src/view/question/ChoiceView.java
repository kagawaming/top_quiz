package view.question;

import model.Question;
import view.PuzzleEx;
import view.SwingDnDFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class ChoiceView extends JPanel {

    public abstract void displayChoice(Question question);

    public abstract ArrayList<String> getUserAnswer();
}


//single choice viewer
class SingleChoiceImpl extends ChoiceView {
    private ButtonGroup choiceGroup;
    private ArrayList<JRadioButton> choiceButtons;

    public SingleChoiceImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
    }

    @Override
    public void displayChoice(Question question) {
        choiceGroup = new ButtonGroup();
        choiceButtons = new ArrayList<>();

        for (String choice : question.getChoices()) {
            JRadioButton button = new JRadioButton(choice);
            button.setFont(util.FormatHelper.setTextFont(15));
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

class MultipleChoiceImpl extends ChoiceView {
//    private static final String TITLE = "Multiple Choice";
    private ArrayList<JCheckBox> checkBoxes;

    public MultipleChoiceImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
    }
    @Override
    public void displayChoice(Question question) {
        checkBoxes = new ArrayList<JCheckBox>();
        for (String choice: question.getChoices()) {
            System.out.println(choice);
            JCheckBox box = new JCheckBox(choice);
            box.setFont(util.FormatHelper.setTextFont(15));
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

class InputTextImpl extends ChoiceView {
//    private static final int ROW_NUM = 10;
//    private static final int COLUMN_NUM = 19;

//    private static final String TITLE = "Your Answer";
    private JTextArea inputArea;

    public InputTextImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setBackground(new Color(255,255,255));
        inputArea = new JTextArea(10, 20);
        add(inputArea);
    }
    @Override
    public void displayChoice(Question question) {
        inputArea.setFont(util.FormatHelper.setTextFont(10));
    }

    @Override
    public ArrayList<String> getUserAnswer() {
        ArrayList<String> userAnswer = new ArrayList<>();
        userAnswer.add(inputArea.getText().trim());
        return userAnswer;
    }
}

class PuzzleImpl extends ChoiceView {
//    private static final int ROW_NUM = 10;
//    private static final int COLUMN_NUM = 19;

    //    private static final String TITLE = "Your Answer";
    private JTextArea inputArea;
    private PuzzleEx puzzle;

    public PuzzleImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setBackground(new Color(255,255,255));
//        inputArea = new JTextArea(10, 20);
//        add(inputArea);
    }
    @Override
    public void displayChoice(Question question) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                puzzle = new PuzzleEx();
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


class DAndDImpl extends ChoiceView {
//    private static final int ROW_NUM = 10;
//    private static final int COLUMN_NUM = 19;

    //    private static final String TITLE = "Your Answer";
    private JTextArea inputArea;
    private SwingDnDFrame swingDnDFrame;

    public DAndDImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setBackground(new Color(255,255,255));
//        inputArea = new JTextArea(10, 20);
//        add(inputArea);
    }
    @Override
    public void displayChoice(Question question) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                swingDnDFrame = new SwingDnDFrame();
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