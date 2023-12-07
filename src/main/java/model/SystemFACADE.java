package model;

import java.util.ArrayList;
import java.util.UUID;

public class SystemFACADE {
    private static SystemFACADE instance;
    public static User currentUser;
    public static ArrayList<Project> currentProjectList;

    private SystemFACADE() {}

    public static SystemFACADE getInstance() {
        if (instance == null) {
            instance = new SystemFACADE();
            currentUser = UserList.getInstance().checkUser("aMadden", "toKillaM0");
            System.out.println(currentUser);
        }
        return instance;
    }

    public boolean login(String username, String password) {
        UserList userList = UserList.getInstance();
        currentUser = userList.checkUser(username, password);
        System.out.println(currentUser);
        return currentUser != null;
    }

    public boolean logout() {
        saveAll();
        currentUser = null;
        currentProjectList = null;
        return currentUser == null && currentProjectList == null;
    }

    public int signUp(String firstName, String lastName, String email, String username, String password) {
        UserList userList = UserList.getInstance();

        // check if username is available
        if (userList.checkUsernameAvailability(username)) {
            if (userList.checkPasswordRequirements(password)) {
                // add user to user list
                userList.addUser(firstName, lastName, email, username, password);

                // save updated user list to data writer
                saveUsers();
                return 0;
            }
            return 1;
        }
        return 2;

    }

    public ProjectList getProjects() {
        // Needs to be specific to the currentUser
        currentProjectList = ProjectList.getInstance().getProjectList();
        return ProjectList.getInstance();
    }

    public void saveAll() {
        UserList userList = UserList.getInstance();
        ProjectList projectList = ProjectList.getInstance();
        userList.saveUsers();
        projectList.saveProjectAndTasks();
    }

    public void saveUsers() {
        UserList userList = UserList.getInstance();
        userList.saveUsers();
    }

    public void saveTasks() {
        ProjectList projectList = ProjectList.getInstance();
        projectList.saveTasks();
    }

    public void saveProjects() {
        ProjectList projectList = ProjectList.getInstance();
        projectList.saveProjects();
    }

    public Project getProjectFromList(UUID id) {
        for(int i = 0; i < currentProjectList.size(); i++) {
            if (currentProjectList.get(i).getId() == id) {
                return currentProjectList.get(i);
            }
        }

        return null;
    }


}