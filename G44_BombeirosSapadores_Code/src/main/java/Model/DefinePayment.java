package Model;

import Utils.Date;
import Utils.Time;
import java.io.Serializable;

/**
 *
 * @author tiagopereira
 */
public class DefinePayment implements Serializable {

    /**
     * time in which the platform will pay to the freelancers
     */
    private Time timeToPay;

    /**
     * date in which the platform will pay to the freelancers
     */
    private Date dateToPay;

    /**
     * recurrence of the payment to the freelancers
     */
    private int nrDays;

    /**
     * time to pay by omission
     */
    private static final Time TIMETOPAY_OMISSION = new Time();

    /**
     * date to pay by omission
     */
    private static final Date DATETOPAY_OMISSION = new Date();

    /**
     * number of days by omission
     */
    private static final int NRDAYS_OMISSION = 0;

    /**
     * complete constructor that builds an instance of DefinePayment and
     * receives a time to pay, a date to pay and the number of days
     *
     * @param timeToPay
     * @param dateToPay
     * @param nrDays
     */
    public DefinePayment(Time timeToPay, Date dateToPay, int nrDays) {
        this.timeToPay = timeToPay;
        this.dateToPay = dateToPay;
        this.nrDays = nrDays;
    }

    /**
     * empty constructor that builds an instance of DefinePayment
     */
    public DefinePayment() {
        timeToPay = TIMETOPAY_OMISSION;
        dateToPay = DATETOPAY_OMISSION;
        nrDays = NRDAYS_OMISSION;
    }
    //======================================================================================================================================================

    /**
     * method that registers the payment definition created
     *
     * @param dpay
     * @return
     */
    public boolean registersDefinePayment(DefinePayment dpay) {
        if (validatesDefinePayment(dpay)) {
            return true;
        }
        return false;
    }

    /**
     * method that validates the payment definition created
     *
     * @param dpay
     * @return
     */
    private boolean validatesDefinePayment(DefinePayment dpay) {
        boolean bRet = true;

        if (dpay == null) {
            bRet = false;
        }

        return bRet;
    }

    //======================================================================================================================================================
    /**
     * returns the time to pay
     *
     * @return the timeToPay
     */
    public Time getTimeToPay() {
        return timeToPay;
    }

    /**
     * returns the date to pay
     *
     * @return the dateToPay
     */
    public Date getDateToPay() {
        return dateToPay;
    }

    /**
     * returns the number of days
     *
     * @return the nrDays
     */
    public int getNrDays() {
        return nrDays;
    }

    //======================================================================================================================================================
    /**
     * modifies the time to pay
     *
     * @param timeToPay the timeToPay to set
     */
    public void setTimeToPay(Time timeToPay) {
        this.timeToPay = timeToPay;
    }

    public void setDateToPay(Date dateToPay) {
        this.dateToPay = dateToPay;
    }

    /**
     * modifies the number of days
     *
     * @param nrDays the nrDays to set
     */
    public void setNrDays(int nrDays) {
        this.nrDays = nrDays;
    }

    //======================================================================================================================================================
    /**
     * Method toString of Define Payment
     *
     * @return Define Payment in String format
     */
    @Override
    public String toString() {
        return String.format("Date to Pay: %s\nTime to Pay: %s\nNumber of Days: %d", dateToPay.toString(), timeToPay.toString(), nrDays);
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        DefinePayment otherDef = (DefinePayment) otherObject;
        return this.timeToPay.equals(otherDef.timeToPay)
                && this.dateToPay.equals(otherDef.dateToPay) 
                && this.nrDays==otherDef.nrDays;
    }

}
