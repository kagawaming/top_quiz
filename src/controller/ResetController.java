package controller;

        import common.Utils;
        import model.Question;
        import model.QuestionBank;
        import model.QuestionStatistic;
        import model.QuestionTime;
        import view.main.*;
        import view.performance.TimeView;
        import view.question.AnswerView;
        import view.question.ChoiceView;

        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;

/**
 * resetController class controls reset button
 */
public class ResetController implements ActionListener {
    private TopicView topicView;
    private ButtonView buttonView;
    private AnswerView answerView;
    private QuestionBank questionBank;
    private QuestionStatistic questionStatistic;
    private QuestionTime questionTime;
    private TimeView timeView;

    public ResetController(QuestionBank questionBank, QuestionStatistic questionStatistic, QuestionTime questionTime,
                           TopicView topicView, AnswerView answerView, TimeView timeView, ButtonView buttonView) {
        this.questionBank = questionBank;
        this.questionStatistic = questionStatistic;
        this.questionTime = questionTime;
        this.topicView = topicView;
        this.answerView = answerView;
        this.timeView = timeView;
        this.buttonView = buttonView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // notify the model to update views
        questionStatistic.reset();
        questionBank.reset();
        questionTime.resetLeftTime();
        timeView.stopTimer();
        answerView.setVisible(false);
        buttonView.disableButton();
        buttonView.enableStartButton();
    }
}
