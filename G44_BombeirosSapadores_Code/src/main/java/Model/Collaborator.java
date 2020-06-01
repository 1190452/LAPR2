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

    private String name;
    private String function;
    private String telephone;
    private String email;

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

    public boolean hasId(String strId) {
        return this.email.equalsIgnoreCase(strId);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Collaborator obj = (Collaborator) o;
        return (Objects.equals(email, obj.email));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", this.name, this.function, this.telephone, this.email);
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

}
