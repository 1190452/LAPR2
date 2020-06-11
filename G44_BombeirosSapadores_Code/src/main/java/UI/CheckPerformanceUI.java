/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CheckPerformanceController;
import Controller.WatchStatisticsController;
import Model.ApplicationPOT;
import Model.Organization;
import Model.TransactionExecution;
import Utils.Statistic;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author OMEN X
 */
public class CheckPerformanceUI implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXComboBox<String> combDecision;
    private CheckPerformanceController cpc;
    private Statistic st;
    private List<TransactionExecution> ltr;
    private List<Organization> lorg;
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
    private void confirm(ActionEvent event) throws IOException {

        String choice = combDecision.getSelectionModel().getSelectedItem();

        if (choice.equalsIgnoreCase("Payment Deviation of each Freelancer")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentDeviationOfEachFreelancer.fxml"));
            Parent root = (Parent) loader.load();
            PaymentDeviationOfEachFreelancerUIA c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } else if (choice.equalsIgnoreCase("Payment Deviation off all Freelancers")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentDeviationOfAllFreelancersA.fxml"));
            Parent root = (Parent) loader.load();
            PaymentDeviationOfAllFreelancersUIA c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } else if (choice.equalsIgnoreCase("Task Execution Delay of each Freelancer")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TaskExecutionDelayOfEachFreelancer.fxml"));
            Parent root = (Parent) loader.load();
            TaskExecutionDelayOfEachFreelancerUIA c = loader.getController();
            c.associarParentUI(this);
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } else if (choice.equals("Task Execution Delay of All Freelancers")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TaskExecutionDelayOfAllFreelancers.fxml"));
            Parent root = (Parent) loader.load();
            TaskExecutionDelayOfAllFreelancersUI c = loader.getController();
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

        combDecision.getSelectionModel().clearSelection();

        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cpc = new CheckPerformanceController();
        combDecision.getItems().addAll("Payment Deviation of each Freelancer", "Payment Deviation off all Freelancers", "Task Execution Delay of each Freelancer", "Task Execution Delay of All Freelancers");
    }

    /**
     * @return the cpc
     */
    public CheckPerformanceController getCpc() {
        return cpc;
    }

}
