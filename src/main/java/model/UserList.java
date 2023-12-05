package model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList instance;
    private ArrayList<User> userList;

    /**
     * A method that generates a userlist
     */
    private UserList() {
        userList = DataLoader.getUsers();
    }

    /**
     * A method that gets an instance of a userlist
     * 
     * @return an instance
     */
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * A method that gets users for a userlist
     * 
     * @return a userlist
     */
    public ArrayList<User> getUsers() {
        return userList;
    }

    /**
     * A method that checks if the inputted password meets the requirments
     * 
     * @param password
     * @return
     */
    public boolean checkPasswordRequirements(String password) {
        char ch;
        boolean hasNumber = false;
        boolean hasCapital = false;
        boolean hasLowerCase = false;
        if (password == null) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
            if (hasNumber && hasCapital && hasLowerCase)
                return true;
        }
        return false;
    }

    /**
     * A method that checks if an inputted Username is available
     * 
     * @param username
     * @return
     */
    public boolean checkUsernameAvailability(String username) {
        for (User user : userList) {
            if (username.equals(user.getUserName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method that checks if the id ia available
     * 
     * @param id
     * @return
     */
    public boolean checkIDAvailability(UUID id) {
        for (User user : userList) {
            if (id.equals(user.getId())) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method that checks if the user exists
     * 
     * @param username
     * @param password
     * @return
     */
    public User checkUser(String username, String password) {
        for (User user : userList) {
            if (username.equals(user.getUserName())) {
                if (password.equals(user.getPassword())) {
                    return user;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * A method that finds the user by the userid
     * 
     * @param id
     * @return
     */
    public User getUserbyId(UUID id) {
        for (User user : userList) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    /**
     * A method that adds a user
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */
    public void addUser(String firstName, String lastName, String email, String username, String password) {
        userList.add(new User(firstName, lastName, email, username, password));
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }
}
