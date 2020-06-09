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
    private double mean;
    private double deviation;
    
    public CustomValue(){
       this.mean = DEFAULT_MEAN;
       this.deviation = DEFAULT_DEVIATION;
    }
    
    public CustomValue(double mean, double deviation ){
        this.mean = mean;
        this.deviation = deviation;
    }


    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }
    
    
    
}
