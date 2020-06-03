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
    private PaymentList pl;

    private static final String freeIDPorOmissao = "whitout id";
    private static final String namePorOmissao = "whitout name";
    private static final String levelExpPorOmissao = "whitout levelExp";
    private static final String emailPorOmissao = "whitout email";
    private static final String nifPorOmissao = "whitout nif";
    private static final String countryPorOmissao = "whitout country";
    private static final String ibanPorOmissao = "whitout iban";

    public Freelancer() {
        this.freeID = freeIDPorOmissao;
        this.country = countryPorOmissao;
        this.name = namePorOmissao;
        this.levelExp = levelExpPorOmissao;
        this.iban = ibanPorOmissao;
        this.nif = nifPorOmissao;
        this.email = emailPorOmissao;
        this.address = new Address();
        this.pl = new PaymentList();
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
        this.pl = new PaymentList(); 
             

    }

    public Boolean validateFreelancer() {
        if ((freeID == null) || (name == null) || (levelExp == null) || (email == null) || (nif == null) || (iban == null) || (getCountry() == null) || (address == null)
                || (freeID.isEmpty()) || (name.isEmpty()) || (levelExp.isEmpty()) || (email.isEmpty()) || (nif.isEmpty()) || (iban.isEmpty()) || (getCountry().isEmpty())) {
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

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the pl
     */
    public PaymentList getPl() {
        return pl;
    }

    /**
     * @param pl the pl to set
     */
    public void setPl(PaymentList pl) {
        this.pl = pl;
    }
    
    public boolean addPayment(Payment p){
        if(p== null){
            return false;
        }
       
        
        pl.addPayment(p);
        return true;
    }
    
    public PaymentList getPaymentList(){
        return new PaymentList(pl.getPaymentList());
    }

}
