/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        rfree = p1.getRfree();
        free = rfree.newFreelancer(name, levelExp, email, nif, iban, country, street, doorNumber, locality);
        return free;

    }

    public boolean saveFreelancer() {
        String freeID = rfree.generateID();
        free.setFreeID(freeID);
        return rfree.saveFreelancer(free);

    }

}
