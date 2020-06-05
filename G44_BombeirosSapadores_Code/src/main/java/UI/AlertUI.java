/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 *
 * @author tiagopereira
 */
public class AlertUI {

    public static Alert criarAlerta(Alert.AlertType alertType, String title, String header, String message) {
        Alert alerta = new Alert(alertType);

        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(message);

        if (alertType == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");
        }

        return alerta;
    }
}
