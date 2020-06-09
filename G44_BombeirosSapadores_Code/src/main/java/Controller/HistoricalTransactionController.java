/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authorization.model.UserSession;
import Model.ApplicationPOT;
import Model.TransactionExecution;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionController {

    /**
     * The list of transactions of HistoricalTransactionController
     */
    private List<TransactionExecution> lt;

    /**
     * Initializes the HistoricalTransactionController
     */
    public HistoricalTransactionController() {

    }
    
    //======================================================================================================================================================

    /**
     * Loads the file of historical transactions
     *
     * @param fileName the name of the file to load
     * @return true if the file was loaded, false if the file wasn't loaded
     */
    public boolean loadHistoricalTransaction(String fileName) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        UserSession log = ap.getActualSession();
        String email = log.getUserEmail();
        lt = ap.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).loadHistoricalTransaction(fileName);
        return lt != null;
    }

}
