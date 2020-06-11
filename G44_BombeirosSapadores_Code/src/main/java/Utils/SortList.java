/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Freelancer;
import Model.TransactionExecution;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author tiagopereira
 */
public class SortList {

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
      
       SortByPaymentValue c = new SortByPaymentValue();
       Collections.sort(ltr,c);
       List<Object> lt =  ltr.stream().filter(distinctByKey(TransactionExecution::getFreel)).distinct().collect(Collectors.toList());
       
        return lfree;
    }
    
    //inspired in https://stackoverflow.com/questions/23699371/java-8-distinct-by-property
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
}
