package com.example.controller;

import com.example.model.Model;
import com.example.model.Restaurant;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import java.awt.*;
import java.util.*;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuController {
    private final Model model = new Model();

    private static final String DEFAULT_BACKGROUND = "/com/example/javajams/images/rest.jpg";

    @FXML
    private GridPane gridPane; // Reference to the GridPane from FXML

    @FXML
    private void initialize() {
        gridPane.setStyle(
                "-fx-background-image: url('" + getClass().getResource("/com/example/javajams/images/rest.jpg").toExternalForm() + "'); " +
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

        // Add backgrounds
        Image orderNowImage = new Image(getClass().getResource("/com/example/javajams/images/tt.png").toExternalForm());
        ImageView orderNowImageView = new ImageView(orderNowImage);
        orderNowImageView.setFitWidth(600);
        orderNowImageView.setFitHeight(120);
        orderNowImageView.setPreserveRatio(true);
        GridPane.setConstraints(orderNowImageView, 0, 0, 4, 1);
        GridPane.setHalignment(orderNowImageView, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(orderNowImageView, javafx.geometry.VPos.CENTER);
        gridPane.getChildren().add(orderNowImageView);

        // Add restaurants
        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Libanesiskt", "Burger King", "McDonalds",
                "Tacos", "Turkiskt", "Pizza Hut", "Dominos", "Thai",
                "Vietnamesiskt"
        );

        // Add vbox to get vertical
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
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

            // Hover effect
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
            final int currentIndex = i;
            button.setOnAction(e -> showRestaurantInfo(currentIndex));

            // Add every button
            buttonBox.getChildren().add(button);
        }

        // Add vbox with buttons
        GridPane.setConstraints(buttonBox, 0, 1, 4, 1);
        gridPane.getChildren().add(buttonBox);
      
        Button surstrommingButton = new Button("Surströmming");
        surstrommingButton.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #7c706d, #baada3);" +
                        "-fx-border-color: #59504e;" +
                        "-fx-border-width: 4px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;"
        );

        surstrommingButton.setOnMouseEntered(e -> surstrommingButton.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #93918f, #575353);" +
                        "-fx-border-color: rgba(0,0,0,0.98);" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;"
        ));
        surstrommingButton.setOnMouseExited(e -> surstrommingButton.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #8a7975, #bdaa9d);" +
                        "-fx-border-color: #635a58;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;"
        ));

        surstrommingButton.setPrefSize(200, 50);



        // Unik logik för Surströmming-knappen
        surstrommingButton.setOnAction(e -> showSurstrommingScene());
        gridPane.add(surstrommingButton, 0, uniqueName.size() + 1);
        buttonBox.getChildren().add(surstrommingButton);
    }




    private void updateContent(Restaurant restaurant) {
        gridPane.getChildren().clear();
        gridPane.setAlignment(Pos.TOP_CENTER);

        if (restaurant.getBackgroundImage() != null) {
            gridPane.setStyle(
                    "-fx-background-image: url('" + getClass().getResource(restaurant.getBackgroundImage()).toExternalForm() + "'); " +
                            "-fx-background-size: 100% 55%; " +
                            "-fx-background-position: center; " +
                            "-fx-background-repeat: no-repeat;"
            );
        } else{
            if (restaurant != null && restaurant.getBackgroundImage() != null) {
                gridPane.setStyle(
                        "-fx-background-image: url('" + getClass().getResource(restaurant.getBackgroundImage()).toExternalForm() + "'); " +
                                "-fx-background-size: contain; " +
                                "-fx-background-position: center; " +
                                "-fx-background-repeat: no-repeat;");
            }
        }

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(20, 10, 20, 10));


        Label orderNowLabel = new Label(model.getRandomSurpriseLabel());
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: Black;");
        contentBox.getChildren().add(orderNowLabel);

        Label restaurantInfo = new Label(
                "Name: " + restaurant.getName() + "\n" +
                        "Address: " + restaurant.getAddress() + "\n" +
                        "Cuisine: " + restaurant.getCuisine()
        );
        restaurantInfo.setOnMouseClicked(event -> {
            String url = restaurant.getWebsite(); // Hämta restaurangens webbadress
            if (url != null && !url.isEmpty()) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(url)); // Öppnar webbläsaren
                } catch (Exception e) {
                    System.out.println("Kunde inte öppna länken: " + e.getMessage());
                }
            } else {
                System.out.println("Ingen webbadress tillgänglig för denna restaurang.");
            }
        });
        restaurantInfo.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #93918f, #575353);" +
                        "-fx-border-color: rgba(0,0,0,0.98);" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;");
        contentBox.getChildren().add(restaurantInfo);

        // Adding hover effect
        restaurantInfo.setOnMouseEntered(e -> restaurantInfo.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #93918f, #575353);" +
                        "-fx-border-color: rgba(0,0,0,0.98);" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;"
        ));
        restaurantInfo.setOnMouseExited(e -> restaurantInfo.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #8a7975, #bdaa9d);" +
                        "-fx-border-color: #635a58;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;"
        ));


        GridPane.setVgrow(contentBox, Priority.ALWAYS);
        gridPane.add(contentBox, 0, 0);

        HBox buttonBox = new HBox(20); // 20px spacing mellan knapparna
        buttonBox.setAlignment(Pos.BOTTOM_CENTER); // Centrera knappar längst ner

        // Yes button
        Image yesImage = new Image(getClass().getResource("/com/example/javajams/images/Ja.jpg").toExternalForm());
        ImageView yesImageView = new ImageView(yesImage);
        yesImageView.setFitWidth(150);
        yesImageView.setFitHeight(150);
        yesImageView.setPreserveRatio(true);

        Button yesButton = new Button();
        yesButton.setGraphic(yesImageView);
        yesButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        yesButton.setOnAction(e -> showConfirmationMessage(restaurant));

        // No button
        Image noImage = new Image(getClass().getResource("/com/example/javajams/images/Nej.jpg").toExternalForm());
        ImageView noImageView = new ImageView(noImage);
        noImageView.setFitWidth(150);
        noImageView.setFitHeight(150);
        noImageView.setPreserveRatio(true);

        Button noButton = new Button();
        noButton.setGraphic(noImageView);
        noButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        noButton.setOnAction(e -> showDoubleCheckButton(restaurant));

        // add butt ons to gridpane
        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(yesButton, noButton);
        buttonsBox.setPadding(new Insets(20));

        // Add hbox to gridpane
        GridPane.setMargin(buttonsBox, new Insets(10));
        gridPane.add(buttonsBox, 0, 2);
    }


    private void showRestaurantInfo(int index) {
        Restaurant selectedRestaurant = model.getRestaurantByIndex(index);

        if (selectedRestaurant != null) {
            Restaurant mismatchedRestaurant = model.getMismatchedRestaurant(selectedRestaurant);
            updateContent(mismatchedRestaurant); // Display the mismatched restaurant's info
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

    private void showSurstrommingScene() {
        gridPane.getChildren().clear();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setStyle(
                "-fx-background-image: url('" + getClass().getResource("/com/example/javajams/images/SurStrömming.png").toExternalForm() + "'); " +
                        "-fx-background-size: contain; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;");


        // Lägger till en varningstext
        Label warningLabel = new Label("Av alla maträtter du kunde välja...");
        warningLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: red;");
        gridPane.add(warningLabel, 0, 0);

        // Lägger till lite humoristisk text
        Label descriptionLabel = new Label("Ifrågasätter starkt dina smaklökar just nu.\nVar snäll och välj en annan maträtt");
        descriptionLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        gridPane.add(descriptionLabel, 0, 1);

        // Lägg till en tillbaka-knapp
        Button backButton = new Button("Tillbaka");
        backButton.setStyle(
                "-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white; " +
                        "-fx-background-color: linear-gradient(to bottom, #7c706d, #baada3);"
        );
        backButton.setOnAction(e -> resetContent());
        gridPane.add(backButton, 0, 2);
    }
}

//    private void showRandomRestaurant() {
//        Random random = new Random();
//        int randomIndex = random.nextInt(model.getRestaurants().size());
//        Restaurant randomRestaurant = model.getRestaurants().get(randomIndex);
//        updateContent(randomRestaurant); // Show the random restaurant details
//    }
