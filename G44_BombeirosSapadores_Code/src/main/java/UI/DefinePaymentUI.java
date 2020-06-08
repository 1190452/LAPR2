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
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class DefinePaymentUI implements Initializable {

    @FXML
    private JFXDatePicker calendarButton;
    @FXML
    private JFXTimePicker timeButton;
    private PaymentController pc;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private JFXTextField nrDaystxt;

    private DefinePayment dp;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pc = new PaymentController();
        dp = new DefinePayment();
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void Confirm(ActionEvent event) {

        Organization org = pc.getOrg();
        Date date = new Date(calendarButton.getValue().getYear(), calendarButton.getValue().getMonthValue(), calendarButton.getValue().getDayOfMonth());
        Time time = new Time(timeButton.getValue().getHour(), timeButton.getValue().getMinute(), timeButton.getValue().getSecond());

        dp = pc.newDefinePayment(time, date, Integer.parseInt(nrDaystxt.getText()));
        Alert alert1 = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Define Payment Hour", dp.toString());
        boolean verif = false;

        Alert alert6 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Define Payment Hour", "Do you confirm this Payment date and hour?");
        Optional<ButtonType> option = alert6.showAndWait();
        if (option.get() == ButtonType.OK) {
            verif = pc.registerDefinePayment();
        } else {
            alert1.close();
        }

        if (verif) {
            AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Define Payment Hour",
                    verif ? "New Date and Hour added with success"
                            : "It was not possible to change the date and hour").show();

            endDP(event);

        }

    }

    @FXML
    private void Cancel(ActionEvent event) {
    }

    private void endDP(ActionEvent event) {
        calendarButton.getEditor().clear();
        timeButton.getEditor().clear();
        nrDaystxt.clear();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
