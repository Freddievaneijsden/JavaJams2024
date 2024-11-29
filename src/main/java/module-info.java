module com.example.javajams {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javajams to javafx.fxml;
    exports com.example.javajams;
    exports com.example;
    opens com.example to javafx.fxml;
}
