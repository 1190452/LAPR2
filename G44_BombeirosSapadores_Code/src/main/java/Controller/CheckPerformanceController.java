/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Organization;
import Model.RegisterTransaction;
import Model.TransactionExecution;
import Utils.CustomValue;
import Utils.Statistic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author OMEN X
 */
public class CheckPerformanceController {

    /**
     * email of the user
     */
    private String email;

    private Statistic st;
    
    //======================================================================================================================================================

    public Map.Entry<String, CustomValue> OverallStatistics() {
        String decisao = null;
        st = new Statistic();
        ApplicationPOT app = ApplicationPOT.getInstance();
        String emailF = "gg@gmail.com";
        List<Organization> lorg = app.getPlatform().getrOrg().getlOrg();
        List<TransactionExecution> ltr = getAllTransactionExecution(lorg);

        if (decisao.equals("Payment Deviation of each Freelancer")) {
            return getPaymentDeviationOfEachFreelancer(emailF, ltr);

        } else if (decisao.equals("Task Execution Delay of each Freelancer")) {
            return getTaskExecutionDelayOfEachFreelancer(emailF, ltr);

        } else if (decisao.equals("Task Execution Delay of All Freelancers")) {
            return getTaskExecutionDelayOfAllFreelancers(ltr);

        } else if (decisao.equals("Payment Deviation of All Freelancers")) {
            return getPaymentDeviationOfAllFreelancers(ltr);
        }
        return null;
    }
    
    //======================================================================================================================================================
    
    /**
     * method that gets the performances of freelancers in 4 ways: - payment
     * mean and deviation of one freelancer - delay mean and deviation of one
     * freelancer - delay mean and deviation of all freelancers
     *
     * @param emailF
     * @param ltr
     * @return
     */
    public Map.Entry<String, CustomValue> getPaymentDeviationOfEachFreelancer(String emailF, List<TransactionExecution> ltr) {
        return st.getPaymentDeviationOfEachFreelancer(ltr, emailF);

    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfEachFreelancer(String emailF, List<TransactionExecution> ltr) {
        return st.getTaskExecutionDelayOfEachFreelancer(ltr, emailF);
    }

    private Map.Entry<String, CustomValue> getTaskExecutionDelayOfAllFreelancers(List<TransactionExecution> ltr) {
        return st.getTaskExecutionDelayOfAllFreelancers(ltr);
    }

    private Map.Entry<String, CustomValue> getPaymentDeviationOfAllFreelancers(List<TransactionExecution> ltr) {
        return st.getPaymentDeviationOfAllFreelancers(ltr);
    }

    private List<TransactionExecution> getAllTransactionExecution(List<Organization> lorg) {
        List<TransactionExecution> ltr = new ArrayList<>();
        for (int i = 0; i < lorg.size(); i++) {
            RegisterTransaction ra = lorg.get(i).getrTrans();
            for (int p = 0; p < ra.getTransactions().size(); p++) {
                ltr.add(ra.getTransactions().get(i));
            }
        }
        return ltr;
    }

}
