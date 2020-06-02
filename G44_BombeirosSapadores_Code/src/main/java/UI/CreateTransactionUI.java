/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import java.util.List;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionUI {
    private CreateTransactionController ct_controller;
    
    public CreateTransactionUI (){
        ct_controller = new CreateTransactionController();
        List<Task> taskList = ct_controller.getTaskList();
        List<Freelancer> freelancerList = ct_controller.getFreelancerList();
    }
  
}
