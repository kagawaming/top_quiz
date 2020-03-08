package view.performance;

import javax.swing.*;
import java.awt.*;
import java.text.AttributedString;
import common.FormatHelper;
import model.QuestionStatistic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 * ChartView class contains performance chart using Jfree Chart library
 */
public class ChartView extends JPanel {
    public ChartView() {
        this.setPreferredSize(new Dimension(300, 250));
    }

    public void update(QuestionStatistic questionStatistic) {
        removeAll();
        drawChart(questionStatistic);
    }
    private void drawChart(QuestionStatistic questionStatistic) {
        int rightAns = questionStatistic.getRightAns();
        int wrongAns = questionStatistic.getTotalAnsweredNum() - rightAns;

        // initialize dataset
        PieDataset pieDataSet = this.createDataset(rightAns, wrongAns);
        JFreeChart chart = createChart(pieDataSet);


        // add the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 250));
        add(chartPanel);
    }

    //create chart dataset
    private PieDataset createDataset(int right, int wrong) {
        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Right", right);
        result.setValue("Wrong", wrong);
        return result;

    }

    //create chart
    private JFreeChart createChart(PieDataset dataset) {
        String chartTitle = "Right and Wrong Numbers";

        final JFreeChart chart = ChartFactory.createPieChart3D(
                chartTitle,
                dataset,
                true,
                true,
                false
        );


        chart.setTitle(new TextTitle(chartTitle, FormatHelper.setTitleFont(16)));


        final PiePlot3D plot = (PiePlot3D) chart.getPlot();

        plot.setLabelGenerator(new CustomLabelGenerator());

        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");

        return chart;

    }

    static class CustomLabelGenerator implements PieSectionLabelGenerator{

        @Override
        public AttributedString generateAttributedSectionLabel(PieDataset arg0, Comparable arg1) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String generateSectionLabel(PieDataset dataset, Comparable key) {
            return String.format("%.0f",dataset.getValue(key));
        }

    }
}
