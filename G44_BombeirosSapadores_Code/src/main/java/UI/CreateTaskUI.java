/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTaskController;
import Model.Task;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    public CreateTaskUI() {
        //ctask_controller = new CreateTaskController();   
        //System.out.println("Introduce the id, brief description, time duration (in hours), cost per hour (in euros), and the category");

//        System.out.println(ts.toString());
//        System.out.println("Confirma?");
//        boolean ans = read.nextBoolean();
//        if(ans==true){
//            if(ctask_controller.registersTask()){
//                System.out.println("Operation Successfull");
//            }
//            
//        }else{
//            System.out.println("failure");
//        }
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
    }

    @FXML
    private void confirm(ActionEvent event) {

        //try {
            
            String id = idTxt.getSelectedText();
            String bd = descriptionTxt.getSelectedText();
            int td = Integer.parseInt(timeTxt.getSelectedText());
            double ch = Double.parseDouble(costTxt.getSelectedText());
            String ct = categoryTxt.getSelectedText();
            ctask_controller = new CreateTaskController();
            
            Task ts = ctask_controller.newTask(id, bd, td, ch, ct);
            if(ts == null){
                
            }
        

    }

}
