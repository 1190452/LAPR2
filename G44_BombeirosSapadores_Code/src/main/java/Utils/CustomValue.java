/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Organization;

/**
 *
 * @author tiagopereira
 */
public class CustomValue {

    /**
     * mean by omission
     */
    private static final double DEFAULT_MEAN = 0;

    /**
     * deviation by omission
     */
    private static final double DEFAULT_DEVIATION = 0;

    /**
     * absolute frequency of the left interval of the histogram by omission
     */
    private static final int DEFAULT_LEFTDEV = 0;

    /**
     * absolute frequency of the middle interval of the histogram by omission
     */
    private static final int DEFAULT_MIDDLEDEV = 0;

    /**
     * absolute frequency of the right interval of the histogram by omission
     */
    private static final int DEFAULT_RIGHTDEV = 0;

    /**
     * mean
     */
    private double mean;

    /**
     * deviation
     */
    private double deviation;

    /**
     * absolute frequency of the left interval of the histogram
     */
    private int leftDev;

    /**
     * absolute frequency of the middle interval of the histogram
     */
    private int middleDev;

    /**
     * absolute frequency of the right interval of the histogram
     */
    private int rightDev;

    /**
     * empty constructor that initializes the variables by omission
     */
    public CustomValue() {
        this.mean = DEFAULT_MEAN;
        this.deviation = DEFAULT_DEVIATION;
        this.leftDev = DEFAULT_LEFTDEV;
        this.middleDev = DEFAULT_MIDDLEDEV;
        this.rightDev = DEFAULT_RIGHTDEV;
    }

    /**
     * complete constructor that initializes thae following variables:
     *
     * @param mean
     * @param deviation
     * @param leftDev
     * @param middleDev
     * @param rightDev
     */
    public CustomValue(double mean, double deviation, int leftDev, int middleDev, int rightDev) {
        this.mean = mean;
        this.deviation = deviation;
        this.leftDev = leftDev;
        this.middleDev = middleDev;
        this.rightDev = rightDev;
    }

    //======================================================================================================================================================
    /**
     * returns the mean
     *
     * @return the mean
     */
    public double getMean() {
        return mean;
    }

    /**
     * returns the deviation
     *
     * @return the deviation
     */
    public double getDeviation() {
        return deviation;
    }

    /**
     * returns the right deviation
     *
     * @return the rightDev
     */
    public int getRightDev() {
        return rightDev;
    }

    /**
     * returns the left deviation
     *
     * @return the leftDev
     */
    public int getLeftDev() {
        return leftDev;
    }

    /**
     * returns the middle deviation
     *
     * @return the middleDev
     */
    public int getMiddleDev() {
        return middleDev;
    }
    //======================================================================================================================================================

    /**
     * modifies the mean
     *
     * @param mean
     */
    public void setMean(double mean) {
        this.mean = mean;
    }

    /**
     * modifies the deviation
     *
     * @param deviation
     */
    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    /**
     * modifies the left deviation
     *
     * @param leftDev the leftDev to set
     */
    public void setLeftDev(int leftDev) {
        this.leftDev = leftDev;
    }

    /**
     * modifies the middle deviation
     *
     * @param middleDev the middleDev to set
     */
    public void setMiddleDev(int middleDev) {
        this.middleDev = middleDev;
    }

    /**
     * modifies the right deviation
     *
     * @param rightDev the rightDev to set
     */
    public void setRightDev(int rightDev) {
        this.rightDev = rightDev;
    }

    /**
     * Compares 2 CustomValue objects through deviation, mean, rightDev, leftDev
     * and middleDev with both objects being considered equal only when these 5
     * parameteres are the same
     *
     * @param otherObject object to be compared with the object that calls the
     * method
     * @return true, if the references of both objects being compared are
     * pointing at the same object false, if the compared object is null or the
     * class of the objects are different true.
     */
    @Override
    public boolean equals(Object otherObject) {

        // self check
        if (this == otherObject) {
            return true;
        }
        // null check
        if (otherObject == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        // field comparison
        CustomValue otherCustomValue = (CustomValue) otherObject;
        return (this.deviation == otherCustomValue.deviation && this.mean == otherCustomValue.mean && this.leftDev == otherCustomValue.leftDev
                && this.middleDev == otherCustomValue.middleDev && this.rightDev == otherCustomValue.rightDev);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.mean) ^ (Double.doubleToLongBits(this.mean) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.deviation) ^ (Double.doubleToLongBits(this.deviation) >>> 32));
        hash = 67 * hash + this.leftDev;
        hash = 67 * hash + this.middleDev;
        hash = 67 * hash + this.rightDev;
        return hash;
    }

}
