/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class CreateOrganizationUI implements Initializable {

    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button nextBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void min(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void next(ActionEvent event) {
    }
    
}
