/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.ApplicationPOT;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Jorge
 */
public class MenuManagerUI implements Initializable {

    @FXML
    private Label dateTime;

    double x, y;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button bt_dph;
    @FXML
    private Button bt_CheckSt;
    @FXML
    private Label lblWelcome;

    private ApplicationPOT pot;

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
    private void definePaymentHour(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DefinePayment.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("DefinePaymentHour");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        // Hide this current window
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void checkStats(ActionEvent event) throws IOException {
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

}
