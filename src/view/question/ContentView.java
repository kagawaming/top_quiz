package view.question;

import model.Question;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * ContentView class contains question content
 */
public class ContentView extends JPanel implements Observer {

    private JTextArea contentArea;


    public ContentView() {
        setBackground(new Color(255,255,255));
        contentArea = new JTextArea(10, 30);
        contentArea.setLineWrap(true);

        add(contentArea);
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
