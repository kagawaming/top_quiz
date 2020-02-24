package view.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MainFrame class contains all views
 */
public class MainFrame extends JFrame {
    private JFrame mainFrame;

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

        mainFrame = new JFrame("Geeks Top Quiz");
        setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add question view to the center
//        QuestionView questionView = new QuestionView();
//        mainFrame.getContentPane().add(questionView, BorderLayout.CENTER);
        ControlView controlView = new ControlView();
        mainFrame.getContentPane().add(controlView.controlPanel, BorderLayout.CENTER);





        List<String> topicTest = new ArrayList<>();
        topicTest.add("Music");
        topicTest.add("Art");
        TopicView topicView = new TopicView(topicTest);
//        TopicView topicView = new TopicView(questionBank.getAllTopics());
        mainFrame.getContentPane().add(topicView, BorderLayout.WEST);

        PerformanceView performanceView = new PerformanceView();
        mainFrame.getContentPane().add(performanceView, BorderLayout.EAST);

        ButtonView buttonView = new ButtonView();
        mainFrame.getContentPane().add(buttonView, BorderLayout.SOUTH);


    }

}



