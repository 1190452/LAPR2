/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Calendar;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class TimeTest {
    
    public TimeTest() {
    }
    
    
    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Time instance = new Time(14,18);
        int expResult = 14;
        int result = instance.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Time instance = new Time(10,25);
        int expResult = 25;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeconds method, of class Time.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        Time instance = new Time(12,13,55);
        int expResult = 55;
        int result = instance.getSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHours method, of class Time.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        int hours = 4;
        Time instance = new Time();
        instance.setHours(hours);
        assertEquals(hours, instance.getHours());
    }

    /**
     * Test of setMinutes method, of class Time.
     */
    @Test
    public void testSetMinutes() {
        System.out.println("setMinutes");
        int minutes = 33;
        Time instance = new Time();
        instance.setMinutes(minutes);
        assertEquals(minutes, instance.getMinutes());
    }

    /**
     * Test of setSeconds method, of class Time.
     */
    @Test
    public void testSetSeconds() {
        System.out.println("setSeconds");
        int seconds = 29;
        Time instance = new Time();
        instance.setSeconds(seconds);
        assertEquals(seconds, instance.getSeconds());
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_3args() {
        System.out.println("setTime");
        int hours = 13;
        int minutes = 30;
        int seconds = 31;
        Time teste = new Time(hours, minutes, seconds);
        Time instance = new Time();
        instance.setTime(hours, minutes, seconds);
        assertEquals(instance, teste);
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_int() {
        System.out.println("setTime");
        int hours = 14;
        Time instance = new Time();
        instance.setTime(hours);
        assertEquals(hours, instance.getHours());
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_int_int() {
        System.out.println("setTime");
        int hours = 4;
        int minutes = 20;
        Time teste = new Time(4,20);
        Time instance = new Time();
        instance.setTime(hours, minutes);
        assertEquals(teste, instance);
    }

    /**
     * Test of toString method, of class Time.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Time instance = new Time(4,20,30);
        String expResult = "04:20:30 AM";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringHHMM method, of class Time.
     */
    @Test
    public void testToStringHHMM() {
        System.out.println("toStringHHMMSS");
        Time instance = new Time(4,20);
        String expResult = "04:20";
        String result = instance.toStringHHMM();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals() {
        System.out.println("equals : same reference");
        Object anotherObject = new Time();
        Time instance = new Time();
        instance = (Time) anotherObject;
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals : null object");
        Object anotherObject = null;
        Time instance = new Time();
        boolean expResult = false;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals : objects from different classes");
        Object anotherObject = new Object();
        Time instance = new Time();
        boolean expResult = false;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals : objects are equal");
        Object anotherObject = new Time(12,12,12);
        Time instance = new Time(12,12,12);
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo : parameter time is equal to time calling");
        Time anotherTime = new Time(12,13,14);
        Time instance = new Time(12,13,14);
        int expResult = 0;
        int result = instance.compareTo(anotherTime);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo : parameter date is later than the time calling");
        Time anotherTime = new Time(14,15,16);
        Time instance = new Time(12,13,14);
        int expResult = -1;
        int result = instance.compareTo(anotherTime);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo : parameter date is earlier than the time calling");
        Time anotherTime = new Time(14,15,16);
        Time instance = new Time(16,17,18);
        int expResult = 1;
        int result = instance.compareTo(anotherTime);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_Time() {
        System.out.println("isGreater : no");
        Time anotherTime = new Time(12,13,14);
        Time instance = new Time(9,10,11);
        boolean expResult = false;
        boolean result = instance.isGreater(anotherTime);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_Time2() {
        System.out.println("isGreater : yes");
        Time anotherTime = new Time(12,13,14);
        Time instance = new Time(13,14,15);
        boolean expResult = true;
        boolean result = instance.isGreater(anotherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_3args() {
        System.out.println("isGreater : no");
        int hours = 10;
        int minutes = 30;
        int seconds = 50;
        Time instance = new Time(8,9,5);
        boolean expResult = false;
        boolean result = instance.isGreater(hours, minutes, seconds);
        assertEquals(expResult, result);
    }

    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_3args2() {
        System.out.println("isGreater : yes");
        int hours = 10;
        int minutes = 30;
        int seconds = 50;
        Time instance = new Time(11,9,5);
        boolean expResult = true;
        boolean result = instance.isGreater(hours, minutes, seconds);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of differenceInSeconds method, of class Time.
     */
    @Test
    public void testDifferenceInSeconds() {
        System.out.println("differenceInSeconds");
        Time anotherTime = new Time(12,0,0);
        Time instance = new Time(13,0,0);
        int expResult = 3600;
        int result = instance.differenceInSeconds(anotherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of differenceInTime method, of class Time.
     */
    @Test
    public void testDifferenceInTime() {
        System.out.println("differenceInTime");
        Time anotherTime = new Time(12,13,30);
        Time instance = new Time(13,15,40);
        Time expResult = new Time(1,2,10);
        Time result = instance.differenceInTime(anotherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of actualTime method, of class Time.
     */
    @Test
    public void testActualTime() {
        System.out.println("actualTime");
        Calendar now = Calendar.getInstance();
        Time expResult = new Time(now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),now.get(Calendar.SECOND));
        Time result = Time.actualTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of toSeconds method, of class Time.
     */
    @Test
    public void testToSeconds() {
        System.out.println("toSeconds");
        Time instance = new Time(1,0,0);
        int expResult = 3600;
        int result = instance.toSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of toMinutes method, of class Time.
     */
    @Test
    public void testToMinutes() {
        System.out.println("toMinutes");
        Time instance = new Time(1,0,0);
        int expResult = 216000;
        int result = instance.toMinutes();
        assertEquals(expResult, result);
    }
    
}
