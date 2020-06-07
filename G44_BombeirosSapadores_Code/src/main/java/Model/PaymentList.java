/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tiagopereira
 */
<<<<<<< HEAD
public class PaymentList implements Serializable{
=======
public class PaymentList {
    /**
     * list of payments
     */
>>>>>>> 8f43a82269b3d63fb10dd068602c8b30d5a25959
    private List<Payment> paymentList;

    /**
     * constructor that inicializes the payment list as an ArrayList
     */
    public PaymentList() {
        paymentList = new ArrayList<>();
    }

    /**
     * method that adds a new payment to the payment list
     * @param t 
     */
    public void addPayment(Payment t){
       paymentList.add(t);
   }
   
    /**
     * method that removes a payment from the payment list
     * @param t 
     */
   public void removePayment(Payment t){
       paymentList.remove(t);
   }
   
   /**
    * returns the list of payments
    * @return 
    */
   public List<Payment> getPaymentList(){
       return paymentList;
   }
}
