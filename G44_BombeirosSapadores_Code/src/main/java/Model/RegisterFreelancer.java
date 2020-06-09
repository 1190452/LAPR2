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
public class RegisterFreelancer implements Serializable {

    /**
     * list of freelancers
     */
    private List<Freelancer> listaFreelancers;
    private double delayProb;

    /**
     * constructor than initializes the list of freelancers as an ArrayList
     */
    public RegisterFreelancer() {
        this.listaFreelancers = new ArrayList();

    }
    
    //======================================================================================================================================================

    /**
     * method that creates a new freelancer
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
        Address address = new Address(street, doorNumber, locality);
        return new Freelancer(name, levelExp, email, nif, iban, country, address);
    }

    /**
     * method that validates the freelancer created
     *
     * @param free
     * @return
     */
    public boolean validateFreelancer(Freelancer free) {
        for (int i = 0; i < listaFreelancers.size(); i++) {
            if ((free.getIban().equalsIgnoreCase(listaFreelancers.get(i).getIban())) || (free.getNif().equalsIgnoreCase(listaFreelancers.get(i).getNif()))
                    || (free.getFreeID().equalsIgnoreCase(listaFreelancers.get(i).getFreeID()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * method that saves the freelancer
     *
     * @param free
     * @return
     */
    public boolean saveFreelancer(Freelancer free) {
        if (validateFreelancer(free)) {
            return addFreelancer(free);
        }
        return false;
    }

    /**
     * method that adds the freelancer to the freelancers list
     *
     * @param free
     * @return
     */
    public boolean addFreelancer(Freelancer free) {
        if (!listaFreelancers.contains(free)) {
            getListaFreelancers().add(free);
            return true;
        } else {
            return false;
        }
    }
    


    /**
     * method that removes a freelancer from the list
     *
     * @param 
     */
    public boolean removeFreelancer(Freelancer fr) {
        return getListaFreelancers().remove(fr);
    }
    
     /**
     * method that generates an id to a freelancer
     *
     * @param free
     * @return
     */
    public String generateID(Freelancer free) {
        String id = "";
        int d = 1;

        String[] nameparts = free.getName().split(" ");
        for (String namepart : nameparts) {
            id += Character.toUpperCase(namepart.toUpperCase().charAt(0));
        }

        for (int i = 0; i < listaFreelancers.size(); i++) {
            if (id.charAt(0) == listaFreelancers.get(i).getFreeID().charAt(0) && id.charAt(1) == listaFreelancers.get(i).getFreeID().charAt(1)) {
                d = Character.getNumericValue(listaFreelancers.get(i).getFreeID().charAt(2));
                d = d + 1;
                
            }
        }
        return id + d;

    }
    
    public boolean Verification(Freelancer fr) {
        if (getListaFreelancers().contains(fr)) {
            return false;
        }
        return true;
    }

    //======================================================================================================================================================

    /**
     * returns the list of freelancers
     *
     * @return
     */
    public List<Freelancer> getListFreelancers() {
        return getListaFreelancers();
    }

    /**
     * method that returns a specific list of freelancers
     *
     * @param lt
     * @param ltr
     * @return
     */
    public List<Freelancer> getFreelancers(List<Task> lt, List<TransactionExecution> ltr) {
        List<Freelancer> newList = new ArrayList<>();
        for (int i = 0; i < lt.size(); i++) {
            Task ts = lt.get(i);
            for (int p = 0; p < ltr.size(); p++) {
                TransactionExecution tr = ltr.get(p);
                Task cts = tr.getTask();
                if (ts.equals(cts)) {
                    Freelancer freel = tr.getFreel();
                    newList.add(freel);
                }
            }
        }
        return newList;
    }

    /**
     * returns the list of freelancers
     *
     * @return the listaFreelancers
     */
    public List<Freelancer> getListaFreelancers() {
        return listaFreelancers;
    }

    

    /**
     * returns the delay probability
     *
     * @return the delayProb
     */
    public double getDelayProb() {
        return delayProb;
    }
    
    //======================================================================================================================================================

    /**
     * modifies the delay probability
     *
     * @param delayProb the delayProb to set
     */
    public void setDelayProb(double delayProb) {
        this.delayProb = delayProb;
    }
    
    /**
     * modifies the list of freelancers
     *
     * @param listaFreelancers the listaFreelancers to set
     */
    public void setListaFreelancers(List<Freelancer> listaFreelancers) {
        this.listaFreelancers = listaFreelancers;
    }
}
