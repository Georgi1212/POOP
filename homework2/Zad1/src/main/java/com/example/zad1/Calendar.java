package com.example.zad1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Calendar extends Application {
    private Group group;
    private Scene scene;
    private TextInputDialog dlg;

    private void inputDialog(String infoMessage, String title) {

        dlg.setTitle(title);
        dlg.setContentText(infoMessage);
    }

    @Override
    public void start(Stage stage) throws IOException {
        group = new Group();
        scene = new Scene(group, 320, 250);
        dlg = new TextInputDialog();

        //dialog box for month
        inputDialog("Enter month: ", "Month data: ");
        int month;
        do
        {
            month = Integer.parseInt(dlg.showAndWait().get());
        } while(month < 1 || month > 12);

        //dialog box for year
        inputDialog("Enter year: ", "Year data: ");
        int year;
        do
        {
            year = Integer.parseInt(dlg.showAndWait().get());
        } while (year < 0);

        //x, y start coordinates from where we are going to display the days of the week
        double xOffset = 35;
        double yOffset = 35;

        double x = xOffset; // in order to change the position of x coordinate

        String[] daysOfTheWeek = new String[]{"MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN" };

        for(int counter = 0; counter < daysOfTheWeek.length; counter++)
        {
            Text textForDays = new Text(x, yOffset, daysOfTheWeek[counter]);
            textForDays.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
            group.getChildren().add(textForDays);
            x += 35;
        }

        yOffset += 35;

        LocalDate date = LocalDate.of(year, month, 1);
        int dayOfWeek = date.getDayOfWeek().getValue();
        int daysInMonth = date.lengthOfMonth();

        int today = LocalDate.now().getDayOfMonth(); //if the current date is 15.03.2022 -> 15
        int todayMonth = LocalDate.now().getMonthValue(); //if the current date is 15.03.2022 -> 3
        int todayYear = LocalDate.now().getYear(); //if the  current date is 15.03.2022 -> 2022

        x = xOffset + (dayOfWeek - 1) * 35; // change the x coordinate so that the number itself is exactly below the name of the day (first line)
        int temp =  dayOfWeek;

        for(int counter = 1; counter <= daysInMonth; counter++)
        {
            if(today == counter && todayMonth == month && todayYear == year)
            {
                Text textForToday = new Text(x, yOffset, Integer.toString(counter));
                textForToday.setFill(Color.RED);
                group.getChildren().add(textForToday);
            }
            else
            {
                Text textForToday = new Text(x, yOffset, Integer.toString(counter));
                group.getChildren().add(textForToday);
            }
            x += 35;

            //when temp comes 7 - we continue to next line
            if(temp == 7)
            {
                x = xOffset;
                yOffset += 35;
                temp = 0;
            }
            temp++;
        }

        stage.setTitle("Calendar for " + date.getMonth() + " " + date.getYear());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}