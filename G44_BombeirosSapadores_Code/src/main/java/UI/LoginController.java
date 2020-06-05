
package UI;

import Model.Constants;
import autorizacao.FacadeAuthorization;
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
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class LoginController implements Initializable {
    
    private static final String MANAGER_ROLE = "MANAGER";
    private static final String ADMINISTRATOR_ROLE = "ADMINISTRATOR";
    private static final String COLLABORATOR_ROLE = "COLLABORATOR";
    
    @FXML
    private JFXTextField txtFieldUsername;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private Button loginBtn;
    
    double x,y;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
            FacadeAuthorization fa = new FacadeAuthorization();
            fa.doLogin(txtFieldUsername.getText(), txtFieldPassword.getText());
            if (FacadeAuthorization.getActualSession().isLoggedInWithPart(Constants.ROLE_ADMINISTRATIVE)) {
                
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuManager.fxml"));
            
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        
        
    }



    @FXML
    private void draged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    
}
