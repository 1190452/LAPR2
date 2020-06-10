/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Model.TransactionExecution;
import Utils.CustomValue;
import Utils.Statistic;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Label lblName;
    private Label lblDelay;
    private Label lblPayment;
    private double x, y;
    private Statistic st;
    private List<TransactionExecution> ltr;
    @FXML
    private JFXComboBox<String> combDecision;

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
    private void confirm(ActionEvent event) throws IOException {
         ltr = wsc.getFreelancers();
        String choice = combDecision.getSelectionModel().getSelectedItem();
        Map.Entry<String, CustomValue> entry = wsc.OverallStatistics(getLtr(), choice);
        
        if (choice.equalsIgnoreCase("Payment Deviation of each Freelancer")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentDeviationofEachFreelancer.fxml"));
            Parent root = loader.load();
            PaymentDeviationOfEachFreelancerUI c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } else if (choice.equalsIgnoreCase("Task Execution Delay of each Freelancer")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateManagerCollaborator.fxml"));
            Parent root = loader.load();
            TaskExecutionDelayOfEachFreelancerUI c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } else if (choice.equals("Task Execution Delay of All Freelancers")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TaskExecutionDelayOffAllFreelancers.fxml"));
            Parent root = loader.load();
            TaskExecutionDelayOffAllFreelancersUI c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        }

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
        st = new Statistic();
        combDecision.getItems().addAll("Payment Deviation of each Freelancer", "Task Execution Delay of each Freelancer", "Task Execution Delay of All Freelancers");
    }

    public WatchStatisticsController getController() {
        return wsc;
    }

    /**
     * @return the ltr
     */
    public List<TransactionExecution> getLtr() {
        return ltr;
    }
}
