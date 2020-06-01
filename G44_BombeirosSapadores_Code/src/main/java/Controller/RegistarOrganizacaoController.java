/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Controller;

import Model.Collaborator;
import Model.Organization;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Platform;

//import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class RegistarOrganizacaoController
{
    private ApplicationPOT m_oApp;
    private Platform m_oPlataforma;
    private Organization m_oOrganizacao;
    private String m_strPwd;
    public RegistarOrganizacaoController()
    {
        this.m_oApp = ApplicationPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
    }
    
    
    public boolean novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, 
            String strEmail, String strLocal, String strCodPostal, String strLocalidade,
            String strNomeGestor, String strFuncaoGestor, String strEmailGestor,  String strTelefoneGestor,String strPwd)
    {
        try
        {
            this.m_strPwd = strPwd;
            EnderecoPostal oMorada = Organization.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
            Collaborator oColab = Organization.novoColaborador(strNomeGestor, strFuncaoGestor, strTelefoneGestor, strEmailGestor);      
            this.m_oOrganizacao = this.m_oPlataforma.novaOrganizacao(strNome, strNIF, strWebsite,strTelefone, strEmail, oMorada, oColab);
            return this.m_oPlataforma.validaOrganizacao(this.m_oOrganizacao, this.m_strPwd);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return false;
        }
    }
    
    
    public boolean registaOrganizacao()
    {
        return this.m_oPlataforma.registaOrganizacao(this.m_oOrganizacao, this.m_strPwd);
    }

    public String getOrganizacaoString()
    {
        return this.m_oOrganizacao.toString();
    }
}
