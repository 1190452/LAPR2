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
import java.io.Serializable;

//import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
/**
 *
 * @author paulomaio
 */
public class RegisterOrganization implements Serializable {

    /**
     * variable used to call the methods of the class ApplicationPOT
     */
    private ApplicationPOT m_oApp;

    /**
     * platform
     */
    private Platform m_oPlataforma;

    /**
     * organization
     */
    private Organization m_oOrganizacao;

    /**
     * manager of the organization
     */
    private Manager manager;

    /**
     * collaborator of the organization
     */
    private Collaborator collab;

    /**
     * list of organizations
     */
    private List<Organization> lOrg;

    /**
     *
     */
    public RegisterOrganization() {
        // this.ctask_controller = new CreateTaskController();
        //    this.m_oApp = ApplicationPOT.getInstance();
        //  this.m_oPlataforma = m_oApp.getPlatform();

        lOrg = new ArrayList<>();
    }

    /**
     * returns the writing method of the organization
     *
     * @return
     */
    public String getOrganizationString() {
        return this.m_oOrganizacao.toString();
    }

    /**
     * adds an organization to the list of organizations
     *
     * @param oOrganizacao
     * @return
     */
    public boolean addOrganization(Organization oOrganizacao) {
        if (lOrg.add(oOrganizacao)) {
            return true;
        }
        return false;
    }

    /**
     * returns the organization of the collaborator, which email was received by
     * parameter
     *
     * @param email
     * @return
     */
    public Organization getOrganizationByUserEmailColab(String email) {
        for (int i = 0; i < lOrg.size(); i++) {
            if (email.equalsIgnoreCase(lOrg.get(i).getColab().getEmailC())) {
                return lOrg.get(i);
            }

        }
        return null;
    }

    /**
     * returns the organization of the manager, which email was received by
     * parameter
     *
     * @param email
     * @return
     */
    public Organization getOrganizationByUserEmailMan(String email) {
        for (int i = 0; i < lOrg.size(); i++) {
            if (email.equalsIgnoreCase(lOrg.get(i).getManager().getEmailM())) {
                return lOrg.get(i);
            }

        }
        return null;
    }

    /**
     * method that creates a new organization and receives the following
     * parameters:
     *
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
        try {
            this.m_oApp = ApplicationPOT.getInstance();
            this.m_oPlataforma = m_oApp.getPlatform();

            Address address = new Address(street, doorNumber, locality);
            String role = Constants.ROLE_MANAGER_ORGANIZATION;
            this.manager = Organization.newManager(nameM, emailM, role);
            role = Constants.ROLE_COLLABORATOR_ORGANIZATION;
            this.collab = Organization.newCollaborator(nameC, emailC, role);
            m_oOrganizacao = new Organization(name, email, NIF, address, collab, manager);
            return m_oOrganizacao;
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return null;
        }
    }

    /**
     * method that validates if an organization is or isn't null
     *
     * @param org
     * @return
     */
    public boolean validateOrganization(Organization org) {
        boolean bRet = true;

        if (org == null) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * method that regists in the system an organization received by parameter
     *
     * @param org
     * @return
     * @throws FileNotFoundException
     */
    public boolean registerOrganization(Organization org) throws FileNotFoundException {
        if (validateOrganization(org)) {
            registUser(this.manager);
            registUser(this.collab);
            addOrganization(org);
            return true;
        }
        return false;
    }

    /**
     * method that regists a manager as a user in the system and sends him an
     * email with his password so he can login
     *
     * @param manager
     * @throws FileNotFoundException
     */
    public void registUser(Manager manager) throws FileNotFoundException {
        String nameM = manager.getNameM();
        String emailM = manager.getEmailM();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdM = alg.generate(7);
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registerUser(nameM, emailM, pwdM, Constants.ROLE_MANAGER_ORGANIZATION);
        Writer.sendsPassword(emailM, pwdM, Constants.ROLE_MANAGER_ORGANIZATION);
    }

    /**
     * method that regists a collaborator as a user in the system and sends him
     * an email with his password so he can login
     *
     * @param collab
     * @throws FileNotFoundException
     */
    public void registUser(Collaborator collab) throws FileNotFoundException {
        String nameC = collab.getNameC();
        String emailC = collab.getEmailC();
        PasswordGenerator alg = m_oPlataforma.getAlg();
        String pwdC = alg.generate(7);
        FacadeAuthorization aut = m_oPlataforma.getFacadeAuthorazation();
        aut.registerUser(nameC, emailC, pwdC, Constants.ROLE_COLLABORATOR_ORGANIZATION);
        Writer.sendsPassword(emailC, pwdC, Constants.ROLE_COLLABORATOR_ORGANIZATION);
    }

}
