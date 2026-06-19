package org.example.csvreaderprocesor.gui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.csvreaderprocesor.csv.CSVDataReader;
import org.example.csvreaderprocesor.csv.CSVRow;
import org.example.csvreaderprocesor.graph.Graph;
import org.example.csvreaderprocesor.graph.CSVTypeCheck;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GraphWithAxes extends Application {
    public static void display(CSVDataReader csvDataReader) {
        CSVTypeCheck csvTypeCheck = new CSVTypeCheck();
        if (!CSVTypeCheck.ValidCSV(csvDataReader.getHeaders())) {
            return;
        }
        VBox root = new VBox();
        Stage window = new Stage();
        ScrollPane scrollPane = new ScrollPane();
        VBox paneGraphs = new VBox();
        paneGraphs.setAlignment(Pos.CENTER); // center children horizontally
        paneGraphs.setSpacing(10);
        scrollPane.setContent(paneGraphs);
        scrollPane.setFitToWidth(true);
        TextField searchField = new TextField();
        root.getChildren().addAll(searchField, scrollPane);
        searchField.setPromptText("Search by series name...");
        ArrayList<Graph> graphs = new ArrayList<>();

        List<String> headers = csvDataReader.getHeaders();
        for (int i = 4; i < headers.size(); i++) {
            try {
                if (csvDataReader.getRows().isEmpty()) {
                    continue;
                }
                csvDataReader.getRows().getFirst().getInt(headers.get(i));
            } catch (NumberFormatException e) {
                continue;
            }
            String xHeader = "timestamp";
            String yHeader = headers.get(i);

            Graph graph = new Graph();
            graph.initializeChart(xHeader, yHeader, yHeader + " - " + xHeader, yHeader);
            int timestamp = 1;
            for (CSVRow row : csvDataReader.getRows()) {
                Number xValue = timestamp;
                timestamp++;
                Number yValue = row.getDouble(yHeader);
                graph.addDataPoint(xValue, yValue);
            }
            graphs.add(graph);
        }

        // Bind each chart's preferred width to window width (capped at 600) and make height equal to width
        for (Graph g : graphs) {
            Region chartRegion = (Region) g.getLineChart();
            // Cap size to 600 and leave a small margin (40) so charts don't touch window edges
            DoubleBinding sizeBinding = Bindings.createDoubleBinding(
                    () -> Math.max(0, Math.min(600, window.getWidth() - 40)),
                    window.widthProperty()
            );

            chartRegion.maxWidth(600);
            chartRegion.setMaxSize(600, 600);
            chartRegion.setMinSize(0, 0);
            chartRegion.prefWidthProperty().bind(sizeBinding);
            chartRegion.prefHeightProperty().bind(sizeBinding);

            StackPane container = new StackPane(chartRegion);
            container.setAlignment(Pos.CENTER);
            container.setMaxWidth(Double.MAX_VALUE); // allow VBox to center it
            paneGraphs.getChildren().add(container);
        }

        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            String query = newValue.toLowerCase();

            // Clear the current view
            paneGraphs.getChildren().clear();

            for (Graph chart : graphs) {
                boolean matches = chart.getLineChart().getData().stream()
                        .anyMatch(series -> series.getName().toLowerCase().contains(query));

                if (matches || query.isEmpty()) {
                    Region chartRegion = (Region) chart.getLineChart();
                    // Cap size to 600 and leave a small margin (40) so charts don't touch window edges
                    DoubleBinding sizeBinding = Bindings.createDoubleBinding(
                            () -> Math.max(0, Math.min(600, window.getWidth() - 40)),
                            window.widthProperty()
                    );

                    chartRegion.maxWidth(600);
                    chartRegion.setMaxSize(600, 600);
                    chartRegion.setMinSize(0, 0);
                    chartRegion.prefWidthProperty().bind(sizeBinding);
                    chartRegion.prefHeightProperty().bind(sizeBinding);

                    StackPane container = new StackPane(chartRegion);
                    container.setAlignment(Pos.CENTER);
                    container.setMaxWidth(Double.MAX_VALUE); // allow VBox to center it
                    paneGraphs.getChildren().add(container);
                }
            }
        });
        window.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
    }
}
