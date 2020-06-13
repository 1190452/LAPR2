package Model;

import Utils.Date;
import Authorization.model.UserSession;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;
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
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ApplicationPOT pot = ApplicationPOT.getInstance();
            UserSession log = pot.getActualSession();
            String email = log.getUserEmail();
            ht = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getRTrans();
            tl = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getTaskList();
            rf = pot.getPlatform().getRfree();
            bufferedReader.readLine(); //reads the first line of the header
            String line = null;

            try {

                while ((line = bufferedReader.readLine()) != null) {
                    String[] temp = line.split(";");
                    int transID = Integer.parseInt(temp[0]);
                    String idTask = temp[1];
                    String descriptionTask = temp[2];
                    int taskDuration = Integer.parseInt(temp[3]);
                    double taskCost = Double.parseDouble(temp[4]);
                    String taskCategory = temp[5];
                    int year = Integer.parseInt(temp[7]);
                    int month = Integer.parseInt(temp[8]);
                    int day = Integer.parseInt(temp[9]);
                    double delay = Double.parseDouble(temp[10]);
                    String descripOFQuality = temp[11];
                    String FreelancerID = temp[12];
                    String FreelancerName = temp[13];
                    String FreelancerExpertise = temp[14];
                    String FreelancerEmail = temp[15];
                    String FreelancerNIF = temp[16];
                    String FreelancerBankAccount = temp[17];
                    String FreelancerStreet = temp[18];
                    String FreelancerDoor = temp[19];
                    String FreelancerLocality = temp[20];
                    String FreelancerCountry = temp[21];

                    Freelancer fr = new Freelancer(FreelancerID, FreelancerName, FreelancerExpertise, FreelancerEmail,
                            FreelancerNIF, FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet, FreelancerDoor,
                                    FreelancerLocality));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(idTask, descriptionTask, taskDuration, taskCost, taskCategory);
                    if (tl.validateTask(t)) {
                        tl.addTask(t);
                    }
                    double valueE = 0;
                    if (FreelancerExpertise.equalsIgnoreCase("Junior")) {
                        valueE = taskDuration * taskCost;
                    } else {
                        valueE = taskDuration * taskCost * 2;
                    }

                    double valueC = pot.getPlatform().getC().convert(valueE, FreelancerCountry);
                    TransactionExecution trans = new TransactionExecution(transID, t, fr, new Date(year, month, day), delay,
                            descripOFQuality, new Payment(valueE, valueC));
                    if (ht.validateTransaction(trans)) {
                        ht.addTransaction(trans);
                    }
                }
                return ht;
            } catch (NoSuchElementException | IOException e) {
                System.out.println("Error reading HistoricalTransaction file!");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("The file " + fileName + " does not exist!");
        } catch (IOException ex) {
            Logger.getLogger(ImportCsvFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
