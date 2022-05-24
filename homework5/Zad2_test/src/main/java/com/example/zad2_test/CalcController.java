package com.example.zad2_test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcController {

    private enum Operation {
        PLUS, MINUS, DIVIDE, MULT, NO_OP
    };

    // keep type of current operation chosen by user
    private Operation operation;

    // keep first digit before choosing operation
    private double firstInputDigit;

    // keep second entered digit
    private double secondInputDigit;

    private double memoryNumber;

    private double result;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSubstract;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnMplus;

    @FXML
    private Button btnMminus;

    @FXML
    private Button btnMCminus;

    @FXML
    private Button btnM;


    public void setFirstInputDigit(String inputDigit){
        if(inputDigit.equals("")){
            firstInputDigit = 0;
        }
        else{
            firstInputDigit = Double.parseDouble(inputDigit);
        }
    }

    public void setSecondInputDigit(String inputDigit){
        if(inputDigit.equals("")){
            secondInputDigit = 0;
        }
        else{
            secondInputDigit = Double.parseDouble(inputDigit);
        }
    }

    public double getResult(){
        return result;
    }


    @FXML
    void btn00OnAction(ActionEvent event) {
        showDigit("00");
    }

    @FXML
    void btn0OnAction(ActionEvent event) {
        showDigit("0");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        showDigit("1");
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        showDigit(btn2.getText());
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        showDigit("3");
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        showDigit("4");
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        showDigit("5");
    }

    @FXML
    void btn6OnAction(ActionEvent event) {
        showDigit("6");
    }

    @FXML
    void btn7OnAction(ActionEvent event) {
        showDigit("7");
    }

    @FXML
    void btn8OnAction(ActionEvent event) {
        showDigit("8");
    }

    @FXML
    void btn9OnAction(ActionEvent event) {
        showDigit("9");
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        doOperation(Operation.PLUS);
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtInput.setText("0");
        operation = Operation.NO_OP;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtInput.setText("0");
    }

    @FXML
    void btnCompluteOnAction(ActionEvent event) {
        setSecondInputDigit(txtInput.getText());
        switch (operation) {
            case MULT:
                result = secondInputDigit * firstInputDigit;
                break;
            case DIVIDE:
                result = firstInputDigit / secondInputDigit;
                break;
            case PLUS:
                result = secondInputDigit + firstInputDigit;
                break;
            case MINUS:
                result = firstInputDigit - secondInputDigit;
                break;
            default:
                return;
        }
        txtInput.setText("" + result);
        operation = Operation.NO_OP;
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        doOperation(Operation.DIVIDE);
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        showDigit(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        doOperation(Operation.MULT);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSubstractOnAction(ActionEvent event) {
        doOperation(Operation.MINUS);
    }

    @FXML
    void btnMCminusOnAction(ActionEvent event) {
        memoryNumber = 0;
        txtInput.setText("0");
    }

    @FXML
    void btnMOnAction(ActionEvent event) {
        memoryNumber = checkMemoryInputNumber(txtInput.getText());
    }

    @FXML
    void btnMminusOnAction(ActionEvent event) {
        double resultSubstr = checkMemoryInputNumber(txtInput.getText()) - memoryNumber;
        txtInput.setText("" + resultSubstr);
    }

    @FXML
    void btnMplusOnAction(ActionEvent event) {
        double resultSum = memoryNumber + checkMemoryInputNumber(txtInput.getText());
        txtInput.setText("" + resultSum);
    }

    private void showDigit(String digit) {
        String text = txtInput.getText();
        if (text.equals("0")) {
            txtInput.setText(digit);
        } else {
            txtInput.setText(text + digit);
        }
    }

    private void doOperation(Operation op) { // get entered digit from text field and keep operation
        setFirstInputDigit(txtInput.getText());
        operation = op;
        txtInput.setText("0");
    }

    private double checkMemoryInputNumber(String inputDigit){
        if(inputDigit.equals("")){
            return 0;
        }
        else{
            return Double.parseDouble(inputDigit);
        }
    }

    @FXML
    void initialize() {
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btn00 != null : "fx:id=\"btn00\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnSubstract != null : "fx:id=\"btnSubstract\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnMplus != null : "fx:id=\"btnMplus\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnMminus != null : "fx:id=\"btnMminus\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnMCminus != null : "fx:id=\"btnMCminus\" was not injected: check your FXML file 'calc-view.fxml'.";
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'calc-view.fxml'.";

    }
}
