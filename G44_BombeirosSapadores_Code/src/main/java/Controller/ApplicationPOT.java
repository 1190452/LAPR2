/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import autorizacao.FacadeAuthorization;
import autorizacao.model.UserSession;
import Model.Constants;
import Model.Platform;

/**
 *
 * @author paulomaio
 */
public class ApplicationPOT
{
       
    private final Platform m_oPlataforma;
    private final FacadeAuthorization m_oAutorizacao;
    
    private ApplicationPOT()
    {
        Properties props = getProperties();
        this.m_oPlataforma = new Platform();
        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorazation();
    }
    
    public Platform getPlatform()
    {
        return this.m_oPlataforma;
    }
    

    public UserSession getActualSession()
    {
        return this.m_oAutorizacao.getActualSession();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }
    
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }
    
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_PLATFORM_DESIGNATION, "Task for Joe");

        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constants.FILE_PARAMS);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {
            
        }
        return props;
    }

    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationPOT singleton = null;
    public static ApplicationPOT getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(ApplicationPOT.class) 
            { 
                singleton = new ApplicationPOT();
            }
        }
        return singleton;
    }

    
}
