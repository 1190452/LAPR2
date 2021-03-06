/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;
import Utils.CustomValue;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class HistogramPaymentDeviationOfAllFreelancersUI {

    @FXML
    private BarChart<?, ?> histogram;
    private double x, y;
    private PaymentDeviationOfAllFreelancersUI tda;
    private WatchStatisticsController wsc;

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

    public void fillData() {
        XYChart.Series set1 = new XYChart.Series<>();
        double value1 = Double.parseDouble(tda.getAverageLbl().getText()) - Double.parseDouble(tda.getDeviationLbl().getText());
        double value2 = Double.parseDouble(tda.getAverageLbl().getText()) + Double.parseDouble(tda.getDeviationLbl().getText());
        Map.Entry<String, CustomValue> entry = tda.getEntry();

        set1.getData().add(new XYChart.Data("]-∞," + value1 + "]", entry.getValue().getLeftDev()));
        set1.getData().add(new XYChart.Data("]" + value1 + "," + value2 + "[", entry.getValue().getMiddleDev()));
        set1.getData().add(new XYChart.Data("[" + value2 + ", +∞[", entry.getValue().getRightDev()));
        histogram.getData().addAll(set1);
    }

    public void associarParentUI(PaymentDeviationOfAllFreelancersUI tda) {
        this.tda = tda;
        this.wsc = this.tda.getWsc();
    }

}
