package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A Documentation Task which is a subtype of Task
 */
public class DocumentationTask extends Task {
    private String toDocument;

    /**
     * Constructor for creating a Documentation Task with attributes
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
     * @param toDocument      Additional attribute specific to DocumentationTask
     */
    public DocumentationTask(UUID id, String name, String content, int priority, Log log, int hoursToComplete,
            UUID userID, ArrayList<Comment> comments, int pointValue, String toDocument) {
        super(id, name, content, priority, log, hoursToComplete, userID, comments, pointValue);
        setToDocument(toDocument);
    }

    /**
     * Constructor for creating Documentation Task without additional attributes and
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
    public DocumentationTask(String name, String content, int priority, int hoursToComplete, UUID userID,
            int pointValue) {
        super(name, content, priority, hoursToComplete, userID, pointValue);
    }

    /**
     * Get toDocument
     * 
     * @return toDocument
     */
    public String getToDocument() {
        return toDocument;
    }

    /**
     * Set toDocument specific to DocumentationTask
     * 
     * @param toDocument toDocument value to set
     */
    public void setToDocument(String toDocument) {
        this.toDocument = toDocument;
    }

    /**
     * Get task type as string
     * 
     * @return Task type as string
     */
    public String getTaskType() {
        return "DocumentationTask";
    }
}
