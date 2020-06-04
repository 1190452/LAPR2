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
import java.util.List;

/**
 *
 * @author brunopereira
 */
public class Writer {

    
    
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
            writer.write("Organization"+org.getName()+ " made a payment of "+ sum +" on " + Date.currentDate().toFile()+ "\n");
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void sendEmail(Freelancer free) throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(new File("Emails.txt"));
            try {
                out.println("Email of your account: " + free.getEmail());
                out.println(String.format("%s your task Delay is better than 3 and better than the overall task Delay ", free.getName()));
                out.close();
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    
    public static void genEmail(List<Transaction> nltr, double valueE, double valueC){
        try {
            //adicionar o code..
            PrintWriter out = new PrintWriter(new File("receipt"+nltr.get(0).getFreel().getFreeID()+Date.currentDate().toFile()+".txt"));
            try {
                out.println("Receipt of "+nltr.get(0).getFreel().getFreeID());
                for(Transaction e : nltr){
                    out.print(e.toString()+"\n");
                }
                if(valueE == valueC){
                    out.println("The total value is: "+ valueE+"euros");   
                }else{
                    out.println("The total value in euros is " + valueE +" and "+valueC +" in your local currency"); 
                }

            } finally {
                
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        
        
    }
    
    
}
