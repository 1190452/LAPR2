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
    private List<Transaction> transactionList;

    /**
     * constructor than initializes the transaftion list as an ArrayList
     */
    public RegisterTransaction() {
        transactionList = new ArrayList<>();
    }

    /**
     * method that removes a transaction from the transaction list
     * @param tr 
     */
    public void removeHistoricalTransaction(Transaction tr) {
        transactionList.remove(tr);
    }

    /**
     * returns the list of transactions
     * @return the transactionList
     */
    public List<Transaction> getTransactions() {
        return transactionList;
    }

    /**
     * method that verifies if they transaction list is empty
     * @param lt
     * @return 
     */
    public boolean validateHistoricalTransaction(List<Transaction> lt) {
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
    public Transaction createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        task.setIsFinished(true);
        return new Transaction(task, freel, new TaskExecution(endDate, delay, qow));
    }

    /**
     * method that registers the transaction
     * @param trans
     * @return 
     */
    public boolean registerTransaction(Transaction trans) {
        if (validateTransaction(trans) == true) {
            return addTransaction(trans);
        }
        return false;
    }

    /**
     * method that checks if the transaction can be added to the list (global validation)
     * @param trans
     * @return 
     */
    public boolean validateTransaction(Transaction trans) {
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
    public boolean addTransaction(Transaction trans) {
        return transactionList.add(trans);
    }

    /**
     * method that calculates the value of each transaction
     * @param trans
     * @return 
     */
    public double calculateTransactionValue(Transaction trans) {
        for (Transaction t : transactionList) {
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
