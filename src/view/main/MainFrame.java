package view.main;

import controller.*;
import model.Question;
import model.QuestionBank;
import model.QuestionStatistic;
import model.QuestionTime;
import view.performance.TimeView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    private void initComponent() {
        /**
         * init models
         * ...
         */
//initiate model
        QuestionBank questionBank = new QuestionBank();
        QuestionStatistic questionStatistic = new QuestionStatistic(questionBank.getAllTopics());
        QuestionTime questionTime = new QuestionTime();

        mainFrame = new JFrame("Geeks Top Quiz");
        setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add question view to the center
//        QuestionView questionView = new QuestionView();
//        mainFrame.getContentPane().add(questionView, BorderLayout.CENTER);


        ControlView controlView = new ControlView();
        mainFrame.getContentPane().add(controlView.controlPanel, BorderLayout.CENTER);

        QuestionView questionView = controlView.getQuestionView();




//        List<String> topicTest = new ArrayList<>();
//        topicTest.add("Music");
//        topicTest.add("geography");
//        TopicView topicView = new TopicView(topicTest);
        topicView = new TopicView(questionBank.getAllTopics());
        mainFrame.getContentPane().add(topicView, BorderLayout.WEST);

        PerformanceView performanceView = new PerformanceView();
        mainFrame.getContentPane().add(performanceView, BorderLayout.EAST);

        ButtonView buttonView = new ButtonView();
        buttonView.disableButton();
        mainFrame.getContentPane().add(buttonView, BorderLayout.SOUTH);

        TimeView timeView = performanceView.getTimeView();



        // add action listeners, observers
        TopicController topicController = new TopicController(questionBank, buttonView);
        StartController startController = new StartController(questionBank, topicView, timeView, buttonView);
//        NextController nextController = new NextController(questionBank, questionTime,topicView);
        NextController nextController = new NextController(questionBank, questionStatistic, questionTime, topicView, questionView.getAnswerView(), timeView);
        TimingController timingController = new TimingController(topicView, questionTime, questionBank);
        SubmitController submitController = new SubmitController(questionTime, questionStatistic, timeView, buttonView);
        ViewResultController viewResultController = new ViewResultController(questionTime, questionStatistic, timeView);

        topicView.addTopicSelectionListener(topicController);
        buttonView.addStartListener(startController);
        buttonView.addNextListener(nextController);
        buttonView.addSubmitListener(submitController);
        buttonView.addViewResultListener(viewResultController);
//        questionButtonView.addQuizEndContinueListener(endController);
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



