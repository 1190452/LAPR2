/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Platform;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class SendEmailFreelTask extends TimerTask{
    private Platform p1;
    
    public SendEmailFreelTask(){
        p1=new Platform();
        
    }

    @Override
    public void run() {
        p1.sendEmail();
        p1.scheduleProcess();
        
        
    }
    
    
        
    
    
}
