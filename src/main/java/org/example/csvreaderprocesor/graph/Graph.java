package org.example.csvreaderprocesor.graph;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
public class Graph {
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    XYChart.Series<Number, Number> series = new XYChart.Series<>();

    public void initializeChart(String xLabel, String yLabel, String chartTitle, String seriesName) {
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
        lineChart.setTitle(chartTitle);
        series.setName(seriesName);
        lineChart.getData().add(series);
    }

    public void addDataPoint(Number x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }

    public void addSeries(XYChart.Series<Number, Number> newSeries) {
        lineChart.getData().add(newSeries);
    }

    public NumberAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(NumberAxis yAxis) {
        this.yAxis = yAxis;
    }

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(NumberAxis xAxis) {
        this.xAxis = xAxis;
    }

    public LineChart<Number, Number> getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChart<Number, Number> lineChart) {
        this.lineChart = lineChart;
    }

    public XYChart.Series<Number, Number> getSeries() {
        return series;
    }

    public void setSeries(XYChart.Series<Number, Number> series) {
        this.series = series;
    }
}
