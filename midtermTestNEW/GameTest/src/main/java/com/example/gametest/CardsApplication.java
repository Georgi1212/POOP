package com.example.gametest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CardsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CardsApplication.class.getResource("cardsGame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 350);
        stage.setTitle("PlayCards");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}