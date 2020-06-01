/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import pt.ipp.isep.dei.esoft.autorizacao.model.User;

/**
 *
 * @author OMEN X
 */
public class Manager extends User {

    /**
     * Builds an instance of Manager that receives name, email and password
     *
     * @param name
     * @param email
     * @param password
     */
    public Manager(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    /**
     * Builds an instance of Manager that is copy of another passed by
     * parameter
     *
     * @param otherManager
     */
    public Manager (Manager otherManager) {
        super(otherManager.getName(), otherManager.getEmail(), otherManager.getPassword(), otherManager.getRole());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
