/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Organization;
import Model.RegisterOrganization;
import Model.TransactionExecution;
import Authorization.model.UserSession;
import Model.Constants;
import Model.RegisterTransaction;
import Utils.CustomValue;
import Utils.Statistic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsController {

    /**
     * email of the user
     */
    private String email;

    private Statistic st;

    private List<TransactionExecution> ltr;

    public List<TransactionExecution> getFreelancers() {
        ApplicationPOT app = ApplicationPOT.getInstance();
        st = app.getPlatform().getSt();
        if (app.getActualSession().getUserBySession().getRole().equalsIgnoreCase(Constants.ROLE_ADMINISTRATIVE)) {
            List<Organization> lorg = app.getPlatform().getrOrg().getlOrg();
            ltr = new ArrayList<>();
            for (int i = 0; i < lorg.size(); i++) {
                RegisterTransaction ra = lorg.get(i).getRTrans();
                for (int p = 0; p < ra.getTransactions().size(); p++) {
                    ltr.add(ra.getTransactions().get(p));
                }
            }
            return ltr;
        } else {
            RegisterOrganization rorgs = app.getPlatform().getrOrg();
            UserSession log = app.getActualSession();
            email = log.getUserEmail();
            Organization org = rorgs.getOrganizationByUserEmail(email);
            return org.getRTrans().getTransactions();
        }

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

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfAllFreelancers(List<TransactionExecution> ltr) {
        return st.getTaskExecutionDelayOfAllFreelancers(ltr);
    }

    public Map.Entry<String, CustomValue> getPaymentDeviationOfAllFreelancers(List<TransactionExecution> ltr) {
        return st.getPaymentDeviationOfAllFreelancers(ltr);
    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfEachFreelancer(String emailF, List<TransactionExecution> ltr) {
        return st.getTaskExecutionDelayOfEachFreelancer(ltr, emailF);
    }

}
