package Model;

import Utils.Date;
import java.io.Serializable;

/**
 *
 * @author tiagopereira
 */
public class TransactionExecution implements Serializable {

    /**
     * task related to the TransactionExecution
     */
    private Task task;

    /**
     * freelancer related to the TransactionExecution
     */
    private Freelancer freel;

    /**
     * end date of the task execution
     */
    private Date endDate;

    /**
     * Delay of the TransactionExecution (extra time that the freelancer took to
     * execute the task)
     */
    private double delay;

    /**
     * Description of quality of the TransactionExecution
     */
    private String descriptionOfQuality;

    /**
     * Delay by omission
     */
    private static final double DELAY_BY_OMISSION = 1;

    /**
     * Description of quality by omission
     */
    private static final String DESCRIPTION_BY_OMISSION = "No description provided";

    /**
     * Value of the TransactionExecution
     */
    private double transactionValue;

    /**
     * The id of the TransactionExecution
     */
    private String transID;

    /**
     * counter which will be incremented to generate the transaction ID
     */
    private static int counter = 100;

    /**
     * constructor that creates an instance of transaction with the following
     * parameters:
     *
     * @param transID
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param descString
     */
    public TransactionExecution(String transID,Task task, Freelancer freel, Date endDate, double delay, String descString) {
        this.transID = transID;
        this.task = task;
        this.freel = freel;
        this.endDate = endDate;
        this.delay = delay;
        this.descriptionOfQuality = descString;
        this.transactionValue = 0;
        counter++;
    }
    
    
    /**
     * constructor that creates an instance of transaction with the following
     * parameters:
     *
     * @param transID
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param descString
     * @param transactionValue
     */
    public TransactionExecution(String transID,Task task, Freelancer freel, Date endDate, double delay, String descString, double transactionValue) {
        this.transID = transID;
        this.task = task;
        this.freel = freel;
        this.endDate = endDate;
        this.delay = delay;
        this.descriptionOfQuality = descString;
        this.transactionValue = transactionValue;
        counter++;
    }
    
    /**
     * constructor that creates an instance of transaction with the following
     * parameters:
     *
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param descString
     */
    public TransactionExecution(Task task, Freelancer freel, Date endDate, double delay, String descString) {
        this.task = task;
        this.freel = freel;
        this.endDate = endDate;
        this.delay = delay;
        this.descriptionOfQuality = descString;
        transactionValue = 0;
        counter++;
    }


    /**
     * empty constructor that creates an instance of Transaction
     */
    public TransactionExecution() {
        this.task = new Task();
        this.freel = new Freelancer();
        this.endDate = new Date();
        this.delay = DELAY_BY_OMISSION;
        this.descriptionOfQuality = DESCRIPTION_BY_OMISSION;
        this.transactionValue = 0;
        counter++;
    }

    /**
     * copy constructor
     *
     * @param otherTrans
     */
    public TransactionExecution(TransactionExecution otherTrans) {
        this.transID = otherTrans.transID;
        this.task = otherTrans.task;
        this.freel = otherTrans.freel;
        this.endDate = otherTrans.endDate;
        this.delay = otherTrans.delay;
        this.descriptionOfQuality = otherTrans.descriptionOfQuality;
        this.transactionValue = otherTrans.transactionValue;

    }

    /**
     * returns the end date
     *
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * returns the task
     *
     * @return the delay
     */
    public double getTaskDelay() {
        return delay;
    }

    /**
     * returns the description of quality
     *
     * @return the descriptionOfQuality
     */
    public String getDescriptionOfQuality() {
        return descriptionOfQuality;
    }

    /**
     * modifies the description of quality
     *
     * @param descriptionOfQuality the descriptionOfQuality to s
     * @return et
     */
    public boolean setDescriptionOfQuality(String descriptionOfQuality) {
        this.descriptionOfQuality = descriptionOfQuality;
        return true;
    }

    /**
     * modifies the end date
     *
     * @param endDate the endDate to set
     * @return 
     */
    public boolean setEndDate(Date endDate) {
        this.endDate = endDate;
        return true;
    }

    /**
     * modifies the delay
     *
     * @param delay the delay to set
     * @return 
     */
    public boolean setDelay(double delay) {
        this.delay = delay;
        return true;
    }

    /**
     * returns the task related to the transaction
     *
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * modifies the task related to the transaction
     *
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * returns the freelancer related to the transaction
     *
     * @return the freel
     */
    public Freelancer getFreel() {
        return freel;
    }

    /**
     * modifies the freelancer related to the transaction
     *
     * @param freel the freel to set
     */
    public void setFreel(Freelancer freel) {
        this.freel = freel;
    }


    /**
     * returns the counter
     *
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }


    /**
     * returns the transaction value
     *
     * @return the transactionValue
     */
    public double getTransactionValue() {
        return transactionValue;
    }

    /**
     * modifies the transaction value
     *
     * @param transactionValue the transactionValue to set
     */
    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    /**
     * writing method of the class TransactionExecution
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Task Execution:%s -------------------- %s ", task.getIdTask(), transactionValue);
    }

}
