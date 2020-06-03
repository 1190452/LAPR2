/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Freelancer;
import Model.RegisterTransaction;
import Model.Organization;
import Model.Platform;
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
    private Platform platform;
    private RegisterTransaction hTransaction;
    private Transaction trans;
    
    public CreateTransactionController(){
        //instanciar
    }
    
    public List<Task> getTaskList(){
       TaskList tl =  organization.getTaskList();
       List<Task> taskList = tl.getTaskList();
       return taskList;
    }
    
    public List<Freelancer> getFreelancerList(){
        RegisterFreelancer rl = platform.getRfree();
        List<Freelancer> freelancerList = rl.getListFreelancer();
        return freelancerList;
    }
    
    public Transaction createNewTransaction(Task task, Freelancer freel, Date endDate, double delay, String qow){
          RegisterTransaction rt = platform.getRTrans();
          trans = rt.createNewTransaction(task, freel, endDate, delay, qow);
          return trans;
    }
    
    public void registerTrasnaction(){
        hTransaction.registerTransaction(trans);
    }
    
    
}
