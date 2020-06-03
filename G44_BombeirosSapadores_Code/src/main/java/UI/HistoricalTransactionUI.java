/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.HistoricalTransactionController;
import Model.Transaction;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class HistoricalTransactionUI {

    Scanner read = new Scanner(System.in);
    private HistoricalTransactionController ht_controller;

    public HistoricalTransactionUI() {
        System.out.println("Introduce the file name to load all transactions");
        String fileName = read.nextLine();
        List<Transaction> lt = ht_controller.loadHistoricalTransaction(fileName);
        if (lt != null) {
            System.out.println("Operation Successfull");
        } else {
            System.out.println("Operation Unsuccessfull");
        }

    }
}
