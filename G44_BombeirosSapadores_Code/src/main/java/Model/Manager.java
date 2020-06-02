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
public class Manager extends User{

    /**
     * Builds an instance of Manager that receives name, email and password
     *
     * @param name
     * @param email
     * @param password
     */
    public Manager(String name, String email, String password) {
       super(name, email, password,"MANAGER");
    }
    public Manager(){
        
    }

    /**
     * Builds an instance of Manager that is copy of another passed by parameter
     *
     * @param otherManager
     */
    public Manager(Manager otherManager) {
        super(otherManager.getName(), otherManager.getEmail(), otherManager.getPassword(), otherManager.getRole());

    }

    @Override
    public String toString() {
        return super.toString();

    }
}
