/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class CreateManagerCollaboratorUI implements Initializable {

    @FXML
    private JFXTextField nameMTxt;
    @FXML
    private JFXTextField nifMTxt;
    @FXML
    private JFXTextField emailMTxt;
    @FXML
    private JFXTextField nameCTxt;
    @FXML
    private JFXTextField nifCTxt;
    @FXML
    private JFXTextField emailCTxt;

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
    
}
