/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Plataforma
{
    private String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<Organizacao> m_lstOrganizacoes;
    

    public Plataforma(String strDesignacao)
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

    public Organizacao novaOrganizacao(String strNome, String strNIF, String strWebsite,String strTelefone, String strEmail, EnderecoPostal oMorada, Colaborador oGestor)
    {
        return new Organizacao(strNome,strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
    }

    public boolean registaOrganizacao(Organizacao oOrganizacao, String strPwd)
    {
        if (this.validaOrganizacao(oOrganizacao,strPwd))
        {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor,strEmailGestor, strPwd, 
                    new String[] {Constantes.PAPEL_GESTOR_ORGANIZACAO,Constantes.PAPEL_COLABORADOR_ORGANIZACAO}))
                return addOrganizacao(oOrganizacao);
        }
        return false;
    }

    private boolean addOrganizacao(Organizacao oOrganizacao)
    {
        return m_lstOrganizacoes.add(oOrganizacao);
    }
    
    public boolean validaOrganizacao(Organizacao oOrganizacao,String strPwd)
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

    
    
