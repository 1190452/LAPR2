package Utils;

import java.io.Serializable;

/**
 *
 * @author OMEN X
 */
public class Validations implements Serializable{

    /**
     * method to confirm if a String is numeric or not
     *
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
     *
     * @param email
     * @return
     */
    //taken from https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    public static boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        return email.matches(regex);
    }

    /**
     * method that validates if a NIF is valid
     *
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
     *
     * @param locality
     * @return
     */
    public static boolean isLocalityValid(String locality) {
        if (locality != null && !locality.isEmpty() && isNumeric(locality) == false) {
            return true;
        }
        return false;
    }

    /**
     * method to confirm is a door number is valid
     * @param doorNumber
     * @return 
     */
    public static boolean isDoorNumberValid(String doorNumber) {
        if (doorNumber != null && !doorNumber.isEmpty() && isNumeric(doorNumber) == true) {
            return true;
        }
        return false;
    }
    
    /**
     * method to confirm if a street is valid
     * @param street
     * @return 
     */
    public static boolean isStreetValid(String street){
        if (street != null && !street.isEmpty() && isNumeric(street) == false) {
            return true;
        }
        return false;
    }

    /**
     * method to confirm if a name is valid
     * @param name
     * @return 
     */
    public static boolean isNameValid(String name) {
        return name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
    }
    
    public static boolean isNameValid2(String name) {
   
        String[] nameparts = name.split(" ");
        
        if(nameparts.length == 2) {
            return true;
        }
        else
            return false;
    }

    /**
     * methos to confirm if an IBAN is valid
     * @param iban
     * @return 
     */
    public static boolean isIBANValid(String iban) {
        int cont = 0;
        if (iban.length() == 20 && iban != null && !iban.isEmpty()) {
            for (int i = 2; i < iban.length(); i++) {
                if (Character.isAlphabetic(iban.charAt(0)) && Character.isAlphabetic(iban.charAt(1)) && Character.isDigit(iban.charAt(i))) {
                    cont++;
                }
            }
            if (cont == iban.length() - 2) {
                return true;
            }
        }
        return false;
    }
    

}
