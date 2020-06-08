
package Model;

import Utils.Date;
import java.io.Serializable;

<<<<<<< HEAD
=======

>>>>>>> 38591059d10c6d6956c8c524142cd0215abb2f0f
/**
 *
 * @author tiagopereira
 */
public class Transaction implements Serializable {

    /**
     * task related to the transaction
     */
    private Task task;

    /**
     * freelancer related to the transaction
     */
    private Freelancer freel;

    /**
     * task execution related to the transaction
     */
    private TaskExecution taskEx;

    /**
     * value of the transaction
     */
    private double transactionValue;
    private String transID;

    /**
     * counter which will be incremented to generate the transaction ID
     */
    private static int counter = 100;

    /**
     *
     * @param task
     * @param freel
     * @param taskEx
     */
    public Transaction(Task task, Freelancer freel, TaskExecution taskEx) {
        this.task = task;
        this.freel = freel;
        this.taskEx = taskEx;
        this.transactionValue = 0;
        counter++;
    }
    
    public Transaction(String transID,Task task, Freelancer freel, TaskExecution taskEx) { 
        this.transID = transID;
        this.task = task;
        this.freel = freel;
        this.taskEx = taskEx;
        this.transactionValue = 0;
    }

    public Transaction() {
        this.task = new Task();
        this.freel = new Freelancer();
        this.taskEx = new TaskExecution();
        this.transactionValue = 0;
        counter++;
    }

    /**
     * returns the task related to the transaction
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * modifies the task related to the transaction
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * returns the freelancer related to the transaction
     * @return the freel
     */
    public Freelancer getFreel() {
        return freel;
    }

    /**
     * modifies the freelancer related to the transaction
     * @param freel the freel to set
     */
    public void setFreel(Freelancer freel) {
        this.freel = freel;
    }

    /**
     * returns the task execution of the transaction
     * @return the taskEx
     */
    public TaskExecution getTaskEx() {
        return taskEx;
    }

    /**
     * returns the counter 
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * modifies the task execution related to the transaction
     * @param taskEx the taskEx to set
     */
    public void setTaskEx(TaskExecution taskEx) {
        this.taskEx = taskEx;
    }

    /**
     * returns the transaction value
     * @return the transactionValue
     */
    public double getTransactionValue() {
        return transactionValue;
    }

    /**
     * modifies the transaction value
     * @param transactionValue the transactionValue to set
     */
    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }


    /**
     * writing method of the class Transaction
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Task :%s -------------------- %s ", task.getIdTask(), transactionValue);
    }

}
