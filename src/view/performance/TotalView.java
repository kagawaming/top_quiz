package view.performance;

import common.Utils;
import model.QuestionStatistic;
import model.TopicStatistic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TotalView extends JPanel {
    private static final int VIEW_HEIGHT = 280;
    private QuestionStatistic questionStatistic;

    public TotalView(QuestionStatistic questionStatistic) {
        this.questionStatistic = questionStatistic;
        drawBarGraph();
    }

    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        Map<String, TopicStatistic> topicStatisticMap = questionStatistic.getTopicStatisticMap();
        for(String topic : this.questionStatistic.getTopicStatisticMap().keySet()){
            TopicStatistic topicStatistic = topicStatisticMap.get(topic);
            dataSet.setValue(topicStatistic.getRightNum(), "Right Num", topicStatistic.getTopic());
        }
        return dataSet;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        String chartTitle = "All Topics Right Number";

        JFreeChart barChart = ChartFactory.createBarChart3D(
                chartTitle,
                "",
                "Right Number",
                dataSet,
                PlotOrientation.VERTICAL,
                false, true, false);
        barChart.setTitle(new TextTitle(chartTitle, Utils.getBorderTitleFont(16)));

        // Apply some styles
        CategoryPlot categoryPlot = (CategoryPlot) barChart.getPlot();
        // Set Y axis font and range
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        numberAxis.setTickLabelFont(Utils.getFormatFont(Font.ITALIC | Font.BOLD, 12));
        numberAxis.setLabelFont(Utils.getFormatFont(Font.ITALIC | Font.BOLD, 14));
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Set X axis font
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setTickLabelFont(Utils.getFormatFont(Font.ITALIC | Font.BOLD, 12));

        return barChart;
    }

    private void drawBarGraph() {
        DefaultCategoryDataset dataSet = createDataset();
        JFreeChart chart = createChart(dataSet);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        add(chartPanel);
    }
}
