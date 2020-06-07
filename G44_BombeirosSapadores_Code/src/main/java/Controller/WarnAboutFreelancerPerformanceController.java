/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Platform;
import java.io.FileNotFoundException;

/**
 *
 * @author OMEN X
 */
public class WarnAboutFreelancerPerformanceController {
    private Platform platform;

    public void sendEmail() throws FileNotFoundException {
        platform.sendEmail();
    }
}
