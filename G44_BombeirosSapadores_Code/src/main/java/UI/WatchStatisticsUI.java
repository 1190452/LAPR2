/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Model.Freelancer;
import Utils.CustomValue;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsUI implements Initializable {

    private WatchStatisticsController wsc;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Label lblName;
    @FXML
    private Label lblDelay;
    @FXML
    private Label lblPayment;
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
    private void cancel(ActionEvent event) {
        endWatch(event);
    }

    @FXML
    private void confirm(ActionEvent event) {
        Map.Entry<Freelancer, CustomValue> entryPayment = wsc.OverallStatistics();
        Map.Entry<Freelancer, CustomValue> entryTaskExecution = wsc.OverallStatistics();
        
    }

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void endWatch(ActionEvent event) {
        lblName.setText("");
        lblDelay.setText("");
        lblPayment.setText("");

        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wsc = new WatchStatisticsController();
    }
}
