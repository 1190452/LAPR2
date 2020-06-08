package UI;

import Model.ApplicationPOT;
import Model.Constants;
import Authorization.FacadeAuthorization;
import Authorization.model.UserSession;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class LoginUI implements Initializable {

    /*
    private static final String MANAGER_ROLE = "MANAGER";
    private static final String ADMINISTRATOR_ROLE = "ADMINISTRATOR";
    private static final String COLLABORATOR_ROLE = "COLLABORATOR";
     */
    @FXML
    private JFXTextField txtFieldUsername;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private Button loginBtn;

    double x, y;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblInformation;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login(ActionEvent event) {
//        try {

        try {
            if (txtFieldUsername.getText().isEmpty() || txtFieldPassword.getText().isEmpty()) {
                lblInformation.setText(" ");
                Alert alert1 = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Login data", "Please introduce the necessary data to access the platform.");
                alert1.show();
            }
            ApplicationPOT ac = ApplicationPOT.getInstance();

            FacadeAuthorization fc = ac.getPlatform().getFacadeAuthorazation();

            UserSession us = fc.doLogin(txtFieldUsername.getText(), txtFieldPassword.getText());

            if (us.isLoggedInWithPart(Constants.ROLE_ADMINISTRATIVE)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuAdministrator.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Administrator Menu");
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setResizable(false);

                stage.getIcons().add(new Image("/images/logoparaapp.png"));
                stage.show();
                endLoginUI(event);

            } else if (us.isLoggedInWithPart(Constants.ROLE_COLLABORATOR_ORGANIZATION)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuCollaborator.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Collaborator Menu");
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setResizable(false);
                stage.show();
                endLoginUI(event);

            } else if (us.isLoggedInWithPart(Constants.ROLE_MANAGER_ORGANIZATION)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuManager.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Manager Menu");
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setResizable(false);
                stage.show();
                endLoginUI(event);

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (!us.isLoggedIn()) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Login data", "The user does not exist. Please register.");
                alert.show();

            } else if (!us.isLoggedIn()) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Login data", "The user does not exist. Please register.");
                alert.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            lblInformation.setText("Invalid information!");
            txtFieldUsername.clear();
            txtFieldPassword.clear();
        }
    }

//        } catch (IOException ex) {
//            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
    @FXML
    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event
    ) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void close(MouseEvent event
    ) {
        ApplicationPOT pot = ApplicationPOT.getInstance();
        pot.doLogout();
        pot.save(pot.getPlatform());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(MouseEvent event
    ) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    private void endLoginUI(ActionEvent event) {
        txtFieldUsername.clear();
        txtFieldPassword.clear();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
