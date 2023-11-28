package model;

import java.util.ArrayList;

/**
 * Gamification features
 */
public class Gamification {
    private int points;
    private double bar;

    /**
     * Edit the user's points
     * 
     * @return Updated point value
     */
    public int editPoints() {
        return 0;
    }

    /**
     * Get the user's points
     * 
     * @return Point value
     */
    public int getPoints() {
        return points;
    }

    /**
     * Display rank of users
     * 
     * @param users List of users
     * @return User's rank
     */
    public String displayRank(ArrayList<User> users) {
        return "";
    }

    /**
     * Display user's progress bar
     * 
     * @return Progress bar value as a double
     */
    public double displayBar() {
        return bar;
    }
}
