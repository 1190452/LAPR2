/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Authorization.model.User;
import java.io.Serializable;

/**
 *
 * @author OMEN X
 */
public class Manager implements Serializable{

    /**
     * name of the manager
     */
    private String nameM;
    
    /**
     * email of the manager
     */
    private String emailM;
    
    /**
     * role of the manager
     */
    private String role;
    
    /**
     * name of the manager by omission
     */
    private static final String NAME_BY_OMISSION = "no name";
    
    /**
     * email of the manager by omission
     */
    private static final String EMAIL_BY_OMISSION = "no email";
    
    /**
     * role of the manager by omission
     */
    private static final String ROLE_BY_OMISSION = "no role";

    /**
     * Complete constructor that builds an instance of Manager that receives name, email and password
     *
     * @param nameM
     * @param emailM
     * @param role
     */
    public Manager(String nameM, String emailM, String role) {
        this.nameM = nameM;
        this.emailM = emailM;
        this.role = role;

    }

    /**
     * empty constructor that builds and instance of Manager
     */
    public Manager() {
        this.nameM = NAME_BY_OMISSION;
        this.emailM = EMAIL_BY_OMISSION;
        this.role = ROLE_BY_OMISSION;
    }

    /**
     * Builds an instance of Manager that is copy of another passed by parameter
     *
     * @param otherManager
     */
    public Manager(Manager otherManager) {
        nameM = otherManager.getNameM();
        emailM = otherManager.getEmailM();
        role = otherManager.getRole();
    }
    
    //======================================================================================================================================================

    /**
     * returns the name of the manager
     * @return the nameM
     */
    public String getNameM() {
        return nameM;
    }

    /**
     * returns the email of the manager
     * @return the emailM
     */
    public String getEmailM() {
        return emailM;
    }


    /**
     * returns the role of the freelancer
     * @return the role
     */
    public String getRole() {
        return role;
    }
    
    //======================================================================================================================================================
    
    /**
     * modifies the name of the manager
     *
     * @param nameM the nameM to set
     */
    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    /**
     * modifies the email of the manager
     * @param emailM the emailM to set
     */
    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }
    /**
     * modifies the role of the freelancer
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    //======================================================================================================================================================
    
    /**
     * writing method of the class Manager
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Nome: %s \nEmail: %s \nRole: %s", nameM, emailM, role);
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Manager otherManager = (Manager) otherObject;
        return this.nameM.equalsIgnoreCase(otherManager.nameM)
                && this.emailM.equals(otherManager.emailM) 
                && this.role.equalsIgnoreCase(otherManager.role);
    }
}


