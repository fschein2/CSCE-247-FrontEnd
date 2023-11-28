module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens model to javafx.fxml;
    exports model;
}
