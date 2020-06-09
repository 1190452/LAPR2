
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DoPaymentTask;
import Controller.SendEmailFreelTask;
import Utils.PasswordGenerator;
import Utils.Date;
import Utils.Time;
import Authorization.FacadeAuthorization;
import Authorization.model.RegisterUser;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Platform implements Serializable {

    /**
     * facade authorization
     */
    private final FacadeAuthorization m_oAutorizacao;

    /**
     * register organization
     */
    private RegisterOrganization rOrg;

    /**
     * register freelancer
     */
    private RegisterFreelancer rFree;

    /**
     * register user
     */
    private RegisterUser rUser;

    /**
     * register transaction
     */
    private RegisterTransaction rTrans;

    /**
     * import txt file
     */
    private ImportTxtFile itxt;

    /**
     * import csv file
     */
    private ImportCsvFile icsv;

    /**
     * password generator
     */
    private PasswordGenerator alg;

    /**
     * do payment task
     */
    private DoPaymentTask dpt;

    /**
     * send email to mean performance freelancers task
     */
    private SendEmailFreelTask sEF;

    /**
     * writer
     */
    private Writer writer;

    /**
     * constructor than initializes the necessary classes (FacadeAuthorization,
     * RegisterOrganization, RegisterFreelancer, PasswordGenerator)
     */
    public Platform() {
        this.m_oAutorizacao = new FacadeAuthorization();
        this.rOrg = new RegisterOrganization();
        this.rFree = new RegisterFreelancer();
        PasswordGenerator.PasswordGeneratorBuilder pg = new PasswordGenerator.PasswordGeneratorBuilder();
        pg.useLower(true);
        pg.useDigits(true);
        this.alg = pg.build();
        this.itxt = new ImportTxtFile();
        this.icsv = new ImportCsvFile();
        this.rTrans = new RegisterTransaction();
    }

    /**
     * returns the facade authorization
     *
     * @return
     */
    public FacadeAuthorization getFacadeAuthorazation() {
        return this.m_oAutorizacao;
    }

    /**
     * returns the register freelancer
     *
     * @return
     */
    public RegisterFreelancer getRfree() {
        return rFree;
    }

    /**
     * method that validates the organization created
     *
     * @param oOrganizacao
     * @param strPwd
     * @return
     */
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
     * returns the register user
     *
     * @return the rUser
     */
    public RegisterUser getrUser() {
        return rUser;
    }

    /**
     * modifies the register user
     *
     * @param rUser the rUser to set
     */
    public void setrUser(RegisterUser rUser) {
        this.rUser = rUser;
    }

    /**
     * returns the register organization
     *
     * @return the rOrg
     */
    public RegisterOrganization getrOrg() {
        return rOrg;
    }

    /**
     * modifies the register organization
     *
     * @param rOrg the rOrg to set
     */
    public void setrOrg(RegisterOrganization rOrg) {
        this.rOrg = rOrg;
    }

    /**
     * method that loads and returns a list of transactions
     *
     * @param fileName
     * @return
     */
    public List<TransactionExecution> loadHistoricalTransaction(String fileName) {
        if (fileName.endsWith(".txt")) {
            rTrans = itxt.importFile(fileName);
            List<TransactionExecution> lt = rTrans.getTransactions();
            return lt;
        } else if (fileName.endsWith(".csv")) {
            rTrans = icsv.importFile(fileName);
            List<TransactionExecution> lt = getRTrans().getTransactions();
            if (getRTrans().validateHistoricalTransaction(lt)) {
                return lt;
            }

        }
        return null;
    }

    /**
     * return the password generator
     *
     * @return the alg
     */
    public PasswordGenerator getAlg() {
        return alg;
    }

    /**
     *
     */
    public void scheduleProcess() {
        Date date = getLastDayDate();
        sEF = new SendEmailFreelTask();
        Timer t = new Timer();
        //t.schedule(sEF, date);

    }

    /**
     * return a date with the last day of the year
     *
     * @return
     */
    public Date getLastDayDate() {
        return new Date(12, 31);
    }

    /**
     * modifies the password generator
     *
     * @param alg the alg to set
     */
    public void setAlg(PasswordGenerator alg) {
        this.alg = alg;
    }

    /**
     * returns the register transaction
     *
     * @return the rTrans
     */
    public RegisterTransaction getRTrans() {
        return rTrans;
    }

    /**
     * method that schedules the payment to the freelancer
     *
     * @param email
     */
    public void schedulesPayment(String email) {
        dpt = new DoPaymentTask();

        Organization org = rOrg.getOrganizationByUserEmailMan(email);
        DefinePayment dp = org.getDefinePayment();
        Date date = dp.getDateToPay();
        Time time = dp.getTimeToPay();
        double nrDays = dp.getNrDays();

        long period = calculatePeriod(nrDays);

        long interval = calculateDifference(date, time);

        Timer t = new Timer();
        
        

        dpt.passOrg(org);
        System.out.println("Timer uc7 defined");
        t.scheduleAtFixedRate(dpt, interval * 1000, period * 1000);

    }

    /**
     * method that calculates the difference between two times in seconds
     *
     * @param date
     * @param time
     * @return
     */
    public long calculateDifference(Date date, Time time) {

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime timeToTimer = ZonedDateTime.of(date.getYear(), date.getMonth(), date.getDay(),
                time.getHours(), time.getMinutes(), time.getSeconds(), 0, ZoneId.of("Europe/London"));

        long diff = ChronoUnit.SECONDS.between(now, timeToTimer);
        return diff;

    }
      public long calculateDifferenceDate(Date date) {
        Time time = new Time();
        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime timeToTimer = ZonedDateTime.of(date.getYear(), date.getMonth(), date.getDay(),
                time.getHours(), time.getMinutes(), time.getSeconds(), 0, ZoneId.of("Europe/London"));

        long diff = ChronoUnit.MILLIS.between(now, timeToTimer);
        return diff;

    }

    /**
     * method that calculates a period
     *
     * @param nrDays
     * @return
     */
    public long calculatePeriod(double nrDays) {
        return (long) (Constants.NR_OF_SECONDS_OF_DAY * nrDays);
    }

    /**
     * return the writer
     *
     * @return
     */
    public Writer getWriter() {
        return writer;
    }

    /**
     * method that "sends" and email to mean performance freelancers
     *
     * @throws FileNotFoundException
     */
    public void sendEmail() throws FileNotFoundException {
        List<Freelancer> listFreelancers = rFree.getListFreelancers();
        double delayProb = rFree.getDelayProb();

        List<TransactionExecution> transList = rTrans.getTransactions();
        for (int i = 0; i < transList.size(); i++) {
            double taskDelay = transList.get(i).getTaskDelay();
            if (taskDelay > 3 && taskDelay > delayProb) {
                Freelancer free = transList.get(i).getFreel();
                Writer.sendEmail(free);
            }
        }
    }
}
