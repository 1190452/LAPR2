package Model;

import Authorization.model.UserSession;
import Utils.Date;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author 
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
            ApplicationPOT pot = ApplicationPOT.getInstance();
            UserSession log = pot.getActualSession();
            String email = log.getUserEmail();
            ht = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getRTrans();
            tl = pot.getPlatform().getrOrg().getOrganizationByUserEmailColab(email).getTaskList();
            rf = pot.getPlatform().getRfree();

            BufferedReader ficheiro = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(ficheiro);
            sc.nextLine();
            try {
                while (sc.hasNextLine()) {
                    String linha = sc.nextLine();
                    String[] data = linha.split(";");
                    Freelancer fr = new Freelancer(data[11].trim(), data[12].trim(), data[13].trim(), data[14].trim(),
                            data[15].trim(), data[16].trim(), data[20].trim(), new Address(data[17].trim(), data[18].trim(),
                                    data[19].trim()));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(data[1].trim(), data[2].trim(), Integer.parseInt(data[3]), Double.parseDouble(data[4]), data[5].trim());
                    if (tl.validateTask(t)) {
                        tl.addTask(t);
                    }
                    double valueE = 0;
                    if (data[13].equalsIgnoreCase("Junior")) {
                        valueE = Integer.parseInt(data[3]) * Double.parseDouble(data[4]);
                    } else {
                        valueE = Integer.parseInt(data[3]) * Double.parseDouble(data[4]) * 2;
                    }

                    double valueC = pot.getPlatform().getC().convert(valueE, data[20]);
                    TransactionExecution trans = new TransactionExecution(Integer.parseInt(data[0]), t, fr, new Date(Integer.parseInt(data[8]), 
                            Integer.parseInt(data[7].trim()), Integer.parseInt(data[6])), Double.parseDouble(data[9]),
                            data[10].trim(), new Payment(valueE, valueC));
                    if (ht.validateTransaction(trans)) {
                        ht.addTransaction(trans);
                    }
                }
                return ht;
            } catch (NoSuchElementException e) {

                System.out.println("Error reading HistoricalTransaction file!");

            }
             catch(Exception e){
                 System.out.println("Error reading file. Contact the admninistrator");
             }
            finally{
                sc.close();
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return ht;
    }
    }

