/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.TransactionExecution;
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
        Map.Entry<String, CustomValue> expResult = null;
        Map.Entry<String, CustomValue> result = instance.getPaymentDeviationOfEachFreelancer(ltr, emailF);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTaskExecutionDelayOfEachFreelancer() {
        System.out.println("getTaskExecutionDelayOfEachFreelancer");
        List<TransactionExecution> ltr = null;
        String emailF = "";
        Statistic instance = new Statistic();
        Map.Entry<String, CustomValue> expResult = null;
        Map.Entry<String, CustomValue> result = instance.getTaskExecutionDelayOfEachFreelancer(ltr, emailF);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTaskExecutionDelayOfAllFreelancers() {
        System.out.println("getTaskExecutionDelayOfAllFreelancers");
        List<TransactionExecution> ltr = null;
        Statistic instance = new Statistic();
        Map.Entry<String, CustomValue> expResult = null;
        Map.Entry<String, CustomValue> result = instance.getTaskExecutionDelayOfAllFreelancers(ltr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPaymentDeviationOfAllFreelancers() {
        System.out.println("getPaymentDeviationOfAllFreelancers");
        List<TransactionExecution> ltr = null;
        Statistic instance = new Statistic();
        Map.Entry<String, CustomValue> expResult = null;
        Map.Entry<String, CustomValue> result = instance.getPaymentDeviationOfAllFreelancers(ltr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
