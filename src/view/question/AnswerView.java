package view.question;

import common.Utils;
import model.Question;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class AnswerView extends JPanel implements Observer {
    private ImageView imageView;
    private ChoiceView choiceView;

    public AnswerView() {
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
        setBackground(new Color(255,255,255));
        imageView = null;
        choiceView = null;

    }

    public void update(Observable observable, Object object) {
        if(object == null){
            if(imageView != null)
                remove(imageView);
            if(choiceView != null)
                remove(choiceView);
            return;
        }

        Question question = (Question) object;

        //Update image of this question
        if(imageView != null)
            remove(imageView);

        imageView = new ImageView();
        String imagePath = question.getPictureFilePath();
        imageView.setImage(imagePath);
//        imageView.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(imageView, BorderLayout.NORTH);


        //Update choiceView of question area
        if(choiceView != null)
            remove(choiceView);
        choiceView = createChoiceView(question);
        add(choiceView, BorderLayout.CENTER);
        choiceView.displayChoice(question);
        revalidate();
        System.out.println("Multiple Choice");
    }

    private ChoiceView createChoiceView(Question question) {
        ChoiceView choiceView;
        String type = question.getQuestionType();

        if(type.equals(Utils.INPUT_TYPE)) {
            choiceView = new InputTextImpl();
        }else if(type.equals(Utils.SINGLE_TYPE)) {
            choiceView = new SingleChoiceImpl();
        }else if(type.equals(Utils.MULTIPLE_TYPE)) {
            choiceView = new MultipleChoiceImpl();
        }else if(type.equals("puzzle")) {
            choiceView = new PuzzleImpl();
        }else if(type.equals("dAndD")) {
            choiceView = new DAndDImpl();
        }
        else
            return null;

        return choiceView;
    }

    public ChoiceView getChoiceView() {
        return choiceView;
    }


}
