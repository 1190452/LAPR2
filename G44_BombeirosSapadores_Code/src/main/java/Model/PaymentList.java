package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */

public class PaymentList implements Serializable{

    /**
     * list of payments
     */

    private List<Payment> paymentList;

    /**
     * constructor that inicializes the payment list as an ArrayList
     */
    public PaymentList() {
        paymentList = new ArrayList<>();
    }

    //======================================================================================================================================================
    
    /**
     * method that adds a new payment to the payment list
     * @param t 
     */
    public boolean addPayment(Payment t){
       return  paymentList.add(t);
   }
   
    /**
     * method that removes a payment from the payment list
     * @param t 
     */
   public boolean removePayment(Payment t){
       return paymentList.remove(t);
   }
   
   //======================================================================================================================================================
   
   /**
    * returns the list of payments
    * @return 
    */
   public List<Payment> getPaymentList(){
       return paymentList;
   }
}
