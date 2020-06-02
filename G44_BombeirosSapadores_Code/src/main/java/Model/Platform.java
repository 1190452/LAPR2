/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashSet;
import java.util.Set;
import autorizacao.FacadeAuthorization;
import autorizacao.model.RegisterUser;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform {

    private final FacadeAuthorization m_oAutorizacao;

    private final Set<Organization> m_lstOrganizacoes;
    
    private RegisterFreelancer rFree;
    
    private RegisterUser rUser;

    public Platform() {

        this.m_oAutorizacao = new FacadeAuthorization();

        this.m_lstOrganizacoes = new HashSet<>();
    }

    public FacadeAuthorization getFacadeAuthorazation() {
        return this.m_oAutorizacao;
    }

    // Organizações
    // <editor-fold defaultstate="collapsed">
    public Organization newOrganization(String name, String NIF, String email, Collaborator colab, Manager manager) {
        return new Organization(name, NIF, email, colab, manager);
    }
    
    public RegisterFreelancer getRfree(){
        return rFree;
    }

    public boolean registerOrganization(Organization oOrganizacao, String strPwd) {
        if (this.validateOrganization(oOrganizacao, strPwd)) {
            Collaborator oGestor = oOrganizacao.getColab();
            String strNomeGestor = oGestor.getName();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registUserWithRole(strNomeGestor, strEmailGestor, strPwd,
                    new String[]{Constants.ROLE_MANAGER_ORGANIZATION, Constants.ROLE_COLLABORATOR_ORGANIZATION})) {
                return addOrganization(oOrganizacao);
            }
        }
        return false;
    }

    private boolean addOrganization(Organization oOrganizacao) {
        return m_lstOrganizacoes.add(oOrganizacao);
    }

    public boolean validateOrganization(Organization oOrganizacao, String strPwd) {
        boolean bRet = true;

        if (this.m_oAutorizacao.userExists(oOrganizacao.getColab().getEmail())) {
            bRet = false;
        }
        if (strPwd == null) {
            bRet = false;
        }
        if (strPwd.isEmpty()) {
            bRet = false;
        }
        //

        return bRet;
    }

    /**
     * @return the rUser
     */
    public RegisterUser getrUser() {
        return rUser;
    }

    /**
     * @param rUser the rUser to set
     */
    public void setrUser(RegisterUser rUser) {
        this.rUser = rUser;
    }

}
