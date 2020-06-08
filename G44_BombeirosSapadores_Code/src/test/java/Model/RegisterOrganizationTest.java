package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class RegisterOrganizationTest {
    
    /**
     * Test of getOrganizationString method, of class RegisterOrganization.
     */
    @Test
    public void testGetOrganizationString() {
        System.out.println("getOrganizationString");
        RegisterOrganization instance = new RegisterOrganization();
        String expResult = "";
        String result = instance.getOrganizationString();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of addOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testAddOrganization() {
        System.out.println("addOrganization");
        Organization oOrganizacao = null;
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = false;
        boolean result = instance.addOrganization(oOrganizacao);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getOrganizationByUserEmailColab method, of class RegisterOrganization.
     */
    @Test
    public void testGetOrganizationByUserEmailColab() {
        System.out.println("getOrganizationByUserEmailColab");
        String email = "";
        RegisterOrganization instance = new RegisterOrganization();
        Organization expResult = null;
        Organization result = instance.getOrganizationByUserEmailColab(email);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getOrganizationByUserEmailMan method, of class RegisterOrganization.
     */
    @Test
    public void testGetOrganizationByUserEmailMan() {
        System.out.println("getOrganizationByUserEmailMan");
        String email = "";
        RegisterOrganization instance = new RegisterOrganization();
        Organization expResult = null;
        Organization result = instance.getOrganizationByUserEmailMan(email);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of newOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testNewOrganization() {
        System.out.println("newOrganization");
        String name = "";
        String email = "";
        String NIF = "";
        String street = "";
        String doorNumber = "";
        String locality = "";
        String nameC = "";
        String emailC = "";
        String nameM = "";
        String emailM = "";
        RegisterOrganization instance = new RegisterOrganization();
        Organization expResult = null;
        Organization result = instance.newOrganization(name, email, NIF, street, doorNumber, locality, nameC, emailC, nameM, emailM);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of validateOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testValidateOrganization() {
        System.out.println("validateOrganization");
        Organization org = null;
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = false;
        boolean result = instance.validateOrganization(org);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of registerOrganization method, of class RegisterOrganization.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegisterOrganization() throws Exception {
        System.out.println("registerOrganization");
        Organization org = null;
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = false;
        boolean result = instance.registerOrganization(org);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registUser method, of class RegisterOrganization.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistUser_Manager() throws Exception {
        System.out.println("registUser");
        Manager manager = null;
        RegisterOrganization instance = new RegisterOrganization();
        boolean result=instance.registUser(manager);
        boolean expectedResult= true;
        assertEquals(expectedResult, result);
       
    }

    /**
     * Test of registUser method, of class RegisterOrganization.
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistUser_Collaborator() throws Exception {
        System.out.println("registUser");
        Collaborator collab = null;
        RegisterOrganization instance = new RegisterOrganization();
        boolean result=instance.registUser(collab);
        boolean expectedResult= true;
        assertEquals(expectedResult, result);
       
    }
    
}
