/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class PaymentDeviationOfAllFreelancersUI {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button HistogramBtn;
    @FXML
    private Label AverageLbl;
    @FXML
    private Label deviationLbl;
    private WatchStatisticsUI ws;
    private WatchStatisticsController wsc;
    private Map.Entry<String, CustomValue> entry;
    private double x,y;

    public void associarParentUI(WatchStatisticsUI ws) {
        this.ws = ws;
        wsc = this.ws.getController();
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
        List<TransactionExecution> ltr = ws.getLtr();
        entry = getWsc().getPaymentDeviationOfAllFreelancers(ltr);
        getDeviationLbl().setText(Double.toString(getEntry().getValue().getDeviation()));
        getAverageLbl().setText(Double.toString(getEntry().getValue().getMean()));
    }

    @FXML
    private void Histogram(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Histogram (PaymentDeviationOfAllFreelancers).fxml"));
            Parent root = (Parent) loader.load();
            HistogramPaymentDeviationOfAllFreelancersUI c = loader.getController();
            c.associarParentUI(this);
            c.fillData();
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        }catch(IOException e) {
            Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error loading the histogram!", "Please confirm the information first.");
            alert.show();
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
        getDeviationLbl().setText("");
        getAverageLbl().setText("");
        ((Node) event.getSource()).getScene().getWindow().hide();
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

    /**
     * @return the wsc
     */
    public WatchStatisticsController getWsc() {
        return wsc;
    }
}
