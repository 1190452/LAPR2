/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Organization;
import Model.Platform;
import Model.RegisterOrganization;
import java.io.FileNotFoundException;

/**
 *
 * @author jorge
 */
public class RegistOrganizationController {

    private Platform plat;
    RegisterOrganization ro;
    Organization org;

    public Organization newOrganization(String name, String email, String NIF, String street, String doorNumber, String locality, String nameC, String emailC, String nameM, String emailM) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        ro = ap.getPlatform().getrOrg();
        org = ro.newOrganization(name, email, NIF, street, doorNumber, locality, nameC, emailC, nameM, emailM);
        if (ro.validateOrganization(org)) {
            return org;
        }
        return null;
    }

    public boolean registaOrganization() throws FileNotFoundException {
        return ro.registerOrganization(org);
    }

    Organization organization;

    public void CreateOrganization() {

    }

}
