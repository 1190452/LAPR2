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
public class ApplicationPOT {
    /**
     * system platform
     */   
    private final Platform m_oPlataforma;
    
    /**
     * facade authorization
     */
    private final FacadeAuthorization m_oAutorizacao;
    
    /**
     * constructor that inicializes the Platform and the FacadeAuthorization
     */
    public ApplicationPOT()
    {
        this.m_oPlataforma = new Platform();
        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorazation();
        bootstrap();
    }
    
    /**
     * return the platform
     * @return m_oPlataforma
     */
    public Platform getPlatform()
    {
        return this.m_oPlataforma;
    }
    
    /**
     * method that returns the actualSession
     * @return 
     */
    public UserSession getActualSession()
    {
        return this.m_oAutorizacao.getActualSession();
    }
    
    /**
     * method that logins a user in the platform
     * @param strId
     * @param strPwd
     * @return 
     */
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }
    
    /**
     * method that logs a user out of the platform
     */
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }
    
    /**
     * method that regists an administrator in the platform
     */
     private void bootstrap()
    {
    
        this.m_oAutorizacao.registerUser("Ricardo", "bombeiro@gmail.com", "qwerty", Constants.ROLE_ADMINISTRATIVE); 
        this.m_oAutorizacao.registerUser("Bruno", "b@gmail.com", "qwerty", Constants.ROLE_COLLABORATOR_ORGANIZATION);
        this.m_oAutorizacao.registerUser("Alexandre", "a@gmail.com ", "qwerty", Constants.ROLE_MANAGER_ORGANIZATION);
    }

    /**
     * method that returns the active instance of the applicationPOT
     */
    // Inspired in  https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
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
