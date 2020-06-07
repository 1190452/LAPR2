package Model;


import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Ricardo
 */

public class Payment implements Serializable{



    /**
     * Value of the payment in euros
     */
    private double valueE;
    /**
     * Value of the payment in Freelancers currency
     */
    private double valueC;
    /**
     * List of the tranmsactions of the freelancer
     */
    private List<Transaction> nltr;

    private static final double VALUEE_BY_OMISSION = 0;
    private static final double VALUEC_BY_OMISSION = 0;

    /**
     * complete constrcutor that creates an instance of payment with the
     * following parameters:
     *
     * @param sum
     * @param curr
     * @param nltr
     */
    public Payment(double sum, double curr, List<Transaction> nltr) {
        if (sum != 0 && curr != 0 && nltr != null) {
            this.valueE = sum;
            this.valueC = curr;
            this.nltr = nltr;
        }
    }

    public Payment() {
        this.valueE = VALUEE_BY_OMISSION;
        this.valueC = VALUEC_BY_OMISSION;
        this.nltr = new ArrayList<Transaction>();
    }

    /**
     * returns the transaction list of the payment
     * @return the nltr
     */
    public List<Transaction> getNltr() {
        return nltr;
    }

    /**
     * modifies the transaction list of the payment
     * @param nltr the nltr to set
     */
    public void setNltr(List<Transaction> nltr) {
        this.nltr = nltr;
    }

    /**
     * returns the value in euros of the payment
     * @return the valueE
     */
    public double getValueE() {
        return valueE;
    }

    /**
     * modifies the value in euros of the payment
     * @param valueE the valueE to set
     */
    public void setValueE(double valueE) {
        this.valueE = valueE;
    }

    /**
     * returns the value in the currency of the freelancer of the payment
     * @return the valueC
     */
    public double getValueC() {
        return valueC;
    }

    /**
     * modifies the value in the currency of the freelancer of the payment
     * @param valueC the valueC to set
     */
    public void setValueC(double valueC) {
        this.valueC = valueC;
    }

    /**
     * method that validates the payment created
     * @return 
     */
    public boolean validatePay() {
        if (valueE != 0 && valueC != 0 && nltr != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * method that generates a receipt 
     * @param country 
     */
    public void generateReceipt(String country) {
        Receipt r = new Receipt(nltr, valueE, valueC);

        r.genEmail();
    }

}
