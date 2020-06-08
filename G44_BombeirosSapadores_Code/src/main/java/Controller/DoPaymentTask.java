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
import Model.Transaction;
import Model.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Ricardo
 */
public class DoPaymentTask extends TimerTask {

    Platform plt;

    Organization org;

    public DoPaymentTask() {

    }

    @Override
    public void run() {
        doPayment();
    }

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
            if (verifier == true) {

                amountsET.add(ts);

            }
        }

        RegisterTransaction rt = plt.getRTrans();
        List<Transaction> ltr = rt.getTransactions();

        List<Transaction> nltr = new ArrayList<>();

        for (int i = 0; i < lf.size(); i++) {

            nltr.removeAll(nltr);
            double sum = 0;
            Freelancer freel = lf.get(i);
            for (int j = 0; j < amountsET.size(); j++) {

                Task ts = amountsET.get(j);

                for (int k = 0; k < ltr.size(); k++) {

                    Transaction tr = ltr.get(k);
                    Freelancer f = tr.getFreel();
                    Task cts = tr.getTask();

                    if (ts.equals(cts) && freel.equals(f)) {
                        nltr.add(tr);
                        double value = tr.getTransactionValue();
                        sum += value;

                    }

                }
            }

            String country = freel.getCountry();
            CurrencyConverter c = new CurrencyConverter();
            double curr = c.convert(sum, country);

            Payment p = new Payment(sum, curr, nltr);

            boolean verif = p.validatePay();
            if (verif == true) {
                freel.addPayment(p);
            }

            Writer.writeOrg(org, sum);

            p.generateReceipt(country);

        }
    }

    public void passOrg(Organization org) {
        this.org = org;
    }

}
