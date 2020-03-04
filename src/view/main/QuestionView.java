package view.main;

import util.FormatHelper;
import view.question.AnswerView;
import view.question.ChoiceView;
import view.question.ContentView;

import javax.swing.*;
import java.awt.*;

/**
 * QuestionView class contains question part and choice part which includes user's answer
 */
public class QuestionView extends JPanel {
    private ContentView contentView;
    private AnswerView answerView;

    public QuestionView() {
        FormatHelper.setMainPanelBorder(this, "QUESTION");
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
//        add(Box.createVerticalStrut(10));
        setBackground(new Color(255,255,255));
        contentView = new ContentView();
        add(contentView, BorderLayout.NORTH);

        answerView = new AnswerView();
        add(answerView, BorderLayout.CENTER);

    }

    public ContentView getContentView() {
        return contentView;
    }

    public AnswerView getAnswerView() {
        return answerView;
    }

}
