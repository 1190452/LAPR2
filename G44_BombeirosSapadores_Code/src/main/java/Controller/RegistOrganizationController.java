/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Organization;
import Model.Platform;
import Model.RegisterOrganization;

/**
 *
 * @author jorge
 */
public class RegistOrganizationController {

    private Platform plat;
    RegisterOrganization ro;
    Organization org;

    public Organization newOrganization(String name, String email, String NIF, String street, String doorNumber, String locality, String nameC, String emailC, String phoneNumberC, String nameM, String emailM, String phoneNumberM) {
        ro = plat.getrOrg();
        org = ro.newOrganization(name, email, NIF, street, doorNumber, locality, nameC, emailC, phoneNumberC, nameM, emailM, phoneNumberM);
        if (ro.validateOrganization(org)) {
            return org;
        }
        return null;
    }

    public void registaOrganization() {
        ro.registerOrganization(org);
    }

}
