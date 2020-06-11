/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utils.CustomValue;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class HistogramPaymentDeviationOfEachFreelancerUI implements Initializable {
    @FXML
    private BarChart<?, ?> histogram;
    private PaymentDeviationOfEachFreelancerUIA td;
    private double x, y;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        

    }
    public void associarParentUI(PaymentDeviationOfEachFreelancerUIA td) {
        this.td = td;
    }
    
    public void fillData(){
    
        XYChart.Series set1 = new XYChart.Series<>();
        double value1 = Double.parseDouble(td.getAverageLbl().getText());
        double value2 = Double.parseDouble(td.getDeviationLbl().getText());
        double valueF = value1 -value2;
        double value3 = Double.parseDouble(td.getAverageLbl().getText());
        double value4 = Double.parseDouble(td.getDeviationLbl().getText());
        double valueR = value3 + value4;
        Map.Entry<String, CustomValue> entry = td.getEntry();
        set1.getData().add(new XYChart.Data("]-∞," + valueF + "]", entry.getValue().getLeftDev()));
        set1.getData().add(new XYChart.Data("]" + valueF + "," + valueR + "[", entry.getValue().getMiddleDev()));
        set1.getData().add(new XYChart.Data("[" + valueR + ", +∞[", entry.getValue().getRightDev()));

        histogram.getData().addAll(set1);
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
}
