/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.HistoricalTransactionController;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionUI implements Initializable {

    private HistoricalTransactionController ht_controller;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button openFile;
    @FXML
    private Label lbl;
    @FXML
    private BorderPane borderPane;

    private double x, y;
    private List<File> files;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ht_controller = new HistoricalTransactionController();
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
    private void Confirm(ActionEvent event) {
        for (int i = 0; i < files.size(); i++) {
            boolean loaded = ht_controller.loadHistoricalTransaction(files.get(i).getName());
            Alert alert6 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Loading File", "Do you confirm this File?");        
            Optional<ButtonType> option = alert6.showAndWait();
            if (option.get() == ButtonType.OK) {
                AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Adding new File",
                        loaded ? "New File added with success"
                                : "It was not possible to add the File").show();
                endLoad(event);
            } 
        }

    }

    @FXML
    private void Cancel(ActionEvent event) {
        endLoad(event);
    }

    @FXML
    private void btnAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt files", "*.txt"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        Stage stage = (Stage) borderPane.getScene().getWindow();

        files = fc.showOpenMultipleDialog(stage);

        if (files != null) {
            if (files.size() == 1) {
                lbl.setText("File loaded!");
            } else {
                lbl.setText("Files loaded!");
            }
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


    private void endLoad(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
