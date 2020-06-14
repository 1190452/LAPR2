package Utils;

import java.io.Serializable;

/**
 *
 * @author 
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
            case ("united states of america"):    
                return valueE*1.1194;
                    
            case ("united kingdom"):
            case ("uk"):
                return valueE*0.8907;
                    
            case ("switzerland"):
            case ("ch"):
                return valueE*1.0793;
                
            case ("canada"):
            case ("ca"):
                return valueE*1.5173;
            
            case ("australia"):
            case ("au"):
                return valueE*1.6280;
            
            case ("japan"):
            case ("jp"):
                return valueE*123.77;
                
            default:
                return valueE;
                
            
        }
        
    }
    
}
