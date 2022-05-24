package com.example.comgui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;

public class Controller {

    private Alert alert;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnGenerateRandomAZ;

    @FXML
    private Button btnRandomSubsetAZ;

    @FXML
    private Button btnQuit;

    @FXML
    void btnGenerateRandomAZOnAction(ActionEvent event) {
        int size = Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt(txtSeed.getText());
        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedRandom(), seed);
        messageBox("Random subsequence of letters A - Z", "Count distinct characters out of " + size, result.toString());
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRandomSubsetAZ(ActionEvent event) {
        int size = Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt(txtSeed.getText());
        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedSelection(), seed);
        messageBox("Generate random subset A - Z", "Count distinct characters out of " + size, result.toString());
    }

    private void messageBox(String title, String headerText, String contentText){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'sample-view.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'sample-view.fxml'.";
        assert btnGenerateRandomAZ != null : "fx:id=\"btnGenerateRandomAZ\" was not injected: check your FXML file 'sample-view.fxml'.";
        assert btnRandomSubsetAZ != null : "fx:id=\"btnRandomSubsetAZ\" was not injected: check your FXML file 'sample-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample-view.fxml'.";

    }
}
