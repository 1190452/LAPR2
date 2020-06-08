package Authorization.model;

import Authorization.model.User;
import java.io.Serializable;

public class UserSession implements Serializable{

    private User user = null;

    public UserSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        }
        this.user = user;
    }

    public void doLogout() {
        this.user = null;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public boolean isLoggedInWithPart(String strRole) {
        if (isLoggedIn()) {
            return this.user.getRole().equalsIgnoreCase(strRole);
        }
        return false;
    }

    public String getUserEmail() {
        if (isLoggedIn()) {
            return this.user.getEmail();
        }
        return null;
    }

    public User getUserBySession() {
        return this.user;
    }

    @Override
    public String toString() {
        return "UserSession{" + "user=" + user.toString() + '}';
    }

}
