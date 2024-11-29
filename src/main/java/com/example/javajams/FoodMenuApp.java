package com.example.javajams;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class FoodMenuApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle(
                "-fx-padding: 20; " +
                        "-fx-alignment: center; " +
                        "-fx-background-image: url('" + getClass().getResource("/com/example/javajams/images/1.png").toExternalForm() + "'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;"
        );


        Label orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: rgba(0,0,0,0.98); -fx-halignment: center;");
        HBox orderNowBox = new HBox();
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 4, 1);

        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Sushi", "Turkiskt", "Burger King",
                "Tacos", "Pizza Hut", "Thai", "Libanesiskt"

        );

        for (int i = 0; i < uniqueName.size(); i++) {
            String buttonName = uniqueName.get(i);
            Button button = new Button(buttonName);
            button.setStyle("-fx-font-size: 20px;");
            button.setStyle("-fx-font-weight: bold;");
            button.setPrefSize(200, 50);
            gridPane.add(button, 0, i + 1);
            button.setOnAction(e -> System.out.println(buttonName + " vald!"));
        }

        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setTitle("Matmeny");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
