/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ReceiptTest {
    

    /**
     * Test of genEmail method, of class Receipt.
     */
    @Test
    public void testGenEmail() {
        System.out.println("genEmail");
        Receipt instance = null;
        boolean expectedResult = true;
        boolean result= instance.genEmail();
        assertEquals(expectedResult, result);
       
    }
    
}
