package view.main;

import controller.*;
import model.QuestionBank;
import model.QuestionStatistic;
import model.QuestionTime;
import view.performance.TimeView;
import view.question.AnswerView;
import javax.swing.*;
import java.awt.*;


/**
 * MainFrame class contains all views
 */
public class MainFrame extends JFrame {
    private JFrame mainFrame;
    private static TopicView topicView;

    public MainFrame() { initComponent();};

    public void initMainFrame() {
        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }

    //initiate all components
    private void initComponent() {

        QuestionBank questionBank = new QuestionBank();
        QuestionStatistic questionStatistic = new QuestionStatistic(questionBank.getAllTopics());
        QuestionTime questionTime = new QuestionTime();

        mainFrame = new JFrame("QH Quiz");
        setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ControlView controlView = new ControlView();
        mainFrame.getContentPane().add(controlView.controlPanel, BorderLayout.CENTER);

        QuestionView questionView = controlView.getQuestionView();

        topicView = new TopicView(questionBank.getAllTopics());
        mainFrame.getContentPane().add(topicView, BorderLayout.WEST);

        PerformanceView performanceView = new PerformanceView();
        mainFrame.getContentPane().add(performanceView, BorderLayout.EAST);

        ButtonView buttonView = new ButtonView();
        buttonView.disableButton();
        mainFrame.getContentPane().add(buttonView, BorderLayout.SOUTH);

        TimeView timeView = performanceView.getTimeView();
        AnswerView answerView = questionView.getAnswerView();


        // add action listeners, observers
        StartController startController = new StartController(questionBank, topicView, timeView, buttonView, answerView);
        NextController nextController = new NextController(questionBank, questionStatistic, questionTime, topicView, questionView.getAnswerView(), timeView);
        TimingController timingController = new TimingController(topicView, questionTime, questionBank);
        SubmitController submitController = new SubmitController(questionTime, questionStatistic, timeView, buttonView);
        ViewResultController viewResultController = new ViewResultController(questionTime, questionStatistic, timeView);
        TopicController topicController = new TopicController(questionBank, buttonView, submitController);
        ResetController resetController = new ResetController(questionBank, questionStatistic, questionTime, topicView, questionView.getAnswerView(), timeView, buttonView, submitController);

        topicView.addTopicSelectionListener(topicController);
        buttonView.addStartListener(startController);
        buttonView.addNextListener(nextController);
        buttonView.addSubmitListener(submitController);
        buttonView.addViewResultListener(viewResultController);
        buttonView.addResetListener(resetController);
        timeView.addTimingListener(timingController);

        questionBank.addObserver(questionView.getContentView());
        questionBank.addObserver(questionView.getAnswerView());
        questionStatistic.addObserver(performanceView);
        questionTime.addObserver(timeView);
    }
    public static TopicView getTopicView() {
        return topicView;
    }

}



