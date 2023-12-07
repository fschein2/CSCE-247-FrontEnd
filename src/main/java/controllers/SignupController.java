package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.App;
import model.SystemFACADE;

public class SignupController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupbutton;

    @FXML
    private TextField fNameTextField;

    @FXML
    private TextField lNameTextField;

    @FXML
    private TextField uNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passTextField;


    @FXML
    void signUp(ActionEvent event) {
        if (0 == SystemFACADE.getInstance().signUp(fNameTextField.getText(), lNameTextField.getText(), emailTextField.getText(), uNameTextField.getText(), passTextField.getText())) {
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
    void switchToLoginPage(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("login.fxml"));
            Parent mainApp = loader.load();

            Scene currentScene = loginButton.getScene();

            currentScene.setRoot(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}