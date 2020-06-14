package Authorization.model;

import java.io.Serializable;

public class UserSession implements Serializable {

    /**
     * user that is logged in
     */
    private User user = null;

    /**
     * constructor than builds an instance of UserSession
     *
     * @param user
     */
    public UserSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        }
        this.user = user;
    }

    /**
     * method that logs out the user
     */
    public void doLogout() {
        this.user = null;
    }

    /**
     * checks if the user is logged in
     *
     * @return
     */
    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * checks if user is logged in with a role
     *
     * @param strRole
     * @return
     */
    public boolean isLoggedInWithPart(String strRole) {
        if (isLoggedIn()) {
            return this.user.getRole().equalsIgnoreCase(strRole);
        }
        return false;
    }

    /**
     * returns the email of the logged in user
     *
     * @return
     */
    public String getUserEmail() {
        if (isLoggedIn()) {
            return this.user.getEmail();
        }
        return null;
    }

    /**
     * returns the user name of the logged user
     *
     * @return
     */
    public String getUserName() {
        if (isLoggedIn()) {
            return this.user.getName();
        }
        return null;
    }

    /**
     * returns the logged user
     *
     * @return
     */
    public User getUserBySession() {
        return this.user;
    }

    /**
     * writing method of the class UserSession
     *
     * @return
     */
    @Override
    public String toString() {
        return "UserSession{" + "user=" + user.toString() + '}';
    }

}
