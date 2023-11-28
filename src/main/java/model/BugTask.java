package model;

import java.util.ArrayList;
import java.util.UUID;

public class BugTask extends Task {
    private String reproductionSteps;
    private String bugEffect;

    /**
     * A method that creates a bugtask object
     * 
     * @param id
     * @param name
     * @param content
     * @param priority
     * @param log
     * @param hoursToComplete
     * @param userID
     * @param comments
     * @param pointValue
     * @param reproductionSteps
     * @param bugEffect
     */
    public BugTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String reproductionSteps, String bugEffect) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setReproductionSteps(reproductionSteps);
        setBugEffect(bugEffect);
    }

    /**
     * A method that creates a bugtask object with different parameters
     * 
     * @param name
     * @param content
     * @param priority
     * @param log
     * @param hoursToComplete
     * @param userID
     * @param pointValue
     */
    public BugTask(String name, String content, int priority, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, hoursToComplete, userID, pointValue);

    }

    /**
     * Getter for tasktype
     */
    public String getTaskType() {
        return "BugTask";
    }

    /**
     * Getter for reproductionsteps
     */
    public String getReproductionSteps() {
        return reproductionSteps;
    }

    /**
     * Setter for reproductionsteps
     * 
     * @param reproductionSteps
     */
    public void setReproductionSteps(String reproductionSteps) {
        this.reproductionSteps = reproductionSteps;
    }

    /**
     * Getter for bugeffect
     */
    public String getBugEffect() {
        return bugEffect;
    }

    /**
     * Setter for bugeffect
     * 
     * @param bugEffect
     */
    public void setBugEffect(String bugEffect) {
        this.bugEffect = bugEffect;
    }
}