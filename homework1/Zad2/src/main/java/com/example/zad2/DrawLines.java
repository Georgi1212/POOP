package com.example.zad2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class DrawLines extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();//creating new group
        Scene scene = new Scene(group, 550, 550);//setting the scene

        //getting the scene width and height
        double width = scene.getWidth();
        double height = scene.getHeight();

        //setting the x, y start and end coordinates
        double xStartCoordinate;
        double yStartCoordinate;
        double xEndCoordinate;
        double yEndCoordinate;

        //start drawing the fist part of the picture
        xStartCoordinate = 0;
        yStartCoordinate = 0;
        xEndCoordinate = 0;
        yEndCoordinate = height;

        while (xEndCoordinate != width && yStartCoordinate != height) {
            Line line = new Line(xStartCoordinate, yStartCoordinate, xEndCoordinate, yEndCoordinate);//drawing a single Line
            line.setStroke(Color.ORANGE);//setting the Color
            group.getChildren().add(line);//Adding the Line to the scene

            xEndCoordinate += 25;
            yStartCoordinate += 25;
        }

        //start drawing the second part of the picture
        xStartCoordinate = 0;
        yStartCoordinate = height;
        xEndCoordinate = width;
        yEndCoordinate = height;

        while (xStartCoordinate != width && yEndCoordinate != 0)
        {
            Line line = new Line(xStartCoordinate, yStartCoordinate, xEndCoordinate, yEndCoordinate);//drawing a single Line
            line.setStroke(Color.ORANGE);//setting the Color
            group.getChildren().add(line);//Adding the Line to the scene

            xStartCoordinate += 25;
            yEndCoordinate -= 25;
        }

        //start drawing the third part of the picture
        xStartCoordinate = width;
        yStartCoordinate = height;
        xEndCoordinate = width;
        yEndCoordinate = 0;

        while (xEndCoordinate != 0 && yStartCoordinate != 0)
        {
            Line line = new Line(xStartCoordinate, yStartCoordinate, xEndCoordinate, yEndCoordinate);//drawing a single Line
            line.setStroke(Color.ORANGE);//setting the Color
            group.getChildren().add(line);//Adding the Line to the scene

            xEndCoordinate -= 25;
            yStartCoordinate -= 25;
        }

        //start drawing the fourth part of the picture
        xStartCoordinate = width;
        yStartCoordinate = 0;
        xEndCoordinate = 0;
        yEndCoordinate = 0;

        while (xStartCoordinate != 0 && yEndCoordinate != height)
        {
            Line line = new Line(xStartCoordinate, yStartCoordinate, xEndCoordinate, yEndCoordinate);//drawing a single Line
            line.setStroke(Color.ORANGE);//setting the Color
            group.getChildren().add(line);//Adding the Line to the scene

            xStartCoordinate -= 25;
            yEndCoordinate += 25;
        }

        primaryStage.setTitle("Canvas demo");//The name of the stage
        primaryStage.setScene(scene);//setting the scene
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}