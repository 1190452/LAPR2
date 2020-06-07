/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class LoginUITest {
    
    public LoginUITest() {
    }

    /**
     * Test of initialize method, of class LoginUI.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoginUI instance = new LoginUI();
        instance.initialize(url, rb);
    }
    
}
