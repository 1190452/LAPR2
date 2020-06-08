/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import java.io.Serializable;

/**
 *
 * @author tiagopereira
 */
public class TaskExecution implements Serializable{

    /**
     * end date of the task execution
     */
    private Date endDate;
    
    /**
     * delay of the task execution (extra time that the freelancer took to execute the task)
     */
    private double delay;
    
    /**
     * description of quality of the task execution
     */
    private String descriptionOfQuality;

    /**
     * delay by omission
     */
    private static final double DELAY_BY_OMISSION = 1;
    
    /**
     * description of quality by omission
     */
    private static final String DESCRIPTION_BY_OMISSION = "No description provided";

    /**
     * complete constructor that builds an instance of task execution
     * @param endDate
     * @param delay
     * @param descriptionOfQuality 
     */
    public TaskExecution(Date endDate, double delay, String descriptionOfQuality) {
        this.endDate = endDate;
        this.delay = delay;
        this.descriptionOfQuality = descriptionOfQuality;
    }
    
    /**
     * empty constructor that builds an instance of task execution
     */
    public TaskExecution(){
        this.endDate = new Date();
        this.delay = DELAY_BY_OMISSION;
        this.descriptionOfQuality = DESCRIPTION_BY_OMISSION;
    }

    /**
     * returns the end date
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * returns the task 
     * @return the delay
     */
    public double getTaskDelay() {
        return delay;
    }

    /**
     * returns the description of quality
     * @return the descriptionOfQuality
     */
    public String getDescriptionOfQuality() {
        return descriptionOfQuality;
    }

    /**
     * modifies the description of quality 
     * @param descriptionOfQuality the descriptionOfQuality to set
     */
    public void setDescriptionOfQuality(String descriptionOfQuality) {
        this.descriptionOfQuality = descriptionOfQuality;
    }

    /**
     * modifies the end date
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * modifies the delay
     * @param delay the delay to set
     */
    public void setDelay(double delay) {
        this.delay = delay;
    }
    
    
}
