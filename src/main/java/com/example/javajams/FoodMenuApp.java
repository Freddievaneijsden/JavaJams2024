package com.example.javajams;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FoodMenuApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Skapa layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Avstånd mellan knappar horisontellt
        gridPane.setVgap(10); // Avstånd mellan knappar vertikalt
        gridPane.setStyle(
                "-fx-padding: 20; " +
                        "-fx-alignment: center; " +
                        "-fx-background-image: url('" + getClass().getResource("/com/example/javajams/images/1.png").toExternalForm() + "'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center; " +
                        "-fx-background-repeat: no-repeat;"
        );

        // Skapa en Label med texten "ORDER NOW" och stil
        Label orderNowLabel = new Label("ORDER NOW");
        orderNowLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white; -fx-halignment: center;");

        // Skapa en HBox för att centrera "ORDER NOW" mellan knapparna
        HBox orderNowBox = new HBox();
        orderNowBox.getChildren().add(orderNowLabel);
        orderNowBox.setStyle("-fx-alignment: center;");

        // Lägg till HBox i GridPane, placera den i rad 0, kolumn 0
        gridPane.add(orderNowBox, 0, 0, 3, 1); // Kolumn 0-2, Rad 0, så att den täcker hela bredden och centrerar etiketten

        // Skapa knappar och lägg till dem på olika rader
        for (int i = 0; i < 6; i++) {
            Button button = new Button("Maträtt " + (i + 1));
            button.setPrefSize(200, 50); // Gör knapparna bredare (200px bred, 50px hög)

            // Lägg till knapp på rad i GridPane (kolumn 0, rad i+1 så att den inte täcker Label)
            gridPane.add(button, 0, i + 1); // Kolumn 0, Rad i+1

            // Lägg till knappaction
            button.setOnAction(e -> System.out.println(button.getText() + " vald!"));
        }

        // Skapa scen och visa fönstret
        Scene scene = new Scene(gridPane, 400, 600); // Appstorlek (400 bred, 600 hög)
        primaryStage.setTitle("Matmeny");
        primaryStage.setScene(scene);

        // Förhindra att användaren ändrar storlek på fönstret
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
