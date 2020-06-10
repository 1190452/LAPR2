package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class RegisterOrganizationTest {

    /**
     * Test of addOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testAddOrganization() {
        System.out.println("addOrganization");
        Organization oOrganizacao = new Organization();
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = true;
        boolean result = instance.addOrganization(oOrganizacao);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOrganizationByUserEmailColab method, of class
     * RegisterOrganization.
     */
    @Test
    public void testGetOrganizationByUserEmailColab() {
        System.out.println("getOrganizationByUserEmailColab");
        String email = "ricardo@gmail.com";
        RegisterOrganization instance = new RegisterOrganization();
        Organization org = new Organization("ISEP", "123456789", "isep@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Ricardo Pereira", email, "a"), new Manager("Antonio Gomes", "x@gmail.com", "a"));
        instance.addOrganization(org);
        Organization expResult = org;
        Organization result = instance.getOrganizationByUserEmailColab(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOrganizationByUserEmailMan method, of class
     * RegisterOrganization.
     */
    @Test
    public void testGetOrganizationByUserEmailMan() {
        System.out.println("getOrganizationByUserEmailMan");
        String email = "ricardo@gmail.com";
        RegisterOrganization instance = new RegisterOrganization();
        Organization org = new Organization("ISEP", "123456789", "isep@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Antonio Gomes", "x@gmail.com", "a"), new Manager("Ricardo Pereira", email, "a"));
        instance.addOrganization(org);
        Organization expResult = org;
        Organization result = instance.getOrganizationByUserEmailMan(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of newOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testNewOrganization() {
        System.out.println("newOrganization");
        String name = "ISEP";
        String email = "isep@gmail.com";
        String NIF = "123456789";
        String street = "street";
        String doorNumber = "123";
        String locality = "Porto";
        String nameC = "Ricardo Pereira";
        String emailC = "r@gmail.com";
        String nameM = "Bruno Pereira";
        String emailM = "b@gmail.com";
        RegisterOrganization instance = new RegisterOrganization();
        Organization expResult = new Organization(name, NIF, email, new Address(street, doorNumber, locality), new Collaborator(nameC, emailC, Constants.ROLE_COLLABORATOR_ORGANIZATION), new Manager(nameM, emailM, Constants.ROLE_MANAGER_ORGANIZATION));
        Organization result = instance.newOrganization(name, NIF, email, street, doorNumber, locality, nameC, emailC, nameM, emailM);
        assertEquals(expResult, result);

    }

    /**
     * Test of validateOrganization method, of class RegisterOrganization.
     */
    @Test
    public void testValidateOrganization() {
        System.out.println("validateOrganization");
        Organization org = new Organization();
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = true;
        boolean result = instance.validateOrganization(org);
        assertEquals(expResult, result);

    }

    /**
     * Test of registerOrganization method, of class RegisterOrganization.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRegisterOrganization() throws Exception {
        System.out.println("registerOrganization");
        RegisterOrganization instance = new RegisterOrganization();
        Organization org = instance.newOrganization("ISEP", "123456789", "isep@gmail.com", "street", "123", "Porto", "Antonio Gomes", "x@gmail.com", "Ricardo Pereira", "r@gmail.com");
        boolean expResult = true;
        boolean result = instance.registerOrganization(org);
        assertEquals(expResult, result);

    }
    /**
     * Test of registUser method, of class RegisterOrganization.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistUser_Manager() throws Exception {
        System.out.println("registUser");
        Manager manager = new Manager("Ricardo Pereira", "r@gmail.com", Constants.ROLE_MANAGER_ORGANIZATION);
        
        RegisterOrganization instance = new RegisterOrganization();
        Organization org = instance.newOrganization("ISEP", "123456789", "isep@gmail.com", "street", "123", "Porto", "Antonio Gomes", "x@gmail.com", "Ricardo Pereira", "r@gmail.com");
        
        boolean result=instance.registUser(manager);
        boolean expectedResult= true;
        assertEquals(expectedResult, result);
       
    }
    /**
     * Test of registUser method, of class RegisterOrganization.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRegistUser_Collaborator() throws Exception {
        System.out.println("registUser");
        Collaborator collab = new Collaborator("Antonio Gomes", "x@gmail.com", Constants.ROLE_COLLABORATOR_ORGANIZATION);
        RegisterOrganization instance = new RegisterOrganization();
        
        Organization org = instance.newOrganization("ISEP", "123456789", "isep@gmail.com", "street", "123", "Porto", "Antonio Gomes", "x@gmail.com", "Ricardo Pereira", "r@gmail.com");
        
        boolean result=instance.registUser(collab);
        boolean expectedResult= true;
        assertEquals(expectedResult, result);
       
    }
}
