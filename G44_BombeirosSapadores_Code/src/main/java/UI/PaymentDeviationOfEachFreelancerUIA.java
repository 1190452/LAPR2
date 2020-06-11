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
import Utils.CustomValue;
import com.jfoenix.controls.JFXComboBox;
import com.sun.glass.ui.Application;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class PaymentDeviationOfEachFreelancerUIA {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXComboBox<String> freelEmail;
    @FXML
    private Label freelancerLbl;
    @FXML
    private Label AverageLbl;
    @FXML
    private Label deviationLbl;
    @FXML
    private Button HistogramBtn;
    
    private double x,y;
    private CheckPerformanceUI cp;
    private CheckPerformanceController cpc;
    private Map.Entry<String, CustomValue> entry;

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
        ApplicationPOT app = ApplicationPOT.getInstance();
        List<Organization> lorg = app.getPlatform().getrOrg().getlOrg();
        List<TransactionExecution> ltr = cpc.getAllTransactionExecution(lorg);
        entry = cpc.getPaymentDeviationOfEachFreelancer(name, ltr);
        freelancerLbl.setText(getEntry().getKey());
        deviationLbl.setText(Double.toString(getEntry().getValue().getDeviation()));
        AverageLbl.setText(Double.toString(getEntry().getValue().getMean()));
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
    @FXML
    private void Histogram(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Histogram (PaymentDeviationOfEachFreelancer).fxml"));
        Parent root = (Parent)loader.load();
        HistogramPaymentDeviationOfEachFreelancerUI c = loader.getController();
        c.associarParentUI(this);
        c.fillData();
        Scene create = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(create);
        window.show();
    }
    private void endWatch(ActionEvent event) {
        getFreelEmail().getSelectionModel().clearSelection();
        getFreelancerLbl().setText("");
        getDeviationLbl().setText("");
        getAverageLbl().setText("");
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * @return the freelEmail
     */
    public JFXComboBox<?> getFreelEmail() {
        return freelEmail;
    }

    /**
     * @return the freelancerLbl
     */
    public Label getFreelancerLbl() {
        return freelancerLbl;
    }

    /**
     * @return the AverageLbl
     */
    public Label getAverageLbl() {
        return AverageLbl;
    }

    /**
     * @return the deviationLbl
     */
    public Label getDeviationLbl() {
        return deviationLbl;
    }

    /**
     * @return the entry
     */
    public Map.Entry<String, CustomValue> getEntry() {
        return entry;
    }

   public void associarParentUI(CheckPerformanceUI cp) {
        this.cp = cp;
        this.cpc = this.cp.getCpc();
                
    }
}
