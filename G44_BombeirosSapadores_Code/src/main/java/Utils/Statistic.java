/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.TransactionExecution;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tiagopereira
 */
public class Statistic {


    private double FreelancerMeanPayment(List<TransactionExecution> eachFreelTrans) {
        double sum = 0;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            sum += eachFreelTrans.get(i).getPayment().getValueE();
        }
        return (sum / eachFreelTrans.size());
    }

    private double FreelancerPaymentDeviation(List<TransactionExecution> eachFreelTrans, double meanFreel) {
        double sumDeviation = 0;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            sumDeviation += Math.pow((eachFreelTrans.get(i).getPayment().getValueE() - meanFreel), 2);
        }
        //(contador==0 ? 1 : contador);
        return (sumDeviation / ((eachFreelTrans.size() - 1) == 0 ? 1 : (eachFreelTrans.size() - 1)));
    }

    private double FreelancerMeanTaskExecution(List<TransactionExecution> eachFreelTrans) {
        double sum = 0;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            sum += eachFreelTrans.get(i).getTaskDelay();
        }
        return (sum / eachFreelTrans.size());
    }

    private double FreelancerDeviationTaskExecution(List<TransactionExecution> eachFreelTrans, double meanFreel) {
        double sumDeviation = 0;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            sumDeviation += Math.pow((eachFreelTrans.get(i).getTaskDelay() - meanFreel), 2);
        }
        return (sumDeviation / ((eachFreelTrans.size() - 1) == 0 ? 1 : (eachFreelTrans.size() - 1)));
    }

    //======================================================================================================================================================
    /**
     * Inspired in
     * https://stackoverflow.com/questions/3110547/java-how-to-create-new-entry-key-value
     *
     * @param ltr
     * @param emailF
     * @return
     */
    public Map.Entry<String, CustomValue> getPaymentDeviationOfEachFreelancer(List<TransactionExecution> ltr, String emailF) {
        List<TransactionExecution> eachFreelTrans = new ArrayList<>();

        String f = null;
        for (int i = 0; i < ltr.size(); i++) {
            if (emailF.equalsIgnoreCase(ltr.get(i).getFreel().getEmail())) {
                eachFreelTrans.add(ltr.get(i));
                f = ltr.get(i).getFreel().getName();
            }
        }
        double meanFreel = FreelancerMeanPayment(eachFreelTrans);
        double deviationFreel = FreelancerPaymentDeviation(eachFreelTrans, meanFreel);
        int leftDev = calculateLeftDev(eachFreelTrans, meanFreel, deviationFreel);
        int midDev = calculateMidDev(eachFreelTrans, meanFreel, deviationFreel);
        int rightDev = calculateRightDev(eachFreelTrans, meanFreel, deviationFreel);

        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>(f, new CustomValue(meanFreel, deviationFreel, leftDev, midDev, rightDev));
        return entry;

    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfEachFreelancer(List<TransactionExecution> ltr, String emailF) {
        List<TransactionExecution> eachFreelTrans = new ArrayList<>();
        String f = null;
        for (int i = 0; i < ltr.size(); i++) {
            if (emailF.equalsIgnoreCase(ltr.get(i).getFreel().getEmail())) {
                eachFreelTrans.add(ltr.get(i));
                f = ltr.get(i).getFreel().getName();
            }
        }
        double meanFreel = FreelancerMeanTaskExecution(eachFreelTrans);
        double deviationFreel = FreelancerDeviationTaskExecution(eachFreelTrans, meanFreel);
        int leftDev = calculateLeftDev(eachFreelTrans, meanFreel, deviationFreel);
        int midDev = calculateMidDev(eachFreelTrans, meanFreel, deviationFreel);
        int rightDev = calculateRightDev(eachFreelTrans, meanFreel, deviationFreel);

        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>(f, new CustomValue(meanFreel, deviationFreel, leftDev, midDev, rightDev));
        return entry;
    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfAllFreelancers(List<TransactionExecution> ltr) {
        double mean = FreelancerMeanTaskExecution(ltr);
        double deviation = FreelancerDeviationTaskExecution(ltr, mean);
        int leftDev = calculateLeftDev(ltr, mean, deviation);
        int midDev = calculateMidDev(ltr, mean, deviation);
        int rightDev = calculateRightDev(ltr, mean, deviation);

        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>("Task Delay of All Freelancers", new CustomValue(mean, deviation, leftDev, midDev, rightDev));
        return entry;
    }

    public Map.Entry<String, CustomValue> getPaymentDeviationOfAllFreelancers(List<TransactionExecution> ltr) {
        double mean = FreelancerMeanPayment(ltr);
        double deviation = FreelancerDeviationTaskExecution(ltr, mean);
        int leftDev = calculateLeftDev(ltr, mean, deviation);
        int midDev = calculateMidDev(ltr, mean, deviation);
        int rightDev = calculateRightDev(ltr, mean, deviation);

        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>("Payment Deviation of All Freelancers", new CustomValue(mean, deviation, leftDev, midDev, rightDev));
        return entry;
    }

    //======================================================================================================================================================
    private int calculateRightDev(List<TransactionExecution> eachFreelTrans, double meanFreel, double deviationFreel) {
        int sum = 0;
        double value = meanFreel + deviationFreel;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            if (eachFreelTrans.get(i).getTaskDelay() >= value) {
                sum++;
            }
        }
        return sum;
    }

    private int calculateMidDev(List<TransactionExecution> eachFreelTrans, double meanFreel, double deviationFreel) {
        int sum = 0;
        double valuer = meanFreel + deviationFreel;
        double valuel = meanFreel - deviationFreel;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            if (eachFreelTrans.get(i).getTaskDelay() < valuer && eachFreelTrans.get(i).getTaskDelay() > valuel) {
                sum++;
            }
        }
        return sum;
    }

    private int calculateLeftDev(List<TransactionExecution> eachFreelTrans, double meanFreel, double deviationFreel) {
        int sum = 0;
        double value = meanFreel - deviationFreel;
        for (int i = 0; i < eachFreelTrans.size(); i++) {
            if (eachFreelTrans.get(i).getTaskDelay() <= value) {
                sum++;
            }
        }
        return sum;
    }

}
