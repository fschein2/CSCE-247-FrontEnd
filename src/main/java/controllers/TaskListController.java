package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Project;

public class TaskListController {

    private Project project;

    @FXML
    private Button goBack;

    @FXML
    void primary(MouseEvent event) {

    }

    public void setProject(Project project) {
        this.project = project;
    }

}
