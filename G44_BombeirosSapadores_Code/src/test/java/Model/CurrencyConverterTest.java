/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CurrencyConverter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class CurrencyConverterTest {
    
    public CurrencyConverterTest() {
    }

    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertUSA() {
        System.out.println("convert");
        double valueE = 10;
        String country = "usa";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 11.194;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertUK() {
        System.out.println("convert");
        double valueE = 10;
        String country = "united kingdom";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 8.907;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertSW() {
        System.out.println("convert");
        double valueE = 10;
        String country = "switzerland";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 10.793;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertCA() {
        System.out.println("convert");
        double valueE = 10;
        String country = "canada";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 15.173;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertAU() {
        System.out.println("convert");
        double valueE = 10;
        String country = "australia";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 16.28;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertJP() {
        System.out.println("convert");
        double valueE = 10;
        String country = "japan";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 1237.7;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvertDefault() {
        System.out.println("convert");
        double valueE = 10;
        String country = "France";
        CurrencyConverter instance = new CurrencyConverter();
        double expResult = 10;
        double result = instance.convert(valueE, country);
        assertEquals(expResult, result, 0.01);
    }
    
}
