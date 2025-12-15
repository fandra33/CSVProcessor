package org.example.csvreaderprocesor.csv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GraphWithAxes extends Application {
        @Override
        public void start(Stage primaryStage) {
            // Create X and Y axes
            NumberAxis xAxis = new NumberAxis();
            xAxis.setLabel("Month");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Sales ($)");

            // Create line chart
            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Monthly Sales Data");

            // Create data series
            XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
            series1.setName("Product A");

            // Add your data points (month, sales)
            series1.getData().add(new XYChart.Data<>(1, 2300));
            series1.getData().add(new XYChart.Data<>(2, 3400));
            series1.getData().add(new XYChart.Data<>(3, 2800));
            series1.getData().add(new XYChart.Data<>(4, 4200));
            series1.getData().add(new XYChart.Data<>(5, 5100));
            series1.getData().add(new XYChart.Data<>(6, 4800));

            // Create another data series
            XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
            series2.setName("Product B");

            series2.getData().add(new XYChart.Data<>(1, 1500));
            series2.getData().add(new XYChart.Data<>(2, 1800));
            series2.getData().add(new XYChart.Data<>(3, 2200));
            series2.getData().add(new XYChart.Data<>(4, 2800));
            series2.getData().add(new XYChart.Data<>(5, 3500));
            series2.getData().add(new XYChart.Data<>(6, 4000));

            // Add series to chart
            lineChart.getData().addAll(series1, series2);

            VBox root = new VBox(lineChart);
            Scene scene = new Scene(root, 800, 600);

            primaryStage.setTitle("Data Graph with X and Y Axes");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }