/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiagopereira
 */
public class Transaction {
    private Task task;
    private String transID;
    private Freelancer freel;
    private TaskExecution taskEx;
    
    private static final String TRANSID_OMISSION = "sem id";
    
    public Transaction(String transID, Task task, Freelancer freel,TaskExecution taskEx){
        this.transID = transID;
        this.task = task;
        this.freel = freel;
        this.taskEx = taskEx;
    }
    
    public Transaction(Task task, Freelancer freel,TaskExecution taskEx){
        this.task = task;
        this.freel = freel;
        this.taskEx = taskEx;
    }
    
    public Transaction(){
        transID = TRANSID_OMISSION;
        task = new Task();
        freel = new Freelancer();
        taskEx = new TaskExecution();
        
    }

    /**
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * @return the transID
     */
    public String getTransID() {
        return transID;
    }

    /**
     * @param transID the transID to set
     */
    public void setTransID(String transID) {
        this.transID = transID;
    }

    /**
     * @return the freel
     */
    public Freelancer getFreel() {
        return freel;
    }

    /**
     * @param freel the freel to set
     */
    public void setFreel(Freelancer freel) {
        this.freel = freel;
    }

    /**
     * @return the taskEx
     */
    public TaskExecution getTaskEx() {
        return taskEx;
    }

    /**
     * @param taskEx the taskEx to set
     */
    public void setTaskEx(TaskExecution taskEx) {
        this.taskEx = taskEx;
    }

    public TaskExecution createTaskExecution(Date endDate, double delay, String qow) {
       return new TaskExecution(endDate, delay, qow);
    }
    
}
