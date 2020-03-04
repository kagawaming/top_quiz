package controller;

import model.QuestionBank;
import model.QuestionTime;
import view.main.TopicView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // If time running out, change to next question
        if(questionTime.isTimeRunOut())
            nextQuestion();
    }

    private void nextQuestion(){
        String topic = topicView.getTopic();
        if(topic == null)
            return;
        // Reset left time
        questionTime.resetLeftTime();
        questionBank.publish(topic);
    }

}