/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Model.ApplicationPOT;
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
public class TaskExecutionDelayOfEachFreelancerUI implements Initializable {

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
    private Label AverageLbl;
    @FXML
    private Label deviationLbl;

    private WatchStatisticsUI ws;
    private WatchStatisticsController wsc;
    private double x, y;
    private List<Freelancer> freel;
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
        entry = wsc.getTaskExecutionDelayOfEachFreelancer(name, ltr);
        freelancerLbl.setText(getEntry().getKey());
        deviationLbl.setText(Double.toString(getEntry().getValue().getDeviation()));
        AverageLbl.setText(Double.toString(getEntry().getValue().getMean()));
    }

    @FXML
    private void Histogram(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Histogram (TaskExecutionDelayOfEachFreelancer).fxml"));
            Parent root = (Parent) loader.load();
            HistogramTaskExecutionDelayOfEachFreelancerUI c = loader.getController();
            c.associarParentUI(this);
            c.fillData();
            Scene create = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(create);
            window.show();
        } catch (IOException e) {
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

    public void associarParentUI(WatchStatisticsUI ws) {
        this.ws = ws;
        wsc = this.ws.getController();
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
    public JFXComboBox<String> getFreelEmail() {
        return freelEmail;
    }

    /**
     * @param freelEmail the freelEmail to set
     */
    public void setFreelEmail(JFXComboBox<String> freelEmail) {
        this.freelEmail = freelEmail;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        freel = ap.getPlatform().getRfree().getListFreelancers();
        for (int i = 0; i < freel.size(); i++) {
            freelEmail.getItems().add(freel.get(i).getEmail());
        }
    }

    /**
     * @return the entry
     */
    public Map.Entry<String, CustomValue> getEntry() {
        return entry;
    }

}
