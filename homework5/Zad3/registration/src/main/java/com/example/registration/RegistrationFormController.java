package com.example.registration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import validation.Validator;

public class RegistrationFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Button btnRegistration;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private PasswordField pswConfirmPassword;

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {
        lblUsername.setText("");
        lblPhoneNumber.setText("");
        lblEmail.setText("");
        lblPassword.setText("");

        boolean isValidUsername = Validator.validateUsername(txtUsername.getText());
        boolean isValidPhone = Validator.validatePhone(txtPhoneNumber.getText());
        boolean isValidEmail = Validator.validateEmail(txtEmail.getText());
        boolean isValidConfirmPassword = Validator.validateConfirmPassword(pswPassword.getText(), pswConfirmPassword.getText());

        if(!isValidUsername){
            lblUsername.setText("Invalid username!");
        }

        if(!isValidPhone) {
            lblPhoneNumber.setText("Invalid phone number!");
        }

        if(!isValidEmail) {
            lblEmail.setText("Invalid email!");
        }

        if(pswPassword.getText() == null || pswPassword.getText().equals("")) {
            lblPassword.setText("No password is added!");
        }

        else if(!isValidConfirmPassword) {
            lblPassword.setText("Confirm password is different!");
        }

        if(lblUsername.getText().equals("") && lblPhoneNumber.getText().equals("") &&
                lblEmail.getText().equals("") && lblPassword.getText().equals("")){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful registration");
            alert.setHeaderText("You have registered an account successfully");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert lblPhoneNumber != null : "fx:id=\"lblPhoneNumber\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert btnRegistration != null : "fx:id=\"btnRegistration\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert pswPassword != null : "fx:id=\"pswPassword\" was not injected: check your FXML file 'registrationForm-view.fxml'.";
        assert pswConfirmPassword != null : "fx:id=\"pswConfirmPassword\" was not injected: check your FXML file 'registrationForm-view.fxml'.";

    }
}
