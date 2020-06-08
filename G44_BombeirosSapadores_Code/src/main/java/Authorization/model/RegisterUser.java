/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authorization.model;

import Model.Platform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulomaio
 */
public class RegisterUser implements Serializable {

    /**
     * list of users
     */
    private List<User> lstUsers;

    /**
     * platform that contains the users
     */
    private Platform platform;

    /**
     * constructor that initializes the list of users as an ArrayList
     */
    public RegisterUser() {
        this.lstUsers = new ArrayList<>();
    }

    /**
     * returns the list of users
     * @return 
     */
    public List<User> getUserList() {
        return lstUsers;
    }

    /**
     * modifies the list of users
     * @param usersList 
     */
    public void setUsersList(ArrayList<User> usersList) {
        lstUsers = usersList;
    }

    /**
     * method that creates a new user
     * @param name
     * @param strEmail
     * @param strPassword
     * @param strRole
     * @return 
     */
    public User newUser(String name, String strEmail, String strPassword, String strRole) {
        return new User(name, strEmail, strPassword, strRole);
    }

    /**
     * adds a user to the list of users
     * @param utlz
     * @return 
     */
    public boolean addUser(User utlz) {
//        if (hasUser(utlz)) {
//            throw new IllegalArgumentException("User Already Exists");
//        }
        return this.lstUsers.add(utlz);
    }

    /**
     * method that finds a user in the list of users by his email and returns him
     * @param strEmail
     * @return 
     */
    public User findUser(String strEmail) {
        for (User utlz : lstUsers) {
            if (utlz.hasEmail(strEmail)) {
                return utlz;
            }
        }
        return null;
    }

    /**
     * method that checks if a platform contains a certain user receiving an email by parameter
     * @param strEmail
     * @return 
     */
    public boolean hasUser(String strEmail) {
        User utlz = findUser(strEmail);
        if (utlz != null) {
            return platform.getrUser().getUserList().contains(utlz);
        }
        return false;
    }

    /**
     * method that checks if a platform contains a certain user receiving an user by parameter
     * @param utlz
     * @return 
     */
    public boolean hasUser(User utlz) {
        return platform.getrUser().getUserList().contains(utlz);
    }

    /**
     * removes a user from the list of users
     * @param utlz
     * @return 
     */
    public boolean remove(User utlz) {
        if (lstUsers.contains(utlz)) {
            return lstUsers.remove(utlz);
        }
        return false;
    }
}
