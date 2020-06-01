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

    /**
     * user's name
     */
    private String name;

    /**
     * user's email
     */
    public String email;

    /**
     * user's password
     */
    private String password;

    /**
     * user's role
     */
    private String role;

    private Set<UserRole> m_lstRoles = new HashSet<UserRole>();

    /**
     * Builds an instance of User that receives a name, an email, a password and
     * a role
     *
     * @param name
     * @param email
     * @param password
     */
    public User(String name, String email, String password) {
        if ((name == null) || (email == null) || (password == null) || (name.isEmpty()) || (email.isEmpty()) || (password.isEmpty()) || (role.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be empty");
        }
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getId() {
        return this.email;
    }

    /**
     * returns the user's name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    public boolean addRole(UserRole papel) {
        if (papel != null) {
            return this.m_lstRoles.add(papel);
        }
        return false;
    }

    public boolean removeRole(UserRole papel) {
        if (papel != null) {
            return this.m_lstRoles.remove(papel);
        }
        return false;

    }

    public boolean hasPassword(String strPwd) {
        return this.password.equals(strPwd);
    }

    public boolean hasPapel(String strPapel) {
        for (UserRole papel : this.m_lstRoles) {
            if (papel.hasId(strPapel)) {
                return true;
            }
        }
        return false;
    }

    /**
     * changes the user's name
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the user's email
     *
     * @return the email
     */
    public String getEmail() {
        return email;

    }

    /**
     * changes the user's email
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns the user's password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        List<UserRole> list = new ArrayList<>();
        for (UserRole papel : this.m_lstRoles) {
            list.add(papel);
        }
        return list;
    }

    /**
     * changes the user's password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;

    }

    /**
     * returns the user's role
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * changes the user's role
     *
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nEmail: %s \nRole: %s", name, email, role);
    }

    @Override
    public boolean equals(Object obj) {
        //self validation
        if (this == obj) {
            return true;
        }
        //null validation
        if (obj == null || obj.getClass() != User.class) {
            return false;
        }

        User u = (User) obj;
        return this.email.equalsIgnoreCase(u.email) && this.role.equalsIgnoreCase(u.role);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.role);
        return hash;
    }

    public boolean hasId(String strId) {
        return this.email.equals(strId);
    }
}
