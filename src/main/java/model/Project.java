package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Project {
    private ArrayList<Comment> comments;
    private HashMap<UserRoleEnum, User> roleMap;
    private String projectName;
    private UUID id;
    private ArrayList<Task> taskList;

    /**
     * A method that creates a project object
     * 
     * @param projectName
     */
    public Project(String projectName) {
        setName(projectName);
        genUUID();
        comments = new ArrayList<Comment>();
        roleMap = new HashMap<UserRoleEnum, User>();
        roleMap.put(UserRoleEnum.MASTER, SystemFACADE.currentUser);
        taskList = new ArrayList<Task>();
    }

    /**
     * A method that creates a prject object with additional parameters
     * 
     * @param id
     * @param projectName
     * @param taskList
     * @param comments
     * @param roleMap
     */
    public Project(UUID id, String projectName, ArrayList<Task> taskList, ArrayList<Comment> comments,
            HashMap<UserRoleEnum, User> roleMap) {
        setId(id);
        setName(projectName);
        setComments(comments);
        setRoleMap(roleMap);
        this.taskList = taskList;
    }

    /**
     * A method that gets task
     * 
     * @return
     */
    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public Task getTaskbyId(UUID id) {
        for (Task task : this.taskList) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        return null;
    }

    /**
     * A method that adds a task
     * 
     * @param name
     * @param content
     * @param priority
     * @param log
     * @param hoursToComplete
     * @param userID
     * @param pointValue
     * @param type
     */
    public UUID addTask(String name, String content, int priority, int hoursToComplete, UUID userID,
            int pointValue, String type) {

        switch (type) {
            case "design":
                DesignTask task = new DesignTask(name, content, priority, hoursToComplete, userID, pointValue);
                taskList.add(task);
                return task.getID();

            case "documentation":
                DocumentationTask task2 = new DocumentationTask(name, content, priority, hoursToComplete, userID,
                        pointValue);
                taskList.add(task2);
                return task2.getID();

            case "bug":
                BugTask task3 = new BugTask(name, content, priority, hoursToComplete, userID, pointValue);
                taskList.add(task3);
                return task3.getID();

            case "new feature":
                NewFeatureTask task4 = new NewFeatureTask(name, content, priority, hoursToComplete, userID,
                        pointValue);
                taskList.add(task4);
                return task4.getID();

            default:
                return null;
        }
    }

    /**
     * A method that removes a task
     * 
     * @param taskID
     */
    public void removeTask(UUID taskID) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getID().equals(taskID)) {
                taskList.remove(i);
                return;
            }
        }
    }

    /**
     * A method that adds a user
     * 
     * @param role
     * @param user
     */
    public void addUser(UserRoleEnum role, User user) {
        roleMap.put(role, user);
    }

    /**
     * A method that adds a comment
     * 
     * @param comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * A method that removes a comment
     * 
     * @param comment
     */
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    /**
     * A method that displays comments
     */
    public void displayComments() {
        for (Comment comment : comments) {
            comment.toString();
        }
    }

    /**
     * Setter for name
     * 
     * @param name
     */
    public void setName(String name) {
        this.projectName = name;
    }

    /**
     * Getter for name
     * 
     * @return a projectname
     */
    public String getName() {
        return this.projectName;
    }

    /**
     * A method that generates a UUID
     */
    private void genUUID() {
        UUID tempID = UUID.randomUUID();
        boolean x = true;
        while (x) {
            if (ProjectList.getInstance().checkIDAvailability(tempID)) {
                this.id = tempID;
                x = false;
            } else {
                tempID = UUID.randomUUID();
            }
        }
    }

    /**
     * Setter for id
     * 
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for id
     * 
     * @return an id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Setter for comments
     * 
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Getter for comments
     * 
     * @return a comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Setter for rolemap
     * 
     * @param roleMap
     */
    public void setRoleMap(HashMap<UserRoleEnum, User> roleMap) {
        this.roleMap = roleMap;
    }

    /**
     * Getter for rolemap
     * 
     * @return a rolemap
     */
    public HashMap<UserRoleEnum, User> getRoleMap() {
        return roleMap;
    }

    /**
     * Tostring method for project
     */
    public String toString() {
        String returnString = "\n\nProject Name: " + this.projectName + "\nProject ID: " + this.id;
        if (taskList != null) {
            for (LogEnum logEnum : LogEnum.values()) {
                returnString += "\n" + logEnum.toString();
                for (Task task : taskList) {
                    if (task.getLog().getType() == logEnum) {
                        returnString += task.toString();
                    }
                }
                returnString += "\n";
            }
        }
        if (comments != null) {
            for (Comment comment : comments) {
                returnString += comment.toString();
            }
        }
        if (roleMap != null && !roleMap.isEmpty()) {
            for (HashMap.Entry<UserRoleEnum, User> entry : roleMap.entrySet()) {
                returnString += "\nRole: " + entry.getKey().toString() + "\nUser: " + entry.getValue().toString();
            }
        }

        return returnString;
    }
}
