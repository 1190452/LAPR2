package Controller;

import Model.Platform;
import java.io.FileNotFoundException;

/**
 *
 * @author OMEN X
 */
public class WarnAboutFreelancerPerformanceController {
    /**
     * platform that will send the email
     */
    private Platform platform;

    /**
     * calls the method of the class Platform that sends the emails
     * @throws FileNotFoundException 
     */
    public void sendEmail() throws FileNotFoundException {
        platform.sendEmail();
    }
}
