package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.SystemFACADE;

public class PrimaryController {

    @FXML
    private TextField usernameInputTextField;

    @FXML
    private TextField passwordInputTextField;

    // @FXML
    // private Button loginButton;

    // @FXML
    // private Button signupbutton;

    // @FXML
    // void login(ActionEvent event) {

    // }

    @FXML
    void switchtosignup(ActionEvent event) {

    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        SystemFACADE.login(usernameInputTextField.getText(), passwordInputTextField.getText());
    }

}