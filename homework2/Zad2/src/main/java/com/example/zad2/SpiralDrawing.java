package com.example.zad2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class SpiralDrawing extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 420, 420);

        //center of the scene
        double xOffset = scene.getWidth() / 2;
        double yOffset = scene.getHeight() / 2;


        int counter = 0;
        while(counter < 5)
        {
            //vertical lines
            Line verticalRightLine = new Line(xOffset + (30 * counter), yOffset - (30 * counter),
                                            xOffset + (30 * counter), yOffset + 30 + (30 * counter));

            verticalRightLine.setStroke(Color.RED);
            verticalRightLine.setStrokeWidth(1);
            group.getChildren().add(verticalRightLine);

            Line verticalLeftLine = new Line(xOffset - 30 - (30 * counter), yOffset - 30 - (30 * counter),
                    xOffset - 30 - (30 * counter), yOffset + 30 + (30 * counter));

            verticalLeftLine.setStroke(Color.RED);
            verticalLeftLine.setStrokeWidth(1);
            group.getChildren().add(verticalLeftLine);


            //horizontal lines
            Line horizontalTopLine = new Line(xOffset - 30 - (30 * counter), yOffset - 30 - (30 * counter),
                    xOffset + 30 + (30 * counter), yOffset - 30 - (30 * counter));

            horizontalTopLine.setStroke(Color.RED);
            horizontalTopLine.setStrokeWidth(1);
            group.getChildren().add(horizontalTopLine);

            Line horizontalDownLine = new Line(xOffset - 30 - (30 * counter), yOffset + 30 + (30 * counter),
                    xOffset + (30 * counter), yOffset + 30 + (30 * counter));

            horizontalDownLine.setStroke(Color.RED);
            horizontalDownLine.setStrokeWidth(1);
            group.getChildren().add(horizontalDownLine);


            counter++;
        }


        stage.setTitle("Draw square shaped spiral");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}