/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class RegisterTransaction implements Serializable{
    
    /**
     * transaction list
     */
    private List<TransactionExecution> transactionList;

    /**
     * constructor than initializes the transaftion list as an ArrayList
     */
    public RegisterTransaction() {
        transactionList = new ArrayList<>();
    }

    /**
     * method that removes a transaction from the transaction list
     * @param tr 
     * @return  
     */
    public boolean removeHistoricalTransaction(TransactionExecution tr) {
       return transactionList.remove(tr);
    }

    /**
     * returns the list of transactions
     * @return the transactionList
     */
    public List<TransactionExecution> getTransactions() {
        return transactionList;
    }

    /**
     * method that verifies if they transaction list is empty
     * @param lt
     * @return 
     */
    public boolean validateHistoricalTransaction(List<TransactionExecution> lt) {
        return !lt.isEmpty();
    }

    /**
     * method that creates a new transaction
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param qow
     * @return 
     */
    public TransactionExecution createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        task.setIsFinished(true);
        return new TransactionExecution(task, freel, endDate, delay, qow);
    }

    /**
     * method that registers the transaction
     * @param trans
     * @return 
     */
    public boolean registerTransaction(TransactionExecution trans) {
        if (validateTransaction(trans)) {
            return addTransaction(trans);
        }
        return false;
    }

    /**
     * method that checks if the transaction can be added to the list (global validation)
     * @param trans
     * @return 
     */
    public boolean validateTransaction(TransactionExecution trans) {
        if (transactionList.contains(trans)) {
            return false;
        }
        return true;
    }

    /**
     * method that adds a transaction 
     * @param trans
     * @return 
     */
    public boolean addTransaction(TransactionExecution trans) {
        transactionList.add(trans);
        trans.setTransactionValue(calculateTransactionValue(trans));
        if(transactionList!=null){
            return true;
        }
        return false;
    }

    /**
     * method that calculates the value of each transaction
     * @param trans
     * @return 
     */
    public double calculateTransactionValue(TransactionExecution trans) {
        for (TransactionExecution t : transactionList) {
            if (t.equals(trans)) {
                if (trans.getFreel().getLevelExp().equalsIgnoreCase("Senior")) {
                    double value = trans.getTask().getCostHour() * trans.getTask().getTimeTask() * 2;
                    trans.setTransactionValue(value);
                    return value;
                    
                }
                double value = trans.getTask().getCostHour() * trans.getTask().getTimeTask();
                trans.setTransactionValue(value);
                return value;
            }

        }
        return -1;        
    }
}
