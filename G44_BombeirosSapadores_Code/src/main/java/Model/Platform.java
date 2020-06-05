/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DoPaymentTask;
import Controller.SendEmailFreelTask;
import Utils.Date;
import Utils.Time;
import autorizacao.FacadeAuthorization;
import autorizacao.model.RegisterUser;
import java.io.FileNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform {

    private final FacadeAuthorization m_oAutorizacao;

    private RegisterOrganization rOrg;

    private RegisterFreelancer rFree;

    private RegisterUser rUser;

    private RegisterTransaction rTrans;

    private ImportTxtFile itxt;

    private ImportCsvFile icsv;

    private PasswordGenerator alg;

    private DoPaymentTask dpt;

    private SendEmailFreelTask sEF;
    
    private Writer writer;

    public Platform() {

        this.m_oAutorizacao = new FacadeAuthorization();
        this.rOrg = new RegisterOrganization();
        this.rFree = new RegisterFreelancer();
    }

    public FacadeAuthorization getFacadeAuthorazation() {
        return this.m_oAutorizacao;
    }

    public RegisterFreelancer getRfree() {
        return rFree;
    }

    public boolean validateOrganization(Organization oOrganizacao, String strPwd) {
        boolean bRet = true;

        if (this.m_oAutorizacao.userExists(oOrganizacao.getColab().getEmailC())) {
            bRet = false;
        }
        if (strPwd == null) {
            bRet = false;
        }
        if (strPwd.isEmpty()) {
            bRet = false;
        }
        //

        return bRet;
    }

    /**
     * @return the rUser
     */
    public RegisterUser getrUser() {
        return rUser;
    }

    /**
     * @param rUser the rUser to set
     */
    public void setrUser(RegisterUser rUser) {
        this.rUser = rUser;
    }

    /**
     * @return the rOrg
     */
    public RegisterOrganization getrOrg() {
        return rOrg;
    }

    /**
     * @param rOrg the rOrg to set
     */
    public void setrOrg(RegisterOrganization rOrg) {
        this.rOrg = rOrg;
    }

    public List<Transaction> loadHistoricalTransaction(String fileName) {
        if (fileName.endsWith(".txt")) {
            rTrans = itxt.importFile(fileName);
            List<Transaction> lt = getRTrans().getTransactions();
            return lt;
        } else if (fileName.endsWith(".csv")) {
            rTrans = icsv.importFile(fileName);
            List<Transaction> lt = getRTrans().getTransactions();
            if (getRTrans().validateHistoricalTransaction(lt)) {
                return lt;
            }

        }
        return null;
    }

    /**
     * @return the alg
     */
    public PasswordGenerator getAlg() {
        return alg;
    }

    public void scheduleProcess() {
        Date date = getLastDayDate();
        sEF = new SendEmailFreelTask();
        Timer t = new Timer();
        // t.schedule(sEF, date);

    }

    public Date getLastDayDate() {
        return new Date(12, 31);
    }

    /**
     * @param alg the alg to set
     */
    public void setAlg(PasswordGenerator alg) {
        this.alg = alg;
    }

    /*
     * @return the rTrans
     */
    public RegisterTransaction getRTrans() {
        return rTrans;
    }

    public void schedulesPayment(String email) {
        dpt = new DoPaymentTask();

        Organization org = rOrg.getOrganizationByUserEmail(email);
        DefinePayment dp = org.getDefinePayment();
        Date date = dp.getDateToPay();
        Time time = dp.getTimeToPay();
        double nrDays = dp.getNrDays();

        long period = calculatePeriod(nrDays);

        long interval = calculateDifference(date, time);

        Timer t = new Timer();

        dpt.passOrg(org);

        t.scheduleAtFixedRate(dpt, interval, period);

    }

    public long calculateDifference(Date date, Time time) {

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime timeToTimer = ZonedDateTime.of(date.getYear(), date.getMonth(), date.getDia(),
                time.getHours(), time.getMinutes(), time.getSeconds(), 0, ZoneId.of("Europe/London"));

        long diff = ChronoUnit.SECONDS.between(now, timeToTimer);
        return diff;

    }

    public long calculatePeriod(double nrDays) {
        return (long) (Constants.NR_OF_SECONDS_OF_DAY * nrDays);
    }
    public Writer getWriter(){
        return writer;
    }

    public void sendEmail() throws FileNotFoundException {
        List<Freelancer> listFreelancers = rFree.getListFreelancers();
        double delayProb = rFree.getDelayProb();

        for (int i = 0; i < listFreelancers.size(); i++) 
        
        {
            Freelancer free = listFreelancers.get(i);
            TaskList taskL = free.getTaskList();
            List<Task> taskList = taskL.getTaskList();

            for (int j = 0; j < taskList.size(); j++) {
                Task task = taskList.get(j);
                TaskExecution taskExec = task.getTexec();
                double taskDelay = taskExec.getTaskDelay();

                if (taskDelay > 3 && taskDelay > delayProb) {
                    Writer writer = getWriter();
                    writer.sendEmail(free);
                }

            }

        }
    }

    
}
