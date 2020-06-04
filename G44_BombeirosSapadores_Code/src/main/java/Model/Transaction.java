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
    private Freelancer freel;
    private TaskExecution taskEx;
    private double transactionValue;

    private static int counter = 100;

    public Transaction(Task task, Freelancer freel, TaskExecution taskEx) {
        this.task = task;
        this.freel = freel;
        this.taskEx = taskEx;
        this.transactionValue = 0;
        counter++;
    }

    public Transaction() {
        task = new Task();
        freel = new Freelancer();
        taskEx = new TaskExecution();
        this.transactionValue = 0;

        counter++;
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
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @param taskEx the taskEx to set
     */
    public void setTaskEx(TaskExecution taskEx) {
        this.taskEx = taskEx;
    } 
    
    /**
     * @return the transactionValue
     */
    public double getTransactionValue() {
        return transactionValue;
    }

    /**
     * @param transactionValue the transactionValue to set
     */
    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    
    
    public TaskExecution createTaskExecution(Date endDate, double delay, String qow) {
        return new TaskExecution(endDate, delay, qow);
    }
    
    @Override
    public String toString(){
        return String.format("Task :%s -------------------- %s ", task.getIdTask(), transactionValue);
    }
    
}
