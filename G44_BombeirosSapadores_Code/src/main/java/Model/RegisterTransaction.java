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

    public boolean meanTaskDelayBetterThan3(Freelancer free) {
        int count = 0;
        double sum = 0;

        for (int i = 0; i < transactionList.size(); i++) {
            if ((transactionList.get(i).getFreel().equals(free)) && (transactionList.get(i).getEndDate().getYear() == Year.now().getValue())) {
                sum += transactionList.get(i).getTaskDelay();
                count++;
            }

        }
        if ((sum / count) > 3) {
            return true;
        } else {
            return false;
        }
    }


//    public double percentageOfDelays(Freelancer free) {
//        int numberOfTasks = free.getTaskList().getTaskList().size();
//        int count = 0;
//        int sum = 0;
//
//        for (int i = 0; i < transactionList.size(); i++) {
//            if (transactionList.get(i).getFreel().equals(free)) {
//                sum += transactionList.get(i).getTaskDelay();
//                count++;
//            }
//
//        }
//        return ((sum / count) * 100);
//    }



    public double overallPercentageDelays() {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < transactionList.size(); i++) {
            if ((transactionList.get(i).getEndDate().getYear() == Year.now().getValue())) {
                sum += transactionList.get(i).getTaskDelay();
                count++;
            }
        }
        return ((sum / count) * 100);

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
        return new TransactionExecution(task, freel, endDate, delay, qow, new Payment(costEuros,costCureency));
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
        if (transactionList.contains(trans)) {
            return false;
        }
        return true;
    }

    /**
     * method that adds a transaction
     *
     * @param trans
     * @return
     */
    public boolean addTransaction(TransactionExecution trans) {
        transactionList.add(trans);
        if (transactionList != null) {
            return true;
        }
        return false;
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

                }
                double value = trans.getTask().getCostHour() * trans.getTask().getTimeTask();
                return value;
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
