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

    /**
     * @return the levelExp
     */
    public String getLevelExp() {
        return levelExp;
    }

    /**
     * @param levelExp the levelExp to set
     */
    public void setLevelExp(String levelExp) {
        this.levelExp = levelExp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private String freeID;
    private String name;
    private String levelExp;
    private String email;
    private String nif;
    private String country;
    private String iban;
    private Address address;
    private PaymentList pl;
    private TaskList tl;

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
        this.pl = new PaymentList();
        this.tl = new TaskList();
    }

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

    public Boolean validateFreelancer() {
        if ((freeID == null) || (name == null) || (getLevelExp() == null) || (getEmail() == null) || (nif == null) || (iban == null) || (getCountry() == null) || (address == null)
                || (freeID.isEmpty()) || (name.isEmpty()) || (getLevelExp().isEmpty()) || (getEmail().isEmpty()) || (nif.isEmpty()) || (iban.isEmpty()) || (getCountry().isEmpty())) {
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

    public boolean addPayment(Payment p) {
        if (p == null) {
            return false;
        }

        pl.addPayment(p);
        return true;
    }

    public PaymentList getPaymentList() {
        return pl;
    }

    /**
     * @return the tl
     */
    public TaskList getTl() {
        return tl;
    }

    /**
     * @param tl the tl to set
     */
    public void setTl(TaskList tl) {
        this.tl = tl;
    }

    public double averageOfEachFreelancer(double paymentTotal, int n) {
        return (paymentTotal / n);
    }

    public double sumDeviation(double averageFreel, double paymentValue) {
        double deviation = Math.pow((paymentValue - averageFreel), 2);
        return deviation;
    }

    public double calculateDeviation(double sumAllPaymentsDeviation, int n) {
        return Math.sqrt((sumAllPaymentsDeviation / (n - 1)));
    }

    public double delayMean(double totalDelay, int size) {
        return (totalDelay / size);
    }

    public double sumDelay(double averageDelayOfFreelancer, double delayTask) {
        double deviation = Math.pow((delayTask - averageDelayOfFreelancer), 2);
        return deviation;
    }

    public double calculateDelayDeviation(double deviatonDelayOfEachTask, int size) {
        return Math.sqrt((deviatonDelayOfEachTask / (size - 1)));
    }

    public double calculateAverageDelayOfAllFreelancers(double totalDelayOfAllFreelancers, double numTasksOfAllFreelancers) {
        return (totalDelayOfAllFreelancers / numTasksOfAllFreelancers);
    }

    public TaskList getTaskList() {
        return tl;
    }

    public double calculateAveragePayementOFAllFreelancers(double totalPaymentOfAllFreelancer, int numPaymentsOfAllFreelancers) {
        return totalPaymentOfAllFreelancer / numPaymentsOfAllFreelancers;
    }

    public double calculatePaymentDeviationOfAllFreelancers(double averagePayementOFAllFreelancers, double payValue) {
        double deviation = Math.pow((payValue - averagePayementOFAllFreelancers), 2);
        return deviation;
    }

    public double calculatepaymentDeviationOfAllFreelancers(double sumPaymentDeviationOfAllFreelancers, int n) {
        return Math.sqrt((sumPaymentDeviationOfAllFreelancers / (n - 1)));
    }

}
