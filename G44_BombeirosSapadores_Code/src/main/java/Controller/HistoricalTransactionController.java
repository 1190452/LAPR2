/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Transaction;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionController {
    private List<Transaction> lt;
    public HistoricalTransactionController(){
        
    }
    
    public boolean loadHistoricalTransaction(String fileName) {
       ApplicationPOT ap = ApplicationPOT.getInstance();
       lt = ap.getPlatform().loadHistoricalTransaction(fileName);
       return lt!=null;
    }


    
}
