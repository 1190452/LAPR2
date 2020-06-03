/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import java.util.List;

/**
 *
 * @author paulomaio
 */
public class AuthorizationController
{
    private ApplicationPOT m_oApp;
    
    public AuthorizationController()
    {
        this.m_oApp = ApplicationPOT.getInstance();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }

    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}
