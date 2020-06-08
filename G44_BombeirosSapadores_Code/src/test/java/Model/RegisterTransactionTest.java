/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
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
public class RegisterTransactionTest {
    
   

    /**
     * Test of removeHistoricalTransaction method, of class RegisterTransaction.
     */
    @Test
    public void testRemoveHistoricalTransaction() {
        System.out.println("removeHistoricalTransaction");
        Transaction tr = null;
        RegisterTransaction instance = new RegisterTransaction();
        boolean result=instance.removeHistoricalTransaction(tr);
        boolean expectedResult= true;
        assertEquals(expectedResult,result);            
    }

    /**
     * Test of validateHistoricalTransaction method, of class RegisterTransaction.
     */
    @Test
    public void testValidateHistoricalTransaction() {
        System.out.println("validateHistoricalTransaction");
        List<Transaction> lt = null;
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = false;
        boolean result = instance.validateHistoricalTransaction(lt);
        assertEquals(expResult, result);  
    }

    /**
     * Test of createNewTransaction method, of class RegisterTransaction.
     */
    @Test
    public void testCreateNewTransaction() {
        System.out.println("createNewTransaction");
        Task task = null;
        Freelancer freel = null;
        Date endDate = null;
        double delay = 0.0;
        String qow = "";
        RegisterTransaction instance = new RegisterTransaction();
        Transaction expResult = null;
        Transaction result = instance.createNewTransaction(task, freel, endDate, delay, qow);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of validateTransaction method, of class RegisterTransaction.
     */
    @Test
    public void testValidateTransaction() {
        System.out.println("validateTransaction");
        Transaction trans = null;
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = false;
        boolean result = instance.validateTransaction(trans);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addTransaction method, of class RegisterTransaction.
     */
    @Test
    public void testAddTransaction() {
        System.out.println("addTransaction");
        Transaction trans = null;
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = false;
        boolean result = instance.addTransaction(trans);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of calculateTransactionValue method, of class RegisterTransaction.
     */
    @Test
    public void testCalculateTransactionValue() {
        System.out.println("calculateTransactionValue");
        Transaction trans = null;
        RegisterTransaction instance = new RegisterTransaction();
        double expResult = 0.0;
        double result = instance.calculateTransactionValue(trans);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
