/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import Utils.Time;
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
public class OrganizationTest {

    /**
     * Test of newAddress method, of class Organization.
     */
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

    /**
     * Test of newCollaborator method, of class Organization.
     */
    @Test
    public void testNewCollaborator() {
        System.out.println("newCollaborator");
        String nameC = "namec";
        String emailC = "emailc";
        String role = "role";
        Collaborator expResult = new Collaborator(nameC, emailC, role);
        Collaborator result = Organization.newCollaborator(nameC, emailC, role);
        assertEquals(expResult, result);

    }

    /**
     * Test of newManager method, of class Organization.
     */
    @Test
    public void testNewManager() {
        System.out.println("newManager");
        String nameM = "nameM";
        String emailM = "emailM";
        String role = "role";
        Manager expResult = new Manager(nameM, emailM, role);
        Organization instance = new Organization("name", "Nif", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager(nameM, emailM, role));
        Manager result = instance.newManager(nameM, emailM, role);
        assertEquals(expResult, result);

    }

    /**
     * Test of newDefinePayment method, of class Organization.
     */
    @Test
    public void testNewDefinePayment() {
        System.out.println("newDefinePayment");
        Time time = new Time(24, 12, 14);
        Date date = new Date(2020, 10, 20);
        int rtp = 10;
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        DefinePayment expResult = new DefinePayment(time, date, rtp);
        DefinePayment result = instance.newDefinePayment(time, date, rtp);
        assertEquals(expResult, result);

    }

    /**
     * Test of validatesDefinePayment method, of class Organization.
     */
    @Test
    public void testValidatesDefinePayment() {
        System.out.println("validatesDefinePayment");
        DefinePayment dp = new DefinePayment(new Time(2, 20, 10), new Date(2020, 2, 9), 10);
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        boolean expResult = true;
        boolean result = instance.validatesDefinePayment(dp);
        assertEquals(expResult, result);

    }

    /**
     * Test of loadHistoricalTransaction method, of class Organization.
     */
    @Test
    public void testLoadHistoricalTransaction() {
        System.out.println("loadHistoricalTransaction");
        String fileName = "file";
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        List<TransactionExecution> expResult = null;
        List<TransactionExecution> result = instance.loadHistoricalTransaction(fileName);
        assertEquals(expResult, result);
    }

    /**
     * Test of sendEmail method, of class Organization.
     */
    @Test
    public void testSendEmail() throws Exception {
        System.out.println("sendEmail");
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        instance.sendEmail();

    }

    /**
     * Test of equals method, of class Organization.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        Organization instance = new Organization("name", "NIF", "email", new Address("street", "doorNumber", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        boolean expResult = t;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);

    }

}
