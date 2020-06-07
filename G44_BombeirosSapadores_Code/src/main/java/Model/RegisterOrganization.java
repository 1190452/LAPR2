/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CreateTaskController;
import autorizacao.FacadeAuthorization;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.jcp.xml.dsig.internal.dom.Utils;
import Utils.PasswordGenerator;

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
//    private CreateTaskController ctask_controller;
    private List<Organization> lOrg;
    

    public RegisterOrganization() {
//        this.ctask_controller = new CreateTaskController();
    //    this.m_oApp = ApplicationPOT.getInstance();
      //  this.m_oPlataforma = m_oApp.getPlatform();
        
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

    public Organization getOrganizationByUserEmailColab(String email) {
        for (int i = 0; i < lOrg.size(); i++) {
            if (email.equalsIgnoreCase(lOrg.get(i).getColab().getEmailC())) {
                return lOrg.get(i);
            }

        }
        return null;
    }
    
    public Organization getOrganizationByUserEmailMan(String email) {
        for (int i = 0; i < lOrg.size(); i++) {
            if (email.equalsIgnoreCase(lOrg.get(i).getManager().getEmailM())) {
                return lOrg.get(i);
            }

        }
        return null;
    }

    public Organization newOrganization(String name, String email, String NIF, String street, String doorNumber, String locality, String nameC, String emailC, String nameM, String emailM) {
        try {
            this.m_oApp = ApplicationPOT.getInstance();
            this.m_oPlataforma = m_oApp.getPlatform();
            
            Address address = new Address(street, doorNumber, locality);
            String role = Constants.ROLE_MANAGER_ORGANIZATION;
            manager = Organization.newManager(nameM, emailM, role);
            role = Constants.ROLE_COLLABORATOR_ORGANIZATION;
            collab = Organization.newCollaborator(nameC, emailC, role);
            m_oOrganizacao = new Organization(name, email, NIF, address, collab, manager);
            return m_oOrganizacao;
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

    public boolean registerOrganization(Organization org) throws FileNotFoundException {
        if (validateOrganization(org)) {
            registUser(manager);
            registUser(collab);
            addOrganization(org);
            return true;
        }
        return false;
    }

    public void registUser(Manager manager) throws FileNotFoundException {
        String nameM = manager.getNameM();
        String emailM = manager.getEmailM();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdM = alg.generate(7);
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registUserWithRole(nameM, emailM, pwdM, Constants.ROLE_MANAGER_ORGANIZATION);
        Writer.sendsPassword(emailM, pwdM, Constants.ROLE_MANAGER_ORGANIZATION);
    }

    public void registUser(Collaborator collab) throws FileNotFoundException {
        String nameC = collab.getNameC();
        String emailC = collab.getEmailC();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdC = alg.generate(7);
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registUserWithRole(nameC, emailC, pwdC, Constants.ROLE_COLLABORATOR_ORGANIZATION);
        Writer.sendsPassword(emailC, pwdC,Constants.ROLE_COLLABORATOR_ORGANIZATION);
    }
    
    public List<Organization> get(){
        return lOrg;
    } 
}
