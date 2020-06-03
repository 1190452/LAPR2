/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import Utils.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionUI {
    static Scanner read = new Scanner(System.in);
    private CreateTransactionController ct_controller;
    
    public CreateTransactionUI (){
        ct_controller = new CreateTransactionController();
        List<Task> taskList = ct_controller.getTaskList();
        List<Freelancer> freelancerList = ct_controller.getFreelancerList();
        System.out.println("Please introduce the end date");
        int year = Integer.parseInt(read.next());
        int month = Integer.parseInt(read.next());
        int day = Integer.parseInt(read.next());
        Date endDate = new Date(year, month, day);
        double delay = read.nextDouble();
        String qow = read.next();
        //ct_controller.createNewTransaction(task, freel, endDate, delay, qow);
    }
  
}
