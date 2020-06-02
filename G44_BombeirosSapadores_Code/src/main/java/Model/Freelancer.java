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
class Freelancer {

    private String freeID;
    private String name;
    private String levelExp;
    private String email;
    private String nif;
    private String country;
    private String iban;
    private Address address;

    private static final String freeIDPorOmissao = "whitout id";
    private static final String namePorOmissao = "whitout name";
    private static final String levelExpPorOmissao = "whitout levelExp";
    private static final String emailPorOmissao = "whitout email";
    private static final String nifPorOmissao = "whitout nif";
    private static final String countryPorOmissao = "whitout country";
    private static final String ibanPorOmissao = "whitout iban";

    public Freelancer() {
        this.freeID=freeIDPorOmissao;
        this.country=countryPorOmissao;
        this.name=namePorOmissao;
        this.levelExp=levelExpPorOmissao;
        this.iban=ibanPorOmissao;
        this.nif=nifPorOmissao;
        this.email=emailPorOmissao;
        this.address= new Address();
        }

    public Freelancer(String freeID, String name, String levelExp, String email, String nif, String iban, String country, Address address) {
        this.freeID = freeID;
        this.address = address;
        this.country = country;
        this.email = email;
        this.iban = iban;
        this.levelExp = levelExp;
        this.name = name;
        this.nif = nif;

    }

    public Boolean validateFreelancer() {
        if ((freeID == null) || (name == null) || (levelExp == null) || (email == null) || (nif == null) || (iban == null) || (country == null) || (address == null)) {
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

}
