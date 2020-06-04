/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author brunopereira
 */
public class Writter {

    public static void sendsPassword(String email, String pwd) throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(new File("EmailsWithPassword.txt"));
            try {
                out.println("Email of your account: " + email);
                out.println("Password to access your account: " + pwd);
                out.close();
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void writeOrg(Organization org, double sum) {
        try {
            FileWriter writer = new FileWriter(Constants.PAYMENTS_ORGS_FILENAME, true);
            writer.write("Organization"+org.getName()+ " made a payment of "+ sum +" on " + Date.currentDate().toYearMonthYearString()+ "\n");
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
