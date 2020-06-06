/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.RegistOrganizationController;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jorge
 */
public class CreateOrganizationUI implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button nextBtn;
    @FXML
    private JFXTextField nameTxt;
    @FXML
    private JFXTextField nifTxt;
    @FXML
    private JFXTextField emailTxt;

    private double x, y;
    @FXML
    private JFXTextField streetTxt;
    @FXML
    private JFXTextField doorTxt;
    @FXML
    private JFXTextField localityTxt;

    
    private RegistOrganizationController controller;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateManagerCollaborator.fxml"));
        Parent root = loader.load();
        CreateManagerCollaboratorUI c = loader.getController();
        
        c.associarParentUI(this);
        
        Scene create = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(create);
        window.show();
    }
    
    public RegistOrganizationController getController(){
        return controller;
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

    /**
     * @return the nameTxt
     */
    public JFXTextField getNameTxt() {
        return nameTxt;
    }

    /**
     * @return the nifTxt
     */
    public JFXTextField getNifTxt() {
        return nifTxt;
    }

    /**
     * @return the emailTxt
     */
    public JFXTextField getEmailTxt() {
        return emailTxt;
    }

    /**
     * @return the streetTxt
     */
    public JFXTextField getStreetTxt() {
        return streetTxt;
    }

    /**
     * @return the doorTxt
     */
    public JFXTextField getDoorTxt() {
        return doorTxt;
    }

    /**
     * @return the localityTxt
     */
    public JFXTextField getLocalityTxt() {
        return localityTxt;
    }

}
