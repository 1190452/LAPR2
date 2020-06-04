package Model;

import java.util.List;

/**
 *
 * @author Ricardo
 */
public class Payment {
    /**
     * Value of the payment in euro
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
    /**
     * 
     * @param sum
     * @param curr
     * @param nltr 
     */
    public Payment(double sum, double curr, List<Transaction> nltr){
        if(sum != 0 && curr != 0 && nltr != null){
            this.valueE=sum;
            this.valueC=curr;
            this.nltr=nltr;
        }
        
    }


    /**
     * @return the nltr
     */
    public List<Transaction> getNltr() {
        return nltr;
    }

    /**
     * @param nltr the nltr to set
     */
    public void setNltr(List<Transaction> nltr) {
        this.nltr = nltr;
    }

    /**
     * @return the valueE
     */
    public double getValueE() {
        return valueE;
    }

    /**
     * @param valueE the valueE to set
     */
    public void setValueE(double valueE) {
        this.valueE = valueE;
    }

    /**
     * @return the valueC
     */
    public double getValueC() {
        return valueC;
    }

    /**
     * @param valueC the valueC to set
     */
    public void setValueC(double valueC) {
        this.valueC = valueC;
    }
    
    public boolean validatePay(){
        
    }
    
    
    
}
