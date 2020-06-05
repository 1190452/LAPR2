package UI;

import Model.Administrator;
import Model.Constants;
import autorizacao.FacadeAuthorization;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.math3.analysis.function.Constant;

public class MainApp extends Application {

    public static final String APPLICATION_TITLE = "T4J";

    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD

        Administrator admin = new Administrator("ZÉ", "zemanel@gmail.com", "q", Constants.ROLE_ADMINISTRATIVE);
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateTask.fxml"));
>>>>>>> 6a7194772e82aacf2a1153bf5e08927d74fc59fc

        Scene scene = new Scene(root);

        //FacadeAuthorization fc = new FacadeAuthorization();
        //fc.registerUser("boas", "zemanel@gmail.com", "qwerty", Constants.ROLE_ADMINISTRATIVE);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
