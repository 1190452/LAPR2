/** To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.IOException;
import Authorization.FacadeAuthorization;
import Authorization.model.RegisterUser;
import Authorization.model.UserSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author paulomaio
 */
public class ApplicationPOT implements Serializable {

    private final String FILENAME = "saves.ser";
    /**
     * system platform
     */
    private Platform m_oPlataforma;

    /**
     * facade authorization
     */
    private FacadeAuthorization m_oAutorizacao;


    /**
     * constructor that initializes the Platform and the FacadeAuthorization
     */
    public ApplicationPOT() {
        this.m_oPlataforma = new Platform();
        this.m_oAutorizacao = this.m_oPlataforma.getFacadeAuthorazation();
        bootstrap();
    }

    //======================================================================================================================================================
    /**
     * reads the data from a binary file
     */
    public void read() {
        Platform plat1;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
            try {
                plat1 = (Platform) in.readObject();
                this.m_oPlataforma = plat1;
                this.m_oAutorizacao = plat1.getFacadeAuthorazation();
            } finally {
                in.close();
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("did not read" + ex.getMessage());
        }
    }

    /**
     * saves the new data into a binary file
     * @param m_Platform
     * @return 
     */
    public boolean save(Platform m_Platform) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(new File(FILENAME)));
            try {
                out.writeObject(m_Platform);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    

    /**
     * method that logins a user in the platform
     *
     * @param strId
     * @param strPwd
     * @return
     */
    public boolean doLogin(String strId, String strPwd) {
        return this.m_oAutorizacao.doLogin(strId, strPwd) != null;
    }

    /**
     * method that logs a user out of the platform
     */
    public void doLogout() {
        this.m_oAutorizacao.doLogout();
    }

    /**
     * method that regists an administrator in the platform
     */
    private void bootstrap() {

        this.m_oAutorizacao.registerUser("T4J Administrator", "admin@gmail.com", "qwerty", Constants.ROLE_ADMINISTRATIVE);
        this.m_oAutorizacao.registerUser("T4J Collaborator", "collaborator@gmail.com", "qwerty", Constants.ROLE_COLLABORATOR_ORGANIZATION);
        this.m_oAutorizacao.registerUser("T4J Manager", "manager@gmail.com ", "qwerty", Constants.ROLE_MANAGER_ORGANIZATION);

    }

    /**
     * method that returns the active instance of the applicationPOT
     */
    // Inspired in  https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationPOT singleton = null;

    public static ApplicationPOT getInstance() {
        if (singleton == null) {

            synchronized (ApplicationPOT.class) {
                singleton = new ApplicationPOT();
            }
        }
        return singleton;
    }

    //======================================================================================================================================================
    /**
     * return the platform
     *
     * @return m_oPlataforma
     */
    public Platform getPlatform() {
        return this.m_oPlataforma;
    }

    /**
     * method that returns the actualSession
     *
     * @return
     */
    public UserSession getActualSession() {
        return this.m_oAutorizacao.getActualSession();
    }

}
