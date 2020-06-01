/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Controller;

import Model.Address;
import Model.Collaborator;
import Model.Manager;
import Model.Organization;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Platform;
import org.jcp.xml.dsig.internal.dom.Utils;

//import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class RegisterOrganization
{
    private ApplicationPOT m_oApp;
    private Platform m_oPlataforma;
    private Organization m_oOrganizacao;
    private String m_strPwd;
    public RegisterOrganization()
    {
        this.m_oApp = ApplicationPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlatform();
    }
    
    
    public boolean newOrganization(String name, String NIF, String email, String nameC, String funcaoC, String telefoneC, String emailC, String nameM, String funcaoM, String telefoneM, String emailM)
    {
        try
        {
            Collaborator Collab = Organization.newCollaborator(nameC, funcaoC, telefoneC, emailC);
            Manager manager = Organization.newManager(nameM, funcaoM, telefoneM, emailM);
            this.m_oOrganizacao = this.m_oPlataforma.newOrganization(name, NIF, email, Collab, manager);
            return this.m_oPlataforma.validateOrganization(this.m_oOrganizacao, this.m_strPwd);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return false;
        }
    }
    
    
    public boolean registerOrganization()
    {
        return this.m_oPlataforma.registerOrganization(this.m_oOrganizacao, this.m_strPwd);
    }

    public String getOrganizationString()
    {
        return this.m_oOrganizacao.toString();
    }
}
