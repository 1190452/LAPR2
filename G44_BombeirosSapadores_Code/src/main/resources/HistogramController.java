/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HistogramController implements Initializable {

    @FXML
    private BarChart<?, ?> histogram;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("]-∞, µ-σ]",  ));
        set1.getData().add(new XYChart.Data("]µ- σ,µ+σ[",  ));
        set1.getData().add(new XYChart.Data("[µ+σ, +∞[",  ));
        
        histogram.getData().addAll(set1);
        
        
    }    

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void dragged(MouseEvent event) {
    }

    @FXML
    private void pressed(MouseEvent event) {
    }
    
}
