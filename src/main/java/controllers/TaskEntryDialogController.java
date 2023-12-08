package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Project;
import model.SystemFACADE;
import model.User;
import model.UserList;
import javafx.util.StringConverter;

public class TaskEntryDialogController implements Initializable {

    private Project project;

    @FXML
    private TextField taskNameField;

    @FXML
    private TextField contentField;

    @FXML
    private TextField priorityField;

    @FXML
    private TextField hoursToCompleteField;

    @FXML
    private TextField pointValueField;

    @FXML
    private ChoiceBox<User> userBox;

    @FXML
    private ChoiceBox<String> typeBox;

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userBox.getItems().addAll(project.getRoleMap().values());

        userBox.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return user == null ? null : user.getUserName();
            }

            @Override
            public User fromString(String arg0) {
                return null;
            }
        });

        typeBox.getItems().addAll("design", "documentation", "bug", "new feature");
    }

    @FXML
    private void addTask() {
        project.addTask(taskNameField.getText(), contentField.getText(),
                Integer.parseInt(priorityField.getText()), Integer.parseInt(hoursToCompleteField.getText()),
                userBox.getValue().getId(), Integer.parseInt(pointValueField.getText()), typeBox.getValue());
        Stage stage = (Stage) taskNameField.getScene().getWindow();
        stage.close();
    }
}
