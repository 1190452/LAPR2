package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Receipt implements Serializable{
    
    private List<Transaction> nltr;
    private double sum;
    private double curr;
    
    public Receipt(List<Transaction> nltr, double valueE, double valueC){
        this.nltr=nltr;
        this.sum=valueE;
        this.curr=valueC;  
    }

    public void genEmail(){
        
        Writer.genEmail(nltr, sum, sum);
    }
    
    
    
}
