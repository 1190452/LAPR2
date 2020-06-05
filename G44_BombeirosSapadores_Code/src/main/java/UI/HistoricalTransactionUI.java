/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.HistoricalTransactionController;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionUI {

    Scanner read = new Scanner(System.in);
    private HistoricalTransactionController ht_controller;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button openFile;
    @FXML
    private Label lbl;
    @FXML
    private BorderPane borderPane;

    /**public HistoricalTransactionUI() {
        System.out.println("Introduce the file name to load all transactions");
        String fileName = read.nextLine();
        List<Transaction> lt = ht_controller.loadHistoricalTransaction(fileName);
        if (lt != null) {
            System.out.println("Operation Successfull");
        } else {
            System.out.println("Operation Unsuccessfull");
        }

    }*/

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Confirm(ActionEvent event) {
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }

    
    @FXML
    private void btnAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt files", "*.txt"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        Stage stage = (Stage) borderPane.getScene().getWindow();
        
        List<File> files = fc.showOpenMultipleDialog(stage);
        //fc.setInitialDirectory(file.getParentFile());
        
        
        if (files != null) {
            if(files.size() == 1) {
                lbl.setText("File loaded!");
            }else
                lbl.setText("Files loaded!");
        }
        
        
        /**
        if (list != null) {
            for(File file : list) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch(IOException e) {
                    Logger.getLogger(HistoricalTransactionController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }*/
    }
}
