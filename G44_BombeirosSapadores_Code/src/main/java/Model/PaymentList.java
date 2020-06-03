/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tiagopereira
 */
public class PaymentList {
    private Set<Payment> paymentList;

    public PaymentList() {
        paymentList = new HashSet<>();
    }
    
    public PaymentList(Set<Payment> l){
        paymentList = new HashSet<>(l);
        
    }
    
    public void addPayment(Payment t){
       paymentList.add(t);
   }
   
   public void removePayment(Payment t){
       paymentList.remove(t);
   }
   
   public Set<Payment> getPaymentList(){
       return paymentList;
   }
}
