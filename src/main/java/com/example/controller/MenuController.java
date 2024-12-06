package com.example.controller;

import com.example.model.Model;
import com.example.model.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MenuController {
    private final Model model = new Model();

    private static final String DEFAULT_BACKGROUND = "/com/example/javajams/images/1.png";

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

        gridPane.setStyle(
                "-fx-background-image: url('" + getClass().getResource(DEFAULT_BACKGROUND).toExternalForm() + "'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;"
        );

        // Add the "ORDER NOW" label
        HBox orderNowBox = new HBox();
        Label orderNowLabel = new Label("ORDER NoOoW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Add buttons dynamically for the menu
        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Libanesiskt", "Burger King", "McDonalds",
                "Tacos", "Turkiskt", "Pizza Hut", "Dominos", "Thai",
                "Vietnamesiskt", "Fermented Baltic Herring", "Sushi"
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

            // Adding hover effect
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

            final int currentIndex = i + 1;
            button.setOnAction(e -> showRestaurantInfo(currentIndex));
        }
    }

    private void updateContent(Restaurant restaurant) {
        gridPane.getChildren().clear();

        if (restaurant.getBackgroundImage() != null) {
            gridPane.setStyle(
                    "-fx-background-image: url('" + getClass().getResource(restaurant.getBackgroundImage()).toExternalForm() + "'); " +
                            "-fx-background-size: contain; " +
                            "-fx-background-position: center; " +
                            "-fx-background-repeat: no-repeat;"
            );
        } else{
            if (restaurant != null && restaurant.getBackgroundImage() != null) {
                gridPane.setStyle(
                        "-fx-background-image: url('" + getClass().getResource(restaurant.getBackgroundImage()).toExternalForm() + "'); " +
                                "-fx-background-size: cover; " +
                                "-fx-background-position: center; " +
                                "-fx-background-repeat: no-repeat;");
            }
        }

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

        // Add Yes and No buttons
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-font-size: 18px; -fx-background-color: green;");
        yesButton.setOnAction(e -> {
            // Confirm the choice (you can display a confirmation message or return to menu)
            showConfirmationMessage(restaurant);
        });
        gridPane.add(yesButton, 0, 2);

        Button noButton = new Button("No");
        noButton.setStyle("-fx-font-size: 18px; -fx-background-color: red;");
        noButton.setOnAction(e -> showDoubleCheckButton(restaurant)); // Show a random restaurant
        gridPane.add(noButton, 2, 2);
    }


    private void showRestaurantInfo(int index) {
        Restaurant restaurant = model.getRestaurants().get(index);

        if (restaurant != null) {
            updateContent(restaurant); // Call the updateContent method to display the restaurant details
        } else {
            System.out.println("No restaurant found at index: " + index);
        }
    }

    private void showConfirmationMessage(Restaurant restaurant) {
        // A confirmation alert for the user after choosing "Yes"
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Your choice");
        alert.setContentText("You have chosen " + restaurant.getName());
        alert.showAndWait();

        // After confirming, reset the content to the main menu
        resetContent();
    }

    private void showDoubleCheckButton(Restaurant restaurant) {
        // A confirmation alert for the user after choosing "Yes"
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Are you sure");
        alert.setHeaderText("You looked like you really wanted " + restaurant.getName());
        alert.setContentText("Are you positive that " + restaurant.getName() + "isn't a better choise?");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yesButton) {
            resetContent();
        }else {
        }
    }
}

//    private void showRandomRestaurant() {
//        Random random = new Random();
//        int randomIndex = random.nextInt(model.getRestaurants().size());
//        Restaurant randomRestaurant = model.getRestaurants().get(randomIndex);
//        updateContent(randomRestaurant); // Show the random restaurant details
//    }

