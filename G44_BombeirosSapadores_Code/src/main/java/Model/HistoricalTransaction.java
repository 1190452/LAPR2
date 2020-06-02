/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransaction {
   private List<Transaction> historicalTransaction; 
   
   public HistoricalTransaction(){
       historicalTransaction = new ArrayList<>();
   }
   
   public void addHistoricalTransaction(Transaction tr){
       historicalTransaction.add(tr);
   }
   
   public void removeHistoricalTransaction(Transaction tr){
       historicalTransaction.remove(tr);
   }
   
   public List<Transaction> getTransactions(){
       return historicalTransaction;
   }
}