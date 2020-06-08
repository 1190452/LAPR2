/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Authorization.model.UserSession;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ApplicationPOTTest {
    
    public ApplicationPOTTest() {
    }

    /**
     * Test of getPlatform method, of class ApplicationPOT.
     */
    @Test
    public void testGetPlatform() {
        System.out.println("getPlatform");
        ApplicationPOT instance = new ApplicationPOT();
        Platform expResult = instance.getPlatform();
        Platform result = instance.getPlatform();
        assertEquals(expResult, result);
    }

    /**
     * Test of getActualSession method, of class ApplicationPOT.
     */
    @Test
    public void testGetActualSession() {
        System.out.println("getActualSession");
        ApplicationPOT instance = new ApplicationPOT();
        UserSession expResult = null;
        UserSession result = instance.getActualSession();
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogin method, of class ApplicationPOT.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String strId = "jose@gmail.com";
        String strPwd = "qwerty";
        ApplicationPOT instance = new ApplicationPOT();
        boolean expResult = false; //o utilizador não se encontra registado
        boolean result = instance.doLogin(strId, strPwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogout method, of class ApplicationPOT.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        ApplicationPOT instance = new ApplicationPOT();
        instance.doLogout();
    }
    
}
