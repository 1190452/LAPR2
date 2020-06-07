/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Freelancer;
import Model.RegisterTransaction;
import Model.Organization;
import Model.RegisterFreelancer;
import Model.Task;
import Model.TaskList;
import Model.Transaction;
import Utils.Date;
import java.util.List;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionController {

    private Organization organization;
    private RegisterTransaction hTransaction;
    private Transaction trans;

    public CreateTransactionController() {
    }

    public List<Task> getTaskList() {
        TaskList tl = organization.getTaskList();
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
        RegisterTransaction rt = app.getPlatform().getRTrans();
        trans = rt.createNewTransaction(task, freel, endDate, delay, qow);
        return trans;
    }

    public void registerTransaction() {
        hTransaction.registerTransaction(trans);
    }

    public double calculateTransactionValue(Transaction trans) {
        return hTransaction.calculateTransactionValue(trans);
    }

}
