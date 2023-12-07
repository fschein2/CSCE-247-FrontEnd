package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Project;
import model.ProjectList;
import model.SystemFACADE;
import model.Task;

public class TaskListController implements Initializable {

    private Project project;

    @FXML
    private Button goBack;

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

}
