/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class Collaborator {

    private String name;
    private String function;
    private String telephone;
    private String email;

    public Collaborator(String name, String function, String telephone, String email) {
        if ((name == null) || (function == null) || (telephone == null) || (email == null)
                || (name.isEmpty()) || (function.isEmpty()) || (telephone.isEmpty()) || (email.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.name = name;
        this.function = function;
        this.telephone = telephone;
        this.email = email;
    }

    public Collaborator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean hasId(String strId) {
        return this.email.equalsIgnoreCase(strId);
    }

    public String getName() {
        return this.name;
    }

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
}
