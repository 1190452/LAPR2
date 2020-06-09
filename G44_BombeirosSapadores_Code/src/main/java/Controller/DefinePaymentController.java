/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.DefinePayment;
import Model.Organization;
import Model.Platform;
import Model.RegisterOrganization;
import Utils.Date;
import Utils.Time;
import Authorization.model.UserSession;

/**
 *
 * @author tiagopereira
 */
public class DefinePaymentController {

    /**
     * The platform of the DefinePaymentController
     */
    private Platform plat;
    
    /**
     * The organization of the DefinePaymentController
     */
    private Organization org;
    
    /**
     * The definePayement of the DefinePaymentController
     */
    private DefinePayment dpay;
    
    /**
     * The email of the DefinePaymentController
     */
    private String email;

    /**
     * The organization that is going to be used to define the payment
     * @return organization
     */
    public Organization getOrg() {
        ApplicationPOT app = ApplicationPOT.getInstance();
        plat = app.getPlatform();
        RegisterOrganization rorgs = plat.getrOrg();
        UserSession log = app.getActualSession();
        email = log.getUserEmail();
        org = rorgs.getOrganizationByUserEmailMan(email);
        return org;
    }

    /**
     * calls the method that creates a new payment definition of the class Organization 
     * @param time the time of the payment
     * @param date the date of the payment
     * @param rtp
     * @return 
     */
    public DefinePayment newDefinePayment(Time time, Date date, int rtp) {
        dpay = org.newDefinePayment(time,date,rtp);
        
        if(org.validatesDefinePayment(dpay)){
            return dpay;
        }
        return null;
    }

    /**
     * calls the method that registers the payment 
     * @return 
     */
    public boolean registerDefinePayment() {
        if(dpay.registersDefinePayment(dpay)){
            org.setDefinePayment(dpay);
            plat.schedulesPayment(email);
            return true;
        }
        return false;
    }

}
