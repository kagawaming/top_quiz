package controller;

import model.Question;
import model.QuestionBank;
import model.QuestionStatistic;
import model.QuestionTime;
import view.main.TopicView;
import view.performance.TimeView;
import view.question.AnswerView;
import view.question.ChoiceView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NextController implements ActionListener {
    private TopicView topicView;
    private AnswerView answerView;
    private QuestionBank questionBank;
    private QuestionStatistic questionStatistic;
    private QuestionTime questionTime;
    private TimeView timeView;

    public NextController(QuestionBank questionBank, QuestionStatistic questionStatistic, QuestionTime questionTime,
                          TopicView topicView, AnswerView answerView, TimeView timeView) {
        this.questionBank = questionBank;
        this.questionStatistic = questionStatistic;
        this.questionTime = questionTime;
        this.topicView = topicView;
        this.answerView = answerView;
        this.timeView = timeView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean isRight = this.isAnswerRight();
        // Notify the model to update views
        questionStatistic.publish(isRight, questionBank.getCurrentQuestion());
        // Jump to next question
        nextQuestion();
    }

    private void nextQuestion(){
        String topic = topicView.getTopic();
        if(topic == null)
            return;
        questionBank.publish(topic);
        // Reset left time
        questionTime.resetLeftTime();
        if (questionBank.getCurrentQuestion() == null) {
            timeView.stopTimer();
        }

    }

    //Judge whether user's answer if right or not
    private boolean isAnswerRight(){
        Question currentQuestion = questionBank.getCurrentQuestion();
        if(currentQuestion == null)
            return false;
        // Set this question is answered
        currentQuestion.questionAnswered();

        ChoiceView choiceView = answerView.getChoiceView();
        if(choiceView == null)
            return false;
        ArrayList<String> userAnswer = choiceView.getUserAnswer();
        return currentQuestion.isAnsweredRight(userAnswer);
    }
}
