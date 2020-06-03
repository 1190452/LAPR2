/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
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
}
