package view.main;

import common.FormatHelper;
import view.question.AnswerView;
import view.question.ContentView;
import javax.swing.*;
import java.awt.*;

/**
 * QuestionView class contains question content view and answer view
 */
public class QuestionView extends JPanel {
    private ContentView contentView;
    private AnswerView answerView;

    public QuestionView() {
        FormatHelper.setMainPanelBorder(this, "QUESTION");

        setLayout(new BorderLayout());

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
