/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import autorizacao.FacadeAuthorization;
import autorizacao.model.RegisterUser;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform {

    private final FacadeAuthorization m_oAutorizacao;

    private RegisterOrganization rOrg;

    private RegisterFreelancer rFree;

    private RegisterUser rUser;

    private RegisterTransaction ht;

    private ImportTxtFile itxt;

    private ImportCsvFile icsv;

    public Platform() {

        this.m_oAutorizacao = new FacadeAuthorization();
        this.rOrg = new RegisterOrganization();
        this.rFree = new RegisterFreelancer();
    }

    public FacadeAuthorization getFacadeAuthorazation() {
        return this.m_oAutorizacao;
    }

    public RegisterFreelancer getRfree() {
        return rFree;
    }

    public Organization newOrganization(String name, String NIF, String email, Collaborator colab, Manager manager, TaskList tl) {
        return new Organization(name, NIF, email, colab, manager, tl);

    }

    public boolean registerOrganization(Organization oOrganizacao, String strPwd) {
        if (this.validateOrganization(oOrganizacao, strPwd)) {
            Collaborator oGestor = oOrganizacao.getColab();
            String strNomeGestor = oGestor.getName();
            String strEmailGestor = oGestor.getEmail();
            String role = oGestor.getRole();
            if (this.m_oAutorizacao.registUserWithRole(strNomeGestor, strEmailGestor, strPwd, role)) {
                return rOrg.addOrganization(oOrganizacao);

            }
        }
        return false;
    }


    /*private boolean addOrganization(Organization oOrganizacao) {
    return m_lstOrganizacoes.add(oOrganizacao);
    }*/
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

    /**
     * @return the rOrg
     */
    public RegisterOrganization getrOrg() {
        return rOrg;
    }

    /**
     * @param rOrg the rOrg to set
     */
    public void setrOrg(RegisterOrganization rOrg) {
        this.rOrg = rOrg;
    }

    public List<Transaction> loadHistoricalTransaction(String fileName) {
        if (fileName.endsWith(".txt")) {
            ht = itxt.importFile(fileName);
            List<Transaction> lt = ht.getTransactions();
            return lt;
        } else if (fileName.endsWith(".csv")) {
            ht = icsv.importFile(fileName);
            List<Transaction> lt = ht.getTransactions();
            if (ht.validateHistoricalTransaction(lt)) {
                return lt;
            }

        }
        return null;
    }

}
