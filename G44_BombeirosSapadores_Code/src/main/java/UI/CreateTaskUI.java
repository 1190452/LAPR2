/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTaskController;
import Model.Task;
import Utils.Validations;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Optional;
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
    private void confirm(ActionEvent event) throws InterruptedException, IOException {

        if (idTxt.getText().isEmpty() || descriptionTxt.getText().isEmpty() || timeTxt.getText().isEmpty() || costTxt.getText().isEmpty() || categoryTxt.getText().isEmpty()) {
            Alert alert2 = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Creation", "Please introduce the necessary data to create a Task.");
            alert2.show();
        } else {
            if (Validations.isNumeric(costTxt.getText()) && Validations.isNumeric(costTxt.getText())) {
                if (Validations.isNameValid(categoryTxt.getText())) {
                    ctask_controller = new CreateTaskController();
                    Task ts = ctask_controller.newTask(idTxt.getText(), descriptionTxt.getText(),
                            Integer.parseInt(timeTxt.getText()), Double.parseDouble(costTxt.getText()), categoryTxt.getText());
                    Alert alert1 = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Task Creation", ts.toString());

                    if (alert1.showAndWait().get() == ButtonType.OK) {
                        alert1.close();
                    }

                    Alert alert6 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Task Creation", "Do you confirm this task?");
                    boolean verif = false;

                    Optional<ButtonType> option = alert6.showAndWait();
                    if (option.get() == ButtonType.OK) {
                        verif = ctask_controller.registersTask();
                    } else {
                        alert1.close();
                    }

                    if (verif) {
                        AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Adding new Task",
                                verif ? "New Task added with success"
                                        : "It was not possible to add the Task").show();

                        endTask(event);

                    }
                }else{
                     Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Error", "Please introduce a valid Category.");
                    alert.show();
                }

            } else {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Error", "Please introduce valid numbers for the cost and hour.");
                alert.show();
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

    private void endTask(ActionEvent event) {
        idTxt.clear();
        descriptionTxt.clear();
        timeTxt.clear();
        costTxt.clear();
        categoryTxt.clear();

        ((Node) event.getSource()).getScene().getWindow().hide();

    }

}
