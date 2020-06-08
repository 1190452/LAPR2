/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
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
public class TaskExecutionTest {
    

 
    /**
     * Test of getEndDate method, of class TaskExecution.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        TaskExecution instance = new TaskExecution();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTaskDelay method, of class TaskExecution.
     */
    @Test
    public void testGetTaskDelay() {
        System.out.println("getTaskDelay");
        TaskExecution instance = new TaskExecution();
        double expResult = 0.0;
        double result = instance.getTaskDelay();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getDescriptionOfQuality method, of class TaskExecution.
     */
    @Test
    public void testGetDescriptionOfQuality() {
        System.out.println("getDescriptionOfQuality");
        TaskExecution instance = new TaskExecution();
        String expResult = "";
        String result = instance.getDescriptionOfQuality();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescriptionOfQuality method, of class TaskExecution.
     */
    @Test
    public void testSetDescriptionOfQuality() {
        System.out.println("setDescriptionOfQuality");
        String descriptionOfQuality = "";
        TaskExecution instance = new TaskExecution();
        instance.setDescriptionOfQuality(descriptionOfQuality);
      
    }

    /**
     * Test of setEndDate method, of class TaskExecution.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        TaskExecution instance = new TaskExecution();
        boolean result= instance.setEndDate(endDate);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);        
    }

    /**
     * Test of setDelay method, of class TaskExecution.
     */
    @Test
    public void testSetDelay() {
        System.out.println("setDelay");
        double delay = 0.0;
        TaskExecution instance = new TaskExecution();
        boolean result = instance.setDelay(delay);
        boolean expectedResult = true;
       
    }
    
}
