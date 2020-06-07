/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import autorizacao.model.User;
import java.io.Serializable;

/**
 *
 * @author OMEN X
 */
public class Administrator extends User implements Serializable{
    
    /**
     * complete constructor of the Administrator with the parameters of the superclass (User)
     * @param name
     * @param email
     * @param password
     * @param role 
     */
    public Administrator(String name, String email, String password, String role){
        super(name, email, password, "ADMINISTRATOR");
    }
    
    /**
     * copy constructor
     * @param otherAdmin 
     */
    public Administrator (Administrator otherAdmin){
        super(otherAdmin.getName(), otherAdmin.getEmail(), otherAdmin.getPassword(), otherAdmin.getRole());
    }
    
    /**
     * writing method of the class Administrator
     * @return 
     */
    @Override
    public String toString(){
        return super.toString();
    }
}
