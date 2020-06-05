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

    private String nameC;
    private String emailC;
    private String role;

    /**
     * Builds an instance of Collaborator that receives name, email and password
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

    public Collaborator() {

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
     * @return the nameC
     */
    public String getNameC() {
        return nameC;
    }

    /**
     * @param nameC the nameC to set
     */
    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    /**
     * @return the emailC
     */
    public String getEmailC() {
        return emailC;
    }

    /**
     * @param emailC the emailC to set
     */
    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s \nEmail: %s \nRole: %s", nameC, emailC, role);
    }
}
