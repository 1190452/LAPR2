/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Address;
import Model.Freelancer;
import Model.Payment;
import Model.Task;
import Model.TransactionExecution;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OMEN X
 */
public class StatisticTest {

    public StatisticTest() {
    }

    @Test
    public void testGetPaymentDeviationOfEachFreelancer() {
        System.out.println("getPaymentDeviationOfEachFreelancer");
        List<TransactionExecution> ltr = null;
        String emailF = "";
        Statistic instance = new Statistic();
        CustomValue c = new CustomValue();
        Map.Entry<String, CustomValue> expResult = null;
        Map.Entry<String, CustomValue> result = instance.getPaymentDeviationOfEachFreelancer(ltr, emailF);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPaymentDeviationOfEachFreelancerWithData() {
        System.out.println("getPaymentDeviationOfEachFreelancer");
        List<TransactionExecution> ltr = new ArrayList<>();
        ltr.add(new TransactionExecution(1, new Task("1", "fvfdgd", 5, 2, "dfsfs", true, true), new Freelancer("12", "Joao Andrade", "Junior", "joao@gmail.com", "123456789", "PT908654099090907654", "Portugal", new Address("Av24", "25", "espinho")), new Date(2020, 12, 4), 2, "fdsgfsfs", new Payment(10, 10)));
        String emailF = "joao@gmail.com";
        Statistic instance = new Statistic();
        CustomValue c = new CustomValue();
        c.setMean(10);
        c.setDeviation(0);
        c.setLeftDev(1);
        c.setMiddleDev(0);
        c.setRightDev(1);
        Map.Entry<String, CustomValue> expResult = new AbstractMap.SimpleEntry<>("Joao Andrade", c);
        Map.Entry<String, CustomValue> result = instance.getPaymentDeviationOfEachFreelancer(ltr, emailF);
        assertEquals(expResult.getKey(), result.getKey());
        assertEquals(expResult.getValue(), result.getValue());

    }

    @Test
    public void testGetTaskExecutionDelayOfEachFreelancer() {
        System.out.println("getTaskExecutionDelayOfEachFreelancer");
        List<TransactionExecution> ltr = new ArrayList<>();
        ltr.add(new TransactionExecution(1, new Task("1", "fvfdgd", 5, 2, "dfsfs", true, true), new Freelancer("12", "Joao Andrade", "Junior", "joao@gmail.com", "123456789", "PT908654099090907654", "Portugal", new Address("Av24", "25", "espinho")), new Date(2020, 12, 4), 2, "fdsgfsfs", new Payment(10, 10)));
        String emailF = "joao@gmail.com";
        Statistic instance = new Statistic();
        CustomValue c = new CustomValue();
        c.setMean(2);
        c.setDeviation(0);
        c.setLeftDev(1);
        c.setMiddleDev(0);
        c.setRightDev(1);
        Map.Entry<String, CustomValue> expResult = new AbstractMap.SimpleEntry<>("Joao Andrade", c);
        Map.Entry<String, CustomValue> result = instance.getTaskExecutionDelayOfEachFreelancer(ltr, emailF);
        assertEquals(expResult.getKey(), result.getKey());
        assertEquals(expResult.getValue(), result.getValue());
    }

    @Test
    public void testGetTaskExecutionDelayOfAllFreelancers() {
        System.out.println("getTaskExecutionDelayOfAllFreelancers");
        List<TransactionExecution> ltr = new ArrayList<>();
        ltr.add(new TransactionExecution(1, new Task("1", "fvfdgd", 5, 2, "dfsfs", true, true), new Freelancer("12", "Joao Andrade", "Junior", "joao@gmail.com", "123456789", "PT908654099090907654", "Portugal", new Address("Av24", "25", "espinho")), new Date(2020, 12, 4), 2, "fdsgfsfs", new Payment(10, 10)));
        ltr.add(new TransactionExecution(2, new Task("2", "fsfsfs", 7, 2, "dsfsf", true, true), new Freelancer("13", "Gustavo Silva", "Senior", "gustavo@gmail.com", "125678980", "PT908654099090902344", "Portugal", new Address("Av29", "207", "espinho")), new Date(2020, 12, 17), 6, "fdsgfsfs", new Payment(14, 14)));
        Statistic instance = new Statistic();
        CustomValue c = new CustomValue();
        c.setMean(4);
        c.setDeviation(8);
        c.setLeftDev(0);
        c.setMiddleDev(2);
        c.setRightDev(0);
        Map.Entry<String, CustomValue> expResult = new AbstractMap.SimpleEntry<>("Task Delay of All Freelancers", c);
        Map.Entry<String, CustomValue> result = instance.getTaskExecutionDelayOfAllFreelancers(ltr);
        assertEquals(expResult.getKey(), result.getKey());
        assertEquals(expResult.getValue(), result.getValue());
    }

    @Test
    public void testGetPaymentDeviationOfAllFreelancers() {
        System.out.println("getPaymentDeviationOfAllFreelancers");
        List<TransactionExecution> ltr = new ArrayList<>();
        ltr.add(new TransactionExecution(1, new Task("1", "fvfdgd", 5, 2, "dfsfs", true, true), new Freelancer("12", "Joao Andrade", "Junior", "joao@gmail.com", "123456789", "PT908654099090907654", "Portugal", new Address("Av24", "25", "espinho")), new Date(2020, 12, 4), 2, "fdsgfsfs", new Payment(10, 10)));
        ltr.add(new TransactionExecution(2, new Task("2", "fsfsfs", 7, 2, "dsfsf", true, true), new Freelancer("13", "Gustavo Silva", "Senior", "gustavo@gmail.com", "125678980", "PT908654099090902344", "Portugal", new Address("Av29", "207", "espinho")), new Date(2020, 12, 17), 6, "fdsgfsfs", new Payment(14, 14)));
        Statistic instance = new Statistic();
        CustomValue c = new CustomValue();
        c.setMean(12);
        c.setDeviation(8);
        c.setLeftDev(0);
        c.setMiddleDev(2);
        c.setRightDev(0);
        Map.Entry<String, CustomValue> expResult = new AbstractMap.SimpleEntry<>("Payment Deviation of All Freelancers", c);;
        Map.Entry<String, CustomValue> result = instance.getPaymentDeviationOfAllFreelancers(ltr);
        assertEquals(expResult.getKey(), result.getKey());
        assertEquals(expResult.getValue(), result.getValue());

    }

}
