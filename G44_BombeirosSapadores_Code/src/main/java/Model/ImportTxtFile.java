/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.io.FileNotFoundException;
import Utils.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class ImportTxtFile implements ImportFile {
    private HistoricalTransaction ht;
    private TaskList tl;
    private RegisterFreelancer rf;
    @Override
    public void importFile(List<Transaction> transactions, String fileName) {
        
        try {
            Scanner sc = new Scanner(new File(fileName), "utf-8");
            sc.useDelimiter(";|\n");
            ht = new HistoricalTransaction();
            tl = new TaskList();
            try {
                while (sc.hasNext()) {
                   String transID = sc.next().trim();
                   String taskID = sc.next().trim();
                   String taskDescrip =  sc.next().trim();
                   int timeTask = Integer.parseInt(sc.next().trim());
                   double taskCost = Double.parseDouble(sc.next().trim());
                   String categoryTask = sc.next().trim();
                   String FreelancerID = sc.next().trim();
                   String FreelancerName = sc.next().trim();
                   String FreelancerExpertise = sc.next().trim();
                   String FreelancerEmail = sc.next().trim();
                   String FreelancerNIF = sc.next().trim();
                   String FreelancerBankAccount = sc.next().trim();
                   String FreelancerStreet = sc.next().trim();
                   String FreelancerDoor = sc.next().trim();
                   String FreelancerLocality = sc.next().trim();
                   String FreelancerCountry = sc.next().trim();
                   int ano = Integer.parseInt(sc.next().trim());
                   int mes = Integer.parseInt(sc.next().trim());
                   int dia = Integer.parseInt(sc.next().trim());
                   double delay =  Double.parseDouble(sc.next().trim());
                   String descripOFQuality = sc.next().trim();
                   Freelancer fr = new Freelancer (FreelancerID,FreelancerName,FreelancerExpertise,FreelancerEmail,FreelancerNIF,FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet,FreelancerDoor,FreelancerLocality));
                   rf.addFreelancer(fr);
                   Task t = new Task(taskID, taskDescrip, timeTask, taskCost, categoryTask);
                   tl.addTask(t);
                   ht.addHistoricalTransaction(new Transaction(transID, t,fr,new TaskExecution(new Date(ano,mes,dia), delay, descripOFQuality)));
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
