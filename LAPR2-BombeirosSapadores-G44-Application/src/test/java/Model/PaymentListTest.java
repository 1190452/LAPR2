/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class PaymentListTest {


    /**
     * Test of addPayment method, of class PaymentList.
     */
    @Test
    public void testAddPayment() {
        System.out.println("addPayment");
        Payment t = new Payment();
        PaymentList instance = new PaymentList();
        instance.addPayment(t);
        boolean result = instance.addPayment(t);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
   
     
    }

    /**
     * Test of removePayment method, of class PaymentList.
     */
    @Test
    public void testRemovePayment() {
        System.out.println("removePayment");
        Payment t = new Payment();
        PaymentList instance = new PaymentList();
        instance.addPayment(t);
        boolean result = instance.removePayment(t);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
       }

    /**
     * Test of getPaymentList method, of class PaymentList.
     */
    @Test
    public void testGetPaymentList() {
        System.out.println("getPaymentList");
        PaymentList instance = new PaymentList();
        List<Payment> expResult = instance.getPaymentList();
        List<Payment> result = instance.getPaymentList();
        assertEquals(expResult, result);
    }

}
