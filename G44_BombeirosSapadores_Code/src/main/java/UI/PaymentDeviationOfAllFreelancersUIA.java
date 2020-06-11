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
public class PaymentDeviationOfAllFreelancersUIA {

     @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button HistogramBtn;
    @FXML
    private Label freelancerLbl;
    @FXML
    private Label AverageLbl;
    @FXML
    private Label deviationLbl;

    private double x, y;
    private CheckPerformanceUI cp;
    private CheckPerformanceController cpc;
    private Map.Entry<String, CustomValue> entry;

    public void associarParentUI(CheckPerformanceUI ws) {
        this.cp = cp;
        cpc = this.cp.getCpc();
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
        endWatch(event);
    }

    @FXML
    private void confirm(ActionEvent event) {   
        ApplicationPOT app = ApplicationPOT.getInstance();
        List<Organization> lorg = app.getPlatform().getrOrg().getlOrg();
        List<TransactionExecution> ltr = cpc.getAllTransactionExecution(lorg);
        entry = cpc.getPaymentDeviationOfAllFreelancers(ltr);
        getFreelancerLbl().setText(getEntry().getKey());
        getDeviationLbl().setText(Double.toString(getEntry().getValue().getDeviation()));
        getAverageLbl().setText(Double.toString(getEntry().getValue().getMean()));
    }

    @FXML
    private void Histogram(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Histogram (PaymentDeviationOfAllFreelancers).fxml"));
        Parent root = (Parent) loader.load();
        HistogramPaymentDeviationOfAllFreelancersUI c = loader.getController();
        c.associarParentUI(this);
        c.fillData();
        Scene create = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(create);
        window.show();
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

        getFreelancerLbl().setText("");
        getDeviationLbl().setText("");
        getAverageLbl().setText("");
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    /**
     * @return the freelancerLbl
     */
    public Label getFreelancerLbl() {
        return freelancerLbl;
    }

    /**
     * @param freelancerLbl the freelancerLbl to set
     */
    public void setFreelancerLbl(Label freelancerLbl) {
        this.freelancerLbl = freelancerLbl;
    }

    /**
     * @return the AverageLbl
     */
    public Label getAverageLbl() {
        return AverageLbl;
    }

    /**
     * @param AverageLbl the AverageLbl to set
     */
    public void setAverageLbl(Label AverageLbl) {
        this.AverageLbl = AverageLbl;
    }

    /**
     * @return the deviationLbl
     */
    public Label getDeviationLbl() {
        return deviationLbl;
    }

    /**
     * @param deviationLbl the deviationLbl to set
     */
    public void setDeviationLbl(Label deviationLbl) {
        this.deviationLbl = deviationLbl;
    }

    /**
     * @return the wsc
     */
    public CheckPerformanceController getWsc() {
        return cpc;
    }

    /**
     * @return the entry
     */
    public Map.Entry<String, CustomValue> getEntry() {
        return entry;
    }
}
