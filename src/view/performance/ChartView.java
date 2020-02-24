package view.performance;


import javax.swing.*;
import java.awt.*;
import java.text.AttributedString;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import util.FormatHelper;


public class ChartView extends JPanel {
    public ChartView() {
        this.setPreferredSize(new Dimension(200, 200));
        update();
    }

    public void update() {
        removeAll();
        drawChart();
    }
    private void drawChart() {
        int right = 10;
        int wrong = 2;

        PieDataset pieDataSet = this.createDataset(10, 2);
        JFreeChart chart = createChart(pieDataSet);


        // add the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(200, 200-10));
        add(chartPanel);
    }

    private PieDataset createDataset(int right, int wrong) {
        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Right", right);
        result.setValue("Wrong", wrong);
        return result;

    }

    private JFreeChart createChart(PieDataset dataset) {
        String chartTitle = "Question Answer Results";

        final JFreeChart chart = ChartFactory.createPieChart3D(
                chartTitle,
                dataset,
                true,
                true,
                false
        );

        // Apply some styles
        chart.setTitle(new TextTitle(chartTitle, FormatHelper.setTitleFont(16)));


        final PiePlot3D plot = (PiePlot3D) chart.getPlot();

        plot.setLabelGenerator(new CustomLabelGenerator());

        plot.setStartAngle(290);
//        plot.setDirection(Rotation.CLOCKWISE);
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
