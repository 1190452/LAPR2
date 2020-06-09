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
    
    //======================================================================================================================================================

    /**
     * calls the RegisterOrganization method that creates a new organization and receives that organization
     * @param name
     * @param email
     * @param NIF
     * @param street
     * @param doorNumber
     * @param locality
     * @param nameC
     * @param emailC
     * @param nameM
     * @param emailM
     * @return 
     */
    public Organization newOrganization(String name, String email, String NIF, String street, String doorNumber, String locality, String nameC, String emailC, String nameM, String emailM) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        ro = ap.getPlatform().getrOrg();
        org = ro.newOrganization(name, email, NIF, street, doorNumber, locality, nameC, emailC, nameM, emailM);
        if (ro.validateOrganization(org)) {
            return org;
        }
        return null;
    }

    /**
     * calls the RegisterOrganization method that register the organization created
     * @return
     * @throws FileNotFoundException 
     */
    public boolean registerOrganization() throws FileNotFoundException {
        return ro.registerOrganization(org);
    }
}
