package controller;

        import model.QuestionBank;
        import model.QuestionStatistic;
        import model.QuestionTime;
        import view.main.*;
        import view.performance.TimeView;
        import view.question.AnswerView;

        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

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
    private SubmitController submitController;

    public ResetController(QuestionBank questionBank, QuestionStatistic questionStatistic, QuestionTime questionTime,
                           TopicView topicView, AnswerView answerView, TimeView timeView, ButtonView buttonView, SubmitController submitController) {
        this.questionBank = questionBank;
        this.questionStatistic = questionStatistic;
        this.questionTime = questionTime;
        this.topicView = topicView;
        this.answerView = answerView;
        this.timeView = timeView;
        this.buttonView = buttonView;
        this.submitController = submitController;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // notify the model to update views
        questionStatistic.reset();
        questionBank.reset();
        questionTime.resetLeftTime();
        timeView.stopTimer();
        submitController.reset();
        answerView.setVisible(false);
        buttonView.disableButton();
        buttonView.enableStartButton();
    }
}
