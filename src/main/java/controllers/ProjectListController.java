package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import library.App;
import model.Project;
import model.ProjectList;
import model.SystemFACADE;

public class ProjectListController implements Initializable {

    @FXML
    private Button account;

    @FXML
    private Button logout;

    @FXML
    private HBox parent;

    @FXML
    void primary(MouseEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ProjectList projects = SystemFACADE.getInstance().getProjects();

        for (Project project : projects.getProjectList()) {
            VBox box = new VBox();
            parent.getChildren().add(box);

            Label label = new Label();
            label.setText(project.getName());
            box.getChildren().add(label);

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

}
