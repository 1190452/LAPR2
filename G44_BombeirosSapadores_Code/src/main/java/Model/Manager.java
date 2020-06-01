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
public class Manager {

    private String name;
    private String email;
    private String password;

    /**
     * Builds an instance of Manager that receives name, email and password
     *
     * @param name
     * @param email
     * @param password
     */
    public Manager(String name, String email, String password) {
       this.name = name;
       this.email = email;
       this.password = password;
    }

    public boolean hasId(String strId) {
        return this.email.equalsIgnoreCase(strId);
    }

    public String getNome() {
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
        Manager obj = (Manager) o;
        return (Objects.equals(email, obj.email));
    }

    /**
     * Builds an instance of Manager that is copy of another passed by parameter
     *
     * @param otherManager
     */
//    public Manager(Manager otherManager) {
//        super(otherManager.getName(), otherManager.getEmail(), otherManager.getPassword(), otherManager.getRole());
//
//    }

    @Override
    public String toString() {
        return super.toString();

    }
}
