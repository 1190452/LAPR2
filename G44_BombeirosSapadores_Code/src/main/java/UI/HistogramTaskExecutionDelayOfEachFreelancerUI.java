package UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * FXML Controller class
 *
 * @author User
 */
public class HistogramTaskExecutionDelayOfEachFreelancerUI implements Initializable {

    @FXML
    private BarChart<?, ?> histogram;
    private TaskExecutionDelayOfEachFreelancerUI td;
    private double x, y;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();

<<<<<<< HEAD:G44_BombeirosSapadores_Code/src/main/java/UI/HistogramUI.java
//        set1.getData().add(new XYChart.Data("]-∞, µ-σ]",));
//        set1.getData().add(new XYChart.Data("]µ- σ,µ+σ[",));
//        set1.getData().add(new XYChart.Data("[µ+σ, +∞[",));
=======
        set1.getData().add(new XYChart.Data("]-∞, µ-σ]",3));
        set1.getData().add(new XYChart.Data("]µ- σ,µ+σ[",3));
        set1.getData().add(new XYChart.Data("[µ+σ, +∞[",3));
>>>>>>> 3ad1f585a254575f3770ede36f8f2f4b3331b2fb:G44_BombeirosSapadores_Code/src/main/java/UI/HistogramTaskExecutionDelayOfEachFreelancerUI.java

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

    public void associarParentUI(TaskExecutionDelayOfEachFreelancerUI td) {
        this.td = td;     
                
    }

}
