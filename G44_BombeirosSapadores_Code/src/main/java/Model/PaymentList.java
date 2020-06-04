/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tiagopereira
 */
public class PaymentList {
    private List<Payment> paymentList;

    public PaymentList() {
        paymentList = new ArrayList<>();
    }
    
    public PaymentList(Set<Payment> l){
        paymentList = new ArrayList<>(l);
        
    }
    
    public void addPayment(Payment t){
       paymentList.add(t);
   }
   
   public void removePayment(Payment t){
       paymentList.remove(t);
   }
   
   public List<Payment> getPaymentList(){
       return paymentList;
   }
}
