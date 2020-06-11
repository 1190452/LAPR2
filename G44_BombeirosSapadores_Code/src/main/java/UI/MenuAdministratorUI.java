/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.ApplicationPOT;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Jorge
 */
public class MenuAdministratorUI implements Initializable {

    @FXML
    private Label dateTime;
    @FXML
    private Button checkStatisticsBtn;
    @FXML
    private Button createOrganizationBtn;

    private double x, y;
    @FXML
    private Button logoutBtn;
    @FXML
    private Label lblWelcome;

    private ApplicationPOT pot;
    @FXML
    private Button warnFreelancerBtn;

    private WarnAboutFreelancerPerformanceUI wabfp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pot = ApplicationPOT.getInstance();
        pot.save(pot.getPlatform());

        /**
         * Shows the current time in the label
         */
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        pot = ApplicationPOT.getInstance();
        lblWelcome.setText("Welcome " + pot.getActualSession().getUserName() + "!");

        PauseTransition visiblePause = new PauseTransition(
                Duration.seconds(10)
        );
        visiblePause.setOnFinished(
                event -> lblWelcome.setVisible(false)
        );
        visiblePause.play();
    }

    @FXML
    private void close(MouseEvent event) {
        ApplicationPOT pot = ApplicationPOT.getInstance();
        pot.doLogout();
        pot.save(pot.getPlatform());
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
    private void checkFreelancerStatistics(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/WatchStatistics.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("See Overall Statistics");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        // Hide this current window
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void createOrganization(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CreateOrganization.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Administrator Menu");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void openInsta(MouseEvent event) throws URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.instagram.com/isep.pporto/"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    @FXML
    private void openFace(MouseEvent event) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/isep.pporto/"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }

    }

    @FXML
    private void openLink(MouseEvent event) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/school/isep/?originalSubdomain=pt"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {

        pot.doLogout();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Login");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        // Hide this current window
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void warnFreelancer(ActionEvent event) throws FileNotFoundException {
        ApplicationPOT app = ApplicationPOT.getInstance();
        wabfp = app.getPlatform().getWabfp();
        boolean check = wabfp.sendEmail();
        if (check) {
            Alert alert1 = AlertUI.createAlert(Alert.AlertType.INFORMATION, MainApp.APPLICATION_TITLE, "Send Email", "Email sent with success!");

            if (alert1.showAndWait().get() == ButtonType.OK) {
                alert1.close();
            }
        }else {
            Alert alert2 = AlertUI.createAlert(Alert.AlertType.ERROR, MainApp.APPLICATION_TITLE, "Send Email", "Email not sent!");
            
            if (alert2.showAndWait().get() == ButtonType.OK) {
                alert2.close();
            }
        }
        // Hide this current window
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
