package com.example.controller;

import com.example.model.Model;
import com.example.model.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        Label orderNowLabel = new Label("ORDER NOW");
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
            button.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            button.setPrefSize(200, 50);

            gridPane.add(button, 0, i + 1);

            final int currentIndex = i;
            button.setOnAction(e -> showRestaurantInfo(currentIndex));  // Show restaurant info after clicking a button
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

        // Add "Yes" and "No" buttons for confirmation
        HBox buttonBox = new HBox();
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-font-size: 18px;");
        yesButton.setOnAction(e -> confirmRestaurant(restaurant));

        Button noButton = new Button("No");
        noButton.setStyle("-fx-font-size: 18px;");
        noButton.setOnAction(e -> showRandomRestaurant());

        buttonBox.getChildren().addAll(yesButton, noButton);
        buttonBox.setStyle("-fx-spacing: 20px; -fx-alignment: center;");
        gridPane.add(buttonBox, 0, 2, 3, 1);
    }

    private void showRestaurantInfo(int index) {
        Restaurant restaurant = model.getRestaurantByIndex(index);

        if (restaurant != null) {
            updateContent(restaurant); // Show restaurant details
        }
    }

    private void confirmRestaurant(Restaurant restaurant) {
        // Show confirmation dialog
        Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
        confirmationAlert.setTitle("Order Confirmed");
        confirmationAlert.setHeaderText("You have confirmed your order from " + restaurant.getName() + ".");
        confirmationAlert.setContentText("Enjoy your meal!");
        confirmationAlert.showAndWait();

        // After confirming, reset the content to the main menu
        resetContent();
    }

    private void showRandomRestaurant() {
        // Get a random restaurant from the list
        Random rand = new Random();
        int randomIndex = rand.nextInt(model.getRestaurants().size());
        Restaurant randomRestaurant = model.getRestaurantByIndex(randomIndex);

        if (randomRestaurant != null) {
            // Show the randomly selected restaurant's details
            updateContent(randomRestaurant);
        }
    }
}
