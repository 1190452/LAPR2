/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao;

import autorizacao.model.RegisterUser;
import autorizacao.model.UserSession;
import autorizacao.model.User;

/**
 *
 * @author paulomaio
 */
public class FacadeAuthorization
{
   private static UserSession session = null;
   private static final RegisterUser users = new RegisterUser();

    public void registUserWithRole(String strEmail, String strPassword, String strRole) {
        User utlz = this.users.newUser(strEmail, strPassword, strRole);
        this.users.addUser(utlz);
    }
    
    public void registerUser(String strNome, String strEmail, String strPassword)
    {
        User utlz = this.users.newUser(strNome,strEmail,strPassword);
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
    
     public boolean existeUtilizador(String strId)
    {
        return this.users.hasUser(strId);
    }
}
