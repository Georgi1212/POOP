module com.example.zad2_test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zad2_test to javafx.fxml;
    exports com.example.zad2_test;
}