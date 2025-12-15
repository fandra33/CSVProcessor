module org.example.csvreaderprocesor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires javafx.graphics;

    exports  org.example.csvreaderprocesor.csv;
    // Allow javafx.graphics to reflectively access the GUI package (needed for Application)
    opens org.example.csvreaderprocesor.gui to javafx.graphics;
    exports org.example.csvreaderprocesor.gui;
}