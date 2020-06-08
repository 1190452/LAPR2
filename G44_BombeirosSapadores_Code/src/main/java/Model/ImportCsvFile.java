package Model;

import Utils.Date;
import autorizacao.model.UserSession;
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
     * atribute from the class RegisterTransaction used to call the methods of that class
     */
    private RegisterTransaction ht;
    
    /**
     * atribute from the class TaskList used to call the methods of that class
     */
    private TaskList tl;
    
    /**
     * atribute from the class RegisterFreelancer used to call the methods of that class
     */
    private RegisterFreelancer rf;

    /**
     * method that reads a CSV file and loads a set of historical transactions
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
            ht = pot.getPlatform().getRTrans();
            tl = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getTaskList();
            rf = pot.getPlatform().getRfree();
            bufferedReader.readLine(); //reads the first line of the header
            String line = null;

            try {
                
                while ((line = bufferedReader.readLine()) != null) {
                    String[] temp = line.split(";");
                    String idTask = temp[1];
                    String descriptionTask = temp[2];
                    int taskDuration = Integer.parseInt(temp[3]);
                    double taskCost = Double.parseDouble(temp[4]);
                    String taskCategory = temp[5];
                    String FreelancerID = temp[6];
                    String FreelancerName = temp[7];
                    String FreelancerExpertise = temp[8];
                    String FreelancerEmail = temp[9];
                    String FreelancerNIF = temp[10];
                    String FreelancerBankAccount = temp[11];
                    String FreelancerStreet = temp[12];
                    String FreelancerDoor = temp[13];
                    String FreelancerLocality = temp[14];
                    String FreelancerCountry = temp[15];
                    int year = Integer.parseInt(temp[16]);
                    int month = Integer.parseInt(temp[17]);
                    int day = Integer.parseInt(temp[18]);
                    double delay = Double.parseDouble(temp[19]);
                    String descripOFQuality = temp[20];

                    Freelancer fr = new Freelancer(FreelancerID,FreelancerName, FreelancerExpertise, FreelancerEmail, FreelancerNIF, FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet, FreelancerDoor, FreelancerLocality));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(idTask, descriptionTask, taskDuration, taskCost, taskCategory);
                    tl.addTask(t);
                    ht.addTransaction(new Transaction(t, fr, new TaskExecution(new Date(year, month, day), delay, descripOFQuality)));
                    return ht;

                }
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
