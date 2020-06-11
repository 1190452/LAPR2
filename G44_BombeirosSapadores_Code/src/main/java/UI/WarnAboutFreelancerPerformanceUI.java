/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WarnAboutFreelancerPerformanceController;
import java.io.FileNotFoundException;

/**
 *
 * @author OMEN X
 */
public class WarnAboutFreelancerPerformanceUI {

    private WarnAboutFreelancerPerformanceController controller;

    //======================================================================================================================================================
    public boolean sendEmail() throws FileNotFoundException {
        controller = new WarnAboutFreelancerPerformanceController();
        return controller.sendEmail();
    }
}
