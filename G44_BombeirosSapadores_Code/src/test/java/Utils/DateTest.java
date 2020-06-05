/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class DateTest {
    
    public DateTest() {
    }

    /**
     * Test of getYear method, of class Date.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Date instance = new Date(2019,10,10);
        int expResult = 2019;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Date.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Date instance = new Date(2019,10,10);
        int expResult = 10;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Date.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Date instance = new Date(2019,10,20);
        int expResult = 20;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate method, of class Date.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        int year = 2019;
        int month = 10;
        int day = 11;
        Date teste = new Date(year,month,day);
        Date instance = new Date();
        instance.setDate(year, month, day);
        assertEquals(instance, teste);
        
    }

    /**
     * Test of toString method, of class Date.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date instance = new Date(2019,6,11);
        String expResult = "Tuesday, 11 of June of 2019";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toYearMonthDayString method, of class Date.
     */
    @Test
    public void testToYearMonthDayString() {
        System.out.println("toYearMonthDayString");
        Date instance = new Date(2019,6,11);
        String expResult = "2019/06/11";
        String result = instance.toYearMonthDayString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals() {
        System.out.println("equals : same reference");
        Object anotherObject = new Date();
        Date instance = new Date();
        instance = (Date) anotherObject;
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals : null object");
        Object anotherObject = null;
        Date instance = new Date();
        boolean expResult = false;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals : objects from different classes");
        Object anotherObject = new Object();
        Date instance = new Date();
        boolean expResult = false;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals : objects are equal");
        Object anotherObject = new Date(2019,8,8);
        Date instance = new Date(2019,8,8);
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    /**
     * Test of compareTo method, of class Date.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo : parameter date is equal to date calling");
        Date anotherDate = new Date(2019,8,8);
        Date instance = new Date(2019,8,8);
        int expResult = 0;
        int result = instance.compareTo(anotherDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Date.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo : parameter date is later than the date calling");
        Date anotherDate = new Date(2019,10,10);
        Date instance = new Date(2019,8,8);
        int expResult = -1;
        int result = instance.compareTo(anotherDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Date.
     */
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo : parameter date is earlier than the date calling");
        Date anotherDate = new Date(2019,7,28);
        Date instance = new Date(2019,8,8);
        int expResult = 1;
        int result = instance.compareTo(anotherDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of weekDay method, of class Date.
     */
    @Test
    public void testWeekDay() {
        System.out.println("weekDay");
        Date instance = new Date(2019,6,11);
        String expResult = "Tuesday";
        String result = instance.weekDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of isGreater method, of class Date.
     */
    @Test
    public void testIsGreater() {
        System.out.println("isGreater");
        Date anotherDate = new Date(2019,6,11);
        Date instance = new Date(2019,9,9);
        boolean expResult = true;
        boolean result = instance.isGreater(anotherDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isGreater method, of class Date.
     */
    @Test
    public void testIsGreater2() {
        System.out.println("isGreater");
        Date anotherDate = new Date(2019,10,20);
        Date instance = new Date(2019,9,9);
        boolean expResult = false;
        boolean result = instance.isGreater(anotherDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Date.
     */
    @Test
    public void testDifference_Date() {
        System.out.println("difference");
        Date anotherDate = new Date(2019,7,1);
        Date instance = new Date(2019,7,31);
        int expResult = 30;
        int result = instance.difference(anotherDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Date.
     */
    @Test
    public void testDifference_3args() {
        System.out.println("difference");
        int year = 2019;
        int month = 7;
        int day = 31;
        Date instance = new Date(2019,7,1);
        int expResult = 30;
        int result = instance.difference(year, month, day);
        assertEquals(expResult, result);
    }

    /**
     * Test of leapYear method, of class Date.
     */
    @Test
    public void testLeapYear() {
        System.out.println("leapYear : leap year");
        int year = 2016;
        boolean expResult = true;
        boolean result = Date.leapYear(year);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of leapYear method, of class Date.
     */
    @Test
    public void testLeapYear2() {
        System.out.println("leapYear : non leap year");
        int year = 2017;
        boolean expResult = false;
        boolean result = Date.leapYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualDate method, of class Date.
     */
    @Test
    public void testActualDate() {
        System.out.println("actualDate");
        Calendar today = Calendar.getInstance();
        Date expResult = new Date(today.get(Calendar.YEAR),(today.get(Calendar.MONTH)+1),today.get(Calendar.DAY_OF_MONTH));
        Date result = Date.actualDate();
        assertEquals(expResult, result);
    }
    
}
