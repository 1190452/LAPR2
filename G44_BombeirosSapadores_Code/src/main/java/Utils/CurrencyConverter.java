package Utils;

import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
public class CurrencyConverter implements Serializable{

    /**
     * Empty constructor that creates an instance of CurrencyConverter
     */
    public CurrencyConverter(){
        
    }
    
    /**
     * Method used to convert currency values
     * @param valueE value in euros
     * @param country the country of origin
     * @return the value in the currency defined by the country
     */
    public double convert(double valueE, String country){
        
        switch(country.toLowerCase()){
            case ("usa"):
            case ("USA"):
            case ("United States of America"):    
                return valueE*1.1194;
                    
            case ("united kingdom"):
            case ("uk"):
            case ("UK"):
                return valueE*0.8907;
                    
            case ("switzerland"):
            case ("Switzerland"):
            case ("CH"):
                return valueE*1.0793;
                
            case ("canada"):
            case ("Canada"):
            case ("CA"):
                return valueE*1.5173;
            
            case ("australia"):
            case ("Australia"):
            case ("AU"):
                return valueE*1.6280;
            
            case ("japan"):
            case ("Japan"):
            case ("JP"):
                return valueE*123.77;
                
            default:
                return valueE;
                
            
        }
        
    }
    
}
