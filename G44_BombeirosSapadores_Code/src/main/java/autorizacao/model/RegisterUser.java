/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao.model;

import Model.Platform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulomaio
 */
public class RegisterUser
        implements Serializable {

    private List<User> lstUsers;
    
    private Platform platform;

    public RegisterUser() {
        this.lstUsers = new ArrayList<>();
    }

    public List<User> getUserList() {
        return lstUsers;
    }

    public void setUsersList(ArrayList<User> usersList) {
        lstUsers = usersList;
    }

    public User newUser(String name, String strEmail, String strPassword, String strRole) {
        return new User(name, strEmail, strPassword, strRole);
    }

    public boolean addUser(User utlz) {
//        if (hasUser(utlz)) {
//            throw new IllegalArgumentException("User Already Exists");
//        }
        return this.lstUsers.add(utlz);
    }

    public void removeUser(User utlz) {
//        if (!hasUser(utlz)) {
//            throw new IllegalArgumentException("User does not exist");
//        }
        platform.getrUser().remove(utlz);
    }

    public User findUser(String strEmail) {
        for (User utlz : lstUsers) {
            if (utlz.hasEmail(strEmail)) {
                return utlz;
            }
        }
        return null;
    }

    public boolean hasUser(String strEmail) {
        User utlz = findUser(strEmail);
        if (utlz != null) {
            return platform.getrUser().getUserList().contains(utlz);
        }
        return false;
    }

    public boolean hasUser(User utlz) {
        return platform.getrUser().getUserList().contains(utlz);
    }

    public boolean remove(User utlz) {
        if (lstUsers.contains(utlz)) {
            return lstUsers.remove(utlz);
        }
        return false;
    }
}
