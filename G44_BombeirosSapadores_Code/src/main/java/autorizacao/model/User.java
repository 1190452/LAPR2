/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class User {
    private String strEmail;
    private String strPassword;
    private String role;
    
    private static final String STR_ROLE_BY_OMISSION = "USER";
    private static final String STR_PASSWORD_BY_OMISSION = "NO PASSWORD";
    private static final String STR_EMAIL_BY_OMISSION = "NO EMAIL";

    public User(String strEmail, String strPassword, String role) {
        setEmail(strEmail);
        setPassword(strPassword);
        setRole(role);
    }
    
    public User(User user){
        this.role = user.role;
        this.strEmail = user.strEmail;
        this.strPassword = user.strPassword;
    }
    
    public User(){
        this.role = STR_ROLE_BY_OMISSION;
        this.strEmail = STR_EMAIL_BY_OMISSION;
        this.strPassword = STR_PASSWORD_BY_OMISSION;
    }

    public String getEmail() {
        return this.strEmail;
    }

    public String getRole() {
        return role;
    }
    
    public String getPassword(){
        return strPassword;
    }

    public void setEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean hasEmail(String strEmail) {
        return this.strEmail.equalsIgnoreCase(strEmail);
    }
    
    public boolean hasPassword(String strPassword){
        return this.strPassword.equals(strPassword);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != User.class) {
            return false;
        }
        
        User u = (User) obj;
        return this.strEmail.equalsIgnoreCase(u.strEmail) && u.role.equalsIgnoreCase(role)
                && u.strPassword.equals(strPassword);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.role, this.strEmail);
    }
}
