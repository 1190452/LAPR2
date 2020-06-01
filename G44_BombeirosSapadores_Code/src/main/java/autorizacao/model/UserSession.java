/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao.model;

import java.util.List;

/**
 *
 * @author paulomaio
 */
public class UserSession
{
    private User m_oUtilizador = null;
    
    private UserSession()
    {
    }
    
    public UserSession(User oUtilizador)
    {
        if (oUtilizador == null)
            throw new IllegalArgumentException("Argumento não pode ser nulo.");
        this.m_oUtilizador = oUtilizador;
    }
    
    public void doLogout()
    {
        this.m_oUtilizador = null;
    }
    
    public boolean isLoggedIn()
    {
        return this.m_oUtilizador != null;
    }
    
    public boolean isLoggedInComPapel(String strPapel)
    {
        if (isLoggedIn())
        {
            return this.m_oUtilizador.hasPapel(strPapel);
        }
        return false;
    }
    
    public String getUserName()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getName();
        return null;
    }
    
    public String getUserEmail()
    {
        if (isLoggedIn())
            this.m_oUtilizador.getEmail();
        return null;
    }
    
    public List<UserRole> getUserRoles()
    {
        return this.m_oUtilizador.getRoles();
    }
}
