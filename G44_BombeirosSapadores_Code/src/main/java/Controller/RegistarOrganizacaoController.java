/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Controller;

import Model.Organizacao;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
import pt.ipp.isep.dei.esoft.pot.model.Colaborator;
import pt.ipp.isep.dei.esoft.pot.model.Organization;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
=======
import Model.Plataforma;

//import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
>>>>>>> 739b64fd5f4e76325b34c2c21c0ab6a5c52d9fbd

/**
 *
 * @author paulomaio
 */
public class RegistarOrganizacaoController
{
    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private Organization m_oOrganizacao;
    private String m_strPwd;
    public RegistarOrganizacaoController()
    {
        this.m_oApp = AplicacaoPOT.getInstance();
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
            Colaborator oColab = Organization.novoColaborador(strNomeGestor, strFuncaoGestor, strTelefoneGestor, strEmailGestor);      
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