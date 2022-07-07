module com.example.gametest {
    requires javafx.controls;
    requires javafx.fxml;
    requires CardGameLib;


    opens com.example.gametest to javafx.fxml;
    exports com.example.gametest;
}