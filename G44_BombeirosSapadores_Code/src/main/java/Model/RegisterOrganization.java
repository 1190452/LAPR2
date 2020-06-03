/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import autorizacao.FacadeAuthorization;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jcp.xml.dsig.internal.dom.Utils;

//import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
/**
 *
 * @author paulomaio
 */
public class RegisterOrganization {

    private ApplicationPOT m_oApp;
    private Platform m_oPlataforma;
    private Organization m_oOrganizacao;
    private Manager manager;
    private Collaborator collab;

    private List<Organization> lOrg;

    private List<Organization> lorgs;

    public RegisterOrganization() {
        lorgs = new ArrayList<>();
        this.m_oApp = ApplicationPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlatform();
        lOrg = new ArrayList<>();
    }

    public String getOrganizationString() {
        return this.m_oOrganizacao.toString();
    }

    public boolean addOrganization(Organization oOrganizacao) {
        if (lOrg.add(oOrganizacao)) {
            return true;
        }
        return false;
    }

    public Organization getOrganizationByUserEmail(String email) {
        for (int i = 0; i < lorgs.size(); i++) {
            if (email.equalsIgnoreCase(lorgs.get(i).getColab().getEmailC())) {
                return lorgs.get(i);
            }

        }
        return null;
    }

    public Organization newOrganization(String name, String email, String NIF, String street, String doorNumber, String locality, String nameC, String emailC, String phoneNumberC, String nameM, String emailM, String phoneNumberM) {
        try {
            Address address = m_oOrganizacao.newAddress(street, doorNumber, locality);
            String role = Constants.ROLE_MANAGER_ORGANIZATION;
            manager = Organization.newManager(nameM, emailM, role, phoneNumberM);
            role = Constants.ROLE_COLLABORATOR_ORGANIZATION;
            collab = Organization.newCollaborator(nameC, emailC, role, phoneNumberC);
            Organization org = new Organization(name, email, NIF, address, collab, manager);
            return org;
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return null;
        }
    }

    public boolean validateOrganization(Organization org) {
        boolean bRet = true;

        if (org == null) {
            bRet = false;
        }

        return bRet;
    }

    public void registerOrganization(Organization org) {
        if (validateOrganization(org)) {
            registUser(manager);
            registUser(collab);
        }
    }

    public void registUser(Manager manager) {
        String nameM = manager.getNameM();
        String emailM = manager.getEmailM();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdM = alg.generate(7);
        String role = manager.getEmailM();
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registUserWithRole(nameM, emailM, pwdM, role);
    }

    public void registUser(Collaborator collab) {
        String nameC = collab.getNameC();
        String emailC = collab.getEmailC();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdC = alg.generate(7);
        String role = manager.getEmailM();
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registUserWithRole(nameC, emailC, pwdC, role);
    }
    
    public List<Organization> get(){
        return lorgs;
    } 
}
