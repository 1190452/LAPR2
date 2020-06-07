/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Model.Freelancer;
import Model.Organization;
import Model.Payment;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.RegisterOrganization;
import Model.Task;
import Model.Transaction;
import autorizacao.model.UserSession;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsController {

    private Platform pl;
    private String email;
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
    private Freelancer freel;
    private double deviationDelay = 0;

    public void getOverallStatistics() {
        RegisterOrganization rorgs = pl.getrOrg();
        ApplicationPOT app = ApplicationPOT.getInstance();
        UserSession log = app.getActualSession();
        email = log.getUserEmail();
        Organization org = rorgs.getOrganizationByUserEmailColab(email);
        List<Task> lt = org.getTaskList().getTaskList();
        List<Transaction> ltr = pl.getRTrans().getTransactions();
        RegisterFreelancer rf = pl.getRfree();
        List<Freelancer> newList = rf.getFreelancers(lt, ltr);
        for (int i = 0; i < newList.size(); i++) {

            Freelancer freel = newList.get(i);
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
        totalDelayOfAllFreelancers += totalDelay;
        double averageDelayOfAllFreelancers = freel.calculateAverageDelayOfAllFreelancers(totalDelayOfAllFreelancers, numTasksOfAllFreelancers);

        for (int i = 0; i < newList.size(); i++) {
            freel = newList.get(i);
            List<Task> taskList = freel.getTl().getTaskList();
            for (int h = 0; h < taskList.size(); h++) {
                Task task = taskList.get(h);
                double delayTask = task.getTexec().getTaskDelay();
                deviationDelay += freel.sumDeviation(averageDelayOfAllFreelancers, delayTask);
            }
        }

        double deviationAllFreelancers = freel.calculateDelayDeviation(deviationDelay, numTasksOfAllFreelancers);
        System.out.println("Delay Deviation: " + deviationAllFreelancers + "\nAverage Delay: " + averageDelayOfAllFreelancers);
        //SHOW HISTOGRAM
    }

}
