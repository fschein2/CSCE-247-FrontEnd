module com.example {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens model to javafx.fxml;
    exports model;

    opens library to javafx.fxml;
    exports library;

    opens controllers to javafx.fxml;
    exports controllers;
}
