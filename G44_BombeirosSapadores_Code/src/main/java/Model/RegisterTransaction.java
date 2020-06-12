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
     * checks if a task delay of a certain freelancer (received by parameter) is
     * higher than 3 hours
     *
     * @param free
     * @param ltr
     * @return
     */
    public boolean meanTaskDelayBetterThan3(Freelancer free, List<TransactionExecution> ltr) {
        int count = 0;
        double sum = 0;

        for (int i = 0; i < ltr.size(); i++) {
            if ((ltr.get(i).getFreel().equals(free)) && (ltr.get(i).getEndDate().getYear() == Year.now().getValue())) {
                sum += ltr.get(i).getTaskDelay();
                count++;
            }

        }
        return (sum / count) > 3;
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
        double costEuros;
        task.setIsFinished(true);
        if (freel.getLevelExp().equals("Senior")) {
            costEuros = task.getCostHour() * task.getTimeTask() * 2;
        } else {
            costEuros = task.getCostHour() * task.getTimeTask();
        }
        double costCurrency = cc.convert(costEuros, freel.getCountry());
        return new TransactionExecution(task, freel, endDate, delay, qow, new Payment(costEuros, costCurrency));
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
