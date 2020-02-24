package view.question;

import view.PuzzleEx;

import javax.swing.*;
import java.awt.*;

public class ContentView extends JPanel {

    private JTextArea contentArea;

    public ContentView() {
        setBackground(new Color(255,255,255));
        contentArea = new JTextArea(10, 30);
//        contentArea.setFont(Utils.getFormatFont());
        contentArea.setLineWrap(true);
//        add(contentArea);
        PuzzleEx puzzleEx = new PuzzleEx();
        add(puzzleEx);
        add(new ImageView());
        update();
    }
    public void update() {
//        if(object == null)
//            questionArea.setText(NO_QUESTION);
//        else{
//            Question question = (Question) object;
//            questionArea.setText(question.getQuestionContent());
//        }
        contentArea.setText("No question yet lalala");
    }
}
