/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateFreelancerController;
import Model.NewEnum;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private ComboBox<String> cbLvl;
    @FXML
    private TextField idTxt;
    @FXML
    private TextField durationTxt;
    @FXML
    private TextField costTxt;
    @FXML
    private TextField categoryTxt;
    @FXML
    private TextField descriptionTxt;
    
    
    
  
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("Junior", "Senior");
        cbLvl.setItems(list);
    }
    


    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void confirm(ActionEvent event) {
    }

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
    }



    
    
}
