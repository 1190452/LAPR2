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

    Platform p1;
    RegisterFreelancer rfree;
    Freelancer free;
   
    public Freelancer newFreelancer(String name, String levelExp, String email, String nif, String iban, String country, String street, String doorNumber, String locality) {   
        ApplicationPOT ap = ApplicationPOT.getInstance();
        rfree = ap.getPlatform().getRfree();
        free = rfree.newFreelancer(name, levelExp, email, nif, iban, country, street, doorNumber, locality);
        if (free != null) {
            return free;
        }
        return null;
    }

    public boolean saveFreelancer() {
        String freeID = rfree.generateID(free);
        free.setFreeID(freeID);
        return rfree.saveFreelancer(free);

    }

}
