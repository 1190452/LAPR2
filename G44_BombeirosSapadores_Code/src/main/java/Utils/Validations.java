/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author OMEN X
 */
public class Validations {
    
    /**
     * method to confirm if a String is numeric or not
     * @param strNum
     * @return 
     */
    public static boolean isNumeric(String strNum) {
        boolean ret = true;
        try {

            Integer.parseInt(strNum);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
    /**
     * method to confirm if email is valid
     * @param email
     * @return 
     */
    //taken from https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    public static boolean isEmailValid(String email) {
       String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
        return email.matches(regex);
    }
    
    /**
     * method that validates if a NIF is valid
     * @param NIF
     * @return 
     */
    public static boolean isNIFValid(String NIF) {
        if (NIF != null && !NIF.isEmpty() && NIF.length() == 9 && isNumeric(NIF) == true && Integer.parseInt(NIF) > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * method to validate if a locality is valid
     * @param locality
     * @return 
     */
    public static boolean isLocalityValid(String locality){
        if(locality != null && !locality.isEmpty() && isNumeric(locality) == false){
            return true;
        }
        return false;
    }
    
    
    public static boolean isNameValid(String name) {
        String regex = "^[A-Z][a-z]{2,}(?: [A-Z][a-z]*)*$";
        return name.matches(regex);
    }
    
    
}