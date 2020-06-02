/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao.model;

import Model.Platform;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class RegisterUser
{
    private List<User> lstUsers = new ArrayList<User>();
    
    private Platform platform;
    
    public RegisterUser(){
        this.lstUsers = new ArrayList<User>();
        this.platform = new Platform();
    }
    
    public List<User> getUserList(){
        return lstUsers;
    }
    
    public void setUsersList(ArrayList<User> usersList){
       lstUsers = usersList; 
    }

    public User newUser(String name, String strEmail, String strPassword, String strRole) {
        return new User(name, strEmail, strPassword, strRole);
    }

    public boolean addUser(User utlz) {
        if (hasUser(utlz)) {
            throw new IllegalArgumentException("User Already Exists");
        }
         return platform.getrUser().getUserList().add(utlz);
    }

    public void removeUser(User utlz) {
        if (!hasUser(utlz)) {
            throw new IllegalArgumentException("User does not exist");
        }
        platform.getrUser().remove(utlz);
    }

    public User findUser(String strEmail) {
        for (User utlz : platform.getrUser().getUserList()) {
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
    
    public boolean remove(User utlz){
        if(lstUsers.contains(utlz)){
          return lstUsers.remove(utlz);
        }
        return false;
    }
}
