/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class RegisterFreelancer {

    private List<Freelancer> listaFreelancers;

    public RegisterFreelancer() {
        this.listaFreelancers = new ArrayList();

    }

    public Freelancer newFreelancer(String freeID, String name, String levelExp, String email, String nif, String iban, String country, String street, String doorNumber, String locality) {
        Address address = new Address(street, doorNumber, locality);
        return new Freelancer(freeID, name, levelExp, email, nif, iban, country, address);
    }

    public boolean validateFreelancer(Freelancer free) {
        for (int i = 0; i < listaFreelancers.size(); i++) {
            if ((free.getIban()==listaFreelancers.get(i).getIban()) || (free.getNif() == listaFreelancers.get(i).getNif()) || (free.getFreeID() == listaFreelancers.get(i).getFreeID())) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean saveFreelancer(Freelancer free) {

    }

    public void addFreelancer(Freelancer free) {

    }

    public String generateID() {
        return new String();
    }
}
