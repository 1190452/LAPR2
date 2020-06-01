/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import pt.ipp.isep.dei.esoft.autorizacao.model.UserRole;

/**
 *
 * @author paulomaio
 */
public class AuthorazationController
{
    private ApplicationPOT m_oApp;
    
    public AuthorazationController()
    {
        this.m_oApp = ApplicationPOT.getInstance();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }
    
    public List<UserRole> getPapeisUtilizador()
    {
        if (this.m_oApp.getSessaoAtual().isLoggedIn())
        {
            return this.m_oApp.getSessaoAtual().getPapeisUtilizador();
        }
        return null;
    }

    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}
