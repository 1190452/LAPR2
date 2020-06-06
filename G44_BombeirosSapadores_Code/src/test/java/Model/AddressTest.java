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
public class AddressTest {
    
    public AddressTest() {
    }

    /**
     * Test of getStreet method, of class Address.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        Address instance = new Address("rua dos combatentes", "46", "Lisboa");
        String expResult = "rua dos combatentes";
        String result = instance.getStreet();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoorNumber method, of class Address.
     */
    @Test
    public void testGetDoorNumber() {
        System.out.println("getDoorNumber");
        Address instance = new Address("rua dos combatentes", "46", "Lisboa");
        String expResult = "46";
        String result = instance.getDoorNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocality method, of class Address.
     */
    @Test
    public void testGetLocality() {
        System.out.println("getLocality");
        Address instance = new Address("rua dos combatentes", "46", "Lisboa");
        String expResult = "Lisboa";
        String result = instance.getLocality();
        assertEquals(expResult, result);
    }


    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        Address instance = new Address("rua dos combatentes", "45", "Lisboa");
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Address instance = new Address("rua xpto", "56", "algarve");
        Address instance2 = new Address(instance);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Address.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Address instance = new Address("rua de cima", "78", "porto");
        String expResult = "Street: rua de cima, Door number: 78, Locality: porto\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
