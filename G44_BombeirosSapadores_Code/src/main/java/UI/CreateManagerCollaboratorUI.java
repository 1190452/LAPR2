/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.RegistOrganizationController;
import Model.Collaborator;
import Model.Organization;
import Model.RegisterOrganization;
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jorge
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        String[] inf = co.getInformation();
        roc.newOrganization(inf[0], inf[2], inf[1], inf[3], inf[4], inf[5], nameCTxt.getText(), emailCTxt.getText(), nameMTxt.getText(), emailMTxt.getText());
        roc.registaOrganization();

    }

}
