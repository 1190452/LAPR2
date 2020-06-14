/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Freelancer;
import Model.TransactionExecution;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class SortList implements Serializable {

    public List<Freelancer> sortByName(List<Freelancer> lfree) {
        int size = lfree.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (lfree.get(i).getName().compareTo(lfree.get(j).getName()) > 0) {
                    Collections.swap(lfree, i, j);
                }
            }
        }
        return lfree;
    }

    public List<Freelancer> sortByPaymentValue(List<Freelancer> lfree, List<TransactionExecution> ltr) {
      List<Freelancer> orderedFreelancers = new ArrayList<>();
       SortByPaymentValue c = new SortByPaymentValue();
       Collections.sort(ltr,c);
        for (int i = 0; i < ltr.size(); i++) {
            if(!orderedFreelancers.contains(ltr.get(i).getFreel())){
                  orderedFreelancers.add(ltr.get(i).getFreel());
            }
          
        }
       
        return orderedFreelancers;
    }
    

}
