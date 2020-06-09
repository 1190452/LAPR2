/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Freelancer;
import Model.Platform;
import Model.RegisterFreelancer;

/**
 *
 * @author User
 */
public class CreateFreelancerController {

    /**
     * atribute to call the methods of the Platform class
     */
    private Platform p1;

    /**
     * atribute to call the methods of the RegisterFreelancer class
     */
    private RegisterFreelancer rfree;

    /**
     * atribute to call the methods of the Freelancer class
     */
    private Freelancer free;

    /**
     * method that calls the class RegisterFreelancer to create a new freelancer
     *
     * @param name
     * @param levelExp
     * @param email
     * @param nif
     * @param iban
     * @param country
     * @param street
     * @param doorNumber
     * @param locality
     * @return
     */
    public Freelancer newFreelancer(String name, String levelExp, String email, String nif, String iban, String country, String street, String doorNumber, String locality) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        rfree = ap.getPlatform().getRfree();
        free = rfree.newFreelancer(name, levelExp, email, nif, iban, country, street, doorNumber, locality);
        if (free != null) {
            return free;
        }
        return null;
    }
    
    //======================================================================================================================================================
    

    /**
     * method that saves a freelancer, creating an ID for him
     *
     * @return
     */
    public boolean saveFreelancer() {
        String freeID = rfree.generateID(free);
        free.setFreeID(freeID);
        return rfree.saveFreelancer(free);

    }

}
