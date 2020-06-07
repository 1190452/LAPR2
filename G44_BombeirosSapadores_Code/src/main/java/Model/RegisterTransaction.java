/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class RegisterTransaction {

    private Transaction transaction;
    private List<Transaction> transactionList;

    /**
     * constructor than initializes the transaftion list as an ArrayList
     */
    public RegisterTransaction() {
        transactionList = new ArrayList<>();
    }

    /**
     * 
     * @param tr 
     */
    public void addHistoricalTransaction(Transaction tr) {
        transactionList.add(tr);
    }

    public void removeHistoricalTransaction(Transaction tr) {
        transactionList.remove(tr);
    }

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public boolean validateHistoricalTransaction(List<Transaction> lt) {
        return !lt.isEmpty();
    }

    public Transaction createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        TaskExecution tascExec = transaction.createTaskExecution(endDate, delay, qow);
        return new Transaction(task, freel, new TaskExecution(endDate, delay, qow));
    }

    public boolean registerTransaction(Transaction trans) {
        if (validateTransaction(trans) == true) {
            return addTransaction(trans);
        }
        return false;
    }

    public boolean validateTransaction(Transaction trans) {
        if (transactionList.contains(trans)) {
            return false;
        }
        return true;
    }

    public boolean addTransaction(Transaction trans) {
        return transactionList.add(trans);
    }

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
