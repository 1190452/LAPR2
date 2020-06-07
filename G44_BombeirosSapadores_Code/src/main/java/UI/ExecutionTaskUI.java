package UI;

import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import Utils.Date;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class ExecutionTaskUI implements Initializable {

    private CreateTransactionController ct_controller;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private JFXDatePicker endDateTxt;
    @FXML
    private JFXTextField delayTxt;
    @FXML
    private JFXTextField descriptionTxt;

    private double x, y;
    @FXML
    private JFXComboBox<Task> listTaskTxt;
    @FXML
    private JFXComboBox<Freelancer> listFreelancerTxt;
    
    private List<Freelancer> freelancerList;
    
    private List<Task> taskList;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ct_controller = new CreateTransactionController();
        taskList = ct_controller.getTaskList();
        listTaskTxt.getItems().addAll(taskList);
        freelancerList = ct_controller.getFreelancerList();
        listFreelancerTxt.getItems().addAll(freelancerList);
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
    }

    @FXML
    private void confirm(ActionEvent event) {

        try {

            if (endDateTxt.getValue() == null || descriptionTxt.getText().isEmpty() || delayTxt.getText().isEmpty()) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Task Execution Creation", "Please introduce the necessary data to create a Task Execution.");
                alert.show();
            } else {
                //ObservableList<Task> tl = FXCollections.observableArrayList(taskList);
                
                //ObservableList<Freelancer> fl = FXCollections.observableArrayList(freelancerList);

                ct_controller.createNewTransaction(listTaskTxt.getSelectionModel().getSelectedItem(), listFreelancerTxt.getSelectionModel().getSelectedItem(), new Date(endDateTxt.getValue().getYear(), endDateTxt.getValue().getMonthValue(), endDateTxt.getValue().getDayOfMonth()), Double.parseDouble(delayTxt.getText()), descriptionTxt.getText());

            }
        } catch (NumberFormatException nfe) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    nfe.getMessage()).show();
        } catch (IllegalArgumentException iae) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    iae.getMessage()).show();
        }
    }

    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

}
