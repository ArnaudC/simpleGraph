package GPlot;

import GUI.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

public class GPlot {

    static List<Integer> fileList;
    private static GUI g;

    public static JPanel createDemoPanel() {
// Create a simple XY chart
        String title = "Scatter Plot from ";
        if (g.isURL()) {
            title += "URL";
        } else {
            title += "FILE";
        }
        XYSeries series = new XYSeries(title);
        for (int i = 0; i <= fileList.size() - 1; i++) {
            series.add(i, fileList.get(i));
        }

// Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart jfreechart = ChartFactory.createXYLineChart(
                title, // Title
                "x-axis", // x-axis Label
                "y-axis", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesShape(0, cross);
        if (g.isURL()) {
            renderer.setSeriesPaint(0, Color.blue);
        } else {
            renderer.setSeriesPaint(0, Color.red);
        }

        return new ChartPanel(jfreechart);
    }

    static JPanel getPlotWithScanner(Scanner s, GUI gui) {
        g = gui;
        GPlot.fileList = new ArrayList<>();
        while (s.hasNext()) {
            GPlot.fileList.add(Integer.parseInt(s.next()));
        }
        s.close();
        JPanel jpanel = GPlot.createDemoPanel();
        jpanel.setPreferredSize(new Dimension(640, 480));
        return jpanel;
    }
}
