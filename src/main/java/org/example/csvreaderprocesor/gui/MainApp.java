package org.example.csvreaderprocesor.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.csvreaderprocesor.csv.CSVDataReader;
import org.example.csvreaderprocesor.csv.CSVRow;
import org.example.csvreaderprocesor.gui.GraphWithAxes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


    public class MainApp extends Application {

        public static void main(String[] args) throws IOException {
            launch(args);
        }

        @Override
        public void start(Stage stage) {
            Button csvButton = new Button("Select CSV File");
            csvButton.setOnAction(e -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open CSV File");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    Path path = Paths.get(selectedFile.getAbsolutePath());
                    CSVDataReader csvDataReader = new CSVDataReader();
                    try {
                        List<CSVRow> rows = csvDataReader.readCSV(path.toString());
                        GraphWithAxes.display(csvDataReader);

                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("CSV File Error");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                    } catch (Exception ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Processing Error");
                        alert.setContentText(ex.getMessage());
                        alert.showAndWait();
                    }

                }
            });
            VBox root = new VBox(10);
            root.getChildren().addAll(csvButton);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CSV Reader");
            stage.show();
        }
    }
