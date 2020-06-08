/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Freelancer;
import Model.RegisterTransaction;
import Model.RegisterFreelancer;
import Model.RegisterOrganization;
import Model.Task;
import Model.TaskList;
import Model.Transaction;
import Utils.Date;
import autorizacao.model.UserSession;
import java.util.List;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionController {

    private RegisterTransaction rt;
    private Transaction trans;
    private String email;
    public CreateTransactionController() {
        
    }

    public List<Task> getTaskList() {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        RegisterOrganization rorgs = ap.getPlatform().getrOrg();
        UserSession log = ap.getActualSession();
        email = log.getUserEmail();
        TaskList tl = rorgs.getOrganizationByUserEmailColab(email).getTaskList();
        List<Task> taskList = tl.getTaskList();
        return taskList;
    }

    public List<Freelancer> getFreelancerList() {
        ApplicationPOT app = ApplicationPOT.getInstance();
        RegisterFreelancer rl = app.getPlatform().getRfree();
        List<Freelancer> freelancerList = rl.getListFreelancers();
        return freelancerList;
    }

    public Transaction createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        ApplicationPOT app = ApplicationPOT.getInstance();
        rt = app.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getRt();
        trans = rt.createNewTransaction(task, freel, endDate, delay, qow);
        return trans;
    }

    public boolean registerTransaction() {
        return rt.registerTransaction(trans);
    }

    public double calculateTransactionValue(Transaction trans) {
        return rt.calculateTransactionValue(trans);
    }

}
