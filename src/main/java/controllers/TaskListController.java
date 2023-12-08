package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Comment;
import model.Project;
import model.ProjectList;
import model.SystemFACADE;
import model.Task;
import model.User;
import model.UserList;

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

    @FXML
    private VBox comments;

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        label.setText(project.getName());

        for (Task task : project.getTasks()) {
            VBox box = new VBox();
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

            Insets padding = new Insets(8, 8, 0, 8);
            box.setPadding(padding);
            box.setStyle("-fx-background-color: #f0f0f0;");
            Insets margins = new Insets(10);
            VBox.setMargin(box, margins);

            Label label = new Label();
            label.setText(task.getName());
            label.setStyle("-fx-font-size: 20px;");
            label.setWrapText(true);
            box.getChildren().add(label);
            box.setPrefHeight(Region.USE_COMPUTED_SIZE);

            Insets labelPadding = new Insets(0, 0, 5, 15);
            label.setPadding(labelPadding);

            HBox hbox = new HBox();
            box.getChildren().add(hbox);

            Label label2 = new Label();
            label2.setText(task.getTaskType());
            label2.setStyle("-fx-font-size: 15px;");
            hbox.getChildren().add(label2);

            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(115);
            hbox.getChildren().add(rectangle);

            UUID id = task.getUserId();
            User user = UserList.getInstance().getUserbyId(id);

            Label label3 = new Label();
            label3.setText(user.getUserName());
            label3.setStyle("-fx-font-size: 15px;");
            hbox.getChildren().add(label3);

            VBox invisBox = new VBox();
            invisBox.setMinHeight(30);
            box.getChildren().add(invisBox);
            
        }

        for (Comment comment : project.getComments()) {
            VBox invisBox = new VBox();
            invisBox.setMinHeight(30);
            comments.getChildren().add(invisBox);

            VBox box = new VBox();
            comments.getChildren().add(box);

            Label label = new Label();
            label.setText(comment.getContent());
            
            box.getChildren().add(label);

            Label label2 = new Label();
            label2.setText(comment.getCommenter().getUserName());
            box.getChildren().add(label2);
        }
    }

}
