/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.PaymentController;
import Model.DefinePayment;
import Model.Organization;
import Utils.Date;
import Utils.Time;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class PaymentUI {

    private PaymentController pc;
    Scanner read = new Scanner(System.in);

    public PaymentUI() {
        Organization org = pc.getOrg();
        System.out.println("Introduce the Date (year, month and day)");
        int year = read.nextInt();
        int month = read.nextInt();
        int day = read.nextInt();
        Date date = new Date(year, month, day);
        System.out.println("Introduce the time of the day (hour, min and sec)");
        int hour = read.nextInt();
        int min = read.nextInt();
        int sec = read.nextInt();
        Time time = new Time(hour, min, sec);
        System.out.println("Introduce the recurrence time period(e.g 7 days)");
        int rtp = read.nextInt();
        DefinePayment dp = pc.newDefinePayment(time, date, rtp);
        System.out.println(dp.toString());
        boolean choice = read.nextBoolean();
        if (choice) {
            if (pc.registerDefinePayment()) {
                System.out.println("Operation Successfull");
            }
        }
    }
}
