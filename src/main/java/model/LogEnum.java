package model;

/**
 * Enumeration that sets the type of log
 */
public enum LogEnum {
    BACKLOG("Back Log"), TODO("To Do"), INPROGRESS("In Progress"), COMPLETE("Complete");

    public final String name;

    private LogEnum(String name) {
        this.name = name;
    }
}
