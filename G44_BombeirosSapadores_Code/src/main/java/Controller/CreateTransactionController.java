/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Freelancer;
import Model.HistoricalTransaction;
import Model.Organization;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.Task;
import Model.TaskList;
import java.util.List;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionController {
    
    private Organization organization;
    private Platform platform;
    private HistoricalTransaction hTransaction;
    
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
}
