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
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.App;
import model.Project;
import model.ProjectList;
import model.SystemFACADE;
import model.Task;

public class TaskListController implements Initializable {

    private Project project;

    @FXML
    private Button backButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button addButton;

    @FXML
    private Text label;

    @FXML
    private VBox backlog;

    @FXML
    private VBox toDo;

    @FXML
    private VBox inProgress;

    @FXML
    private VBox completed;

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        label.setText(project.getName());

        for (Task task : project.getTasks()) {
            HBox box = new HBox();
            switch (task.getLog().getType().toString()) {
                case "BACKLOG":
                    backlog.getChildren().add(box);
                    break;
                case "TODO":
                    toDo.getChildren().add(box);
                    break;
                case "INPROGRESS":
                    inProgress.getChildren().add(box);
                    break;
                case "COMPLETE":
                    completed.getChildren().add(box);
                    break;
            }

            Text taskText = new Text();
            taskText.setText(task.toString());
            taskText.wrappingWidthProperty().bind(backlog.widthProperty());

            box.getChildren().add(taskText);

            box.setPrefHeight(Region.USE_COMPUTED_SIZE);
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("projectList.fxml"));
            Parent mainApp = loader.load();

            Scene currentScene = backButton.getScene();

            currentScene.setRoot(mainApp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addTask() {
        try {
            // Load the task entry dialog FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("taskEntryDialogue.fxml"));
            Parent root = loader.load();

            // Create a new stage for the dialog
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(scrollPane.getScene().getWindow());
            dialogStage.setScene(new Scene(root));

            // Show the dialog
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
