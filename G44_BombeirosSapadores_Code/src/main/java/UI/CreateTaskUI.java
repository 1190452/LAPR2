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
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    private double x, y;

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
    private void confirm(ActionEvent event) throws InterruptedException {
        ctask_controller = new CreateTaskController();
        if (idTxt.getText().isEmpty() || descriptionTxt.getText().isEmpty() || timeTxt.getText().isEmpty() || costTxt.getText().isEmpty() || categoryTxt.getText().isEmpty()) {
            Alert alert2 = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Creation", "Please introduce the necessary data to create a Task.");
            alert2.show();
        } else {
            
            Task ts = ctask_controller.newTask(idTxt.getText(), descriptionTxt.getText(),
                    Integer.parseInt(timeTxt.getText()), Double.parseDouble(costTxt.getText()), categoryTxt.getText());
            Alert alert1 = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Task Creation", ts.toStringS());
            alert1.show();
            TimeUnit.SECONDS.sleep(5);
            alert1.close();
            Alert alert2 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Task Creation", "Do you confirm this task?");
            alert2.show();
            if (alert2.showAndWait().get() == ButtonType.YES) {
                ctask_controller.registersTask();
                
            } else {
                alert1.close();
            }

        }

    }

    @FXML
    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

}
