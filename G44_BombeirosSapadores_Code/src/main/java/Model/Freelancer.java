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

    Freelancer(String freeID, String name, String levelExp, String email, String nif, String iban, String country, Address address) {
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
        if((freeID!=null)|| (name!=null) || (levelExp!=null) || (email!=null) || (nif!=null) || (iban!=null) || (country!=null)|| (address!=null)){
            return true;
        }else{
            return false;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the levelExp
     */
    public String getLevelExp() {
        return levelExp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }


}
