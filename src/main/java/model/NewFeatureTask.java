package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * New Feature Task which is a subtype of Task
 */
public class NewFeatureTask extends Task {
    private String justification;
    private String intention;

    /**
     * Constructor for creating New Feature Task with attributes
     * 
     * @param id              Identifier for the task
     * @param name            Name of the task
     * @param content         Content of the task
     * @param priority        Priority level of the task
     * @param log             Task's log
     * @param hoursToComplete Hours required to complete the task
     * @param userID          Identifier of the user assigned to the task
     * @param comments        List of comments associated with the task
     * @param pointValue      Point value of the task
     * @param justification   Justification for new feature
     * @param intention       Intention behind new feature
     */
    public NewFeatureTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String justification, String intention) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setJustification(justification);
        setIntention(intention);
    }

    /**
     * Constructor for creating New Feature Task wihtout additonal attributes and
     * specifying default values
     * 
     * @param name            Name of the task
     * @param content         Content of the task
     * @param priority        Priority level of the task
     * @param log             Task's log
     * @param hoursToComplete Hours required to complete the task
     * @param userID          Identifier of the user assigned to the task
     * @param pointValue      Point value of the task
     */
    public NewFeatureTask(String name, String content, int priority, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, hoursToComplete, userID, pointValue);
    }

    /**
     * Get justification for new feature
     * 
     * @return Justification for new feature
     */
    public String getJustification() {
        return justification;
    }

    /**
     * Set justification for new feature
     * 
     * @param justification Justification to set
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }

    /**
     * Get intention behind new feature
     * 
     * @return Intention behind new feature
     */
    public String getIntention() {
        return intention;
    }

    /**
     * Set intention behind new feature
     * 
     * @param intention Intention to set
     */
    public void setIntention(String intention) {
        this.intention = intention;
    }

    /**
     * Get task type as string
     * 
     * @return Task type as string
     */
    public String getTaskType() {
        return "NewFeatureTask";
    }
}
