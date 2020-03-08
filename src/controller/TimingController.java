package controller;

import model.QuestionBank;
import model.QuestionTime;
import view.main.TopicView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TimingController class controls timer
 */
public class TimingController implements ActionListener {
    private TopicView topicView;
    private QuestionTime questionTime;
    private QuestionBank questionBank;

    public TimingController(TopicView topicView, QuestionTime questionTime, QuestionBank questionBank){
        this.topicView = topicView;
        this.questionTime = questionTime;
        this.questionBank = questionBank;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        questionTime.publish();
        // ff time running out, go to next question
        if(questionTime.isTimeRunOut())
            nextQuestion();
    }

    private void nextQuestion(){
        String topic = topicView.getTopic();
        if(topic == null)
            return;
        // reset left time
        questionTime.resetLeftTime();
        //update question
        questionBank.publish(topic);
    }

}