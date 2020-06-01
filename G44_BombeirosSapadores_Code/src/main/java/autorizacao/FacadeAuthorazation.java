/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao;

import pt.ipp.isep.dei.esoft.autorizacao.model.UserRole;
import pt.ipp.isep.dei.esoft.autorizacao.model.RegisterUserRoles;
import pt.ipp.isep.dei.esoft.autorizacao.model.RegisterUser;
import pt.ipp.isep.dei.esoft.autorizacao.model.UserSession;
import pt.ipp.isep.dei.esoft.autorizacao.model.User;

/**
 *
 * @author paulomaio
 */
public class FacadeAuthorazation
{
    private UserSession m_oSessao = null;
    
    private final RegisterUserRoles m_oPapeis = new RegisterUserRoles();
    private final RegisterUser m_oUtilizadores = new RegisterUser();
    
    public boolean registaPapelUtilizador(String strPapel)
    {
        UserRole papel = this.m_oPapeis.novoPapelUtilizador(strPapel);
        return this.m_oPapeis.addPapel(papel);
    }
    
    public boolean registaPapelUtilizador(String strPapel, String strDescricao)
    {
        UserRole papel = this.m_oPapeis.novoPapelUtilizador(strPapel,strDescricao);
        return this.m_oPapeis.addPapel(papel);
    }
    
    public boolean registaUtilizador(String strNome, String strEmail, String strPassword)
    {
        User utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean registaUtilizadorComPapel(String strNome, String strEmail, String strPassword, String strPapel)
    {
        UserRole papel = this.m_oPapeis.procuraPapel(strPapel);
        User utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        utlz.addPapel(papel);
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean registaUtilizadorComPapeis(String strNome, String strEmail, String strPassword, String[] papeis)
    {
        User utlz = this.m_oUtilizadores.novoUtilizador(strNome,strEmail,strPassword);
        for (String strPapel: papeis)
        {
            UserRole papel = this.m_oPapeis.procuraPapel(strPapel);
            utlz.addPapel(papel);
        }
        
        return this.m_oUtilizadores.addUtilizador(utlz);
    }
    
    public boolean existeUtilizador(String strId)
    {
        return this.m_oUtilizadores.hasUtilizador(strId);
    }
    
    
    public UserSession doLogin(String strId, String strPwd)
    {
        User utlz = this.m_oUtilizadores.procuraUtilizador(strId);
        if (utlz != null)
        {
            if (utlz.hasPassword(strPwd)){
                this.m_oSessao = new UserSession(utlz);
            }
        }
        return getActualSession();
    }
    
    public UserSession getActualSession()
    {
        return this.m_oSessao;
    }
    
    public void doLogout()
    {
        if (this.m_oSessao != null)
            this.m_oSessao.doLogout();
        this.m_oSessao = null;
    }
}
