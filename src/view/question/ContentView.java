package view.question;

import model.Question;
import view.PuzzleEx;
import view.performance.TimeView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ContentView extends JPanel implements Observer {

    private JTextArea contentArea;

//    private Question question;


    public ContentView() {
        setBackground(new Color(255,255,255));
        contentArea = new JTextArea(10, 30);
//        contentArea.setFont(Utils.getFormatFont());
        contentArea.setLineWrap(true);
//        add(contentArea);
//        PuzzleEx puzzleEx = new PuzzleEx();
//        add(puzzleEx);


        add(contentArea);
//        add(new ImageView());

    }


    @Override
    public void update(Observable o, Object arg) {
        if(arg == null)
            contentArea.setText("No question available T.T");

        else{
            Question question = (Question) arg;
            contentArea.setText(question.getQuestionContent());

        }
    }
}
