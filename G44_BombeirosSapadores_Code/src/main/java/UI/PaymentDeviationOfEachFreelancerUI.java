/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Utils.CustomValue;
import com.jfoenix.controls.JFXComboBox;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class PaymentDeviationOfEachFreelancerUI {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXComboBox<String> freelEmail;
    @FXML
    private Button HistogramBtn;
    @FXML
    private Label freelancerLbl;
    @FXML
    private Label deviationLbl;
    @FXML
    private Label averageLbl;

    private WatchStatisticsUI ws;
    private WatchStatisticsController wsc;
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
        String name = freelEmail.getValue();
        Map.Entry<String, CustomValue> entry = wsc.OverallStatistics(ltr, name)
    }

    @FXML
    private void Histogram(ActionEvent event) {
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

    public void associarParentUI(WatchStatisticsUI ws) {
        this.ws = ws;
        wsc = this.ws.getController();
    }

    private void endWatch(ActionEvent event) {
        freelEmail.getSelectionModel().clearSelection();
        freelancerLbl.setText("");
        deviationLbl.setText("");
        averageLbl.setText("");
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
