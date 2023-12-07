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
        SystemFACADE systemFACADE = SystemFACADE.getInstance();

        ProjectList projects = systemFACADE.getProjects();

        for (Project project : projects.getProjectList()) {
            VBox box = new VBox();
            parent.getChildren().add(box);

            Label label = new Label();
            label.setText(project.getName());
            box.getChildren().add(label);

            VBox box2 = new VBox();
            box2.setMinHeight(40);
            box.getChildren().add(box2);

            Label label2 = new Label();
            label2.setText(project.getRoleMap().get(UserRoleEnum.MASTER).getUserName());
            box.getChildren().add(label2);

            box.setOnMouseClicked(event -> handleVBoxClick(project));
        }
    }

    private void handleVBoxClick(Project project) {
        try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("taskList.fxml"));
                Parent mainApp = loader.load();

                TaskListController taskListController = loader.getController();

                taskListController.setProject(project);

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
