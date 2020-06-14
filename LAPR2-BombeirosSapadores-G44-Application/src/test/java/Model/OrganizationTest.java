/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import Utils.Time;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class OrganizationTest {
    
    public OrganizationTest() {
    }

    @Test
    public void testNewAddress() {
       System.out.println("newAddress");
        String street = "rua de cima";
        String doorNumber = "212";
        String locality = "Vila do conde";
        Organization instance = new Organization("name", "Nif", "email", new Address(street, doorNumber, locality), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        Address expResult = new Address(street, doorNumber, locality);
        Address result = instance.newAddress(street, doorNumber, locality);
        assertEquals(expResult, result);
    }

    @Test
    public void testNewCollaborator() {
        String nameC = "José Vieira";
        String emailC = "jose@gmail.com";
        String role = Constants.ROLE_COLLABORATOR_ORGANIZATION;
        Collaborator expResult = new Collaborator(nameC, emailC, role);
        Collaborator result = Organization.newCollaborator(nameC, emailC, role);
        assertEquals(expResult, result);
    }

    @Test
    public void testNewManager() {
        String nameM = "José Vieira";
        String emailM = "jose@gmail.com";
        String role = Constants.ROLE_MANAGER_ORGANIZATION;
        Manager expResult = new Manager(nameM, emailM, role);
        Manager result = Organization.newManager(nameM, emailM, role);
        assertEquals(expResult, result);
    }

    @Test
    public void testNewDefinePayment() {
        System.out.println("newDefinePayment");
        Time time = new Time(24, 12, 14);
        Date date = new Date(2020, 10, 20);
        int rtp = 10;
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        DefinePayment expResult = new DefinePayment(time, date, rtp);
        DefinePayment result = instance.newDefinePayment(time, date, rtp);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidatesDefinePayment() {
        System.out.println("validatesDefinePayment");
        DefinePayment dp = new DefinePayment(new Time(2, 20, 10), new Date(2020, 2, 9), 10);
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        boolean expResult = true;
        boolean result = instance.validatesDefinePayment(dp);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoadHistoricalTransaction() {
        System.out.println("loadHistoricalTransaction");
        String fileName = "file";
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        List<TransactionExecution> expResult = null;
        List<TransactionExecution> result = instance.loadHistoricalTransaction(fileName);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Organization("name", "NIF", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
}
