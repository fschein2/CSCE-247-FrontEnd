package model;

/**
 * Defines constants for data related fields
 */
public class DataConstants {
  // USER
  protected static final String USER_FILE_NAME = "JSON/userList.json";
  protected static final String USER_ID = "id";
  protected static final String USER_USER_NAME = "username";
  protected static final String USER_FIRST_NAME = "firstName";
  protected static final String USER_LAST_NAME = "lastName";
  protected static final String USER_PASSWORD = "password";
  protected static final String USER_EMAIL = "email";

  // PROJECT
  protected static final String PROJECT_FILE_NAME = "JSON/projectList.json";
  protected static final String PROJECT_ID = "id";
  protected static final String PROJECT_NAME = "projectName";
  protected static final String TASK_IDS = "taskIDs";
  protected static final String ROLE_MAP = "roleMap";
  protected static final String ROLE = "role";
  protected static final String ROLE_USER_ID = "userUUID";

  // COMMENTS (TASK AND PROJECT)
  protected static final String COMMENTS = "comments";
  protected static final String COMMENTER_ID = "commenterUUID";
  protected static final String CONTENT = "content";
  protected static final String DATE = "date";
  protected static final String REPLIES = "replies";

  // TASK
  protected static final String TASK_FILE_NAME = "JSON/task.json";
  protected static final String TASK_ID = "id";
  protected static final String TASK_NAME = "name";
  protected static final String TASK_CONTENT = "taskContent";
  protected static final String PRIORITY = "priority";
  protected static final String TASK_TYPE = "type";
  protected static final String LOG = "log";
  protected static final String LOG_DATE = "date";
  protected static final String LOG_ENUM = "logType";
  protected static final String HOURS = "hoursToComplete";
  protected static final String TASK_USER_ID = "userID";
  protected static final String POINT_VALUE = "pointValue";
  protected static final String TO_DESIGN = "toDesign";
  protected static final String TO_DOCUMENT = "toDocument";
  protected static final String REPRODUCTION_STEPS = "reproductionSteps";
  protected static final String BUG_EFFECT = "bugEffect";
  protected static final String JUSTIFICATION = "justification";
  protected static final String INTENTION = "intention";
}
