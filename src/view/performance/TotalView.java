package view.performance;

import common.FormatHelper;
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
import java.util.Map;

/**
 * TotalView class contains bar chart by using JFree Chart library
 * to show right numbers under different topics
 */
public class TotalView extends JPanel {
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

    //create chart
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        String chartTitle = "All Topics Right Number";

        JFreeChart barChart = ChartFactory.createBarChart3D(
                chartTitle,
                "",
                "Right Number",
                dataSet,
                PlotOrientation.VERTICAL,
                false, true, false);
        barChart.setTitle(new TextTitle(chartTitle, FormatHelper.getBorderTitleFont(16)));


        CategoryPlot categoryPlot = (CategoryPlot) barChart.getPlot();
        // set Y axis
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        numberAxis.setTickLabelFont(FormatHelper.getFormatFont(Font.ITALIC | Font.BOLD, 12));
        numberAxis.setLabelFont(FormatHelper.getFormatFont(Font.ITALIC | Font.BOLD, 14));
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // set X axis
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setTickLabelFont(FormatHelper.getFormatFont(Font.ITALIC | Font.BOLD, 12));

        return barChart;
    }

    //draw bar graph
    private void drawBarGraph() {
        DefaultCategoryDataset dataSet = createDataset();
        JFreeChart chart = createChart(dataSet);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 250));
        add(chartPanel);
    }


}
