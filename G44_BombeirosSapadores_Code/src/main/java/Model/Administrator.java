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
public class Administrator extends User{
    
    public Administrator(String name, String email, String password, String role){
        super(name, email, password, "ADMINISTRATOR");
    }
    
    public Administrator (Administrator otherAdmin){
        super(otherAdmin.getName(), otherAdmin.getEmail(), otherAdmin.getPassword(), otherAdmin.getRole());
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
