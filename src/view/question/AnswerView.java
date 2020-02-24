package view.question;

import util.FormatHelper;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AnswerView extends JPanel {
//    public abstract void displayChoice(Question question);

    public abstract ArrayList<String> getUserAnswer();
}


//single choice viewer
class SingleChoiceImpl extends AnswerView {
    private ButtonGroup choiceGroup;
    private ArrayList<JRadioButton> choiceButtons;

    public SingleChoiceImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

//    @Override
//    public void displayChoice(Question question) {
//        choiceGroup = new ButtonGroup();
//        choiceButtons = new ArrayList<>();
//
//        for (String choice : question.getChoices()) {
//            JRadioButton button = new JRadioButton(choice);
//            button.setFont(FormatHelper.setTextFont(10));
//            choiceGroup.add(button);
//            choiceButtons.add(button);
//            add(button);
//        }
//    }

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

class MultipleChoiceImpl extends AnswerView {
//    private static final String TITLE = "Multiple Choice";
    private ArrayList<JCheckBox> checkBoxes;

    public MultipleChoiceImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
//    @Override
//    public void displayChoice(Question question) {
//        checkBoxes = new ArrayList<JCheckBox>();
//        for (String choice: question.getChoices()) {
//            JCheckBox box = new JCheckBox(choice);
//            box.setFont(FormatHelper.setTextFont(10));
//            checkBoxes.add(box);
//            add(box);
//        }
//    }

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

class InputTextImpl extends AnswerView {
//    private static final int ROW_NUM = 10;
//    private static final int COLUMN_NUM = 19;

//    private static final String TITLE = "Your Answer";
    private JTextArea inputArea;

    public InputTextImpl() {
//        Utils.initSubPanelBorder(this, TITLE);
        inputArea = new JTextArea(10, 20);
        add(inputArea);
    }
//    @Override
//    public void displayChoice(Question question) {
//        inputArea.setFont(FormatHelper.setTextFont(10));
//    }

    @Override
    public ArrayList<String> getUserAnswer() {
        ArrayList<String> userAnswer = new ArrayList<>();
        userAnswer.add(inputArea.getText().trim());
        return userAnswer;
    }
}