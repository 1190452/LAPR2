/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authorization;

import Authorization.model.RegisterUser;
import Authorization.model.UserSession;
import Authorization.model.User;
import java.io.Serializable;

/**
 *
 * @author paulomaio
 */
public class FacadeAuthorization implements Serializable {

    /**
     * atribute of the class UserSession used to call the methods of that class
     */
    private static UserSession session = null;
    //private static final RegisterUser users = new RegisterUser();

    /**
     * atribute of the class RegisterUser used to call the methods of that class
     */
    private RegisterUser users;

    /**
     * construtor that initializes the RegisterUser
     */
    public FacadeAuthorization() {
        this.users = new RegisterUser();
    }

    /**
     * ethod that register a user with a role receiving the following parameters:
     * @param strNome
     * @param strEmail
     * @param strPassword
     * @param role 
     */
    public void registerUser(String strNome, String strEmail, String strPassword, String role) {
        User utlz = this.users.newUser(strNome, strEmail, strPassword, role);
        this.users.addUser(utlz);
    }

    /**
     * checks if a user exists
     * @param strEmail
     * @return 
     */
    public boolean userExists(String strEmail) {
        return this.users.hasUser(strEmail);
    }

    /**
     * does the login with the parameters received that are the following:
     * @param strEmail
     * @param strPwd
     * @return
     * then returns the session that logged in
     */
    public UserSession doLogin(String strEmail, String strPwd) {
        User utlz = this.users.findUser(strEmail);
        if (utlz != null) {
            if (utlz.hasPassword(strPwd)) {
                this.session = new UserSession(utlz);
            }
        }
        return getActualSession();
    }

    /**
     * returns the actual session
     * @return 
     */
    public static UserSession getActualSession() {
        return FacadeAuthorization.session;
    }

    /**
     * logs the user out of the application
     */
    public void doLogout() {
        if (this.session != null) {
            this.session.doLogout();
        }
        this.session = null;
    }
}
