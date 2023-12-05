package model;

public class SystemFACADE {
    public static User currentUser;
    public static Project currentProject;

    public static boolean login(String username, String password) {
        UserList userList = UserList.getInstance();
        currentUser = userList.checkUser(username, password);
        return currentUser != null;
    }

    public User logout(String username, String password) {
        User temp = new User("", "", "", "", "");
        return temp;
    }

    public int signUp(String firstName, String lastName, String email, String username, String password) {
        UserList userList = UserList.getInstance();

        // check if username is available
        if (userList.checkUsernameAvailability(username)) {
            if (userList.checkPasswordRequirements(password)) {
                // add user to user list
                userList.addUser(firstName, lastName, email, username, password);

                // save updated user list to data writer
                DataWriter.saveUsers();
                return 0;
            }
            return 1;
        }
        return 2;

    }

    public ProjectList getProjects() {
        return ProjectList.getInstance();
    }
}