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

    // Create the main layout and scene elements
    private GridPane gridPane;
    private Label orderNowLabel;

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
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

        // Create "ORDER NOW" label
        orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        HBox orderNowBox = new HBox();
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 4, 1);

        // List of food items (button names)
        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Sushi", "Turkiskt", "Burger King",
                "Tacos", "Pizza Hut", "Thai", "Libanesiskt"
        );

        // Loop through the food items and create a button for each
        for (int i = 0; i < uniqueName.size(); i++) {
            String buttonName = uniqueName.get(i);
            Button button = new Button(buttonName);
            button.setStyle("-fx-font-size: 20px;");
            button.setStyle("-fx-font-weight: bold;");
            button.setPrefSize(200, 50);
            gridPane.add(button, 0, i + 1);

            // Action for button click: Update content in the same window
            button.setOnAction(e -> updateContent(buttonName));
        }

        // Create the main scene and show the primary stage
        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setTitle("Matmeny");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Method to update content in the same window when a button is clicked
    private void updateContent(String foodName) {
        // Remove any previous content from the grid (optional)
        gridPane.getChildren().clear();

        // Re-add the "ORDER NOW" label back to the top
        HBox orderNowBox = new HBox();
        orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Display information about the selected food
        Label selectedFoodLabel = new Label("You selected: " + foodName);
        selectedFoodLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");
        gridPane.add(selectedFoodLabel, 0, 1, 3, 1);

        // Optionally add a button to return to the food menu
        Button backButton = new Button("Back to Menu");
        backButton.setStyle("-fx-font-size: 18px;");
        backButton.setOnAction(e -> resetContent());
        gridPane.add(backButton, 0, 2, 3, 1);
    }

    // Method to reset the content and show the food menu again
    private void resetContent() {
        // Clear all existing content
        gridPane.getChildren().clear();

        // Re-add the "ORDER NOW" label back to the top
        HBox orderNowBox = new HBox();
        orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Re-add the food selection buttons
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

            // Action for button click: Update content in the same window
            button.setOnAction(e -> updateContent(buttonName));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
