module com.example.com_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.model;

    opens com.example.com_gui to javafx.fxml;
    exports com.example.com_gui;
}