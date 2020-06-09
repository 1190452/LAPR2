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
import Model.RegisterFreelancer;
import Model.RegisterOrganization;
import Model.Task;
import Model.Transaction;
import Authorization.model.UserSession;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsController {

    /**
     * email of the user
     */
    private String email;

    /**
     * payment total
     */
    private double paymentTotal = 0;

    /**
     * average payment of one freelancer
     */
    private double averagePaymentFreel = 0;

    /**
     * payment value of one freelancer
     */
    private double paymentValue = 0;

    /**
     * sum deviation of one freelancer
     */
    private double sumDeviation = 0;

    /**
     * sum of all payment deviation of one freelancer
     */
    private double sumAllPaymentsDeviation = 0;

    /**
     * payment deviation of one freelancer
     */
    private double deviation = 0;

    /**
     * total delay of one freelancer
     */
    private double totalDelay = 0;

    /**
     * list of transactions
     */
    List<Transaction> listTransactions;

    /**
     * total delay of all freelancers
     */
    private double totalDelayOfAllFreelancers = 0;

    /**
     * deviation delay of each task
     */
    private double deviatonDelayOfEachTask = 0;

    /**
     * delay deviation of one freelancer
     */
    private double deviatonDelayOfEachFreelancer = 0;

    /**
     * number of tasks of all freelancers
     */
    private int numTasksOfAllFreelancers = 0;

    /**
     * object of the class where all the calculations are done
     */
    private Freelancer freel;

    /**
     * deviation delay of all freelancers
     */
    private double deviationDelay = 0;

    /**
     * method that gets the performances of freelancers in 4 ways: - payment
     * mean and deviation of one freelancer - delay mean and deviation of one
     * freelancer - delay mean and deviation of all freelancers
     * @return 
     */
    public Object[][] getOverallStatistics() {
        ApplicationPOT app = ApplicationPOT.getInstance();
        RegisterOrganization rorgs = app.getPlatform().getrOrg();
        UserSession log = app.getActualSession();
        email = log.getUserEmail();
        Organization org = rorgs.getOrganizationByUserEmailColab(email);
        List<Task> lt = org.getTaskList().getTaskList();
        List<Transaction> ltr = app.getPlatform().getRTrans().getTransactions();
        RegisterFreelancer rf = app.getPlatform().getRfree();
        List<Freelancer> newList = rf.getFreelancers(lt, ltr);
        Object[][] object = new Object[newList.size() + 1][5];
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
            averagePaymentFreel = freel.averageOfEachFreelancer(paymentTotal, n);
            //For each payment of each freelancer
            for (int p = 0; p < listPayments.size(); p++) {
                Payment payment = listPayments.get(p);
                listTransactions = payment.getNltr();
                //For each transaction of each freelancer
                for (int z = 0; z < listTransactions.size(); z++) {
                    Transaction transaction = listTransactions.get(z);
                    paymentValue = transaction.getTransactionValue();
                    sumDeviation += freel.sumPaymentVariance(averagePaymentFreel, paymentValue);
                }
                //Sum all deviations calculated with payment and the average calculated before
                sumAllPaymentsDeviation += sumDeviation;
            }
            //Deviation of each Freelancer
            deviation = freel.calculateDeviation(sumAllPaymentsDeviation, n);
            //Output the result
            System.out.println("Freelancer: " + freel + "\nPayment Deviation: " + deviation + "\nAverage Payment: " + averagePaymentFreel);
            object[i][0] = freel;
            object[i][1] = deviation;
            object[i][2] = averagePaymentFreel;

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
                deviatonDelayOfEachTask += freel.sumDelayVariance(averageDelayOfFreelancer, delayTask);
            }
            numTasksOfAllFreelancers += taskList.size();
            deviatonDelayOfEachFreelancer = freel.calculateDelayDeviation(deviatonDelayOfEachTask, taskList.size());
            System.out.println("Freelancer: " + freel + "\nDelay Deviation: " + deviatonDelayOfEachFreelancer + "\nAverage Delay: " + averageDelayOfFreelancer);
            object[i][3] = deviatonDelayOfEachFreelancer;
            object[i][4] = averageDelayOfFreelancer;
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
                deviationDelay += freel.sumPaymentVariance(averageDelayOfAllFreelancers, delayTask);
            }
        }

        double deviationAllFreelancers = freel.calculateDelayDeviation(deviationDelay, numTasksOfAllFreelancers);
        System.out.println("Delay Deviation: " + deviationAllFreelancers + "\nAverage Delay: " + averageDelayOfAllFreelancers);
        object[newList.size() + 1][0] = "All Freelancers";
        object[newList.size() + 1][1] = deviationAllFreelancers;
        object[newList.size() + 1][2] = averageDelayOfAllFreelancers;

        return object;
    }

}
