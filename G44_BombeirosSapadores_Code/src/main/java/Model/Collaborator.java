/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author OMEN X
 */
public class Collaborator {

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
    
    private static final String NAME_BY_OMISSION = "no name";
    private static final String EMAIL_BY_OMISSION = "no email";
    private static final String ROLE_BY_OMISSION = "no role";

    /**
     * Builds an instance of Collaborator that receives name, email and role
     *
     * @param nameC
     * @param emailC
     * @param role
     * @param phoneNumberC
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

    /**
     * returns the name of the collaborator
     * @return the nameC
     */
    public String getNameC() {
        return nameC;
    }

    /**
     * modifies the name of the collaborator
     * @param nameC the nameC to set
     */
    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    /**
     * returns the email of the collaborator
     * @return the emailC
     */
    public String getEmailC() {
        return emailC;
    }

    /**
     * modifies the email of teh collaborator
     * @param emailC the emailC to set
     */
    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    /**
     * returns the role of the collaborator
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * modifies teh role of the collaborator
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * writing method of the class Collaborator
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Nome: %s \nEmail: %s \nRole: %s", nameC, emailC, role);
    }
}
