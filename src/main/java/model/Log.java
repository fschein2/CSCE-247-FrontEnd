package model;

import java.time.LocalDate;

public class Log {
    LocalDate date;
    LogEnum logEnum;

    /**
     * A method that creates a log object
     * 
     * @param date
     * @param user
     * @param logEnum
     * @param reason
     */
    public Log(LocalDate date, LogEnum logEnum) {
        this.date = date;
        this.logEnum = logEnum;
    }

    /**
     * A method that creates a log object without the reason string
     * 
     * @param date
     * @param user
     * @param logEnum
     */
    public Log() {
        this.date = LocalDate.now();
        this.logEnum = LogEnum.BACKLOG;
    }

    /**
     * Getter for date
     * 
     * @return a date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Getter for type
     * 
     * @return
     */
    public LogEnum getType() {
        return this.logEnum;
    }

    /**
     * A method that changes the type of log
     * 
     * @param date
     * @param user
     */
    public void changeLog(LocalDate date, User user) {
        switch (this.logEnum) {
            case BACKLOG:
                this.logEnum = LogEnum.TODO;
                break;
            case COMPLETE:
                break;
            case INPROGRESS:
                this.logEnum = LogEnum.COMPLETE;
                break;
            case TODO:
                this.logEnum = LogEnum.INPROGRESS;
                break;
            default:
                this.logEnum = LogEnum.BACKLOG;
                break;

        }
        this.date = date;
    }

    /**
     * A method that changes the type of log but in the opposite direction
     * 
     * @param date
     * @param user
     * @param reason
     */
    public void reverseLog(LocalDate date, User user, String reason) {
        switch (this.logEnum) {
            case BACKLOG:
                break;
            case COMPLETE:
                this.logEnum = LogEnum.INPROGRESS;
                break;
            case INPROGRESS:
                this.logEnum = LogEnum.TODO;
                break;
            case TODO:
                this.logEnum = LogEnum.BACKLOG;
                break;
            default:
                this.logEnum = LogEnum.BACKLOG;
                break;

        }
        this.date = date;
    }

    /**
     * A tostring method for log
     */
    public String toString() {
        return "\nDate: " + this.date + "\nLog Type: " + this.logEnum;
    }
}
