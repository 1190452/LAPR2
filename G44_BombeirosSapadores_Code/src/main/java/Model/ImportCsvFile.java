package Model;

import Utils.Date;
import Authorization.model.UserSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class ImportCsvFile implements ImportFile, Serializable {

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

    //======================================================================================================================================================
    /**
     * method that reads a CSV file and loads a set of historical transactions
     *
     * @param fileName
     * @return
     */
    @Override
    public RegisterTransaction importFile(String fileName) {

        try {
            Scanner sc = new Scanner(new File(fileName), "utf-8");
            sc.useDelimiter("\t|\n");
            ApplicationPOT pot = ApplicationPOT.getInstance();
            UserSession log = pot.getActualSession();
            String email = log.getUserEmail();
            ht = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getRTrans();
            tl = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getTaskList();
            rf = pot.getPlatform().getRfree();
            String header = sc.nextLine();
            try {
                while (sc.hasNext()) {
                    int transID = Integer.parseInt(sc.next().trim());
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

                    Freelancer fr = new Freelancer(FreelancerID, FreelancerName, FreelancerExpertise, FreelancerEmail,
                            FreelancerNIF, FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet, FreelancerDoor,
                                    FreelancerLocality));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(taskID, taskDescrip, timeTask, taskCost, categoryTask);
                    if (tl.validateTask(t)) {
                        tl.addTask(t);
                    }
                    double valueE = 0;
                    if (FreelancerExpertise.equalsIgnoreCase("Junior")) {
                        valueE = timeTask * taskCost;
                    } else {
                        valueE = timeTask * taskCost * 2;
                    }

                    double valueC = pot.getPlatform().getC().convert(valueE, FreelancerCountry);
                    TransactionExecution trans = new TransactionExecution(transID, t, fr, new Date(year, month, day), delay,
                            descripOFQuality, new Payment(valueE, valueC));
                    if (ht.validateTransaction(trans)) {
                        ht.addTransaction(trans);
                    }
                }
                return ht;
            } catch (NoSuchElementException e) {

                System.out.println("Error reading HistoricalTransaction file!");

            }

            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + fileName + " does not exist!");
        } catch (IOException ex) {
            Logger.getLogger(ImportCsvFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
