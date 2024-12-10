package com.example.javajams;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FoodMenuApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javajams/hello-view.fxml"));
            Parent root = loader.load();

            // Set Scene
            Scene scene = new Scene(root, 800, 800);
            primaryStage.setTitle("Taste Twist");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
