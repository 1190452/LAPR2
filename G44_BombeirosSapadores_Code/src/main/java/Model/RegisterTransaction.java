/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CurrencyConverter;
import Utils.Date;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class RegisterTransaction implements Serializable {

    /**
     * transaction list
     */
    private List<TransactionExecution> transactionList;

    private CurrencyConverter cc;

    /**
     * constructor than initializes the transaftion list as an ArrayList
     */
    public RegisterTransaction() {
        transactionList = new ArrayList<>();
        cc = new CurrencyConverter();

    }

    //======================================================================================================================================================
    /**
     * method that removes a transaction from the transaction list
     *
     * @param tr
     * @return
     */
    public boolean removeHistoricalTransaction(TransactionExecution tr) {
        return transactionList.remove(tr);
    }

   

 

    /**
     * method that verifies if they transaction list is empty
     *
     * @param lt
     * @return
     */
    public boolean validateHistoricalTransaction(List<TransactionExecution> lt) {
        return !lt.isEmpty();
    }

    /**
     * method that creates a new transaction
     *
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param qow
     * @return
     */
    public TransactionExecution createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {

        task.setIsFinished(true);
        double costEuros = task.getCostHour() * task.getTimeTask();
        double costCureency = cc.convert(costEuros, freel.getCountry());
        return new TransactionExecution(task, freel, endDate, delay, qow, new Payment(costEuros, costCureency));
    }

    /**
     * method that registers the transaction
     *
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
     * method that checks if the transaction can be added to the list (global
     * validation)
     *
     * @param trans
     * @return
     */
    public boolean validateTransaction(TransactionExecution trans) {
        for (TransactionExecution t : transactionList) {
            if (t.getTransID() == trans.getTransID()) {
                return false;
            }
        }
        return !transactionList.contains(trans);
    }

    /**
     * method that adds a transaction
     *
     * @param trans
     * @return
     */
    public boolean addTransaction(TransactionExecution trans) {
        return transactionList.add(trans);
    }

    /**
     * method that calculates the value of each transaction
     *
     * @param trans
     * @return
     */
    public double calculateTransactionValue(TransactionExecution trans) {
        for (TransactionExecution t : transactionList) {
            if (t.equals(trans)) {
                if (trans.getFreel().getLevelExp().equalsIgnoreCase("Senior")) {
                    double value = trans.getTask().getCostHour() * trans.getTask().getTimeTask() * 2;
                    return value;

                } else {
                    double value = trans.getTask().getCostHour() * trans.getTask().getTimeTask();
                    return value;
                }
            }

        }
        return -1;
    }

    //======================================================================================================================================================
    /**
     * returns the list of transactions
     *
     * @return the transactionList
     */
    public List<TransactionExecution> getTransactions() {
        return transactionList;
    }

}
