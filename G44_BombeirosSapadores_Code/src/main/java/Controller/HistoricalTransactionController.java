/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Platform;
import Model.Transaction;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionController {
    private Platform ht_plat;
    private List<Transaction> lt;
    public HistoricalTransactionController(){
        
    }
    
    public boolean loadHistoricalTransaction(String fileName) {
       lt = ht_plat.loadHistoricalTransaction(fileName);
       return lt!=null;
    }


    
}
