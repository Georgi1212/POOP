module registration {
   requires javafx.controls;
   requires javafx.fxml;
   requires informationValidation;


    opens com.example.registration to javafx.fxml;
    exports com.example.registration;
}