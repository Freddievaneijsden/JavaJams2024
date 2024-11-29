package com.example;

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
    private void initialize() {
        button1.setOnAction(e -> handleButtonClick(button1));
        button2.setOnAction(e -> handleButtonClick(button2));
        button3.setOnAction(e -> handleButtonClick(button3));
        button4.setOnAction(e -> handleButtonClick(button4));
        button5.setOnAction(e -> handleButtonClick(button5));
        button6.setOnAction(e -> handleButtonClick(button6));
    }

    private void handleButtonClick(Button button) {
        System.out.println(button.getText() + " vald!");
    }
}
