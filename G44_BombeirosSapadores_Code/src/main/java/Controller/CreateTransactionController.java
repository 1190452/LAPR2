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
import Model.TransactionExecution;
import Utils.Date;
import Authorization.model.UserSession;
import java.util.List;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionController {

    /**
     * atribute to call the methods of RegisterTransaction class
     */
    private RegisterTransaction rt;
    
    /**
     * transaction that will be created 
     */
    private TransactionExecution trans;
    
    /**
     * email of the user
     */
    private String email;
    
    /**
     * constructor that creates an instance of CreateTransactionController
     */
    public CreateTransactionController() {
        
    }

    /**
     * method that calls the TaskList class to get the list of tasks
     * @return taskList
     */
    public List<Task> getTaskList() {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        RegisterOrganization rorgs = ap.getPlatform().getrOrg();
        UserSession log = ap.getActualSession();
        email = log.getUserEmail();
        TaskList tl = rorgs.getOrganizationByUserEmailColab(email).getTaskList();
        List<Task> taskList = tl.getTaskList();
        return taskList;
    }

    /**
     * method that calls the RegisterFreelancer class to get the list of freelancers
     * @return freelancerList
     */
    public List<Freelancer> getFreelancerList() {
        ApplicationPOT app = ApplicationPOT.getInstance();
        RegisterFreelancer rl = app.getPlatform().getRfree();
        List<Freelancer> freelancerList = rl.getListFreelancers();
        return freelancerList;
    }

    /**
     * calls the method of the class RegisterTransaction to create a new transaction
     * @param task
     * @param freel
     * @param endDate
     * @param delay
     * @param qow
     * @return 
     */
    public TransactionExecution createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow) {
        ApplicationPOT app = ApplicationPOT.getInstance();
        rt = app.getPlatform().getRTrans();
        trans = rt.createNewTransaction(task, freel, endDate, delay, qow);
        return trans;
    }

    /**
     * calls the method of the class RegisterTransaction to register the created transaction
     * @return 
     */
    public boolean registerTransaction() {
        return rt.registerTransaction(trans);
    }
}
