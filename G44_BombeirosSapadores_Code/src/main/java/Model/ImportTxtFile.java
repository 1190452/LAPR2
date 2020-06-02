/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class ImportTxtFile implements ImportFile {
    private HistoricalTransaction ht;
    @Override
    public void importFile(List<Transaction> transactions, String fileName) {
        
        try {
            Scanner sc = new Scanner(new File(fileName), "utf-8");
            sc.useDelimiter(";|\n");
            ht = new HistoricalTransaction();
            try {
                while (sc.hasNext()) {
                   String transID = sc.next().trim();
                   String taskID = sc.next().trim();
                   Time time = (Time) sc.next
                   
                }
                
            } catch (NoSuchElementException e) {
                
                System.out.println("Error reading HistoricalTransaction file!");
                
            }
            
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro que está a tentar carregar nao existe.");
            
        }
    
    }

}
