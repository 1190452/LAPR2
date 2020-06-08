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

    private Task task;
    private TaskList tl;

    public CreateTaskController() {
    }

    public Task newTask(String idTask, String description, int timeTask, double costHour, String taskCategory) {
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        String email = log.getUserEmail();
        //NAO ESQUECER DE APAGAR
        Organization org = new Organization("org", "123456789", "o@gmail.com", new Address("rua12", "23", "Espinho"), new Collaborator("Bruno", "b@gmail.com", Constants.ROLE_COLLABORATOR_ORGANIZATION), new Manager("Bruno", "c@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION));
        RegisterOrganization rorgs = app.getPlatform().getrOrg();
        //NAO ESQUECER DE APAGAR
        rorgs.addOrganization(org);
        Organization org2 = rorgs.getOrganizationByUserEmailColab(email);
        this.tl = org2.getTaskList();
        this.task = tl.newTask(idTask, description, timeTask, costHour, taskCategory);
        return task;

    }

    public boolean registersTask() {
        return tl.registersTask(this.task);
    }

}
