package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.App;
import model.SystemFACADE;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    void login(ActionEvent event) {
        if (SystemFACADE.getInstance().login(userTextField.getText(), passwordTextField.getText())) {
            // Load and switch to the new FXML file (assuming "MainApp.fxml" here)
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("projectList.fxml"));
                Parent mainApp = loader.load();

                Scene currentScene = loginButton.getScene();

                currentScene.setRoot(mainApp);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void switchToSignup(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("signup.fxml"));
            Parent mainApp = loader.load();

            Scene currentScene = signupButton.getScene();

            currentScene.setRoot(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}