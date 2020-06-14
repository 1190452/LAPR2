package Model;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Payment implements Serializable {

    /**
     * Value of the payment in euros
     */
    private double valueE;
    /**
     * Value of the payment in Freelancers currency
     */
    private double valueC;

    private static final double VALUEE_BY_OMISSION = 0;
    private static final double VALUEC_BY_OMISSION = 0;

    /**
     * complete constrcutor that creates an instance of payment with the
     * following parameters:
     *
     * @param sum
     * @param curr
     */
    public Payment(double sum, double curr) {
        if (sum != 0 && curr != 0) {
            this.valueE = sum;
            this.valueC = curr;
        }
    }

    public Payment() {
        this.valueE = VALUEE_BY_OMISSION;
        this.valueC = VALUEC_BY_OMISSION;
    }

    //======================================================================================================================================================
    /**
     * returns the value in euros of the payment
     *
     * @return the valueE
     */
    public double getValueE() {
        return valueE;
    }

    /**
     * returns the value in the currency of the freelancer of the payment
     *
     * @return the valueC
     */
    public double getValueC() {
        return valueC;
    }

    //======================================================================================================================================================
    /**
     * modifies the value in euros of the payment
     *
     * @param valueE the valueE to set
     */
    public void setValueE(double valueE) {
        this.valueE = valueE;
    }

    /**
     * modifies the value in the currency of the freelancer of the payment
     *
     * @param valueC the valueC to set
     */
    public void setValueC(double valueC) {
        this.valueC = valueC;
    }

    @Override
    public String toString() {
        return String.format("%.2f", valueE);
    }
}
