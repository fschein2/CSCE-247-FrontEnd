package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A Design Task which is a subtype of Task
 */
public class DesignTask extends Task {
    private String toDesign;

    /**
     * Constructor for creating a Design Task with attributes
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
     * @param toDesign        Additional attribute specific to DesignTask
     */
    public DesignTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
            ArrayList<Comment> comments, int pointValue, String toDesign) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setToDesign(toDesign);
    }

    /**
     * Constructor for creating Design Task without addtitional attributes
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
     */

    public DesignTask(String name, String content, int priority, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, hoursToComplete, userID, pointValue);
    }

    /**
     * Get toDesign
     * 
     * @return toDesign
     */
    public String getToDesign() {
        return toDesign;
    }

    /**
     * Set toDesign specific to DesignTask
     * 
     * @param toDesign toDesign value to set
     */
    public void setToDesign(String toDesign) {
        this.toDesign = toDesign;
    }

    /**
     * Get task type as string
     * 
     * @return Task type as string
     */
    public String getTaskType() {
        return "DesignTask";
    }
}
