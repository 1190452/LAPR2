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

    /**
     * Inspired in
     * https://stackoverflow.com/questions/3110547/java-how-to-create-new-entry-key-value
     *
     * @param ltr
     * @param emailF
     * @return
     */
    public Map.Entry<String, CustomValue> getPaymentDeviationOfEachFreelancer(List<TransactionExecution> ltr, String emailF) {
        List<TransactionExecution> eachFreel = new ArrayList<>();

        String f = null;
        for (int i = 0; i < ltr.size(); i++) {
            if (emailF.equalsIgnoreCase(ltr.get(i).getFreel().getEmail())) {
                eachFreel.add(ltr.get(i));
                f = ltr.get(i).getFreel().getName();
            }
        }
        double meanFreel = FreelancerMeanPayment(eachFreel);
        double deviationFreel = FreelancerPaymentDeviation(eachFreel, meanFreel);

        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>(f, new CustomValue(meanFreel, deviationFreel));
        return entry;

    }

    private double FreelancerMeanPayment(List<TransactionExecution> eachFreel) {
        double sum = 0;
        for (int i = 0; i < eachFreel.size(); i++) {
            sum += eachFreel.get(i).getPayment().getValueE();
        }
        return (sum / eachFreel.size());
    }

    private double FreelancerPaymentDeviation(List<TransactionExecution> eachFreel, double meanFreel) {
        double sumDeviation = 0;
        for (int i = 0; i < eachFreel.size(); i++) {
            sumDeviation += Math.pow((eachFreel.get(i).getPayment().getValueE() - meanFreel), 2);
        }
        return sumDeviation;
    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfEachFreelancer(List<TransactionExecution> ltr, String emailF) {
        List<TransactionExecution> eachFreel = new ArrayList<>();
        String f = null;
        for (int i = 0; i < ltr.size(); i++) {
            if (emailF.equalsIgnoreCase(ltr.get(i).getFreel().getEmail())) {
                eachFreel.add(ltr.get(i));
                f = ltr.get(i).getFreel().getName();
            }
        }
        double meanFreel = FreelancerMeanTaskExecution(eachFreel);
        double deviationFreel = FreelancerDeviationTaskExecution(eachFreel, meanFreel);
        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>(f, new CustomValue(meanFreel, deviationFreel));
        return entry;
    }

    private double FreelancerMeanTaskExecution(List<TransactionExecution> eachFreel) {
        double sum = 0;
        for (int i = 0; i < eachFreel.size(); i++) {
            sum += eachFreel.get(i).getTaskDelay();
        }
        return (sum / eachFreel.size());
    }

    private double FreelancerDeviationTaskExecution(List<TransactionExecution> eachFreel, double meanFreel) {
        double sumDeviation = 0;
        for (int i = 0; i < eachFreel.size(); i++) {
            sumDeviation += Math.pow((eachFreel.get(i).getTaskDelay() - meanFreel), 2);
        }
        return sumDeviation;
    }

    public Map.Entry<String, CustomValue> getTaskExecutionDelayOfAllFreelancers(List<TransactionExecution> ltr) {
        double mean = FreelancerMeanTaskExecution(ltr);
        double deviation = FreelancerDeviationTaskExecution(ltr, mean);
        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>("Task Execution Delay of All Freelancers", new CustomValue(mean, deviation));
        return entry;
    }

    public Map.Entry<String, CustomValue> getPaymentDeviationOfAllFreelancers(List<TransactionExecution> ltr) {
        double mean = FreelancerMeanPayment(ltr);
        double deviation = FreelancerDeviationTaskExecution(ltr, mean);
        Map.Entry<String, CustomValue> entry = new AbstractMap.SimpleEntry<>("Payment Deviation of All Freelancers", new CustomValue(mean, deviation));
        return entry;
    }

}
