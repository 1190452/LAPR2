/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rafael
 */
public class Freelancer {

    private String freeID;
    private String name;
    private String levelExp;
    private String email;
    private String nif;
    private String country;
    private String iban;
    private Address address;

    private static final String freeIDPorOmissao = "without id";
    private static final String namePorOmissao = "without name";
    private static final String levelExpPorOmissao = "without levelExp";
    private static final String emailPorOmissao = "without email";
    private static final String nifPorOmissao = "without nif";
    private static final String countryPorOmissao = "without country";
    private static final String ibanPorOmissao = "without iban";

    public Freelancer() {
        this.freeID = freeIDPorOmissao;
        this.country = countryPorOmissao;
        this.name = namePorOmissao;
        this.levelExp = levelExpPorOmissao;
        this.iban = ibanPorOmissao;
        this.nif = nifPorOmissao;
        this.email = emailPorOmissao;
        this.address = new Address();
    }

    public Freelancer(String freeID, String name, String levelExp, String email, String nif, String iban, String country, Address address) {
        this.freeID = freeID;
        this.country = country;
        this.email = email;
        this.iban = iban;
        this.levelExp = levelExp;
        this.name = name;
        this.nif = nif;
        this.address = address;

    }

    public Boolean validateFreelancer() {
        if ((freeID == null) || (name == null) || (levelExp == null) || (email == null) || (nif == null) || (iban == null) || (country == null) || (address == null)
                || (freeID.isEmpty()) || (name.isEmpty()) || (levelExp.isEmpty()) || (email.isEmpty()) || (nif.isEmpty()) || (iban.isEmpty()) || (country.isEmpty())) {
            return false;
        } else {
            return true;
        }

    }

    public void setFreeID(String freeID) {
        this.freeID = this.getFreeID();
    }

    /**
     * @return the freeID
     */
    public String getFreeID() {
        return freeID;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    public String getName() {
        return name;
    }

}
