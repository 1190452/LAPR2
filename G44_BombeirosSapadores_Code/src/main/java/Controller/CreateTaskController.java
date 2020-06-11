/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Address;
import Model.ApplicationPOT;
import Model.Collaborator;
import Model.Constants;
import Model.Manager;
import Model.Organization;
import Model.RegisterOrganization;
import Model.Task;
import Model.TaskList;
import Authorization.model.UserSession;

/**
 *
 * @author Ricardo
 */
public class CreateTaskController {

    /**
     * task that will be created
     */
    private Task task;
    
    /**
     * task list
     */
    private TaskList tl;

    /**
     * empty constructor that creates an instance of CreateTaskController
     */
    public CreateTaskController() {
    }

    
    //======================================================================================================================================================
    
    /**
     * method that calls the class TaskList to create a new task
     * @param idTask
     * @param description
     * @param timeTask
     * @param costHour
     * @param taskCategory
     * @return 
     */
    public Task newTask(String idTask, String description, int timeTask, double costHour, String taskCategory) {
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        String email = log.getUserEmail();
        RegisterOrganization rorgs = app.getPlatform().getrOrg();
        Organization org2 = rorgs.getOrganizationByUserEmailColab(email);
        this.tl = org2.getTaskList();
        this.task = tl.newTask(idTask, description, timeTask, costHour, taskCategory);
        return task;

    }
    

    /**
     * method that calls the class TaskList to register the task
     * @return 
     */
    public boolean registersTask() {
        return tl.registersTask(this.task);
    }

}
