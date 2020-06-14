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
                    Freelancer fr = new Freelancer(data[11], data[12], data[13], data[14],
                            data[15], data[16], data[20], new Address(data[17], data[18],
                                    data[19]));
                    if (rf.Verification(fr)) {
                        rf.addFreelancer(fr);
                    }
                    Task t = new Task(data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]), data[5]);
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
                    TransactionExecution trans = new TransactionExecution(Integer.parseInt(data[0]), t, fr, new Date(Integer.parseInt(data[8]), Integer.parseInt(data[7]), Integer.parseInt(data[6])), Double.parseDouble(data[9]),
                            data[10], new Payment(valueE, valueC));
                    if (ht.validateTransaction(trans)) {
                        ht.addTransaction(trans);
                    }
                }
                return ht;
            } catch (NoSuchElementException e) {

                System.out.println("Error reading HistoricalTransaction file!");

            }
            finally{
                sc.close();
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return null;
    }
    }

