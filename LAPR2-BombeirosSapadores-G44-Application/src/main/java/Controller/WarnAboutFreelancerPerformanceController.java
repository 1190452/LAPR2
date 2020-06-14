package Controller;

import Model.ApplicationPOT;
import java.io.FileNotFoundException;

/**
 *
 * @author
 */
public class WarnAboutFreelancerPerformanceController {

    //======================================================================================================================================================
    /**
     * calls the method of the class Platform that sends the emails
     *
     * @return 
     * @throws FileNotFoundException
     */
    public boolean sendEmail() throws FileNotFoundException {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        return ap.getPlatform().sendEmail();
    }
}
