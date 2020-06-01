/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacao.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class RegisterUserRoles
{
    private Set<UserRole> m_lstPapeis = new HashSet<UserRole>();
    
    public UserRole novoPapelUtilizador(String strPapel)
    {
        return new UserRole(strPapel);
    }
    
    public UserRole novoPapelUtilizador(String strPapel, String strDescricao)
    {
        return new UserRole(strPapel,strDescricao);
    }
    
    public boolean addPapel(UserRole papel)
    {
        if (papel != null)
            return this.m_lstPapeis.add(papel);
        return false;
    }
    
    public boolean removePapel(UserRole papel)
    {
        if (papel != null)
            return this.m_lstPapeis.remove(papel);
        return false;
    }
    
    public UserRole procuraPapel(String strPapel)
    {
        for(UserRole p: this.m_lstPapeis)
        {
            if(p.hasId(strPapel))
                return p;
        }
        return null;
    }
    
    public boolean hasPapel(String strPapel)
    {
        UserRole papel = procuraPapel(strPapel);
        if (papel != null)
            return this.m_lstPapeis.contains(papel);
        return false;
    }
    
    public boolean hasPapel(UserRole papel)
    {
        return this.m_lstPapeis.contains(papel);
    }
}
