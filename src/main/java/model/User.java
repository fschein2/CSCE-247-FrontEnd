package model;

import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    /**
     * A method that creates a user object
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */
    public User(UUID id, String firstName, String lastName, String email, String username, String password) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserName(username);
        setPassword(password);
    }

    /**
     * A method that creates a user object without the id parameter
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */
    public User(String firstName, String lastName, String email, String username, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserName(username);
        setPassword(password);
        genUUID();
    }

    /**
     * A method that generates a UUID
     */
    private void genUUID() {
        UUID tempID = UUID.randomUUID();
        boolean x = true;
        while (x) {
            if (UserList.getInstance().checkIDAvailability(tempID)) {
                this.id = tempID;
                x = false;
            } else {
                tempID = UUID.randomUUID();
            }
        }
    }

    /**
     * Getter for id
     * 
     * @return an id
     */
    public UUID getId() {
        return id;
    }

    /**
     * setter for id
     * 
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * getter for firstname
     * 
     * @return a firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for firstname
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for lastname
     * 
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for lastname
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter for email
     * 
     * @return an email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for username
     * 
     * @return a username
     */
    public String getUserName() {
        return username;
    }

    /**
     * setter for username
     * 
     * @param username
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * getter for password
     * 
     * @return a password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Tostring method for a User
     */
    public String toString() {
        return this.username;
    }
}
