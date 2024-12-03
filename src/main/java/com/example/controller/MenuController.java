package com.example.controller;

import com.example.model.Model;
import com.example.model.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;

public class MenuController {
    private final Model model = new Model();

    @FXML
    private GridPane gridPane; // Reference to the GridPane from FXML

    @FXML
    private void initialize() {
        gridPane.setStyle(
                "-fx-background-image: url('" + getClass().getResource("/com/example/javajams/images/1.png").toExternalForm() + "'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;"
        );

        resetContent(); // Populate the initial menu
    }

    private void resetContent() {
        gridPane.getChildren().clear();

        // Add the "ORDER NOW" label
        HBox orderNowBox = new HBox();
        Label orderNowLabel = new Label("ORDER NOoW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Add buttons dynamically for the menu
        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Sushi", "Turkiskt", "Burger King",
                "Tacos", "Pizza Hut", "Thai", "Libanesiskt"
        );

        for (int i = 0; i < uniqueName.size(); i++) {
            String buttonName = uniqueName.get(i);
            Button button = new Button(buttonName);
            button.setStyle(
                    "-fx-font-size: 18px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #7c706d, #baada3);" +
                            "-fx-border-color: #59504e;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-background-radius: 10px;"
            );

            // Adding hower effect
            button.setOnMouseEntered(e -> button.setStyle(
                    "-fx-font-size: 18px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #93918f, #575353);" +
                            "-fx-border-color: rgba(0,0,0,0.98);" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-background-radius: 10px;"
            ));
            button.setOnMouseExited(e -> button.setStyle(
                    "-fx-font-size: 18px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #8a7975, #bdaa9d);" +
                            "-fx-border-color: #635a58;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 10px;" +
                            "-fx-background-radius: 10px;"
            ));

            button.setPrefSize(200, 50);

            gridPane.add(button, 0, i + 1);

            final int currentIndex = i;
            button.setOnAction(e -> showRestaurantInfo(currentIndex));
        }
    }

    private void updateContent(Restaurant restaurant) {
        gridPane.getChildren().clear();

        // Add the "ORDER NOW" label
        HBox orderNowBox = new HBox();
        Label orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Display information about the selected restaurant
        Label restaurantInfo = new Label(
                "Name: " + restaurant.getName() + "\n" +
                        "Address: " + restaurant.getAddress() + "\n" +
                        "Cuisine: " + restaurant.getCuisine()
        );
        restaurantInfo.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");
        gridPane.add(restaurantInfo, 0, 1, 3, 1);

        // Add a back button
        Button backButton = new Button("Back to Menu");
        backButton.setStyle("-fx-font-size: 18px;");
        backButton.setOnAction(e -> resetContent());
        gridPane.add(backButton, 0, 2, 3, 1);
    }

    private void showRestaurantInfo(int index) {
        Restaurant restaurant = model.getRestaurants().get(index);

        if (restaurant != null) {
            updateContent(restaurant); // Call the updateContent method to display the restaurant details
        } else {
            System.out.println("No restaurant found at index: " + index);
        }
    }
}
