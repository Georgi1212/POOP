package com.example.gametest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.StackOfCards;

public class CardsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDealHand;

    @FXML
    private Button btnKingQueen;

    @FXML
    private Button btn4Ace;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea txaDealHand;

    @FXML
    private TextArea txaOtherActions;

    @FXML
    private Label lblKoz;

    public StackOfCards gameModel;

    @FXML
    void btn4AceOnAction(ActionEvent event) {
        if(gameModel.has4ACE()) {
            txaOtherActions.appendText("В изтеглената ръка има четворка Ace\n");
        }
        else{
            txaOtherActions.appendText("В изтеглената ръка няма четворка Ace\n");
        }

    }

    @FXML
    void btnDealHandOnAction(ActionEvent event) {
        gameModel.dealHand();
        txaDealHand.appendText(gameModel.printCards());
    }

    @FXML
    void btnKingQueenOnAction(ActionEvent event) {
        if(gameModel.hasKQ()) {
            txaOtherActions.appendText("В изтеглената ръка има двойка King-Queen\n");
        }
        else{
            txaOtherActions.appendText("В изтеглената ръка няма двойка King-Queen\n");
        }
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnDealHand != null : "fx:id=\"btnDealHand\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert btnKingQueen != null : "fx:id=\"btnKingQueen\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert btn4Ace != null : "fx:id=\"btn4Ace\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert txaDealHand != null : "fx:id=\"txaDealHand\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert txaOtherActions != null : "fx:id=\"txaOtherActions\" was not injected: check your FXML file 'cardsGame-view.fxml'.";
        assert lblKoz != null : "fx:id=\"lblKoz\" was not injected: check your FXML file 'cardsGame-view.fxml'.";

        gameModel = new StackOfCards();
        gameModel.make2packs();

        lblKoz.setText(Integer.toString(gameModel.getTrump()));

    }
}

