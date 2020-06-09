package UI;

import Controller.CreateTransactionController;
import Model.Freelancer;
import Model.Task;
import Model.TransactionExecution;
import Utils.Date;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        endTransaction(event);
    }

    @FXML
    private void confirm(ActionEvent event) {

        try {

            if (endDateTxt.getValue() == null || descriptionTxt.getText().isEmpty() || delayTxt.getText().isEmpty()) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Transaction Creation", "Please introduce the necessary data to create a Transaction.");
                alert.show();
            } else {
                TransactionExecution ts = ct_controller.createNewTransaction(listTaskTxt.getSelectionModel().getSelectedItem(), listFreelancerTxt.getSelectionModel().getSelectedItem(), new Date(endDateTxt.getValue().getYear(), endDateTxt.getValue().getMonthValue(), endDateTxt.getValue().getDayOfMonth()), Double.parseDouble(delayTxt.getText()), descriptionTxt.getText());
                 Alert alert1 = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Transaction Creation", ts.toString());

                if (alert1.showAndWait().get() == ButtonType.OK) {
                    alert1.close();
                }

                Alert alert6 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Transaction Creation", "Do you confirm this transaction?");
                boolean verif = false;

                Optional<ButtonType> option = alert6.showAndWait();
                if (option.get() == ButtonType.OK) {
                    verif = ct_controller.registerTransaction();
                } else {
                    alert1.close();
                }

                if (verif) {
                    AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Adding new Transaction",
                            verif ? "New Transaction added with success"
                                    : "It was not possible to add the Transaction").show();

                    endTransaction(event);

                }
            }
        } catch (NumberFormatException nfe) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    nfe.getMessage()).show();
        } catch (IllegalArgumentException iae) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    iae.getMessage()).show();
        }
    }

    @FXML
    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    private void endTransaction(ActionEvent event) {
       listFreelancerTxt.getSelectionModel().clearSelection();
       listTaskTxt.getSelectionModel().clearSelection();
       delayTxt.clear();
       descriptionTxt.clear();
       endDateTxt.getEditor().clear();
       
       ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
