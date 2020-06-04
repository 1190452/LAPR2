/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Freelancer;
import Model.Organization;
import Model.Payment;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.RegisterOrganization;
import Model.Task;
import Model.Transaction;
import autorizacao.model.UserSession;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsController {

    private Platform pl;
    private String email;

    public void getOverallStatistics() {
        RegisterOrganization rorgs = pl.getrOrg();
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        email = log.getUserEmail();
        Organization org = rorgs.getOrganizationByUserEmail(email);
        List<Task> lt = org.getTaskList().getTaskList();
        List<Transaction> ltr = pl.getRTrans().getTransactions();
        RegisterFreelancer rf = pl.getRfree();
        List<Freelancer> newList = rf.getFreelancers(lt, ltr);
        for (int i = 0; i < newList.size(); i++) {
            Freelancer freel = newList.get(i);
            List <Payment> listPayments = freel.getPaymentList().;
        }
    }

}
