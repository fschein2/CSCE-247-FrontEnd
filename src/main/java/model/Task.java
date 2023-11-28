package model;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Task {
  private String name;
  private String taskContent;
  private int priority;
  private Log log;
  private int hoursToComplete;
  private ArrayList<Comment> comments;
  private UUID id;
  private UUID userId;
  private int pointValue;
  private boolean inSprint = false;
  private String toDesign;
  private String toDocument;
  private String reproductionSteps;
  private String bugEffect;
  private String justification;
  private String intention;

  /**
   * A method that generates a task object
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
   */
  public Task(UUID id, String name, String content, int priority, Log log, int hoursToComplete, UUID userID,
      ArrayList<Comment> comments, int pointValue) {
    setId(id);
    setName(name);
    setTaskContent(content);
    setPriority(priority);
    setLog(log);
    setHoursToComplete(hoursToComplete);
    setUserId(userID);
    setComments(comments);
    setPointValue(pointValue);
  }

  /**
   * A method that generates a task object with different variables
   * 
   * @param name
   * @param content
   * @param priority
   * @param log
   * @param hoursToComplete
   * @param userID
   * @param pointValue
   */
  public Task(String name, String content, int priority, int hoursToComplete, UUID userID, int pointValue) {
    genUUID();
    setName(name);
    setTaskContent(content);
    setHoursToComplete(hoursToComplete);
    setUserId(userID);
    setPriority(priority);
    setPointValue(pointValue);
    this.comments = new ArrayList<Comment>();
    this.log = new Log();
  }

  /**
   * A method that gets the task type
   * 
   * @return
   */
  public abstract String getTaskType();

  /**
   * A method that toggles sprint
   */
  public void toggleSprint() {
    this.inSprint = !this.inSprint;
  }

  /**
   * A method that adds a comment
   * 
   * @param comment
   */
  public void addComment(Comment comment) {
    this.comments.add(comment);
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
   * Getter for insprint
   * 
   * @return insprint
   */
  public boolean getInSprint() {
    return inSprint;
  }

  /**
   * Getter for name
   * 
   * @return a name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name
   * 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for task content
   * 
   * @return taskcontent
   */
  public String getTaskContent() {
    return taskContent;
  }

  /**
   * Setter for taskcontent
   * 
   * @param taskContent
   */
  public void setTaskContent(String taskContent) {
    this.taskContent = taskContent;
  }

  /**
   * Getter for priority
   * 
   * @return priority
   */
  public int getPriority() {
    return priority;
  }

  /**
   * Setter for priority
   * 
   * @param priority
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }

  /**
   * Getter for hourstocomplete
   * 
   * @return hourstocomplete
   */
  public int getHoursToComplete() {
    return hoursToComplete;
  }

  /**
   * Setter for hourstocomplete
   * 
   * @param hoursToComplete
   */
  public void setHoursToComplete(int hoursToComplete) {
    this.hoursToComplete = hoursToComplete;
  }

  /**
   * Getter for Userid
   * 
   * @return userid
   */
  public UUID getUserId() {
    return userId;
  }

  /**
   * Setter for id
   * 
   * @param userId
   */
  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  /**
   * Getter for log
   * 
   * @return log
   */
  public Log getLog() {
    return log;
  }

  /**
   * Setter for log
   * 
   * @param log
   */
  public void setLog(Log log) {
    this.log = log;
  }

  /**
   * Getter for comments
   * 
   * @return comments
   */
  public ArrayList<Comment> getComments() {
    return comments;
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
   * Getter for pointvalue
   * 
   * @return pointvalue
   */
  public int getPointValue() {
    return pointValue;
  }

  /**
   * Setter for pointvalue
   * 
   * @param pointValue
   */
  public void setPointValue(int pointValue) {
    this.pointValue = pointValue;
  }

  /**
   * A method that generates a UUID
   */
  private void genUUID() {
    UUID tempID = UUID.randomUUID();
    boolean x = true;
    while (x) {
      if (ProjectList.getInstance().checkIDAvailabilityTask(tempID)) {
        this.id = tempID;
        x = false;
      } else {
        tempID = UUID.randomUUID();
      }
    }
  }

  public UUID getId() {
    return this.id;
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
   * @return id
   */
  public UUID getID() {
    return id;
  }

  /**
   * Getter for todesign
   * 
   * @return todesign
   */
  public String getToDesign() {
    return this.toDesign;
  }

  /**
   * Getter for todocument
   * 
   * @return todocument
   */
  public String getToDocument() {
    return this.toDocument;
  }

  /**
   * Getter for reproducctionsteps
   * 
   * @return reproductionsteps
   */
  public String getReproductionSteps() {
    return this.reproductionSteps;
  }

  /**
   * Getter for bugeffect
   * 
   * @return bugeffect
   */
  public String getBugEffect() {
    return this.bugEffect;
  }

  /**
   * Getter for justification
   * 
   * @return justification
   */
  public String getJustification() {
    return this.justification;
  }

  /**
   * Getter for intention
   * 
   * @return intention
   */
  public String getIntention() {
    return this.intention;
  }

  /**
   * Tostring method for task
   */
  public String toString() {
    String returnString = "\nTask Name: " + this.name + "\nIn Sprint?: " + this.inSprint + "\nTask ID: " + this.id
        + "\nTask Content: " +
        this.taskContent + "\nPriority: " + this.priority + "\nLog: " + this.log.toString()
        + "\nHours to Complete: " + this.hoursToComplete +
        "\nAssigned User: " + this.userId + "\nPoint Value: " + this.pointValue;

    if (comments != null) {
      for (Comment comment : comments) {
        returnString += comment.toString();
      }
    }

    return returnString;
  }

}
