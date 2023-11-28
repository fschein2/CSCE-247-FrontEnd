package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Responsible for writing data to JSON files
 */
public class DataWriter extends DataConstants {

    /**
     * Save user data to JSON file
     */
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save project data to JSON file
     */
    public static void saveProjects() {
        ProjectList projects = ProjectList.getInstance();
        ArrayList<Project> projectList = projects.getProjectList();
        JSONArray jsonProjects = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < projectList.size(); i++) {
            jsonProjects.add(getProjectJSON(projectList.get(i)));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {

            file.write(jsonProjects.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save task data to JSON file
     */
    public static void saveTasks() {
        ProjectList projects = ProjectList.getInstance();
        ArrayList<Project> projectList = projects.getProjectList();
        JSONArray jsonTasks = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < projectList.size(); i++) {
            for (Task task : projectList.get(i).getTasks()) {
                jsonTasks.add(getTaskJSON(task));
            }
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {

            file.write(jsonTasks.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert User to JSON object
     * 
     * @param user The User object to convert
     * @return A JSON object which represents the user
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL, user.getEmail());

        return userDetails;
    }

    /**
     * Convert Project to JSON object
     * 
     * @param project The Project object to convert
     * @return A JSON object which represents the project
     */
    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectDetails = new JSONObject();
        projectDetails.put(PROJECT_ID, project.getId().toString());
        projectDetails.put(PROJECT_NAME, project.getName());

        ArrayList<Task> tasks = project.getTasks();
        JSONArray tasksJSON = new JSONArray();

        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                tasksJSON.add(task.getID().toString());
            }
        }
        projectDetails.put(TASK_IDS, tasksJSON);

        ArrayList<Comment> comments = project.getComments();
        JSONArray commentsJSON = new JSONArray();

        if (!comments.isEmpty()) {
            for (Comment comment : comments) {
                commentsJSON.add(getCommentJSON(comment));
            }
        }
        projectDetails.put(COMMENTS, commentsJSON);

        JSONArray rolesJSON = new JSONArray();
        HashMap<UserRoleEnum, User> roleMap = project.getRoleMap();
        if (roleMap.isEmpty()) {
            for (Map.Entry<UserRoleEnum, User> entry : roleMap.entrySet()) {
                rolesJSON.add(getRoleObject(entry));

            }
        }
        projectDetails.put(ROLE_MAP, rolesJSON);

        return projectDetails;
    }

    /**
     * Convert Comment to JSON object
     * 
     * @param comment The Comment object to convert
     * @return JSON object which represents the comment
     */
    public static JSONObject getCommentJSON(Comment comment) {
        JSONObject commentDetails = new JSONObject();
        commentDetails.put(COMMENTER_ID, comment.getCommenter().getId().toString());
        commentDetails.put(CONTENT, comment.getContent());
        commentDetails.put(DATE, comment.getDate().toString());

        JSONArray jsonComments = new JSONArray();

        for (Comment reply : comment.getReplies()) {
            jsonComments.add(getCommentJSON(reply));
        }
        commentDetails.put(REPLIES, jsonComments);
        return commentDetails;
    }

    /**
     * Convert UserRoleEnum-User mapping to JSON object
     * 
     * @param entry Mapping of a role to a user
     * @return JSON object which represents the role mapping
     */
    public static JSONObject getRoleObject(Map.Entry<UserRoleEnum, User> entry) {
        JSONObject roleObject = new JSONObject();
        roleObject.put(ROLE, entry.getKey().toString());
        roleObject.put(USER_ID, entry.getValue().getId().toString());
        return roleObject;
    }

    /**
     * Convert Task to JSON object
     * 
     * @param task The Task object to convert
     * @return JSON object which represents the task
     */
    public static JSONObject getTaskObject(Task task) {
        JSONObject taskObject = new JSONObject();
        taskObject.put(TASK_ID, task.getID().toString());
        taskObject.put(TASK_NAME, task.getName());
        taskObject.put(TASK_CONTENT, task.getTaskContent());
        taskObject.put(PRIORITY, task.getPriority());
        taskObject.put(TASK_TYPE, task.getTaskType());
        taskObject.put(LOG, getLogObject(task.getLog()));
        taskObject.put(HOURS, task.getHoursToComplete());
        taskObject.put(USER_ID, task.getUserId().toString());
        taskObject.put(TO_DESIGN, task.getToDesign());
        taskObject.put(TO_DOCUMENT, task.getToDocument());
        taskObject.put(REPRODUCTION_STEPS, task.getReproductionSteps());
        taskObject.put(BUG_EFFECT, task.getBugEffect());
        taskObject.put(JUSTIFICATION, task.getJustification());
        taskObject.put(INTENTION, task.getIntention());

        ArrayList<Comment> comments = task.getComments();
        JSONArray commentsJSON = new JSONArray();

        for (Comment comment : comments) {
            commentsJSON.add(getCommentJSON(comment));
        }
        taskObject.put(COMMENTS, commentsJSON);
        taskObject.put(POINT_VALUE, task.getPointValue());

        return taskObject;
    }

    /**
     * Convert Log to JSON object
     * 
     * @param log The Log object to convert
     * @return JSON object which represents the log
     */
    public static JSONObject getLogObject(Log log) {
        JSONObject logObject = new JSONObject();
        logObject.put(LOG_DATE, log.getDate().toString());
        logObject.put(LOG_ENUM, log.getType().toString());
        return logObject;
    }

    public static JSONObject getTaskJSON(Task task) {
        JSONObject taskObject = new JSONObject();
        taskObject.put(TASK_ID, task.getId().toString());
        taskObject.put(TASK_NAME, task.getName());
        taskObject.put(TASK_CONTENT, task.getTaskContent());
        taskObject.put(PRIORITY, task.getPriority());
        taskObject.put(TASK_TYPE, task.getTaskType());
        taskObject.put(LOG, getLogObject(task.getLog()));
        taskObject.put(HOURS, task.getHoursToComplete());
        taskObject.put(TASK_USER_ID, task.getUserId().toString());

        ArrayList<Comment> comments = task.getComments();
        JSONArray commentsJSON = new JSONArray();

        for (Comment comment : comments) {
            commentsJSON.add(getCommentJSON(comment));
        }
        taskObject.put(COMMENTS, commentsJSON);

        taskObject.put(POINT_VALUE, task.getPointValue());
        taskObject.put(TO_DESIGN, task.getToDesign());
        taskObject.put(TO_DOCUMENT, task.getToDocument());
        taskObject.put(REPRODUCTION_STEPS, task.getReproductionSteps());
        taskObject.put(BUG_EFFECT, task.getBugEffect());
        taskObject.put(JUSTIFICATION, task.getJustification());
        taskObject.put(INTENTION, task.getIntention());
        return taskObject;
    }
}
