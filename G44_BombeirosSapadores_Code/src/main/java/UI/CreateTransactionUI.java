/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import Model.Transaction;
import Utils.Date;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author OMEN X
 */
public class CreateTransactionUI {
    static Scanner read = new Scanner(System.in);
    private CreateTransactionController ct_controller;
    @FXML
    private JFXDatePicker calendarButton;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private JFXTextField DelayTxt;
    @FXML
    private JFXTextField qowTxt;
    
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
        
        //Transaction trans ...
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void Confirm(ActionEvent event) {
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
  
}
