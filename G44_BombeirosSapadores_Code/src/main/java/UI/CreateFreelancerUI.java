/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateFreelancerController;
import Model.Freelancer;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
 *
 * @author User
 */
public class CreateFreelancerUI implements Initializable {

    private CreateFreelancerController cf;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;

    @FXML
    private JFXTextField nameTxt;
    @FXML
    private JFXTextField emailTxt;
    @FXML
    private JFXTextField nifTxt;
    @FXML
    private JFXTextField ibanTxt;
    @FXML
    private JFXTextField countryTxt;
    @FXML
    private JFXTextField streetTxt;
    @FXML
    private JFXTextField doorTxt;
    @FXML
    private JFXTextField localityTxt;
    @FXML
    private JFXComboBox<String> experienceCB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        experienceCB.getItems().addAll("Junior", "Senior");
    }

    @FXML
    private void cancelBtn(ActionEvent event) {
        encerrarCreateFreelancerUI(event);
    }

    private void encerrarCreateFreelancerUI(ActionEvent event) {
        this.nameTxt.clear();
        this.emailTxt.clear();
        this.nifTxt.clear();
        this.ibanTxt.clear();
        this.countryTxt.clear();
        this.streetTxt.clear();
        this.doorTxt.clear();
        this.localityTxt.clear();
        this.experienceCB.getSelectionModel().clearSelection();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void confirmBtn(ActionEvent event) {
        try {
            String name = nameTxt.getSelectedText();
            String email = emailTxt.getSelectedText();
            String nif = nifTxt.getSelectedText();
            String iban = ibanTxt.getSelectedText();
            String country = countryTxt.getSelectedText();
            String street = streetTxt.getSelectedText();
            String door = doorTxt.getSelectedText();
            String locality = localityTxt.getSelectedText();
            String exp = experienceCB.getSelectionModel().getSelectedItem();
            cf.newFreelancer(name, exp, email, nif, iban, country, street, door, locality);
            if (alert1(event) == ButtonType.YES) {
                boolean added = cf.saveFreelancer();
                AlertUI.criarAlerta(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Add new Freelancer.",
                        added ? "Freelancer added with success."
                                : "It was not possible to add Freelancer").show();
                encerrarCreateFreelancerUI(event);
            } else if(alert1(event) == ButtonType.NO){
                encerrarCreateFreelancerUI(event);
            }

        } catch (NumberFormatException nfe) {
            AlertUI.criarAlerta(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    "Introduza correct data").show();
        } catch (IllegalArgumentException iae) {
            AlertUI.criarAlerta(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    iae.getMessage()).show();
        }
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
    private ButtonType alert1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Freelancer");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }

}
