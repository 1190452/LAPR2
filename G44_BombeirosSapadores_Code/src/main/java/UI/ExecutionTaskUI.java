/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTaskController;
import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import Utils.Date;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class ExecutionTaskUI implements Initializable {

    private CreateTransactionController ct_controller;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    private JFXDatePicker endDateTxt;
    private JFXTextField delayTxt;
    private JFXTextField descriptionTxt;
    @FXML
    private JFXComboBox<Task> listTaskCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ct_controller = new CreateTransactionController();
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
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void confirm(ActionEvent event) {

        try {

            if (endDateTxt.getValue() == null || descriptionTxt.getText().isEmpty() || delayTxt.getText().isEmpty()) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Execution Creation", "Please introduce the necessary data to create a Task Execution.");
                alert.show();
            } else {
                List<Task> taskList = ct_controller.getTaskList();
                ObservableList<Task> tl = FXCollections.observableArrayList(taskList);
                List<Freelancer> freelancerList = ct_controller.getFreelancerList();
                ObservableList<Freelancer> fl = FXCollections.observableArrayList(freelancerList);

                ct_controller.createNewTransaction(taskList, freelancerList, new Date(endDateTxt.getValue().getYear(), endDateTxt.getValue().getMonthValue(), endDateTxt.getValue().getDayOfMonth()), Double.parseDouble(delayTxt.getText()), descriptionTxt.getText());

            }
        } catch (NumberFormatException nfe) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    nfe.getMessage()).show();
        } catch (IllegalArgumentException iae) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    iae.getMessage()).show();
        }
    }

    @FXML
    private void draged(MouseEvent event) {
    }

    @FXML
    private void pressed(MouseEvent event) {
    }

}
