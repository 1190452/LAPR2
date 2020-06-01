/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashSet;
import java.util.Set;
import autorizacao.FacadeAuthorazation;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform {

    private String m_strDesignacao;
    private final FacadeAuthorazation m_oAutorizacao;

    private final Set<Organization> m_lstOrganizacoes;

    public Platform() {

        this.m_oAutorizacao = new FacadeAuthorazation();

        this.m_lstOrganizacoes = new HashSet<>();
    }

    public FacadeAuthorazation getFacadeAuthorazation() {
        return this.m_oAutorizacao;
    }

    // Organizações
    // <editor-fold defaultstate="collapsed">
    public Organization novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, String strEmail, Address oMorada, Collaborator oGestor) {
        return new Organization(strNome, strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
    }

    public boolean registerOrganization(Organization oOrganizacao, String strPwd) {
        if (this.validateOrganization(oOrganizacao, strPwd)) {
            Collaborator oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor, strEmailGestor, strPwd,
                    new String[]{Constants.PAPEL_GESTOR_ORGANIZACAO, Constants.PAPEL_COLABORADOR_ORGANIZACAO})) {
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

        // Escrever aqui o código de validação
        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail())) {
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

}
