/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class RegisterFreelancer implements Serializable{

    private List<Freelancer> listaFreelancers;
    private Freelancer free;
    double delayProb;

    public RegisterFreelancer() {
        this.listaFreelancers = new ArrayList();

    }

    public Freelancer newFreelancer(String name, String levelExp, String email, String nif, String iban, String country, String street, String doorNumber, String locality) {
        Address address = new Address(street, doorNumber, locality);
        return new Freelancer(name, levelExp, email, nif, iban, country, address);
    }

    public boolean validateFreelancer(Freelancer free) {
        for (int i = 0; i < listaFreelancers.size(); i++) {
            if ((free.getIban() == listaFreelancers.get(i).getIban()) || (free.getNif() == listaFreelancers.get(i).getNif()) || (free.getFreeID() == listaFreelancers.get(i).getFreeID())) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean saveFreelancer(Freelancer free) {
        return (validateFreelancer(free)) && addFreelancer(free);

    }

    public boolean addFreelancer(Freelancer free) {
        if (!listaFreelancers.contains(free)) {
            listaFreelancers.add(free);
            return true;
        } else {
            return false;
        }
    }

    public void removeFreelancer(Freelancer fr) {
        listaFreelancers.remove(fr);
    }

    public List<Freelancer> getListFreelancers() {
        return listaFreelancers;
    }

    public String generateID(Freelancer free) {
        String id;
        int count = 1;
        
        String[] nameparts = free.getName().split(" ");
        if (nameparts.length == 1) {
            id = String.valueOf(nameparts[0].toUpperCase().charAt(0) + nameparts[0].toUpperCase().charAt(1));
        }else {
            id = String.valueOf(nameparts[0].toUpperCase().charAt(0) + nameparts[1].toUpperCase().charAt(0));
        }

        for (int i = 0; i < listaFreelancers.size(); i++) {
            if (id.equalsIgnoreCase(listaFreelancers.get(i).getFreeID())) {
                count++;
            }
        }
        return id+count;

    }

    public List<Freelancer> getFreelancers(List<Task> lt, List<Transaction> ltr) {
        List<Freelancer> newList = new ArrayList<>();
        for (int i = 0; i < lt.size(); i++) {
           Task ts = lt.get(i);
           for (int p = 0; p < ltr.size(); p++) {
               Transaction tr = ltr.get(p);
               Task cts = tr.getTask();
               if(ts.equals(cts)){
                   Freelancer freel = tr.getFreel();
                   newList.add(freel);
               }
           }
        }
        return newList;
    }


    public boolean Verification(Freelancer fr) {
        if(listaFreelancers.contains(fr)){
            return false;
        }
        return true;
    }

    public double getDelayProb() {
        return delayProb;
    }
    
}
