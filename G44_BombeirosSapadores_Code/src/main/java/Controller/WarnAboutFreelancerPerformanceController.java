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
