/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Model.ApplicationPOT;
import Model.Constants;
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
 * @author tiagopereira
 */
public class WatchStatisticsUI implements Initializable {

    private WatchStatisticsController wsc;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
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

        switch (choice) {
            case "Payment Deviation of each Freelancer":
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentDeviationOfEachFreelancer.fxml"));
                Parent root = (Parent) loader.load();
                PaymentDeviationOfEachFreelancerUI c = loader.getController();
                c.associarParentUI(this);
                Scene create = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(create);
                window.show();
                break;
            case "Task Execution Delay of each Freelancer":
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/TaskExecutionDelayOfEachFreelancer.fxml"));
                Parent root1 = (Parent) loader1.load();
                TaskExecutionDelayOfEachFreelancerUI c1 = loader1.getController();
                c1.associarParentUI(this);
                Scene create1 = new Scene(root1);
                Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window1.setScene(create1);
                window1.show();
                break;
            case "Task Execution Delay of All Freelancers":
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/TaskExecutionDelayOfAllFreelancers.fxml"));
                Parent root2 = (Parent) loader2.load();
                TaskExecutionDelayOfAllFreelancersUI c2 = loader2.getController();
                c2.associarParentUI(this);
                Scene create2 = new Scene(root2);
                Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window2.setScene(create2);
                window2.show();
                break;
            case "Payment Deviation off all Freelancers":
                break;
            default:
                System.out.println("Ecra nao disponivel");
                break;

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
        wsc = new WatchStatisticsController();
        ApplicationPOT ap = ApplicationPOT.getInstance();
        if (ap.getActualSession().getUserBySession().getRole().equalsIgnoreCase(Constants.ROLE_ADMINISTRATIVE)) {
            combDecision.getItems().clear();
            combDecision.getItems().addAll("Payment Deviation of each Freelancer", "Payment Deviation of all Freelancers", "Task Execution Delay of each Freelancer", "Task Execution Delay of All Freelancers");
        } else {
            combDecision.getItems().clear();
            combDecision.getItems().addAll("Payment Deviation of each Freelancer", "Task Execution Delay of each Freelancer", "Task Execution Delay of All Freelancers");
        }

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
