/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.Validations.isIBANValid;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class ValidationsTest {
    
    @Test
    public void testValidationTest() {
        
    }
    
    /**
     * Test of isNumeric method, of class Validations.
     */
    @Test
    public void testIsNumeric() {
        String strNum = "1254";
        boolean expResult = true;
        boolean result = Validations.isNumeric(strNum);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNumeric method, of class Validations.
     */
    @Test
    public void testIsNumeric2() {
        String strNum = "abc";
        boolean expResult = false;
        boolean result = Validations.isNumeric(strNum);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmailValid method, of class Validations.
     */
    @Test
    public void testIsEmailValid() {
        String email = "jw@gmail.com";
        boolean expResult = true;
        boolean result = Validations.isEmailValid(email);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isEmailValid method, of class Validations.
     */
    @Test
    public void testIsEmailValid2() {
        String email = "jwgmail.com";
        boolean expResult = false;
        boolean result = Validations.isEmailValid(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid() {
        String NIF = "921654987";
        boolean expResult = true;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid2() {
        String NIF = "921654987234";
        boolean expResult = false;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLocalityValid method, of class Validations.
     */
    @Test
    public void testIsLocalityValid() {
        String locality = "Mem-Martins";
        boolean expResult = true;
        boolean result = Validations.isLocalityValid(locality);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLocalityValid method, of class Validations.
     */
    @Test
    public void testIsLocalityValid2() {
        String locality = "4950";
        boolean expResult = false;
        boolean result = Validations.isLocalityValid(locality);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNameValid method, of class Validations.
     */
    @Test
    public void testIsNameValid() {
        String name = "Albertina Macacao";
        boolean expResult = true;
        boolean result = Validations.isNameValid(name);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isNameValid method, of class Validations.
     */
    @Test
    public void testIsNameValid2() {
        String name = "q8ajz";
        boolean expResult = false;
        boolean result = Validations.isNameValid(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isIBANValid method, of class Validations.
     */
    @Test
    public void testIsIBANValid() {
        System.out.println("isIBANValid");
        String iban = "PT4LOLOLLLLLOOOOKIPO";
        boolean expResult = false;
        boolean result = isIBANValid(iban);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsIBANValid2() {
        System.out.println("isIBANValid");
        String iban = "PT120010001234567891";
        boolean expResult = true;
        boolean result = isIBANValid(iban);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDoorNumberValid method, of class Validations.
     */
    @Test
    public void testIsDoorNumberValid() {
        String doorNumber = "55";
        boolean expResult = true;
        boolean result = Validations.isDoorNumberValid(doorNumber);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isDoorNumberValid method, of class Validations.
     */
    @Test
    public void testIsDoorNumberValid2() {
        String doorNumber = "bba";
        boolean expResult = false;
        boolean result = Validations.isDoorNumberValid(doorNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStreetValid method, of class Validations.
     */
    @Test
    public void testIsStreetValid() {
        System.out.println("isStreetValid");
        String street = "Rua Maria da Assunção";
        boolean expResult = true;
        boolean result = Validations.isStreetValid(street);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStreetValid method, of class Validations.
     */
    @Test
    public void testIsStreetValid2() {
        System.out.println("isStreetValid");
        String street = "9281";
        boolean expResult = false;
        boolean result = Validations.isStreetValid(street);
        assertEquals(expResult, result);
    }
    
}
