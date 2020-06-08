package Model;

import Utils.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author brunopereira
 */
public class Writer {

    /**
     * method that "sends" an email to the new registered users with the
     * password
     *
     * @param email
     * @param pwd
     * @param role
     */
    public static void sendsPassword(String email, String pwd, String role) {
        try {
            try (PrintWriter out = new PrintWriter(new FileWriter("Data about " + role + ".txt", true))) {
                out.println("Email of your account: " + email);
                out.println("Password to access your account: " + pwd);
                out.close();
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
        }
    }

    /**
     * method that "sends" an email to the freelancers with the payment value
     *
     * @param org
     * @param sum
     */
    public static void writeOrg(Organization org, double sum) {
        try {
            FileWriter writer = new FileWriter(Constants.PAYMENTS_ORGS_FILENAME, true);
            writer.write("Organization" + org.getName() + " made a payment of " + sum + " on " + Date.actualDate().toFile() + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method that "sends" an email to freelancers that have a task delay higher
     * than 3 hours and higher than the overall task delay
     *
     * @param free
     * @throws FileNotFoundException
     */
    public static void sendEmail(Freelancer free) throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(new File("Emails.txt"));
            try {
                out.println("Email of your account: " + free.getEmail());
                out.println(String.format("%s your task Delay is higher than 3 and higher than the overall task Delay ", free.getName()));
                out.close();
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    /**
     * method that "sends" an email with the receipt, explaining the payment for
     * eahc task and the overall payment in euros and in the currency of the
     * freelancer
     *
     * @param nltr
     * @param valueE
     * @param valueC
     */
    public static boolean genEmail(List<Transaction> nltr, double valueE, double valueC) {
        try {

            FileWriter writer2 = new FileWriter(Constants.PAYMENTS_ORGS_FILENAME, true);
            {
                writer2.write("Receipt of " + nltr.get(0).getFreel().getFreeID());
                for (Transaction e : nltr) {
                    writer2.write(e.toString() + "\n");
                }
                if (valueE == valueC) {
                    writer2.write("The total value is: " + valueE + "euros\n");
                } else {
                    writer2.write("The total value in euros is " + valueE + " and " + valueC + " in your local currency\n");
                }

<<<<<<< HEAD
            }
=======
            } finally {
                out.close();
                return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return false;
        }
       
>>>>>>> b79fc1b553a4924042adf73a90021641e1fa59bc

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
