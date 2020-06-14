/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.RegistOrganizationController;
import Utils.Validations;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 
 */
public class CreateManagerCollaboratorUI implements Initializable {

    @FXML
    private JFXTextField nameMTxt;
    @FXML
    private JFXTextField emailMTxt;
    @FXML
    private JFXTextField nameCTxt;
    @FXML
    private JFXTextField emailCTxt;

    private double x, y;
    @FXML
    private Button backBtn;
    @FXML
    private Button submitBtn;
    @FXML
    private BorderPane borderPane;

    private RegistOrganizationController roc;

    private CreateOrganizationUI co;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void associarParentUI(CreateOrganizationUI co) {
        this.co = co;
        roc = this.co.getController();

    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
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

    @FXML
    private void back(ActionEvent event) throws IOException {

        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateOrganization.fxml"));
        borderPane.getChildren().setAll(pane);
        /*Stage stage = new Stage();
        FXMLLoader fxmlLoader= FXMLLoader.load(getClass().getResource("Login.fxml"));
        BorderPane myborder = null;
        Scene scene = new Scene(myborder);
        stage.setScene(scene);
        
        prevStage.close();
        stage.show();*/
    }

    @FXML
    private void submit(ActionEvent event) throws FileNotFoundException {
        try {
            if (Validations.isNameValid(co.getNameTxt().getText())) {
                if (Validations.isEmailValid(co.getEmailTxt().getText())) {
                    if (Validations.isNIFValid(co.getNifTxt().getText())) {
                        if (Validations.isStreetValid(co.getStreetTxt().getText())) {
                            if (Validations.isDoorNumberValid(co.getDoorTxt().getText())) {
                                if (Validations.isLocalityValid(co.getLocalityTxt().getText())) {
                                    if (Validations.isNameValid(nameCTxt.getText()) && Validations.isEmailValid(emailCTxt.getText())) {
                                        if (Validations.isNameValid(nameMTxt.getText()) && Validations.isEmailValid(emailMTxt.getText())) {

                                            roc.newOrganization(co.getNameTxt().getText(), co.getEmailTxt().getText(), co.getNifTxt().getText(), co.getStreetTxt().getText(), co.getDoorTxt().getText(), co.getLocalityTxt().getText(), nameCTxt.getText(), emailCTxt.getText(), nameMTxt.getText(), emailMTxt.getText());
                                            boolean added = roc.registerOrganization();
                                            if (added) {
                                                AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Adding new Organization",
                                                        added ? "New Organization added with success"
                                                                : "It was not possible to add the organization").show();

                                                endCreateManagerCollaboratorUI(event);
                                            }

                                        } else {
                                            Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Manager is invalid!", "Please check the information written.");
                                            alert.show();
                                        }
                                    } else {
                                        Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Collaborator is invalid!", "Please check the information written.");
                                        alert.show();
                                    }
                                } else {
                                    Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The locality is invalid!", "Please check the information written.");
                                    alert.show();
                                }
                            } else {
                                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Door number is invalid!", "Please check the information written.");
                                alert.show();
                            }
                        } else {
                            Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Street is invalid!", "Please check the information written.");
                            alert.show();
                        }
                    } else {
                        Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The NIF is invalid!", "Please check the information written.");
                        alert.show();
                    }
                } else {
                    Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Email is invalid!", "Please check the information written.");
                    alert.show();
                }
            } else {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "The Name of the Organization is invalid!", "Please check the information written.");
                alert.show();
            }

        } catch (NumberFormatException nfe) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    "Introduce correct data").show();
        } catch (IllegalArgumentException iae) {
            AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Error in data.",
                    iae.getMessage()).show();
        }
    }

    private void endCreateManagerCollaboratorUI(ActionEvent event) {
        this.nameMTxt.clear();
        this.emailMTxt.clear();
        this.nameCTxt.clear();
        this.emailCTxt.clear();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
