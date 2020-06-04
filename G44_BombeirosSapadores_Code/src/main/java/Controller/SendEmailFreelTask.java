/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Platform;
import java.io.FileNotFoundException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            p1.sendEmail();
            p1.scheduleProcess();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SendEmailFreelTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
        
    
    
}
