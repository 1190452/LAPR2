/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constants;
import Model.Platform;
import Model.RegisterOrganization;
import Model.Task;
import autorizacao.model.UserSession;

/**
 *
 * @author Ricardo
 */
public class CreateTaskController {
    private Platform m_plat;
    private Task ts;
    
    
    public CreateTaskController(){
    if(!ApplicationPOT.getInstance().getActualSession().isLoggedInWithPart(Constants.ROLE_COLLABORATOR_ORGANIZATION))
    throw new IllegalStateException("Non authorized user");
        this.m_plat = ApplicationPOT.getInstance().getPlatform();
    }
                
    public boolean newTask(String idTask, String description, int timeTask, double costHour, String taskCategory){
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        String email = log.getUserEmail();
        RegisterOrganization rorgs = m_plat.get esta linha...
        //Organization org = 
        
    }
    
}
