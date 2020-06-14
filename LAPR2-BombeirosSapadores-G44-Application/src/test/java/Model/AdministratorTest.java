/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class AdministratorTest {
    /**
     * Test of toString method, of class Administrator.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Administrator instance = new Administrator("José", "jose@gmail.com", "qwerty", Constants.ROLE_ADMINISTRATIVE);
        String expResult = "ADMINISTRATOR - jose@gmail.com";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
