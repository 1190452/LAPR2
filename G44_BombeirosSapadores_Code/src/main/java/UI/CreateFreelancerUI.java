/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateFreelancerController;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CreateFreelancerUI implements Initializable {
    private CreateFreelancerController c1;
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
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void confirm(ActionEvent event) {
        String name = nameTxt.getSelectedText();
        String email = emailTxt.getSelectedText();
        String nif = nifTxt.getSelectedText();
        String iban = ibanTxt.getSelectedText();
        String country = countryTxt.getSelectedText();
        String street = streetTxt.getSelectedText();
        String door = doorTxt.getSelectedText();
        String locality = localityTxt.getSelectedText();
        String exp = experienceCB.getSelectionModel().getSelectedItem();
        
        
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }



    
    
}
