package Utils;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author jorge
 */
public class Time implements Comparable<Time>,Serializable{
    
    /**
     * Hours of time.
     */
    private int hours;
    
    /**
     * Minutes of time.
     */
    private int minutes;
    
    /**
     * Seconds of time.
     */
    private int seconds;

    /**
     * Hours by default.
     */
    private static final int HOURS_BY_OMISSION = 0;
    
    /**
     * Minutes by default.
     */
    private static final int MINUTES_BY_OMISSION = 0;
    
    /**
     * Seconds by default.
     */
    private static final int SECONDS_BY_OMISSION = 0;

    /**
     * It builds a Time instance receiving the hours, the minutes and the
     * seconds.
     *
     * @param hours   time's hours.
     * @param minutes time's minutes.
     * @param seconds time's seconds.
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * It builds a Time instance receiving the hours and the minutes, 
     * assuming the seconds by default.
     *
     * @param hours   time's hours.
     * @param minutes time's minutes.
     */
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        seconds = SECONDS_BY_OMISSION;
    }

    /**
     * It builds a Time instance receiving the hours, and assuming the minutes
     * and the seconds, by default.
     *
     * @param hours time's hours.
     */
    public Time(int hours) {
        this.hours = hours;
        minutes = MINUTES_BY_OMISSION;
        seconds = SECONDS_BY_OMISSION;
    }

    /**
     * It builds a Time instance with the hours, minutes and seconds, by
     * default.
     */
    public Time() {
        hours = HOURS_BY_OMISSION;
        minutes = MINUTES_BY_OMISSION;
        seconds = SECONDS_BY_OMISSION;
    }

    /**
     * It builds a Time instance with the same characteristics of the time
     * received by parameter.
     *
     * @param anotherTime the time with the characteristics to copy from.
     */
    public Time(Time anotherTime) {
        hours = anotherTime.hours;
        minutes = anotherTime.minutes;
        seconds = anotherTime.seconds;
    }

    /**
     * It returns the time's hours.
     *
     * @return time's hours.
     */
    public int getHours() {
        return hours;
    }

    /**
     * It returns the time's minutes.
     *
     * @return time's minutes.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * It returns the time's seconds.
     *
     * @return time's seconds.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * It changes the time's hours.
     *
     * @param hours the new time's hours.
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * It changes the time's minutes.
     *
     * @param minutes the new time's minutes.
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * It changes the time's seconds.
     *
     * @param seconds the new time's seconds.
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * It changes the time's hours, minutes and seconds.
     *
     * @param hours   the new time's hours.
     * @param minutes the new time's minutes.
     * @param seconds the new time's seconds.
     */
    public void setTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    /**
     * It changes the time's hours
     * @param hours the new time's hours
     */
    public void setTime(int hours){
        this.hours = hours;
        minutes = MINUTES_BY_OMISSION;
        seconds = SECONDS_BY_OMISSION;
    }
    /**
     * It changes the time's hours and minutes
     * @param hours the new time's hours
     * @param minutes the new time's minutes
     */
    public void setTime(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
        seconds = SECONDS_BY_OMISSION;
    }

    /**
     * Returns the textual description of the time in the format:
     * %02d:%02d:%02d AM/PM.
     *
     * @return time's characteristics.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (hours == 12 || hours == 0) ? 12 : hours % 12,
                minutes, seconds, hours < 12 ? "AM" : "PM");
    }

    /**
     * Returns the time in the format: %02d%02d%02d.
     *
     * @return time's characteristics.
     */
    public String toStringHHMM() {
        return String.format("%02d:%02d", hours, minutes);
    }

    /**
     * Compares the time with the received object.
     *
     * @param anotherObject the object to be compared with the time.
     * @return true if the received object represents a time equivalent to the
     *         time. Otherwise, returns false.
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }
        Time anotherTime = (Time) anotherObject;
        return hours == anotherTime.hours && minutes == anotherTime.minutes
                && seconds == anotherTime.seconds;
    }
    
    /**
     * Compares the time with another time received by parameter.
     * 
     * @param anotherTime time to be compared.
     * @return value 0 if the anotherTime received is equal to the time;
     *         value -1 if the anotherTime is later than the time;
     *         value 1 if the anotherTime is earlier than the time.
     */    
    @Override
    public int compareTo(Time anotherTime) {
        return (anotherTime.isGreater(this)) ? -1 : (isGreater(anotherTime)) ? 1 : 0;
    }     

    /**
     * Returns true if the time is greater than the time received by parameter.
     * If the time is less than or equal to the time received by parameter,
     * returns false.
     *
     * @param anotherTime the other time with which the date is compared.
     * @return true if the time is greater than the time received by parameter,
     *         otherwise returns false.
     */
    public boolean isGreater(Time anotherTime) {
        return toSeconds() > anotherTime.toSeconds();
    }

    /**
     * Returns true if the time is greater than the time (hours, minutes, and
     * seconds) received per parameter. If the time is less than or equal to
     * the time (hours, minutes, and seconds) received by parameter, returns
     * false.
     *
     * @param hours the other hours of time with which time is compared.
     * @param minutes the other minutes of time with which time is compared.
     * @param seconds the other seconds of time with which time is compared.
     * @return true if the time is greater than the time (hours, minutes, and
     *         seconds) received by parameter, otherwise returns false.
     */
    public boolean isGreater(int hours, int minutes, int seconds) {
        Time anotherTime = new Time(hours, minutes, seconds);
        return this.toSeconds() > anotherTime.toSeconds();
    }

    /**
     * Returns the difference in seconds between the time and the time received
     * by parameter.
     *
     * @param anotherTime the other time that compares the time to calculate
     *                    the difference in seconds.
     * @return difference in seconds between the time and the time received by
     *         parameter.
     */
    public int differenceInSeconds(Time anotherTime) {
        return Math.abs(toSeconds() - anotherTime.toSeconds());
    }

    /**
     * Returns a Time instance representing the difference between time and the
     * time received by parameter.
     *
     * @param anotherTime the other time with which time is compared to obtain
     *                    a Time instance representing the difference between
     *                    time and time received per parameter.
     * @return Time instance representing the difference between time and the
     *         received parameter.
     */
    public Time differenceInTime(Time anotherTime) {
        int dif = differenceInSeconds(anotherTime);
        int s = dif % 60;
        dif = dif / 60;
        int m = dif % 60;
        int h = dif / 60;
        return new Time(h, m, s);
    }
    
    /**
     * Returns the current system time.
     * 
     * @return the current system time.
     */
    public static Time actualTime() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        return new Time(hour,minute,second);
    }    

     /**
     * Returns the number of seconds corresponding to the time.
     *
     * @return the number of seconds corresponding to the time.
     */
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    /**
     * Returns the number of minutes corresponding to the time.
     *
     * @return the number of minutes corresponding to the time.
     */
    public int toMinutes() {
        return toSeconds()*60;
    }
    
}
