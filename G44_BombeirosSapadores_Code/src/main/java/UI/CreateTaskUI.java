/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTaskController;
import Model.Task;
import com.jfoenix.controls.JFXTextField;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ricardo
 */
public class CreateTaskUI {
    Scanner read = new Scanner(System.in);
    private CreateTaskController ctask_controller;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXTextField idTxt;
    @FXML
    private JFXTextField descriptionTxt;
    @FXML
    private JFXTextField timeTxt;
    @FXML
    private JFXTextField costTxt;
    @FXML
    private JFXTextField categoryTxt;
    
    public CreateTaskUI(){
        ctask_controller = new CreateTaskController();   
        System.out.println("Introduce the id, brief description, time duration (in hours), cost per hour (in euros), and the category");
        String id = read.next();
        String bd = read.nextLine();
        int td = read.nextInt();
        double ch = read.nextDouble();
        String ct = read.nextLine();
        Task ts = ctask_controller.newTask(id, bd, td, ch, ct);
        System.out.println(ts.toString());
        System.out.println("Confirma?");
        boolean ans = read.nextBoolean();
        if(ans==true){
            if(ctask_controller.registersTask()){
                System.out.println("Operation Successfull");
            }
            
        }else{
            System.out.println("failure");
        }
        
    }

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void confirm(ActionEvent event) {
    }
    
    
    
}
