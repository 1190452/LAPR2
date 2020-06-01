/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
class Freelancer {
    private String freeID;
     private String name;
      private String levelExp;
       private String email;
        private String  nif;
         private String country;
         private String iban;
         private Address address;
        
        
    Freelancer(String freeID, String name, String levelExp, String email, String nif,String iban , String country, Address address) {
        this.freeID=freeID;
        this.address=address;
        this.country=country;
        this.email=email;
        this.iban=iban;
        this.levelExp=levelExp;
        this.name=name;
        this.nif=nif;
        
        
    }
    
    
}
