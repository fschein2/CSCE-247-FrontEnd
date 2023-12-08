package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import library.App;
import model.Project;
import model.ProjectList;
import model.SystemFACADE;
import model.UserRoleEnum;

public class ProjectListController implements Initializable {

    @FXML
    private Button account;

    @FXML
    private Button logout;

    @FXML
    private HBox parent;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ProjectList projects = SystemFACADE.getInstance().getProjects();

        for (Project project : projects.getProjectList()) {
            VBox invisBox = new VBox();
            parent.getChildren().add(invisBox);
            invisBox.setMinWidth(75);

            VBox box = new VBox();
            parent.getChildren().add(box);
            box.setMaxWidth(275);
            box.setMinWidth(275);
            box.setStyle(
                    "-fx-background-color: #3498db; -fx-padding: 0; -fx-spacing: 5; -fx-border-color: #000000; -fx-border-width: 0;");

            Label label = new Label();
            label.setText(project.getName());
            label.setFont(new Font(35));
            box.getChildren().add(label);

            VBox box2 = new VBox();
            box2.setMinHeight(100);
            box.getChildren().add(box2);
            box2.setStyle("-fx-background-color: #D3D3D3;");

            Label label2 = new Label();
            if (project.getRoleMap().get(UserRoleEnum.MASTER) != null) {
                label2.setText(project.getRoleMap().get(UserRoleEnum.MASTER).getUserName());
                label2.setFont(new Font(30));
            } else {
                label2.setText("No Owner Found");
            }

            box.getChildren().add(label2);
            box.setOnMouseClicked(event -> handleVBoxClick(project));
        }
    }

    private void handleVBoxClick(Project project) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("taskList.fxml"));

            // Set a custom controller factory
            loader.setControllerFactory(controllerClass -> {
                TaskListController taskListController = new TaskListController();
                taskListController.setProject(project);
                return taskListController;
            });
            Parent mainApp = loader.load();

            Scene currentScene = logout.getScene();

            currentScene.setRoot(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logout(ActionEvent event) {
        if (SystemFACADE.getInstance().logout()) {
            // Load and switch to the new FXML file (assuming "MainApp.fxml" here)
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("login.fxml"));
                Parent mainApp = loader.load();

                Scene currentScene = logout.getScene();

                currentScene.setRoot(mainApp);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void switchToAccount(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("account.fxml"));
            Parent mainApp = loader.load();

            Scene currentScene = account.getScene();

            currentScene.setRoot(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
