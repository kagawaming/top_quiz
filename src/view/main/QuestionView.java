package view.main;

import util.FormatHelper;
import view.question.ContentView;
import view.question.ImageView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * QuestionView class contains question part and choice part which includes user's answer
 */
public class QuestionView extends JPanel {
    private ContentView contentView;
    private ImageView imageView;
//    private AnswerView answerView;

    public QuestionView() {
        FormatHelper.setMainPanelBorder(this, "QUESTION");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
        contentView = new ContentView();
        add(contentView);



//        imageView = new ImageView();
//        add(imageView, BorderLayout.EAST);



    }

}
