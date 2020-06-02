/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import autorizacao.model.User;
import java.util.Objects;

/**
 *
 * @author OMEN X
 */
public class Collaborator extends User {

    /**
     * Builds an instance of Collaborator that receives name, email and password
     *
     * @param name
     * @param email
     * @param password
     */
    public Collaborator(String name, String email, String password) {
        super(name, email, password, "COLLABORATOR");
    }
    
    public Collaborator(){
        
    }

    /**
     * Builds an instance of Collaborator that is copy of another passed by
     * parameter
     *
     * @param otherCollaborator
     */
    public Collaborator(Collaborator otherCollaborator) {
        super(otherCollaborator.getName(), otherCollaborator.getEmail(), otherCollaborator.getPassword(), otherCollaborator.getRole());

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
