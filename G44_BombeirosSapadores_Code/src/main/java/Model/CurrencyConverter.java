/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ricardo
 */
public class CurrencyConverter {

    public CurrencyConverter(){
        
    }
    
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
                return valueE*121.5400;
                
            default:
                return valueE;
                
            
        }
        
    }
    
}
