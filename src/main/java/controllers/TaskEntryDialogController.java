package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskEntryDialogController {

    @FXML
    private TextField taskNameField;

    @FXML
    private void addTask() {
        // Handle the logic for adding the task here
        String taskName = taskNameField.getText();
        // Perform any necessary actions with the taskName (e.g., add it to a list)

        // Close the dialog
        Stage stage = (Stage) taskNameField.getScene().getWindow();
        stage.close();
    }
}
