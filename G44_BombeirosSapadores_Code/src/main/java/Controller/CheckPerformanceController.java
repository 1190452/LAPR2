
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Freelancer;
import Model.Payment;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.Task;
import Model.Transaction;
import java.util.List;
import org.apache.commons.math3.distribution.NormalDistribution;


/**
 *
 * @author OMEN X
 */
public class CheckPerformanceController {

    private Platform platform;
    private double paymentTotal = 0;
    private double averageFreel = 0;
    private double paymentValue = 0;
    private double sumDeviation = 0;
    private double sumAllPaymentsDeviation = 0;
    private double deviation = 0;
    private double totalDelay = 0;
    List<Transaction> listTransactions;
    private double totalDelayOfAllFreelancers = 0;
    private double deviatonDelayOfEachTask = 0;
    private double deviatonDelayOfEachFreelancer = 0;
    private int numTasksOfAllFreelancers = 0;
    private int numPaymentsOfAllFreelancers = 0;
    private Freelancer freel;
    private double deviationDelay = 0;
    private double totalDeviationDelayOfAllFreelancers = 0;
    private double totalPaymentOfAllFreelancer = 0;
    private double sumPaymentDeviationOfAllFreelancers = 0;

    public CheckPerformanceController() {
        platform = new Platform();
    }

    public void getPerformances() {
        RegisterFreelancer rFree = platform.getRfree();
        List<Freelancer> listFreelancer = rFree.getListFreelancers();
        for (int i = 0; i < listFreelancer.size(); i++) {
            Freelancer freel = listFreelancer.get(i);
            List<Payment> listPayments = freel.getPaymentList().getPaymentList();
            //For each payment of each freelancer
            for (int p = 0; p < listPayments.size(); p++) {
                Payment payment = listPayments.get(p);
                listTransactions = payment.getNltr();
                //For each transaction of each freelancer
                for (int z = 0; z < listTransactions.size(); z++) {
                    Transaction transaction = listTransactions.get(z);
                    paymentValue += transaction.getTransactionValue();
                }
                //Sum all payments that Freelancer received
                paymentTotal += paymentValue;
                numPaymentsOfAllFreelancers += listTransactions.size();
            }
            int n = listPayments.size() * listTransactions.size();
            //Average of each Freelancer
            averageFreel = freel.averageOfEachFreelancer(paymentTotal, n);
            //For each payment of each freelancer
            for (int p = 0; p < listPayments.size(); p++) {
                Payment payment = listPayments.get(p);
                listTransactions = payment.getNltr();
                //For each transaction of each freelancer
                for (int z = 0; z < listTransactions.size(); z++) {
                    Transaction transaction = listTransactions.get(z);
                    paymentValue = transaction.getTransactionValue();
                    sumDeviation += freel.sumDeviation(averageFreel, paymentValue);
                }
                //Sum all deviations calculated with payment and the average calculated before
                sumAllPaymentsDeviation += sumDeviation;
            }
            //Deviation of each Freelancer
            deviation = freel.calculateDeviation(sumAllPaymentsDeviation, n);
            //Output the result
            System.out.println("Freelancer: " + freel + "\nPayment Deviation: " + deviation + "\nAverage Payment: " + averageFreel);

            List<Task> taskList = freel.getTl().getTaskList();
            for (int h = 0; h < taskList.size(); h++) {
                Task task = taskList.get(h);
                double delayTask = task.getTexec().getTaskDelay();
                totalDelay += delayTask;
            }
            double averageDelayOfFreelancer = freel.delayMean(totalDelay, taskList.size());

            for (int h = 0; h < taskList.size(); h++) {
                Task task = taskList.get(h);
                double delayTask = task.getTexec().getTaskDelay();
                deviatonDelayOfEachTask += freel.sumDelay(averageDelayOfFreelancer, delayTask);
            }
            numTasksOfAllFreelancers += taskList.size();
            deviatonDelayOfEachFreelancer = freel.calculateDelayDeviation(deviatonDelayOfEachTask, taskList.size());
            System.out.println("Freelancer: " + freel + "\nDelay Deviation: " + deviatonDelayOfEachFreelancer + "\nAverage Delay: " + averageDelayOfFreelancer);
            //SHOW HISTOGRAM
        }
        totalPaymentOfAllFreelancer += paymentTotal;

        double averagePayementOFAllFreelancers = freel.calculateAveragePayementOFAllFreelancers(totalPaymentOfAllFreelancer, numPaymentsOfAllFreelancers);
        totalDelayOfAllFreelancers += totalDelay;
        double averageDelayOfAllFreelancers = freel.calculateAverageDelayOfAllFreelancers(totalDelayOfAllFreelancers, numTasksOfAllFreelancers);

        for (int i = 0; i < listFreelancer.size(); i++) {
            freel = listFreelancer.get(i);
            List<Task> taskList = freel.getTl().getTaskList();
            List<Payment> listPayments = freel.getPaymentList().getPaymentList();
            for (int h = 0; h < taskList.size(); h++) {
                Task task = taskList.get(h);
                double delayTask = task.getTexec().getTaskDelay();
                deviationDelay += freel.sumDeviation(averageDelayOfAllFreelancers, delayTask);
            }
            for (int k = 0; k < listPayments.size(); k++) {
                Payment payment = listPayments.get(k);
                listTransactions = payment.getNltr();
                //For each transaction of each freelancer
                for (int z = 0; z < listTransactions.size(); z++) {
                    Transaction transaction = listTransactions.get(z);
                    double payValue = transaction.getTransactionValue();
                    sumPaymentDeviationOfAllFreelancers += freel.calculatePaymentDeviationOfAllFreelancers(averagePayementOFAllFreelancers, payValue);
                }
                totalDeviationDelayOfAllFreelancers += deviationDelay;
                
            }
            //calculation of the payment deviation of all freelancers
            double paymentDeviationOfAllFreelancers = freel.calculatepaymentDeviationOfAllFreelancers(sumPaymentDeviationOfAllFreelancers,numTasksOfAllFreelancers );
            
            
            double deviationAllFreel = freel.calculateDelayDeviation(totalDeviationDelayOfAllFreelancers, numTasksOfAllFreelancers);
            System.out.println("Delay Deviation: " + deviationAllFreel + "\nAverage Delay: " + averageDelayOfAllFreelancers);
            //SHOW HISTOGRAM
             
            
            /*
            X represents the mean execution time delay of the freelancers
            mean = 2
            standard deviation = 1.5/Math.sqrt(number of freelancers)
            X~N(2;1.5/Math.sqrt(number of freelancers)
            */
            NormalDistribution nd = new NormalDistribution(2, (1.5/Math.sqrt(listFreelancer.size())));
            
            //P(X>3) = 1 - P(X<=3) 
            double probability = 1 - nd.cumulativeProbability(3); 
            
        }
    }

}