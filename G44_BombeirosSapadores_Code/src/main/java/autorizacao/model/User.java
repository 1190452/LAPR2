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
    private String name;
    private String email;
    private String password;
    private String role;
    
    private static final String NAME_BY_OMISSION = "NO NAME";
    private static final String ROLE_BY_OMISSION = "USER";
    private static final String PASSWORD_BY_OMISSION=  "NO PASSWORD";
    private static final String EMAIL_BY_OMISSION = "NO EMAIL";

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public User(User user){
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.role = user.role;
    }
    
    public User(){
        this.name = NAME_BY_OMISSION;
        this.email = EMAIL_BY_OMISSION;
        this.password = PASSWORD_BY_OMISSION;
        this.role = ROLE_BY_OMISSION;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRole() {
        return role;
    }
    
    public String getPassword(){
        return password;
    }

    public void setEmail(String strEmail) {
        this.email = strEmail;
    }

    public void setPassword(String strPassword) {
        this.password = strPassword;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean hasEmail(String strEmail) {
        return this.email.equalsIgnoreCase(strEmail);
    }
    
    public boolean hasPassword(String strPassword){
        return this.password.equals(strPassword);
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
        return this.email.equalsIgnoreCase(u.email) && u.role.equalsIgnoreCase(role)
                && u.password.equals(password);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.role, this.email);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
