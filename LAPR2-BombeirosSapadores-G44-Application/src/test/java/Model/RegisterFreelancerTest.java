/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class RegisterFreelancerTest {
    

    /**
     * Test of newFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testNewFreelancer() {
        System.out.println("newFreelancer");
        String name = "Ricardo";
        String levelExp = "Junior";
        String email = "ricardo@gmail.com";
        String nif = "123456789";
        String iban = "PT123456789987654321";
        String country = "Japan";
        String street = "Street";
        String doorNumber = "12";
        String locality = "Tóquio";
        RegisterFreelancer instance = new RegisterFreelancer();
        Freelancer expResult = new Freelancer(name, levelExp, email, nif, iban, country, new Address(street, doorNumber, locality));
        Freelancer result = instance.newFreelancer(name, levelExp, email, nif, iban, country, street, doorNumber, locality);
        
        assertEquals(result, expResult);
        
      
    }

    /**
     * Test of validateFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testValidateFreelancer() {
        System.out.println("validateFreelancer");
        Freelancer free = new Freelancer();
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = true;
        boolean result = instance.validateFreelancer(free);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of saveFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testSaveFreelancer() {
        System.out.println("saveFreelancer");
        Freelancer free = new Freelancer();
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = true;
        boolean result = instance.saveFreelancer(free);
        assertEquals(expResult, result);       
    }

    /**
     * Test of addFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testAddFreelancer() {
        System.out.println("addFreelancer");
        Freelancer free = new Freelancer();
        RegisterFreelancer instance = new RegisterFreelancer();
        boolean expResult = true;
        boolean result = instance.addFreelancer(free);
        assertEquals(expResult, result); 
    }

    /**
     * Test of removeFreelancer method, of class RegisterFreelancer.
     */
    @Test
    public void testRemoveFreelancer() {
        System.out.println("removeFreelancer");
        Freelancer fr = new Freelancer();
        RegisterFreelancer instance = new RegisterFreelancer();
        instance.addFreelancer(fr);
        boolean expectedResult = instance.removeFreelancer(fr);
        boolean result = true;
        
        assertEquals(expectedResult, result);
        
    }

    /**
     * Test of getListFreelancers method, of class RegisterFreelancer.
     */
    @Test
    public void testGetListFreelancers() {
        System.out.println("getListFreelancers");
        RegisterFreelancer instance = new RegisterFreelancer();
        List<Freelancer> expResult = new ArrayList<>();
        List<Freelancer> result = instance.getListFreelancers();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of generateID method, of class RegisterFreelancer.
     */
    @Test
    public void testGenerateID() {
        System.out.println("generateID");
        Freelancer free = new Freelancer("Ricardo Pereira","levelExp", "email", "nif", "iban", "country",new Address());
        RegisterFreelancer instance = new RegisterFreelancer();
        String expResult = "RP1";
        String result = instance.generateID(free);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFreelancers method, of class RegisterFreelancer.
     */
    @Test
    public void testGetFreelancers() {
        System.out.println("getFreelancers");
        List<Task> lt = new ArrayList<>();
        List<TransactionExecution> ltr = new ArrayList<>();
        RegisterFreelancer instance = new RegisterFreelancer();
        List<Freelancer> expResult = new ArrayList<>();
        List<Freelancer> result = instance.getFreelancers(lt, ltr);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of Verification method, of class RegisterFreelancer.
     */
    @Test
    public void testVerification() {
        System.out.println("Verification");
        Freelancer fr = new Freelancer();
        RegisterFreelancer instance = new RegisterFreelancer();
        instance.addFreelancer(fr);
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
        List<Freelancer> expResult = new ArrayList<>();
        List<Freelancer> result = instance.getListFreelancers();
        assertEquals(expResult, result);
       
    }


    
    
}
