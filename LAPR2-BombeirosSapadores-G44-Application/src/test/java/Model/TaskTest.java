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
public class TaskTest {
    
    public TaskTest() {
    }

    /**
     * Test of getIdTask method, of class Task.
     */
    @Test
    public void testGetIdTask() {
        System.out.println("getIdTask");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        String expResult = "T4";
        String result = instance.getIdTask();
        assertEquals(expResult, result);
    }


    /**
     * Test of getDescription method, of class Task.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        String expResult = "desc";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }


    /**
     * Test of getTimeTask method, of class Task.
     */
    @Test
    public void testGetTimeTask() {
        System.out.println("getTimeTask");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        int expResult = 12;
        int result = instance.getTimeTask();
        assertEquals(expResult, result);
    }


    /**
     * Test of getCostHour method, of class Task.
     */
    @Test
    public void testGetCostHour() {
        System.out.println("getCostHour");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        double expResult = 9;
        double result = instance.getCostHour();
        assertEquals(expResult, result, 0.1);
    }


    /**
     * Test of isIsPayed method, of class Task.
     */
    @Test
    public void testIsIsPayed() {
        System.out.println("isIsPayed");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        boolean expResult = false;
        boolean result = instance.isIsPayed();
        assertEquals(expResult, result);
    }
    
    
        /**
     * Test of isIsPayed method, of class Task.
     */
    @Test
    public void testIsIsPayed2() {
        System.out.println("isIsPayed");
        Task instance = new Task("T4","desc",12,9,"IT",true,true);
        boolean expResult = true;
        boolean result = instance.isIsPayed();
        assertEquals(expResult, result);
    }


    /**
     * Test of isIsFinished method, of class Task.
     */
    @Test
    public void testIsIsFinished() {
        System.out.println("isIsFinished");
        Task instance = new Task("T4","desc",12,9,"IT",false,false);
        boolean expResult = false;
        boolean result = instance.isIsFinished();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isIsFinished method, of class Task.
     */
    @Test
    public void testIsIsFinished2() {
        System.out.println("isIsFinished");
        Task instance = new Task("T4","desc",12,9,"IT",false,true);
        boolean expResult = true;
        boolean result = instance.isIsFinished();
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of equals method, of class Task.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        Task instance = new Task("T4","desc",12,9,"IT",false,true);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of equals method, of class Task.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Task instance1 = new Task("T4","desc",12,9,"IT",false,true);
        Task instance = new Task(instance1);
        boolean expResult = true;
        boolean result = instance.equals(instance1);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = new Task("T4","desc",12,9,"IT",false,true);
        String expResult = "Task T4, description: desc, cost per hour: 9.0, "
                + "category: IT";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    
}
