/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ApplicationPOT;
import Utils.CurrencyConverter;
import Model.Freelancer;
import Model.Organization;
import Model.Payment;
import Model.Platform;
import Model.RegisterFreelancer;
import Model.RegisterTransaction;
import Model.Task;
import Model.TransactionExecution;
import Model.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Ricardo
 */
public class DoPaymentTask extends TimerTask {

    /**
     * platform that does the payment
     */
    private Platform plt;

    /**
     * organization that has the list of tasks
     */
    private Organization org;

    /**
     * currency converter
     */
    private CurrencyConverter c;

    /**
     * creates an instance of DoPaymentTask
     */
    public DoPaymentTask() {

    }

    //======================================================================================================================================================
    /**
     * calls the method doPayment
     */
    @Override
    public void run() {
        doPayment();
    }

    /**
     * method that does the payment and generates the receipt
     */
    private void doPayment() {

        System.out.println("task ta a andarrrrrr");
        ApplicationPOT app = ApplicationPOT.getInstance();

        plt = app.getPlatform();

        RegisterFreelancer rFree = plt.getRfree();

        List<Freelancer> lf = rFree.getListFreelancers();

        List<Task> lt = org.getTaskList().getTaskList();

        List<Task> amountsET = new ArrayList<>();

        for (int i = 0; i < lt.size(); i++) {

            Task ts = lt.get(i);
            boolean verifier = ts.isIsFinished();
            boolean verifier2 = ts.isIsPayed();
            if (verifier == true && verifier2 == false) {
                amountsET.add(ts);
            }
        }

        RegisterTransaction rt = org.getRTrans();
        List<TransactionExecution> ltr = rt.getTransactions();

        List<TransactionExecution> nltr = new ArrayList<>();

        for (int i = 0; i < lf.size(); i++) {

            nltr.removeAll(nltr);
            double sum = 0;
            Freelancer freel = lf.get(i);
            for (int j = 0; j < amountsET.size(); j++) {

                Task ts = amountsET.get(j);

                for (int k = 0; k < ltr.size(); k++) {

                    TransactionExecution tr = ltr.get(k);
                    Freelancer f = tr.getFreel();
                    Task cts = tr.getTask();

                    if (ts.equals(cts) && freel.equals(f)) {
                        nltr.add(tr);
                        Payment p = tr.getPayment();
                        double value = p.getValueE();
                        sum += value;

                    }

                }
            }
            if(sum!= 0){
            String country = freel.getCountry();
            double curr = plt.getC().convert(sum, country);

            Writer.writeOrg(org, sum);

            Writer.genEmail(nltr, sum, curr);
            }

        }
    }

    /**
     * method that substitutes the atribute org for the organization received by
     * parameter
     *
     * @param org
     */
    public void passOrg(Organization org) {
        this.org = org;
    }

}
