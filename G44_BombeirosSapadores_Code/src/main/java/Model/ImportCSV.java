package Model;

import Utils.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class ImportCSV implements ImportFile {

    private HistoricalTransaction ht;
    
    @Override
    public void importFile(List<Transaction> transactions, String fileName) {
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = null;
            try {
                while((line = bufferedReader.readLine()) != null) {
                    String[] temp = line.split(";");
                    String idTrans = temp[0];
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
                    double delay =  Double.parseDouble(temp[19]);
                    String descripOFQuality = temp[20];
                    
                    ht.addHistoricalTransaction(new Transaction(idTrans, new Task(idTask, descriptionTask, taskDuration, taskCost, taskCategory), 
                            new Freelancer(FreelancerID, FreelancerName, FreelancerExpertise, FreelancerEmail, FreelancerNIF, 
                                    FreelancerBankAccount, FreelancerCountry, new Address(FreelancerStreet, FreelancerDoor, FreelancerLocality)), 
                            new TaskExecution(new Date(year, month, day), delay, descripOFQuality)));
                
                }
            } catch (NoSuchElementException | IOException e) {
                System.out.println("Error reading HistoricalTransaction file!");
            }

        
            
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + fileName + " does not exist!");
        }
    }
    
}
