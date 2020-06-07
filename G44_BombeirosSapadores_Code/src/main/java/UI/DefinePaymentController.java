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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author tiagopereira
 */
public class DefinePaymentController implements Initializable {

    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private JFXDatePicker calendarButton;
    private JFXTimePicker timeButton;
    private PaymentController pc;
    @FXML
    private JFXTextField DelayTxt;
    @FXML
    private JFXTextField qowTxt;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pc = new PaymentController();
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
        DefinePayment dp = pc.newDefinePayment(time, date, 0);

    }

    @FXML
    private void Cancel(ActionEvent event) {
    }

}
