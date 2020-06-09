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
public class FreelancerTest {
    
   

    /**
     * Test of validateFreelancer method, of class Freelancer.
     */
    @Test
    public void testValidateFreelancer() {
        System.out.println("validateFreelancer");
        Freelancer instance = new Freelancer("name", "levelExp", "email", "123445", "59342492", "country", new Address("street", "12", "locality"));
        boolean expResult = true;
        boolean result = instance.validateFreelancer();
        assertEquals(expResult, result); 
    }

    
  



   
    
}
