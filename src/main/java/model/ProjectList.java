package model;

import java.util.ArrayList;
import java.util.UUID;

public class ProjectList {
    public static ProjectList instance;
    private ArrayList<Project> projectList;

    /**
     * A method that creates a projectlist array
     */
    private ProjectList() {
        projectList = DataLoader.getProjects();
    }

    /**
     * A method that returns an instance of a projectlist
     * 
     * @return an instance
     */
    public static ProjectList getInstance() {
        if (instance == null) {
            instance = new ProjectList();
        }
        return instance;
    }

    /**
     * Getter for projectlist
     * 
     * @return a projectlist
     */
    public ArrayList<Project> getProjectList() {
        return this.projectList;
    }

    /**
     * A method that creates a projectboard string
     * 
     * @return a returnstring
     */
    public String ProjectBoard() {
        String returnString = "";
        if (!projectList.isEmpty()) {
            for (Project project : projectList) {
                if (project.getRoleMap().containsValue(SystemFACADE.currentUser)) {
                    returnString += project.toString();
                }
            }
        }
        return returnString;
    }

    /**
     * A method that adds a project
     * 
     * @param name
     */
    public UUID addProject(String name) {
        Project newProject = new Project(name);
        projectList.add(newProject);
        DataWriter.saveProjects();
        return newProject.getId();
    }

    /**
     * A method that removes a project
     * 
     * @param name
     */
    public void removeProject(UUID id) {
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getId().equals(id)) {
                projectList.remove(i);
                DataWriter.saveProjects();
                return;
            }
        }
    }

    /**
     * A method that selects a project
     * 
     * @param id
     * @return
     */
    public Project selectProject(UUID id) {
        for (Project project : projectList) {
            if (project.getId().equals(id)) {
                return project;
            }
        }

        return null;
    }

    /**
     * A method that checks if an id is availability
     * 
     * @param id
     * @return
     */
    public boolean checkIDAvailability(UUID id) {
        for (Project project : projectList) {
            if (id.equals(project.getId())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIDAvailabilityTask(UUID id) {
        for (Project project : projectList) {
            for (Task task : project.getTasks()) {
                if (id.equals(task.getId())) {
                    return false;
                }
            }
        }
        return true;
    }
}