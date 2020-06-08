/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
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
public class RegisterFreelancerTest {
    

    /**
     * Test of newFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testNewFreelancer() {
        System.out.println("newFreelancer");
        String name = "";
        String levelExp = "";
        String email = "";
        String nif = "";
        String iban = "";
        String country = "";
        String street = "";
        String doorNumber = "";
        String locality = "";
        RegisterFreelancer instance = new RegisterFreelancer();
        Freelancer expResult = null;
        Freelancer result = instance.newFreelancer(name, levelExp, email, nif, iban, country, street, doorNumber, locality);
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of validateFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testValidateFreelancer() {
        System.out.println("validateFreelancer");
        Freelancer free = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = false;
        boolean result = instance.validateFreelancer(free);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of saveFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testSaveFreelancer() {
        System.out.println("saveFreelancer");
        Freelancer free = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = false;
        boolean result = instance.saveFreelancer(free);
        assertEquals(expResult, result);       
    }

    /**
     * Test of addFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testAddFreelancer() {
        System.out.println("addFreelancer");
        Freelancer free = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = false;
        boolean result = instance.addFreelancer(free);
        assertEquals(expResult, result); 
    }

    /**
     * Test of removeFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testRemoveFreelancer() {
        System.out.println("removeFreelancer");
        Freelancer fr = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expectedResult = instance.removeFreelancer(fr);
        boolean result = true;
        
    }

    /**
     * Test of getListFreelancers method, of class RegisterFreelancer.
     */
    @Test
    public void testGetListFreelancers() {
        System.out.println("getListFreelancers");
        RegisterFreelancer instance = new RegisterFreelancer();
        List<Freelancer> expResult = null;
        List<Freelancer> result = instance.getListFreelancers();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of generateID method, of class RegisterFreelancer.
     */
    @Test
    public void testGenerateID() {
        System.out.println("generateID");
        Freelancer free = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        String expResult = "";
        String result = instance.generateID(free);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFreelancers method, of class RegisterFreelancer.
     */
    @Test
    public void testGetFreelancers() {
        System.out.println("getFreelancers");
        List<Task> lt = null;
        List<Transaction> ltr = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        List<Freelancer> expResult = null;
        List<Freelancer> result = instance.getFreelancers(lt, ltr);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of Verification method, of class RegisterFreelancer.
     */
    @Test
    public void testVerification() {
        System.out.println("Verification");
        Freelancer fr = null;
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = false;
        boolean result = instance.Verification(fr);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getListaFreelancers method, of class RegisterFreelancer.
     */
    @Test
    public void testGetListaFreelancers() {
        System.out.println("getListaFreelancers");
        RegisterFreelancer instance = new RegisterFreelancer();
        List<Freelancer> expResult = null;
        List<Freelancer> result = instance.getListaFreelancers();
        assertEquals(expResult, result);
       
    }


    
    
}
