/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import Utils.Time;

/**
 *
 * @author tiagopereira
 */
public class DefinePayment {
    private Time timeToPay;
    private Date dateToPay;
    private int nrDays;
    
    private static final Time TIMETOPAY_OMISSION = new Time();
    private static final Date DATETOPAY_OMISSION = new Date();
    private static final int NRDAYS_OMISSION = 0;
    
    public DefinePayment(Time timeToPay, Date dateToPay, int nrDays){
        this.timeToPay = timeToPay;
        this.dateToPay = dateToPay;
        this.nrDays = nrDays;
    }
    
    public DefinePayment(){
        timeToPay = TIMETOPAY_OMISSION;
        dateToPay = DATETOPAY_OMISSION;
        nrDays = NRDAYS_OMISSION;
    }

    /**
     * @return the timeToPay
     */
    public Time getTimeToPay() {
        return timeToPay;
    }

    /**
     * @param timeToPay the timeToPay to set
     */
    public void setTimeToPay(Time timeToPay) {
        this.timeToPay = timeToPay;
    }

    /**
     * @return the dateToPay
     */
    public Date getDateToPay() {
        return dateToPay;
    }

    /**
     * @param dateToPay the dateToPay to set
     */
    public void setDateToPay(Date dateToPay) {
        this.dateToPay = dateToPay;
    }

    /**
     * @return the nrDays
     */
    public int getNrDays() {
        return nrDays;
    }

    /**
     * @param nrDays the nrDays to set
     */
    public void setNrDays(int nrDays) {
        this.nrDays = nrDays;
    }

    public boolean registersDefinePayment(DefinePayment dpay) {
       if(validatesDefinePayment(dpay)){
           return true;
       }
       return false;
    }

    private boolean validatesDefinePayment(DefinePayment dpay) {
        boolean bRet = true;

        if (dpay == null) {
            bRet = false;
        }

        return bRet;
    }
    }
    
    

