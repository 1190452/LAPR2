/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import java.util.ArrayList;
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
public class WriterTest {

    /**
     * Test of sendsPassword method, of class Writer.
     */
    @Test
    public void testSendsPassword() {
        System.out.println("sendsPassword");
        String email = "email";
        String pwd = "12131";
        String role = "role";
        boolean expectedResult = true;
        boolean result = Writer.sendsPassword(email, pwd, role);
        assertEquals(expectedResult, result);

    }

    /**
     * Test of writeOrg method, of class Writer.
     */
    @Test
    public void testWriteOrg() {
        System.out.println("writeOrg");
        Organization org = new Organization("name", "Nif", "email", new Address("street", "123", "locality"), new Collaborator("name", "email", "role"), new Manager("name", "email", "role"));
        double sum = 2.0;
        boolean expectedResult = true;
        boolean result = Writer.writeOrg(org, sum);
        assertEquals(expectedResult, result);

    }

    /**
     * Test of sendEmail method, of class Writer.
     */
    @Test
    public void testSendEmail() throws Exception {
        System.out.println("sendEmail");
        Freelancer free = new Freelancer("name", "levelExp", "email", "12344", "12445", "country", new Address("street", "123", "locality"));
        boolean result = Writer.sendEmail(free);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);

    }

    /**
     * Test of genEmail method, of class Writer.
     */
    @Test
    public void testGenEmail() {
        System.out.println("genEmail");
        ArrayList<TransactionExecution> nltr = new ArrayList();
        nltr.add(new TransactionExecution("transID", new Task("idTask", "description", 20, 30, "taskCategory"), new Freelancer("name", "levelExp", "email", "12344", "12445", "country", new Address("street", "123", "locality")) , new Date(2010,10,5), 20, "descString"));
        double valueE = 2.0;
        double valueC = 3.0;
        boolean result = Writer.genEmail(nltr, valueE, valueC);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
        
        
    }

}
