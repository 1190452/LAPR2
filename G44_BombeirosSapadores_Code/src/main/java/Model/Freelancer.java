/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class Freelancer implements Serializable{

    /**
     * id of the freelancer
     */
    private String freeID;
    
    /**
     * name of the freelancer
     */
    private String name;
    
    /**
     * level of expertise of the freelancer
     */
    private String levelExp;
    
    /**
     * email of the freelancer
     */
    private String email;
    
    /**
     * nif of the freelancer
     */
    private String nif;
    
    /**
     * country of the freelancer
     */
    private String country;
    
    /**
     * iban of the freelancer
     */
    private String iban;
    
    /**
     * address of the freelancer
     */
    private Address address;
    
    /**
     * payment list of the freelancer
     */
    private PaymentList pl;
    
    /**
     * task list of the freelancer
     */
    private TaskList tl;

    /**
     * freelancer id by omission
     */
    private static final String FREEID_BY_OMISSION = "no id";
    
    /**
     * freelancer name by omission
     */
    private static final String NAME_BY_OMISSION = "no name";
    
    /**
     * level of expertise of the freelancer by omission
     */
    private static final String LEVELEXP_BY_OMISSION = "no level of expertise";
    
    /**
     * email of the freelancer by omission
     */
    private static final String EMAIL_BY_OMISSION = "no email";
    
    /**
     * freelancer's nif by omission
     */
    private static final String NIF_BY_OMISSION = "no nif";
    
    /**
     * freelancer's country by omission
     */
    private static final String COUNTRY_BY_OMISSION = "no country";
    
    /**
     * freelancer's iban by omission
     */
    private static final String IBAN_BY_OMISSION = "no iban";

    /**
     * empty constructor that creates an instance of Freelancer
     */
    public Freelancer() {
        this.freeID = FREEID_BY_OMISSION;
        this.country = COUNTRY_BY_OMISSION;
        this.name = NAME_BY_OMISSION;
        this.levelExp = LEVELEXP_BY_OMISSION;
        this.iban = IBAN_BY_OMISSION;
        this.nif = NIF_BY_OMISSION;
        this.email = EMAIL_BY_OMISSION;
        this.address = new Address();
        this.pl = new PaymentList();
        this.tl = new TaskList();
    }

    /**
     * constructor that creates an instance of Freelancer and receives the following parameters
     * @param name
     * @param levelExp
     * @param email
     * @param nif
     * @param iban
     * @param country
     * @param address 
     */
    public Freelancer(String name, String levelExp, String email, String nif, String iban, String country, Address address) {
        freeID = freeID;
        this.country = country;
        this.email = email;
        this.iban = iban;
        this.levelExp = levelExp;
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.pl = new PaymentList();
        this.tl = new TaskList();

    }

    /**
     * constructor that creates an instance of Freelancer and receives the following parameters
     * @param freeID
     * @param name
     * @param levelExp
     * @param email
     * @param nif
     * @param iban
     * @param country
     * @param address 
     */
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
        this.tl = new TaskList();

    }

    /**
     * returns the level of expertise of the freelancer
     * @return the levelExp
     */
    public String getLevelExp() {
        return levelExp;
    }

    /**
     * modifies the level of expertise of the freelancer
     * @param levelExp the levelExp to set
     */
    public void setLevelExp(String levelExp) {
        this.levelExp = levelExp;
    }

    /**
     * returns the email of the freelancer
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * modifies the email of the freelancer
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * method that checks if the freelancer atributes are valid
     * @return 
     */
    public boolean validateFreelancer() {
        if ((freeID == null) || (name == null) || (getLevelExp() == null) || (getEmail() == null) || (nif == null) || (iban == null) || (getCountry() == null) || (address == null)
                || (freeID.isEmpty()) || (name.isEmpty()) || (getLevelExp().isEmpty()) || (getEmail().isEmpty()) || (nif.isEmpty()) || (iban.isEmpty()) || (getCountry().isEmpty())) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * modifies the freelancer ID
     * @param freeID 
     */
    public void setFreeID(String freeID) {
        this.freeID = freeID;
    }

    /**
     * returns the freelancer ID
     * @return the freeID
     */
    public String getFreeID() {
        return freeID;
    }

    /**
     * returns freelancer's NIF
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * returns freelancer's IBAN
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * returns freelancer's name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * returns freelancer's country
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * modifies freelancer's country
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * returns freelancer's payment list
     * @return the pl
     */
    public PaymentList getPl() {
        return pl;
    }

    /**
     * modifies freelancer's payment list
     * @param pl the pl to set
     */
    public void setPl(PaymentList pl) {
        this.pl = pl;
    }

    /**
     * method that adds a payment to freelancer's payment list
     * @param p
     * @return 
     */
    public boolean addPayment(Payment p) {
        if (p == null) {
            return false;
        }

        pl.addPayment(p);
        return true;
    }

    /**
     * returns freelancer's payment list 
     * @return 
     */
    public PaymentList getPaymentList() {
        return pl;
    }

    /**
     * returns freelancer's task list
     * @return the tl
     */
    public TaskList getTl() {
        return tl;
    }

    /**
     * modifies freelancer's task list
     * @param tl the tl to set
     */
    public void setTl(TaskList tl) {
        this.tl = tl;
    }

    /**
     * method that calculates the average payment of one freelancer
     * @param paymentTotal
     * @param n
     * @return 
     */
    public double averageOfEachFreelancer(double paymentTotal, int n) {
        return (paymentTotal / n);
    }

    /**
     * method that calculates the payment variance of one freelancer
     * @param averageFreel
     * @param paymentValue
     * @return 
     */
    public double sumPaymentVariance(double averageFreel, double paymentValue) {
        double deviation = Math.pow((paymentValue - averageFreel), 2);
        return deviation;
    }

    /**
     * method that calculates the payment deviation of one freelancer
     * @param sumAllPaymentsDeviation
     * @param n
     * @return 
     */
    public double calculateDeviation(double sumAllPaymentsDeviation, int n) {
        return Math.sqrt((sumAllPaymentsDeviation / (n - 1)));
    }

    /**
     * method that calculates the delay mean of one freelancer
     * @param totalDelay
     * @param size
     * @return 
     */
    public double delayMean(double totalDelay, int size) {
        return (totalDelay / size);
    }

    /**
     * method that calculates the delay variance of one freelancer
     * @param averageDelayOfFreelancer
     * @param delayTask
     * @return 
     */
    public double sumDelayVariance(double averageDelayOfFreelancer, double delayTask) {
        double deviation = Math.pow((delayTask - averageDelayOfFreelancer), 2);
        return deviation;
    }

    /**
     * method that calculates the delay deviation of one freelancer
     * @param deviatonDelayOfEachTask
     * @param size
     * @return 
     */
    public double calculateDelayDeviation(double deviatonDelayOfEachTask, int size) {
        return Math.sqrt((deviatonDelayOfEachTask / (size - 1)));
    }

    /**
     * method that calculates the average delay of all freelancers
     * @param totalDelayOfAllFreelancers
     * @param numTasksOfAllFreelancers
     * @return 
     */
    public double calculateAverageDelayOfAllFreelancers(double totalDelayOfAllFreelancers, double numTasksOfAllFreelancers) {
        return (totalDelayOfAllFreelancers / numTasksOfAllFreelancers);
    }

    /**
     * returns the task list of the freelancer
     * @return 
     */
    public TaskList getTaskList() {
        return tl;
    }

    /**
     * method that calculates the average payment of all freelancers
     * @param totalPaymentOfAllFreelancer
     * @param numPaymentsOfAllFreelancers
     * @return 
     */
    public double calculateAveragePayementOFAllFreelancers(double totalPaymentOfAllFreelancer, int numPaymentsOfAllFreelancers) {
        return totalPaymentOfAllFreelancer / numPaymentsOfAllFreelancers;
    }

    /**
     * method that calculates the payment variance of all freelancers
     * @param averagePayementOFAllFreelancers
     * @param payValue
     * @return 
     */
    public double calculatePaymentVarianceOfAllFreelancers(double averagePayementOFAllFreelancers, double payValue) {
        double deviation = Math.pow((payValue - averagePayementOFAllFreelancers), 2);
        return deviation;
    }

    /**
     * method that claculates the payment deviation of all freelancers
     * @param sumPaymentDeviationOfAllFreelancers
     * @param n
     * @return 
     */
    public double calculatepaymentDeviationOfAllFreelancers(double sumPaymentDeviationOfAllFreelancers, int n) {
        return Math.sqrt((sumPaymentDeviationOfAllFreelancers / (n - 1)));
    }

}
