package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Receipt implements Serializable{
    
    /**
     * transaction list of teh receipt
     */
    private List<Transaction> nltr;
    
    /**
     * sum (total value) of the receipt in euros
     */
    private double sum;
    
    /**
     * total value of the receipt in the currency of the freelancer country
     */
    private double curr;
    
    /**
     * constructor that creates an instance of receipt
     * @param nltr
     * @param valueE
     * @param valueC 
     */
    public Receipt(List<Transaction> nltr, double valueE, double valueC){
        this.nltr=nltr;
        this.sum=valueE;
        this.curr=valueC;  
    }

    /**
     * method that call the writer to generate an email with the receipt
     */
    public void genEmail(){
        
        Writer.genEmail(nltr, sum, sum);
    }
    
    
    
}
