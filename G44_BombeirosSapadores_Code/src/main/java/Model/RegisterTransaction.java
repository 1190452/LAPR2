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
    private List<Transaction> historicalTransaction;

    public RegisterTransaction() {
        historicalTransaction = new ArrayList<>();
    }

    public void addHistoricalTransaction(Transaction tr) {
        historicalTransaction.add(tr);
    }

    public void removeHistoricalTransaction(Transaction tr) {
        historicalTransaction.remove(tr);
    }

    public List<Transaction> getTransactions() {
        return historicalTransaction;
    }

    public boolean validateHistoricalTransaction(List<Transaction> lt) {
        return !lt.isEmpty();
    }

    public Transaction createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        TaskExecution tascExec = transaction.createTaskExecution(endDate, delay, qow);
        return new Transaction(task, freel, tascExec);
    }

    
    
    public boolean registerTransaction(Transaction trans) {
        if(validateTransaction(trans)==true){
            return addTransaction(trans);
        }
        return false;
    }
    
    public boolean validateTransaction(Transaction trans){
       if(historicalTransaction.contains(trans)){
            return false;
        }
       return true; 
    }
    
    public boolean addTransaction(Transaction trans){
        return historicalTransaction.add(trans);
    }
}
