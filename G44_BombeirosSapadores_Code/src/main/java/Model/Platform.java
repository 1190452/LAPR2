
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
import java.time.Year;
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

    }

    //======================================================================================================================================================
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
     *
     */
    public void scheduleProcess() {
        Date date = getLastDayDate();
        sEF = new SendEmailFreelTask();
        Timer t = new Timer();
        sEF.setTimer(t);
        long delay = calculateDifferenceDate(date);
        long interval = getYearInterval();
        t.scheduleAtFixedRate(sEF, delay, interval);

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
     * method that "sends" and email to mean performance freelancers
     *
     * @throws FileNotFoundException
     */
    public void sendEmail() throws FileNotFoundException {
        List<Freelancer> listFreelancers = rFree.getListFreelancers();
        double delayPercentage = rFree.getDelayProb()*100;
        List<Organization> orgList = rOrg.getlOrg();
        for (int i = 0; i < orgList.size(); i++) {
            List<TransactionExecution> transList = orgList.get(i).getRTrans().getTransactions();

            for (int j = 0; j < transList.size(); j++) {
                double taskDelay = transList.get(j).getTaskDelay();
                if (taskDelay > 3 && taskDelay > delayProb) {
                    Freelancer free = transList.get(j).getFreel();
                    Writer.sendEmail(free);
                }
        }
    }
    }
    /**
     * Returns true if the year received by parameter is a leap year. If the
     * year received by parameter is not a leap year, it returns false.
     *
     * @param year the year to be validated.
     * @return true if the year received by parameter is a leap year, otherwise
     * it is false.
     */
    public static boolean leapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    //======================================================================================================================================================

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
     * returns the register user
     *
     * @return the rUser
     */
    public RegisterUser getrUser() {
        return rUser;
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
     * return the password generator
     *
     * @return the alg
     */
    public PasswordGenerator getAlg() {
        return alg;
    }

    public long getYearInterval() {
        return 366 * 24 * 60 * 60 * 1000;
    }

    /**
     * return a date with the last day of the year
     *
     * @return
     */
    public Date getLastDayDate() {
        int year = Year.now().getValue();
        return new Date(year, 12, 31);
    }

    /**
     * return the writer
     *
     * @return
     */
    public Writer getWriter() {
        return writer;
    }

    //======================================================================================================================================================
    /**
     * modifies the register user
     *
     * @param rUser the rUser to set
     */
    public void setrUser(RegisterUser rUser) {
        this.rUser = rUser;
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
     * modifies the password generator
     *
     * @param alg the alg to set
     */
    public void setAlg(PasswordGenerator alg) {
        this.alg = alg;
    }

}
