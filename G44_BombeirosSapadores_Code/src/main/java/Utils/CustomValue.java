/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author tiagopereira
 */
public class CustomValue {

    private static final double DEFAULT_MEAN = 0;
    private static final double DEFAULT_DEVIATION = 0;
    private static final int DEFAULT_LEFTDEV = 0;
    private static final int DEFAULT_MIDDLEDEV = 0;
    private static final int DEFAULT_RIGHTDEV = 0;
    private double mean;
    private double deviation;
    private int leftDev;
    private int middleDev;
    private int rightDev;

    public CustomValue() {
        this.mean = DEFAULT_MEAN;
        this.deviation = DEFAULT_DEVIATION;
        this.leftDev = DEFAULT_LEFTDEV;
        this.middleDev = DEFAULT_MIDDLEDEV;
        this.rightDev = DEFAULT_RIGHTDEV;
    }

    public CustomValue(double mean, double deviation, int leftDev, int middleDev, int rightDev) {
        this.mean = mean;
        this.deviation = deviation;
        this.leftDev = leftDev;
        this.middleDev = middleDev;
        this.rightDev = rightDev;
    }

    //======================================================================================================================================================
    public double getMean() {
        return mean;
    }

    public double getDeviation() {
        return deviation;
    }

    /**
     * @return the rightDev
     */
    public int getRightDev() {
        return rightDev;
    }

    /**
     * @return the leftDev
     */
    public int getLeftDev() {
        return leftDev;
    }

    /**
     * @return the middleDev
     */
    public int getMiddleDev() {
        return middleDev;
    }
    //======================================================================================================================================================

    public void setMean(double mean) {
        this.mean = mean;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    /**
     * @param leftDev the leftDev to set
     */
    public void setLeftDev(int leftDev) {
        this.leftDev = leftDev;
    }

    /**
     * @param middleDev the middleDev to set
     */
    public void setMiddleDev(int middleDev) {
        this.middleDev = middleDev;
    }

    /**
     * @param rightDev the rightDev to set
     */
    public void setRightDev(int rightDev) {
        this.rightDev = rightDev;
    }

}
