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
import autorizacao.model.UserSession;

/**
 *
 * @author tiagopereira
 */
public class PaymentController {

    private Platform plat;
    private Organization org;
    private DefinePayment dpay;

    public Organization getOrg() {
        RegisterOrganization rorgs = plat.getrOrg();
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        String email = log.getUserEmail();
        org = rorgs.getOrganizationByUserEmail(email);
        return org;
    }

    public DefinePayment newDefinePayment(Time time, Date date, int rtp) {
        dpay = org.newDefinePayment(time,date,rtp);
        if(org.validatesDefinePayment(dpay)){
            return dpay;
        }
        return null;
    }

    public boolean registerDefinePayment() {
        if(dpay.registersDefinePayment(dpay)){
            org.setDefinePayment(dpay);
            return true;
        }
        return false;
    }

}
