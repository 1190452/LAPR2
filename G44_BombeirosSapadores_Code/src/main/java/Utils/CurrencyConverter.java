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
                return valueE*1.1194;
                    
            case ("united kingdom"):
                return valueE*0.8907;
                    
            case ("switzerland"):
                return valueE*1.0793;
                
            case ("canada"):
                return valueE*1.5173;
            
            case ("australia"):
                return valueE*1.6280;
            
            case ("japan"):
                return valueE*123.77;
                
            default:
                return valueE;
                
            
        }
        
    }
    
}
