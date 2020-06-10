/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CurrencyConverter;
import Utils.Date;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OMEN X
 */
public class RegisterTransactionTest {

    @Test
    public void testRemoveHistoricalTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = false;
        boolean result = instance.removeHistoricalTransaction(trans);
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
        RegisterTransaction instance = new RegisterTransaction();

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
        RegisterTransaction instance = new RegisterTransaction();

        Freelancer free = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));

        boolean expResult = false;
        boolean result = instance.meanTaskDelayBetterThan3(free, lt);
        assertEquals(expResult, result);
    }

    @Test
    public void testPercentageOfDelays() {
        System.out.println("percentageOfDelays");
        Freelancer free = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
       
        RegisterTransaction instance = new RegisterTransaction();
        
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

        RegisterTransaction instance = new RegisterTransaction();
        double expResult = 25.0;
        double result = instance.overallPercentageDelays(lOrg);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testValidateHistoricalTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", true, true);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
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
        List<TransactionExecution> lt = new ArrayList<TransactionExecution>();
        lt.add(trans);
        lt.add(trans2);
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = true;
        boolean result = instance.validateHistoricalTransaction(lt);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateNewTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", false, false);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        RegisterTransaction instance = new RegisterTransaction();
        TransactionExecution expResult = new TransactionExecution(task, freel, endDate, delay, qow);
        TransactionExecution result = instance.createNewTransaction(task, freel, endDate, delay, qow);
        assertEquals(expResult, result);

    }

    @Test
    public void testRegisterTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", false, false);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow);
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = true;
        boolean result = instance.registerTransaction(trans);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", false, false);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = true;
        boolean result = instance.validateTransaction(trans);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTransaction() {
        Task task = new Task("101", "task1", 12, 20, "Programming", false, false);
        Freelancer freel = new Freelancer("Jose Manuel", "Junior", "jose@gmail.com", "123456789", "PT125478965478965412", "Portugal", new Address("rua do bosque", "12", "bosque"));
        Date endDate = new Date(2020, 07, 01);
        double delay = 0.5;
        String qow = "Very good";
        CurrencyConverter cc = new CurrencyConverter();
        double valueE = task.getCostHour() * task.getTimeTask();
        double valueC = cc.convert(valueE, freel.getCountry());
        TransactionExecution trans = new TransactionExecution(task, freel, endDate, delay, qow, new Payment(valueE, valueC));
        RegisterTransaction instance = new RegisterTransaction();
        boolean expResult = true;
        boolean result = instance.addTransaction(trans);
        assertEquals(expResult, result);
    }

}
