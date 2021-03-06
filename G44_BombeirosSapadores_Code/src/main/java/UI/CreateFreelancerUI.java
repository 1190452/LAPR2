/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateFreelancerController;
import Model.Freelancer;
import Utils.Validations;
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
    private double x, y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        experienceCB.getItems().addAll("Junior", "Senior");
        this.cf = new CreateFreelancerController();
    }

    public CreateFreelancerUI() {
        cf = new CreateFreelancerController();
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

    private void cancelBtn(ActionEvent event) {

    }

    private void endCreateFreelancerUI(ActionEvent event) {
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
    private void cancel(ActionEvent event) {
        endCreateFreelancerUI(event);
    }

    @FXML
    private void confirm(ActionEvent event) {
        if (Validations.isNameValid2(nameTxt.getText()) && Validations.isNameValid(nameTxt.getText())) {
            if (Validations.isEmailValid(emailTxt.getText())) {
                if (Validations.isNIFValid(nifTxt.getText())) {
                    if (Validations.isIBANValid(ibanTxt.getText())) {
                        if (Validations.isNameValid(countryTxt.getText()) && Validations.isStreetValid(streetTxt.getText())
                                && Validations.isDoorNumberValid(doorTxt.getText()) && Validations.isLocalityValid(localityTxt.getText())) {
                            Freelancer f = cf.newFreelancer(nameTxt.getText(), experienceCB.getSelectionModel().getSelectedItem(), emailTxt.getText(), nifTxt.getText(),
                                    ibanTxt.getText(), countryTxt.getText(), streetTxt.getText(), doorTxt.getText(), localityTxt.getText());
                            Alert alert = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Freelancer Creation", f.toString());
                            if (alert.showAndWait().get() == ButtonType.OK) {
                                alert.close();
                            }

                            Alert alert1 = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, MainApp.APPLICATION_TITLE, "Freelancer Creation", "Do you confirm this Freelancer");
                            Optional<ButtonType> option = alert1.showAndWait();
                            boolean added = false;
                            if (option.get() == ButtonType.OK) {
                                added = cf.saveFreelancer();
                            } else {
                                alert1.close();
                            }

                            if (added) {
                                AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Adding new Freelancer",
                                        added ? "New Freelancer added with success"
                                                : "It was not possible to add the Freelancer").show();

                                endCreateFreelancerUI(event);

                            } else {
                               Alert alert2 =  AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Address of the Freelancer is invalid!", "Please write the correct Address.");
                               alert2.show();
                            }
                        } else {
                           Alert alert =  AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The IBAN of the Freelancer is invalid!", "Please write the correct IBAN.");
                           alert.show();
                        }
                    } else {
                        Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The NIF of the Freelancer is invalid!", "Please write the correct NIF.");
                        alert.show();
                    }
                } else {
                    Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Email is invalid!", "Please use a real email.");
                    alert.show();
                }
            }
        } else {
            Alert alert = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "The name of the freelancer is incomplete/invalid!", "Please write your first and last name");
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

}
