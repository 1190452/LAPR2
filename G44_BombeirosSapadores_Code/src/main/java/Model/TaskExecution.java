/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;

/**
 *
 * @author tiagopereira
 */
public class TaskExecution {

    private Date endDate;
    private double delay;
    private String descriptionOfQuality;

    private static final Date DATA_OMISSAO = new Date();
    private static final double DELAY_OMISSAO = 1;
    private static final String DESCRIPTION_OMISSAO = "sem descrição";

    public TaskExecution(Date endDate, double delay, String descriptionOfQuality) {
        this.endDate = endDate;
        this.delay = delay;
        this.descriptionOfQuality = descriptionOfQuality;
    }
    
    public TaskExecution(){
        endDate = DATA_OMISSAO;
        delay = DELAY_OMISSAO;
        descriptionOfQuality = DESCRIPTION_OMISSAO;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the delay
     */
    public double getTaskDelay() {
        return delay;
    }

    /**
     * @return the descriptionOfQuality
     */
    public String getDescriptionOfQuality() {
        return descriptionOfQuality;
    }

    /**
     * @param descriptionOfQuality the descriptionOfQuality to set
     */
    public void setDescriptionOfQuality(String descriptionOfQuality) {
        this.descriptionOfQuality = descriptionOfQuality;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(double delay) {
        this.delay = delay;
    }
    
    
}
