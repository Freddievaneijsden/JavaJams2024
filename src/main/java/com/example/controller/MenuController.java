package com.example.controller;

import com.example.model.Model;
import com.example.model.Restaurant;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javax.swing.text.html.ImageView;
import java.util.*;

import static javax.swing.text.StyleConstants.getBackground;
import static javax.swing.text.StyleConstants.setBackground;

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
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: Black; -fx-halignment: center;");
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");
        gridPane.add(orderNowBox, 0, 0, 3, 1);

        // Add buttons dynamically for the menu
        List<String> uniqueName = Arrays.asList(
                "Persiskt", "Libanesiskt", "Burger King", "McDonalds",
                "Tacos", "Turkiskt", "Pizza Hut", "Dominos", "Thai",
                "Vietnamesiskt"
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

            gridPane.add(button, 0, i + 1);

            button.setPrefSize(200, 50);

            final int currentIndex = i;
            button.setOnAction(e -> showRestaurantInfo(currentIndex));

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
            gridPane.add(surstrommingButton, 0, uniqueName.size() + 1); // Läggs efter andra knappar

        }
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


        Label orderNowLabel = new Label("ORDER NoOoW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: Black;");
        contentBox.getChildren().add(orderNowLabel);

        Label restaurantInfo = new Label(
                "Name: " + restaurant.getName() + "\n" +
                        "Address: " + restaurant.getAddress() + "\n" +
                        "Cuisine: " + restaurant.getCuisine()
        );
        restaurantInfo.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        contentBox.getChildren().add(restaurantInfo);

        GridPane.setVgrow(contentBox, Priority.ALWAYS);
        gridPane.add(contentBox, 0, 0);

        HBox buttonBox = new HBox(20); // 20px spacing mellan knapparna
        buttonBox.setAlignment(Pos.BOTTOM_CENTER); // Centrera knappar längst ner

        // Ja-knappen
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-font-size: 18px; -fx-background-color: green; -fx-text-fill: Red;");
        yesButton.setOnAction(e -> showConfirmationMessage(restaurant));
        buttonBox.getChildren().add(yesButton);

        // Nej-knappen
        Button noButton = new Button("No");
        noButton.setStyle("-fx-font-size: 18px; -fx-background-color: red; -fx-text-fill: Green;");
        noButton.setOnAction(e -> showDoubleCheckButton(restaurant));
        buttonBox.getChildren().add(noButton);

        // Lägg till buttonBox i GridPane längst ner
        GridPane.setVgrow(buttonBox, Priority.ALWAYS);
        gridPane.add(buttonBox, 0, 2);
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
        
        DialogPane dialogPane = alert.getDialogPane()
                ;
        dialogPane.setContentText(alert.getContentText());
        dialogPane.setStyle(dialogPane.getStyle() +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: Black; " // Ändra textfärgen om nödvändigt
        );

        // Styla knapparna
        dialogPane.lookupButton(yesButton).setStyle(
                "-fx-background-color: #4CAF50; " + // Grön bakgrund
                        "-fx-text-fill: red; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px;"
        );

        dialogPane.lookupButton(noButton).setStyle(
                "-fx-background-color: #F44336; " + // Röd bakgrund
                        "-fx-text-fill: green; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px;"
        );

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

