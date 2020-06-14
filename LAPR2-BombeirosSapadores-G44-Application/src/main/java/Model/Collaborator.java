/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Collaborator implements Serializable {

    /**
     * name of the collaborator
     */
    private String nameC;

    /**
     * email of the Collaborator
     */
    private String emailC;

    /**
     * role of the Collaborator
     */
    private String role;

    /**
     * name of the collaborator by omission
     */
    private static final String NAME_BY_OMISSION = "no name";

    /**
     * email of the collaborator by omission
     */
    private static final String EMAIL_BY_OMISSION = "no email";

    /**
     * role of the collaborator by omission
     */
    private static final String ROLE_BY_OMISSION = "no role";

    /**
     * Builds an instance of Collaborator that receives name, email and role
     *
     * @param nameC
     * @param emailC
     * @param role
     */
    public Collaborator(String nameC, String emailC, String role) {
        this.nameC = nameC;
        this.emailC = emailC;
        this.role = role;

    }

    /**
     * empty constructor that builds an instance of Collaborator
     */
    public Collaborator() {
        this.nameC = NAME_BY_OMISSION;
        this.emailC = EMAIL_BY_OMISSION;
        this.role = ROLE_BY_OMISSION;
    }

    /**
     * Builds an instance of Collaborator that is copy of another passed by
     * parameter
     *
     * @param otherCollaborator
     */
    public Collaborator(Collaborator otherCollaborator) {
        nameC = otherCollaborator.getNameC();
        emailC = otherCollaborator.getEmailC();
        role = otherCollaborator.getRole();
    }

    //======================================================================================================================================================
    /**
     * returns the name of the collaborator
     *
     * @return the nameC
     */
    public String getNameC() {
        return nameC;
    }

    /**
     * returns the email of the collaborator
     *
     * @return the emailC
     */
    public String getEmailC() {
        return emailC;
    }

    /**
     * returns the role of the collaborator
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    //======================================================================================================================================================
    /**
     * modifies the email of teh collaborator
     *
     * @param emailC the emailC to set
     */
    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    /**
     * modifies the name of the collaborator
     *
     * @param nameC the nameC to set
     */
    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    /**
     * modifies teh role of the collaborator
     *
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    //======================================================================================================================================================

    /**
     * writing method of the class Collaborator
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Nome: %s \nEmail: %s \nRole: %s", nameC, emailC, role);
    }
    
    //======================================================================================================================================================
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Collaborator otherCollab = (Collaborator) otherObject;
        return this.nameC.equalsIgnoreCase(otherCollab.nameC)
                && this.emailC.equals(otherCollab.emailC) 
                && this.role.equalsIgnoreCase(otherCollab.role);
    }
}
