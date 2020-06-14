/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Model.ApplicationPOT;
import Model.Constants;
import Model.Freelancer;
import Model.TransactionExecution;
import Utils.CustomValue;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class PaymentDeviationOfEachFreelancerUI implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXComboBox<String> freelEmail;
    @FXML
    private Label freelancerLbl;
    @FXML
    private Label deviationLbl;

    private WatchStatisticsUI ws;
    private WatchStatisticsController wsc;
    private double x, y;
    @FXML
    private Label AverageLbl;
    private List<Freelancer> freel;
    @FXML
    private Button histogramButon;
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
        List<TransactionExecution> ltr = ws.getLtr();
        entry = wsc.getPaymentDeviationOfEachFreelancer(name, ltr);
        getFreelancerLbl().setText(getEntry().getKey());
        getDeviationLbl().setText(Double.toString(getEntry().getValue().getDeviation()));
        getAverageLbl().setText(Double.toString(getEntry().getValue().getMean()));
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
        getFreelancerLbl().setText("");
        getDeviationLbl().setText("");
        getAverageLbl().setText("");
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        
        if(ap.getActualSession().getUserBySession().getRole().equalsIgnoreCase(Constants.ROLE_ADMINISTRATIVE)){
            this.histogramButon.setVisible(true);
        }else{
             this.histogramButon.setVisible(false);
        }
        freel = ap.getPlatform().getRfree().getListFreelancers();
        for (int i = 0; i < freel.size(); i++) {
            freelEmail.getItems().add(freel.get(i).getEmail());
        }
    }

    @FXML
    private void histogram(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Histogram (PaymentDeviationOfEachFreelancer).fxml"));
            Parent root = (Parent) loader.load();
            HistogramPaymentDeviationOfEachFreelancerUI c = loader.getController();
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

    /**
     * @return the freelancerLbl
     */
    public Label getFreelancerLbl() {
        return freelancerLbl;
    }

    /**
     * @return the deviationLbl
     */
    public Label getDeviationLbl() {
        return deviationLbl;
    }

    /**
     * @return the AverageLbl
     */
    public Label getAverageLbl() {
        return AverageLbl;
    }

    /**
     * @return the entry
     */
    public Map.Entry<String, CustomValue> getEntry() {
        return entry;
    }

}
