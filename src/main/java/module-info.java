module org.example.csvreaderprocesor {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csvreaderprocesor to javafx.fxml;
    exports org.example.csvreaderprocesor;
}