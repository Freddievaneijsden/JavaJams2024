module com.example.javajams {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;

    opens com.example.javajams to javafx.fxml;
    opens com.example.controller to javafx.fxml;
    opens com.example.model to javafx.fxml;

    exports com.example.javajams;
    exports com.example.controller;
    exports com.example.model;

}

