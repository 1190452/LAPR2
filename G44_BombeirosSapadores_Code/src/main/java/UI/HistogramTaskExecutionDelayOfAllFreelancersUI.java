/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
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
public class HistogramTaskExecutionDelayOfAllFreelancersUI implements Initializable{

    @FXML
    private BarChart<?, ?> histogram;
    private double x,y;
    private TaskExecutionDelayOfAllFreelancersUI tda;

      /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("]-∞, µ-σ]",3));
        set1.getData().add(new XYChart.Data("]µ- σ,µ+σ[",3));
        set1.getData().add(new XYChart.Data("[µ+σ, +∞[",3));

        histogram.getData().addAll(set1);

    }

    public void associarParentUI(TaskExecutionDelayOfAllFreelancersUI tda){
        this.tda = tda;
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

    void associarParentUI(TaskExecutionDelayOfEachFreelancerUI td) {
        this.td = td;
    }

}
