/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
import javafx.stage.StageStyle;

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

    /**
     * Initializes the controller class.
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
    
        Parent view = FXMLLoader.load(getClass().getResource("/fxml/CreateManagerCollaborator.fxml"));
        
        Scene create = new Scene(view);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(create);
        window.show();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CreateManagerCollaborator.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        //Stage stage = new Stage();
//        Scene createMC_scene = new Scene(root1);
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(createMC_scene);
//        //stage.setTitle("Create Menu");
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.setResizable(false);
//        stage.show();
//            
//        // Hide this current window
//        //((Node) (event.getSource())).getScene().getWindow().hide();
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

}
