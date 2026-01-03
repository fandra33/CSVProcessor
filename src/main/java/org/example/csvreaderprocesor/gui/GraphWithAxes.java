package org.example.csvreaderprocesor.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.csvreaderprocesor.csv.CSVDataReader;
import org.example.csvreaderprocesor.csv.CSVRow;
import org.example.csvreaderprocesor.graph.Graph;
import javafx.scene.layout.*;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GraphWithAxes extends Application {
        public static void display(CSVDataReader csvDataReader) {
            Stage window = new Stage();
            GridPane gridPane = new GridPane();
            // Make columns grow to fill available space
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPercentWidth(50); // 50% of available width
            col1.setHgrow(Priority.ALWAYS);

            ColumnConstraints col2 = new ColumnConstraints();
            col2.setPercentWidth(50); // 50% of available width
            col2.setHgrow(Priority.ALWAYS);

            gridPane.getColumnConstraints().addAll(col1, col2);
            gridPane.setHgap(10); // horizontal gap between columns
            gridPane.setVgap(10); // vertical gap between rows
            gridPane.setPadding(new javafx.geometry.Insets(10));
            ArrayList<Graph> graphs = new ArrayList<>();

            List<String> headers = csvDataReader.getHeaders();
            for (String header : headers) {
                System.out.println("Header: " + header);
            }
            int nrHeaders = headers.size();
            int prev = -1;
            int repeatedTimes = 0;
            for (int i = 1; i < nrHeaders; i++){
                String xHeader = headers.get(0);
                String yHeader = headers.get(i);

                Graph graph = new Graph();
                graph.initializeChart(xHeader, yHeader, yHeader + " - " + xHeader, yHeader);

                for (CSVRow row : csvDataReader.getRows()) {
                    int currentTime = row.getInt(xHeader) * 10 + repeatedTimes;  // daca pot exista timpi repetati de ordinul zecilor se inlocuieste 10 cu 100
                    if (currentTime == prev) {
                        repeatedTimes += 1;
                    } else {
                        repeatedTimes = 0;
                    }
                    Number xValue = row.getInt(xHeader) * 10 + repeatedTimes;
                    prev = row.getInt(yHeader) * 10 + repeatedTimes;
                    Number yValue = row.getDouble(yHeader);
                    graph.addDataPoint(xValue, yValue);
                }
                graphs.add(graph);
            }

            for (int i = 0; i < nrHeaders-1; i++) {
                System.out.println("Graph Title: " + graphs.get(i).getLineChart().getTitle());
                for (XYChart.Data<Number, Number> dataPoint : graphs.get(i).getSeries().getData()) {
                    System.out.println("Data Point - X: " + dataPoint.getXValue() + ", Y: " + dataPoint.getYValue());
                }
                gridPane.add(graphs.get(i).getLineChart(), i%2, i/2 );
            }

            Scene scene = new Scene(gridPane);
            window.setScene(scene);
            window.show();

        }
    @Override
    public void start(Stage stage) throws IOException {
    }
}