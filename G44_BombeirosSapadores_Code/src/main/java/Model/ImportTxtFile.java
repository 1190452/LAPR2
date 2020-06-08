/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import Utils.Date;
import autorizacao.model.UserSession;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class ImportTxtFile implements ImportFile, Serializable {

    /**
     * atribute from the class RegisterTransaction used to call the methods of
     * that class
     */
    private RegisterTransaction ht;

    /**
     * atribute from the class TaskList used to call the methods of that class
     */
    private TaskList tl;

    /**
     * atribute from the class RegisterFreelancer used to call the methods of
     * that class
     */
    private RegisterFreelancer rf;

    /**
     * method that reads a txt file and loads a set of historical transactions
     *
     * @param fileName
     * @return
     */
    public ImportTxtFile() {
    }

    @Override
    public RegisterTransaction importFile(String fileName) {

        try {
            Scanner sc = new Scanner(new File(fileName), "utf-8");
            sc.useDelimiter(";|\n|-|,");
            ApplicationPOT pot = ApplicationPOT.getInstance();
            UserSession log = pot.getActualSession();
            String email = log.getUserEmail();
            ht = pot.getPlatform().getRTrans();
            tl = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getTaskList();
            rf = pot.getPlatform().getRfree();
            String cabecalho = sc.nextLine();
            try {
                while (sc.hasNext()) {
                    String transID = sc.next().trim();
                    String taskID = sc.next().trim();
                    String taskDescrip = sc.next().trim();
                    int timeTask = Integer.parseInt(sc.next().trim());
                    double taskCost = Double.parseDouble(sc.next().trim());
                    String categoryTask = sc.next().trim();
                    int day = Integer.parseInt(sc.next().trim());
                    int month = Integer.parseInt(sc.next().trim());
                    int year = Integer.parseInt(sc.next().trim());
                    double delay = Double.parseDouble(sc.next().trim());
                    String descripOFQuality = sc.next().trim();
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

                    Freelancer fr = new Freelancer(FreelancerID, FreelancerName, FreelancerExpertise, FreelancerEmail, FreelancerNIF, FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet, FreelancerDoor, FreelancerLocality));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(taskID, taskDescrip, timeTask, taskCost, categoryTask);
                    tl.addTask(t);
                    ht.addHistoricalTransaction(new Transaction(transID, t, fr, new TaskExecution(new Date(year, month, day), delay, descripOFQuality)));

                }
                return ht;
            } catch (NoSuchElementException e) {

                System.out.println("Error reading HistoricalTransaction file!");

            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro que está a tentar carregar nao existe.");

        }
        return null;

    }

}
