/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CurrencyConverter;
import Utils.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OMEN X
 */
public class RegisterOrganizationTest {
    
    public RegisterOrganizationTest() {
    }

    @Test
    public void testAddOrganization() {
       System.out.println("addOrganization");
        Organization oOrganizacao = new Organization();
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = true;
        boolean result = instance.addOrganization(oOrganizacao);
        assertEquals(expResult, result);
    }

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

    @Test
    public void testValidateOrganization() {
        System.out.println("validateOrganization");
        Organization org = new Organization();
        RegisterOrganization instance = new RegisterOrganization();
        boolean expResult = true;
        boolean result = instance.validateOrganization(org);
        assertEquals(expResult, result);
    }

    @Test
    public void testMeanTaskDelayBetterThan3() {
        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 3;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));

        Task task2 = new Task("102", "task2", 12, 20, "Programming2", true, true);
        Freelancer free2 = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate2 = new Date(2020, 07, 01);
        double delay2 = 4;
        String qow2 = "Very good";
        CurrencyConverter cc2 = new CurrencyConverter();
        double valueE2 = task.getCostHour() * task.getTimeTask();
        double valueC2 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans2 = new TransactionExecution(task2, free2, endDate2, delay2, qow2, new Payment(valueE2, valueC2));

        List<TransactionExecution> lt = new ArrayList<>();
        lt.add(trans);
        lt.add(trans2);
        RegisterOrganization instance = new RegisterOrganization();

        Freelancer free = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));

        boolean expResult = true;
        boolean result = instance.meanTaskDelayBetterThan3(free, lt);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testMeanTaskDelayBetterThan3_2() {
        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 1;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));

        Task task2 = new Task("102", "task2", 12, 20, "Programming2", true, true);
        Freelancer free2 = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate2 = new Date(2020, 07, 01);
        double delay2 = -1;
        String qow2 = "Very good";
        CurrencyConverter cc2 = new CurrencyConverter();
        double valueE2 = task.getCostHour() * task.getTimeTask();
        double valueC2 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans2 = new TransactionExecution(task2, free2, endDate2, delay2, qow2, new Payment(valueE2, valueC2));

        List<TransactionExecution> lt = new ArrayList<>();
        lt.add(trans);
        lt.add(trans2);
        RegisterOrganization instance = new RegisterOrganization();

        Freelancer free = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));

        boolean expResult = false;
        boolean result = instance.meanTaskDelayBetterThan3(free, lt);
        assertEquals(expResult, result);
    }

    @Test
    public void testPercentageOfDelays() {
        System.out.println("percentageOfDelays");
        Freelancer free = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
       
        RegisterOrganization instance = new RegisterOrganization();
        
        Organization org = new Organization("ISEP", "123456789", "isep@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Ricardo Pereira", "ricky@gmail.com", "a"), new Manager("Antonio Gomes", "x@gmail.com", "a"));
        Organization org2 = new Organization("ISEP2", "123451789", "isep1@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Ricardo Pereira", "roro@gmail.com", "a"), new Manager("Antonio Gomes", "x@gmail.com", "a"));
        List<Organization> lOrg = new ArrayList<>();
        lOrg.add(org);
        lOrg.add(org2);
        List<TransactionExecution> ltr = lOrg.get(0).getRTrans().getTransactions();
        List<TransactionExecution> ltr2 = lOrg.get(0).getRTrans().getTransactions();

        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 4;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));

        Task task2 = new Task("102", "task2", 12, 20, "Programming2", true, true);
        Freelancer free2 = new Freelancer("Jose Michel", "Senior", "michel@gmail.com", "113456789", "PT125478965478965652", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate2 = new Date(2020, 07, 01);
        double delay2 = 0.5;
        String qow2 = "Very good";
        CurrencyConverter cc2 = new CurrencyConverter();
        double valueE2 = task.getCostHour() * task.getTimeTask();
        double valueC2 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans2 = new TransactionExecution(task2, free2, endDate2, delay2, qow2, new Payment(valueE2, valueC2));

        Task task3 = new Task("103", "task1", 12, 20, "Programming", true, true);
        Freelancer freel3 = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate3 = new Date(2020, 07, 01);
        double delay3 = 2;
        String qow3 = "Very good";
        CurrencyConverter cc3 = new CurrencyConverter();
        double valueE3 = task.getCostHour() * task.getTimeTask();
        double valueC3 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans3 = new TransactionExecution(task3, freel3, endDate3, delay3, qow3, new Payment(valueE3, valueC));

        Task task4 = new Task("104", "task2", 12, 20, "Programming2", true, true);
        Freelancer free4 = new Freelancer("Jose Michel", "Senior", "michel@gmail.com", "113456789", "PT125478965478965652", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate4 = new Date(2020, 07, 01);
        double delay4 = 1;
        String qow4 = "Very good";
        CurrencyConverter cc4 = new CurrencyConverter();
        double valueE4 = task.getCostHour() * task.getTimeTask();
        double valueC4 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans4 = new TransactionExecution(task4, free4, endDate4, delay4, qow4, new Payment(valueE4, valueC4));

        ltr.add(trans);
        ltr.add(trans2);
        ltr2.add(trans3);
        ltr2.add(trans4);

       
        double expResult = 50.0;
        double result = instance.percentageOfDelays(free,lOrg);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testOverallPercentageDelays() {
        Organization org = new Organization("ISEP", "123456789", "isep@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Ricardo Pereira", "ricky@gmail.com", "a"), new Manager("Antonio Gomes", "x@gmail.com", "a"));
        Organization org2 = new Organization("ISEP2", "123451789", "isep1@gmail.com", new Address("street", "123", "Porto"), new Collaborator("Ricardo Pereira", "roro@gmail.com", "a"), new Manager("Antonio Gomes", "x@gmail.com", "a"));
        List<Organization> lOrg = new ArrayList<>();
        lOrg.add(org);
        lOrg.add(org2);
        List<TransactionExecution> ltr = lOrg.get(0).getRTrans().getTransactions();
        List<TransactionExecution> ltr2 = lOrg.get(0).getRTrans().getTransactions();

        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 4;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));

        Task task2 = new Task("102", "task2", 12, 20, "Programming2", true, true);
        Freelancer free2 = new Freelancer("Jose Michel", "Senior", "michel@gmail.com", "113456789", "PT125478965478965652", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate2 = new Date(2020, 07, 01);
        double delay2 = 0.5;
        String qow2 = "Very good";
        CurrencyConverter cc2 = new CurrencyConverter();
        double valueE2 = task.getCostHour() * task.getTimeTask();
        double valueC2 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans2 = new TransactionExecution(task2, free2, endDate2, delay2, qow2, new Payment(valueE2, valueC2));

        Task task3 = new Task("103", "task1", 12, 20, "Programming", true, true);
        Freelancer freel3 = new Freelancer("Jose Manuel23", "Junior23", "jose2@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate3 = new Date(2020, 07, 01);
        double delay3 = 2;
        String qow3 = "Very good";
        CurrencyConverter cc3 = new CurrencyConverter();
        double valueE3 = task.getCostHour() * task.getTimeTask();
        double valueC3 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans3 = new TransactionExecution(task3, freel3, endDate3, delay3, qow3, new Payment(valueE3, valueC));

        Task task4 = new Task("104", "task2", 12, 20, "Programming2", true, true);
        Freelancer free4 = new Freelancer("Jose Michel", "Senior", "michel@gmail.com", "113456789", "PT125478965478965652", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate4 = new Date(2020, 07, 01);
        double delay4 = 1;
        String qow4 = "Very good";
        CurrencyConverter cc4 = new CurrencyConverter();
        double valueE4 = task.getCostHour() * task.getTimeTask();
        double valueC4 = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans4 = new TransactionExecution(task4, free4, endDate4, delay4, qow4, new Payment(valueE4, valueC4));

        ltr.add(trans);
        ltr.add(trans2);
        ltr2.add(trans3);
        ltr2.add(trans4);

        RegisterOrganization instance = new RegisterOrganization();
        double expResult = 25.0;
        double result = instance.overallPercentageDelays(lOrg);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testRegisterOrganization() throws Exception {
        System.out.println("registerOrganization");
        RegisterOrganization instance = new RegisterOrganization();
        Organization org = instance.newOrganization("ISEP", "123456789", "isep@gmail.com", "street", "123", "Porto", "Antonio Gomes", "x@gmail.com", "Ricardo Pereira", "r@gmail.com");
        boolean expResult = true;
        boolean result = instance.registerOrganization(org);
        assertEquals(expResult, result);
    }

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

    
}
