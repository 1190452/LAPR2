package Utils;

import java.util.Calendar;

/**
 *
 * @author jorge
 */
public class Date implements Comparable<Date> { 
    
    /**
     * The year of the Date.
     */
    private int year;
    
    /**
     * The month of the Date.
     */
    private int month;
    
    /**
     * The day of the Date.
     */
    private int day;
    
    /**
     * The year by omission.
     */
    private static final int YEAR_BY_OMISSION = 1;
    
    /**
     * The month by omission.
     */
    private static final int MONTH_POR_OMISSION = 1;
    
    /**
     * The day by omission.
     */
    private static final int DIA_POR_OMISSION = 1;

    /**
     * Names of the days of the week.
     */
    private static String[] nameDayOfTheWeek = {"Sunday", "Monday",
        "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    /**
     * Number of days in every month of the year.
     */
    private static int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
        31, 30, 31};

    /**
     * Names of the months of the year.
     */
    private static String[] nameMonth = {"Invalid", "January", "February",
        "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};
     public Date( int month, int day) {
        this.month = month;
        this.day = year;
    }

    /**
     * Builds an instance of Date receiving the year, the mês and the day.
     *
     * @param year the year of the date.
     * @param month the month of the date.
     * @param day the day of the date.
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = year;
    }

    /**
     * Builds an instance of Date with the omission values
     */
    public Date() {
        year = YEAR_BY_OMISSION;
        month = MONTH_POR_OMISSION;
        day = DIA_POR_OMISSION;
    }

    /**
     * Builds an instance of Date that is copy of the one passed by parameter
     *
     * @param anotherDate the date that is copied.
     */
    public Date(Date anotherDate) {
        year = anotherDate.year;
        month = anotherDate.month;
        day = anotherDate.day;
    }

    /**
     * Returns the year of the date.
     *
     * @return year of the date
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of the dat.
     *
     * @return month of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of the date.
     *
     * @return day of date.
     */
    public int getDia() {
        return day;
    }

    /**
     * Changes the year, the month and the day of the date.
     *
     * @param year the new year of the date.
     * @param month the new month of the date.
     * @param day the new day of the date.
     */
    public void setData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the description of the date in format: dayOfTheWeek, day of the month
     * and the year.
     * @return characteristics of the date.
     */
    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", dayOfTheWeek(), day,
                nameMonth[month], year);
    }

    /**
     * Devolve a data no formato:%04d/%02d/%02d.
     *
     * @return caraterísticas da data.
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }
    
    /**
     * Compares the date with another object received
     *
     * @param anotherObject the object to compare the date.
     * @return true if the object received represents a date equivalent to the
     *         date. Else, returns false.
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
        return year == anotherDate.year && month == anotherDate.month
                && day == anotherDate.day;
    }

    /**
     * Compares the date with another received by parameter.
     *
     * @param anotherDate the date to be compared.
     * @return the value 0 if the other date received is the same date; the value -1 if
     *         the anotherDate is posterior; the value 1 if anotherDate is 
     *         previous to the date.
     */
    @Override
    public int compareTo(Date anotherDate) {
        return (anotherDate.isGreater(this)) ? -1 : (isGreater(anotherDate)) ? 1 : 0;
    }

    
    /**
     * Returns the day of the week of the date.
     *
     * @return day of the week of the date.
     */
    public String dayOfTheWeek() {
        int totalDays = countDays();
        totalDays = totalDays % 7;

        return nameDayOfTheWeek[totalDays];
    }

    
    public boolean isGreater(Date anotherDate) {
        int totalDays = countDays();
        int totalDays1 = anotherDate.countDays();

        return totalDays > totalDays1;
    }


    public int difference(Date anotherDate) {
        int totalDays = countDays();
        int totalDays1 = anotherDate.countDays();

        return Math.abs(totalDays - totalDays1);
    }


    public int difference(int year, int month, int day) {
        int totalDays = countDays();
        Date anotherDate = new Date(year, month, day);
        int totalDays1 = anotherDate.countDays();

        return Math.abs(totalDays - totalDays1);
    }


    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }


    public static Date currentDate() {
        Calendar hoje = Calendar.getInstance();
        int year = hoje.get(Calendar.YEAR);
        int month = hoje.get(Calendar.MONTH) + 1;    // January is represented by 0
        int day = hoje.get(Calendar.DAY_OF_MONTH);
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
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            totalDays += daysPerMonth[i];
        }
        totalDays += (isLeapYear(year) && month > 2) ? 1 : 0;
        totalDays += day;

        return totalDays;
    }
}
