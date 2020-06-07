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
 * @author Jorge
 */
public class ManagerTest {
    
    public ManagerTest() {
    }

    /**
     * Test of getNameM method, of class Manager.
     */
    @Test
    public void testGetNameM() {
        System.out.println("getNameM");
        Manager instance = new Manager("Bruno", "bruno@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION);
        String expResult = "Bruno";
        String result = instance.getNameM();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNameM method, of class Manager.
     */
    @Test
    public void testSetNameM() {
        System.out.println("setNameM");
        String nameM = "Bruno";
        Manager instance = new Manager();
        instance.setNameM(nameM);
    }

    /**
     * Test of getEmailM method, of class Manager.
     */
    @Test
    public void testGetEmailM() {
        System.out.println("getEmailM");
        Manager instance = new Manager("Bruno", "bruno@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION);
        String expResult = "bruno@gmail.com";
        String result = instance.getEmailM();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailM method, of class Manager.
     */
    @Test
    public void testSetEmailM() {
        System.out.println("setEmailM");
        String emailM = "bruno@gmail.com";
        Manager instance = new Manager();
        instance.setEmailM(emailM);
    }

    /**
     * Test of getRole method, of class Manager.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Manager instance = new Manager("Bruno", "bruno@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION);
        String expResult = "MANAGER_ORGANIZATION";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class Manager.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = Constants.ROLE_MANAGER_ORGANIZATION;
        Manager instance = new Manager();
        instance.setRole(role);
    }

    /**
     * Test of toString method, of class Manager.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Manager instance = new Manager("Bruno", "bruno@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION);
        System.out.println(instance.toString());
        String expResult = "Nome: Bruno \nEmail: bruno@gmail.com \nRole: MANAGER_ORGANIZATION";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
