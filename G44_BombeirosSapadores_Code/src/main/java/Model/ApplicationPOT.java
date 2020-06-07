 /** To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import autorizacao.FacadeAuthorization;
import autorizacao.model.UserSession;

/**
 *
 * @author paulomaio
 */
public class ApplicationPOT
{
       
    private final Platform m_oPlataforma;
    private final FacadeAuthorization m_oAutorizacao;
    
    public ApplicationPOT()
    {
        this.m_oPlataforma = new Platform();
        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorazation();
        bootstrap();
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
     private void bootstrap()
    {
    
        this.m_oAutorizacao.registerUser("Ricardo", "bombeiro@gmail.com", "qwerty", Constants.ROLE_ADMINISTRATIVE); 
        this.m_oAutorizacao.registerUser("Bruno", "b@gmail.com", "qwerty", Constants.ROLE_COLLABORATOR_ORGANIZATION);
        this.m_oAutorizacao.registerUser("Alexandre", "a@gmail.com ", "qwerty", Constants.ROLE_MANAGER_ORGANIZATION);
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
