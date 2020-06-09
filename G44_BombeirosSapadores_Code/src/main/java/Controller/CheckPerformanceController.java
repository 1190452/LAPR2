/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authorization.model.UserSession;
import Model.ApplicationPOT;
import Model.Freelancer;
import Model.Organization;
import Model.Payment;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.RegisterOrganization;
import Model.Task;
import Model.TransactionExecution;
import Utils.CustomValue;
import Utils.Statistic;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.distribution.NormalDistribution;

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

    public Map.Entry<String, CustomValue> OverallStatistics() {
        String decisao = null;
        String emailF = "gg@gmail.com";
        st = new Statistic();
        ApplicationPOT app = ApplicationPOT.getInstance();
        RegisterOrganization rorgs = app.getPlatform().getrOrg();
        UserSession log = app.getActualSession();
        email = log.getUserEmail();
        Organization org = rorgs.getOrganizationByUserEmailColab(email);
        List<TransactionExecution> ltr = org.getRTrans().getTransactions();
        if (decisao.equals("Payment Deviation of each Freelancer")) {
            return getPaymentDeviationOfEachFreelancer(emailF, ltr);

        } else if (decisao.equals("Task Execution Delay of each Freelancer")) {
            return getTaskExecutionDelayOfEachFreelancer(emailF, ltr);

        } else if (decisao.equals("Task Execution Delay of All Freelancers")) {
            return getTaskExecutionDelayOfAllFreelancers(ltr);
       
        }else if (decisao.equals("Payment Deviation of All Freelancers")) {
            return getPaymentDeviationOfAllFreelancers(ltr);
        }

        return null;
    }

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
}
