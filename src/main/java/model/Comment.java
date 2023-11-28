package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comment {
    private User commenter;
    private String content;
    private LocalDate date;
    private ArrayList<Comment> replies;

    /**
     * A method that creates a comment object
     * 
     * @param commenter
     * @param content
     * @param date
     * @param replies
     */
    public Comment(User commenter, String content, LocalDate date, ArrayList<Comment> replies) {
        this.commenter = commenter;
        this.content = content;
        this.date = date;
        this.replies = replies;
    }

    /**
     * A method that removes a comment
     * 
     * @param comment
     */
    public void removeReply(Comment comment) {
        replies.remove(comment);
    }

    /**
     * Getter for commenter
     * 
     * @return a commenter
     */
    public User getCommenter() {
        return this.commenter;
    }

    /**
     * Setter for commenter
     * 
     * @param commenter
     */
    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    /**
     * Getter for content
     * 
     * @return a content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Setter for content
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
     * Setter for date
     * 
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for replies
     * 
     * @return replies
     */
    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

    /**
     * Setter for replies
     * 
     * @param replies
     */
    public void setReplies(ArrayList<Comment> replies) {
        this.replies = replies;
    }

    /**
     * A method that adds a reply
     * 
     * @param reply
     */
    public void addReply(Comment reply) {
        replies.add(reply);
    }

    /**
     * A method that displays replies
     * 
     * @return replies
     */
    public ArrayList<Comment> displayReplies() {
        return this.replies;
    }

    /**
     * Tostring method for comment
     */
    public String toString() {
        String returnString = "\nComment:" + "\n\tCommenter: " + this.commenter.getUserName() + "\n\tComment Content: "
                +
                this.content + "\n\tDate: " + this.date;

        if (!replies.isEmpty()) {
            for (Comment reply : replies) {
                returnString += "\t" + reply.toString();
            }
        }

        return returnString;
    }
}
