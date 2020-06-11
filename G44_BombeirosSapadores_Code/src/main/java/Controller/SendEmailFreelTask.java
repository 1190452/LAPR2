/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Platform;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SendEmailFreelTask extends TimerTask {

    /**
     * The platform that is going to be used
     */
    private Platform p1;

    private Timer t1;

    /**
     * constructor that gets platform of the current session
     */
    public SendEmailFreelTask() {
        ApplicationPOT pot = ApplicationPOT.getInstance();
        p1 = pot.getPlatform();
    }
    
    //======================================================================================================================================================

    /**
     * Runs the process of sending an email to the freelancers
     */
    @Override
    public void run() {
        try {
            int year = Year.now().getValue();
            boolean leapY = p1.leapYear(year);

            if (leapY) {
                long time = getOneDayTime();
                t1.wait(time);
                p1.sendEmail();
            } else {
                p1.sendEmail();
            }
        } catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(SendEmailFreelTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //======================================================================================================================================================

    private long getOneDayTime() {
        return 24 * 60 * 60 * 1000;
    }

    //======================================================================================================================================================

    public void setTimer(Timer t1) {
        this.t1 = t1;
    }

}
