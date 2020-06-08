package Utils;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author jorge
 */
public class Date implements Comparable<Date>, Serializable {

    /**
     * The year of the date.
     */
    private int year;
    
    /**
     * The month of the date.
     */
    private Month month;
    
    /**
     * The day of the date.
     */
    private int day;
    
    /**
     * Year by default.
     */
    private static final int YEAR_BY_OMISSION = 1;
    
    /**
     * Month by default.
     */
    private static final Month MONTH_BY_OMISSION = Month.JANUARY;
    
    /**
     * Day by default.
     */
    private static final int DAY_BY_OMISSION = 1;
    
    /**
     * Represents weekday.
     */
    private static enum WeekDay {

        /**
         * Weekdays.
         */ 
        SUNDAY { @Override public String toString() { return "Sunday"; } },
        MONDAY { @Override public String toString() { return "Monday"; } },
        TUESDAY {   @Override public String toString() { return "Tuesday"; } },
        WEDNESDAY {  @Override public String toString() { return "Wednesday"; } },
        THURSDAY {  @Override public String toString() { return "Thursday"; } },
        FRIDAY {   @Override public String toString() { return "Friday"; } },
        SATURDAY {  @Override public String toString() { return "Saturday"; } };

        /**
         * Returns the name of the weekday whose order is received by parameter. 
         * 
         * @param weekdayOrder the order of the weekday goes from zero to six.
         *                     The lowest order is Sunday. 
         * @return weekday designation. 
         */
        public static String weekdayDesignation(int weekdayOrder) {
            return WeekDay.values()[weekdayOrder].toString();
        }
    }

    /**
     * Represents the year's month.
     */
    private static enum Month {

        /**
         * Year's months.
         */
        JANUARY(31) {   @Override public String toString() { return "January"; } }, 
        FEBRUARY(28) { @Override public String toString() { return "February"; } }, 
        MARSH(31) {     @Override public String toString() { return "Marsh"; } },
        APRIL(30) {     @Override public String toString() { return "April"; } }, 
        MAY(31) {      @Override public String toString() { return "May"; } }, 
        JUNE(30) {     @Override public String toString() { return "June"; } }, 
        JULY(31) {     @Override public String toString() { return "July"; } }, 
        AUGUST(31) {    @Override public String toString() { return "August"; } }, 
        SEPTEMBER(30) {  @Override public String toString() { return "September"; } },
        OCTOBER(31) {   @Override public String toString() { return "October"; } }, 
        NOVEMBER(30) {  @Override public String toString() { return "November"; } }, 
        DECEMBER(31) {  @Override public String toString() { return "December"; } };

        /**
         * The number of days of a month.
         */
        private int daysNumber;

        /**
        * It builds a month with the number of days received as parameter.
        * 
        * @param daysNumber the number of the days of a month.
        */
        private Month(int daysNumber) {
            this.daysNumber = daysNumber;
        }

        /**
         * Returns the number of days in the month of the year received
         * by parameter.
         * 
         * @param year month's year.
         * @return the number of days in the month of the year.
         */
        public int daysNumber(int year) {
            if (ordinal() == 1 && Date.leapYear(year)) {
                return daysNumber + 1;
            }
            return daysNumber;
        }
        
        /**
         * Returns the month whose order is received as a parameter.
         * 
         * @param monthsOrder the order of the month.
         * @return the month whose order is received by parameter.
         */
        public static Month getMonth(int monthsOrder) {
            return Month.values()[monthsOrder - 1];
        }

    }
    /**
     * It builds a date instance receiving the year, the month and the day.
     * @param year date's year
     * @param month month's year
     * @param day day's date
     */
    public Date(int year, int month, int day){
        setDate(year, month, day);
    }
    
    /**
     * 
     * @param month
     * @param day 
     */
    public Date(int month, int day) {
        setDate(year, month, day);
    }
    
    /**
     * It builds a Date instance by default.
     */
    public Date() {
        year = YEAR_BY_OMISSION;
        month = MONTH_BY_OMISSION;
        day = DAY_BY_OMISSION;
    }

    /**
     * It builds a Date instance with the same characteristics as the date
     * received per parameter.
     *
     * @param yeartherDate the date with the characteristics to be copied.
     */
    public Date(Date yeartherDate) {
        year = yeartherDate.year;
        month = yeartherDate.month;
        day = yeartherDate.day;
    }

    /**
     * It gives the date's year.
     *
     * @return date's year
     */
    public int getYear() {
        return year;
    }

    /**
     * It gives the date's month.
     *
     * @return date's month
     */
    public int getMonth() {
        return month.ordinal()+1;
    }

    /**
     * It gives the date's day.
     *
     * @return date's day
     */
    public int getDay() {
        return day;
    }

    /**
     * It changes the date's yeay, month and day.
     *
     * @param year the new date's year.
     * @param month the new date's month.
     * @param day the new date's day.
     */
    public final void setDate(int year, int month, int day) {
        this.year = year;         
        this.month = Month.getMonth(month);       
        this.day = day;
    }
    
        /**
     * It changes the date's yeay, month and day.
     *
     * @param month the new date's month.
     * @param day the new date's day.
     */
    public final void setDate(int month, int day) {         
        this.month = Month.getMonth(month);       
        this.day = day;
    }

    /**
     * Returns the textual description of the date in the format: weekDay,
     * day of the month of the year.
     *
     * @return date's characteristics.
     */
    @Override
    public String toString() {
        return String.format("%s, %d of %s of %d", weekDay(), day, month, year);
    }

    /**
     * Returns the date as:%04d/%02d/%02d.
     *
     * @return date's characteristics.
     */
    public String toYearMonthDayString() {
        return String.format("%04d/%02d/%02d", year, month.ordinal()+1, day);
    }
    
    /**
     * Compares the date with the received object.
     *
     * @param anotherObject the object to be compared with the date.
     * @return true if the received object represents a date equivalent to
     *         the date. Otherwise, returns false.
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }
        Date anotherDate = (Date) anotherObject;
        return year == anotherDate.year && month.equals(anotherDate.month)
                && day == anotherDate.day;
    }

    /**
     * Compares the date with another date received by parameter.
     *
     * @param anotherDate date to be compared.
     * @return value 0 if the anotherDate received is equal to the date;
     *         value -1 if the anotherDate is later than the date;
     *         value 1 if the anotherDate is earlier than the date.
     */
    @Override
    public int compareTo(Date anotherDate) {
        return (anotherDate.isGreater(this)) ? -1 : (isGreater(anotherDate)) ? 1 : 0;
    }

    /**
     * Returns the weekday of the date.
     *
     * @return weekday of the date.
     */
    public String weekDay() {
        int totalDays = countDays();
        totalDays = totalDays % 7;

        return WeekDay.weekdayDesignation(totalDays);
    }


    /**
     * Returns true if the date is greater than the date received by parameter.
     * If the date is less than or equal to the date received by parameter,
     * returns false.
     *
     * @param anotherDate the other date with which the date is compared.
     * @return true if the date is greater than the date received by parameter,
     *         otherwise returns false.
     */
    public boolean isGreater(Date anotherDate) {
        int totalDays = countDays();
        int totalDays1 = anotherDate.countDays();

        return totalDays > totalDays1;
    }
    
    /**
     * Returns true if the date is greater than the date received by parameter.
     * If the date is less than or equal to the date received by parameter,
     * returns false.
     *
     * @param anotherDate the other date with which the date is compared.
     * @return true if the date is greater or equal than the date received by parameter,
     *         otherwise returns false.
     */
    public boolean isGreaterOrEqual(Date anotherDate) {
        int totalDays = countDays();
        int totalDays1 = anotherDate.countDays();

        return totalDays >= totalDays1;
    }

    /**
     * Returns the difference in number of days between the date and the date
     * received by parameter.
     *
     * @param anotherDate the other date with which the date is compared
     *        to calculate the difference in the number of days.
     * @return difference in number of days between the date and the date
     *         received by parameter.
     */
    public int difference(Date anotherDate) {
        int totalDays = countDays();
        int totalDays1 = anotherDate.countDays();

        return Math.abs(totalDays - totalDays1);
    }

    /**
     * Returns the difference in number of days between the date and the date
     * received by parameter with year, month and day.
     *
     * @param year the date's year with which the date is compared to calculate
     *            the difference in the number of days.
     * @param month the date's month with which the date is compared to
     *            calculate the difference in the number of days.
     * @param day the date's day with which the date is compared to calculate
     *            the difference in the number of days.
     * @return difference in number of days between the date and the date
     *         received per parameter with year, month and day.
     */
    public int difference(int year, int month, int day) {
        int totalDays = countDays();
        Date anotherDate = new Date(year, month, day);
        int totalDays1 = anotherDate.countDays();

        return Math.abs(totalDays - totalDays1);
    }

    /**
     * Returns true if the year received by parameter is a leap year.
     * If the year received by parameter is not a leap year, it returns false.
     *
     * @param year the year to be validated.
     * @return true if the year received by parameter is a leap year,
     *         otherwise it is false.
     */
    public static boolean leapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * Returns the actual date.
     *
     * @return actual date of the system.
     */
    public static Date actualDate() {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) + 1;    // january means 0.
        int day = today.get(Calendar.DAY_OF_MONTH);
        return new Date(year, month, day);
    }

    /**
     * Returns the number of days since 1/1/1 until the date.
     *
     * @return number of days since 1/1/1 until the date.
     */
    private int countDays() {
        int totalDays = 0;

        for (int i = 1; i < year; i++) {
            totalDays += leapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month.ordinal()+1; i++) {
            totalDays += Month.getMonth(i).daysNumber(year);
        }
        totalDays += day;

        return totalDays;
    }
    
    /**
     * Returns the date in a format specified for a file
     * @return Date in string format
     */
    public String toFile(){
        return String.format("%s_%s_%s", year, month, day);
    }
}
