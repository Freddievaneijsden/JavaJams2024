package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;

    @FXML
    private void initialize() {
        button1.setOnAction(e -> handleButtonClick(button1));
        button2.setOnAction(e -> handleButtonClick(button2));
        button3.setOnAction(e -> handleButtonClick(button3));
        button4.setOnAction(e -> handleButtonClick(button4));
        button5.setOnAction(e -> handleButtonClick(button5));
        button6.setOnAction(e -> handleButtonClick(button6));
        button7.setOnAction(e -> handleButtonClick(button7));
        button8.setOnAction(e -> handleButtonClick(button8));
        button9.setOnAction(e -> handleButtonClick(button9));
        button10.setOnAction(e -> handleButtonClick(button10));
        button11.setOnAction(e -> handleButtonClick(button11));
        button12.setOnAction(e -> handleButtonClick(button12));
    }

    private void handleButtonClick(Button button) {
        System.out.println(button.getText() + " vald!");
    }
}
