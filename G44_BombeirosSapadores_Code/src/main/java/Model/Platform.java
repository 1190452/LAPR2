/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.HashSet;
import java.util.Set;
import autorizacao.AutorizacaoFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform
{
    private String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;

    private final Set<Organization> m_lstOrganizacoes;

    

    public Platform(String strDesignacao)
    {
        if ( (strDesignacao == null) ||
                (strDesignacao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strDesignacao = strDesignacao;
      
        
        this.m_oAutorizacao = new AutorizacaoFacade();
        
        this.m_lstOrganizacoes = new HashSet<>();
    }   
    
    public AutorizacaoFacade getAutorizacaoFacade()
    {
        return this.m_oAutorizacao;
    }
    
    // Organizações
    
    // <editor-fold defaultstate="collapsed">

    public Organization novaOrganizacao(String strNome, String strNIF, String strWebsite,String strTelefone, String strEmail, EnderecoPostal oMorada, Collaborator oGestor)
    {
        return new Organization(strNome,strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
    }

    public boolean registaOrganizacao(Organization oOrganizacao, String strPwd)
    {
        if (this.validaOrganizacao(oOrganizacao,strPwd))
        {
            Collaborator oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor,strEmailGestor, strPwd, 
                    new String[] {Constantes.PAPEL_GESTOR_ORGANIZACAO,Constantes.PAPEL_COLABORADOR_ORGANIZACAO}))
                return addOrganizacao(oOrganizacao);
        }
        return false;
    }

    private boolean addOrganizacao(Organization oOrganizacao)
    {
        return m_lstOrganizacoes.add(oOrganizacao);
    }
    
    public boolean validaOrganizacao(Organization oOrganizacao,String strPwd)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail()))
            bRet = false;
        if (strPwd == null)
            bRet = false;
        if (strPwd.isEmpty())
            bRet = false;
        //
      
        return bRet;
    }

    // </editor-fold>
    
    
    // Competências Tecnicas
    
    // <editor-fold defaultstate="collapsed">
    
   
}

    
    
