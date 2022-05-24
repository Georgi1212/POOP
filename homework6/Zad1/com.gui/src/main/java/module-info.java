module com.example.comgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.providers;
    requires com.services;


    opens com.example.comgui to javafx.fxml;
    exports com.example.comgui;
}