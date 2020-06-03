/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import autorizacao.model.User;

/**
 *
 * @author OMEN X
 */
public class Manager {

    private String nameM;
    private String emailM;
    private String role;
    private String phoneNumberM;

    /**
     * Builds an instance of Manager that receives name, email and password
     *
     * @param nameM
     * @param emailM
     * @param role
     * @param phoneNumberM
     */
    public Manager(String nameM, String emailM, String role, String phoneNumberM) {
        this.nameM = nameM;
        this.emailM = emailM;
        this.role = role;
        this.phoneNumberM = phoneNumberM;

    }

    public Manager() {

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
        phoneNumberM = otherManager.getPhoneNumberM();
    }

    /**
     * @return the nameM
     */
    public String getNameM() {
        return nameM;
    }

    /**
     * @param nameM the nameM to set
     */
    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    /**
     * @return the emailM
     */
    public String getEmailM() {
        return emailM;
    }

    /**
     * @param emailM the emailM to set
     */
    public void setEmailM(String emailM) {
        this.emailM = emailM;
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

    /**
     * @return the phoneNumberM
     */
    public String getPhoneNumberM() {
        return phoneNumberM;
    }

    /**
     * @param phoneNumberM the phoneNumberM to set
     */
    public void setPhoneNumberM(String phoneNumberM) {
        this.phoneNumberM = phoneNumberM;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s \nEmail: %s \nRole: %s \nPhone Number: %s", nameM, emailM, role, phoneNumberM);
    }
}


