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

    private static UserSession session = null;
    //private static final RegisterUser users = new RegisterUser();
    
    private RegisterUser users;

    public FacadeAuthorization() {
        this.users = new RegisterUser();
    }

    public boolean registUserWithRole(String name, String strEmail, String strPassword, String strRole) {
        User utlz = this.users.newUser(name, strEmail, strPassword, strRole);
        return users.addUser(utlz);
    }

    public void registerUser(String strNome, String strEmail, String strPassword, String role) {
        User utlz = this.users.newUser(strNome, strEmail, strPassword, role);
        this.users.addUser(utlz);
    }

    public boolean userExists(String strEmail) {
        return this.users.hasUser(strEmail);
    }

    public UserSession doLogin(String strEmail, String strPwd) {
        User utlz = this.users.findUser(strEmail);
        if (utlz != null) {
            if (utlz.hasPassword(strPwd)) {
                this.session = new UserSession(utlz);
            }
        }
        return getActualSession();
    }

    public static UserSession getActualSession() {
        return FacadeAuthorization.session;
    }

    public void doLogout() {
        if (this.session != null) {
            this.session.doLogout();
        }
        this.session = null;
    }

    public boolean existeUtilizador(String strId) {
        return this.users.hasUser(strId);
    }
}