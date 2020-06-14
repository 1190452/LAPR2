/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.TransactionExecution;
import java.util.Comparator;

/**
 *
 * @author 
 */

/*Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>*/

public class SortByPaymentValue implements Comparator<TransactionExecution>{

    @Override
    public int compare(TransactionExecution o1, TransactionExecution o2) {
        if(o1.getPayment().getValueE() < o2.getPayment().getValueE()){
            return 1;
        }
        else if(o1.getPayment().getValueE() == o2.getPayment().getValueE()){
            return 0;
        }else{
            return -1;
        }
    }
    
}
