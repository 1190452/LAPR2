/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.RegistOrganizationController;
import Model.Organization;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tiagopereira
 */
public class RegisterOrganizationUI {

    Scanner read = new Scanner(System.in);
    private RegistOrganizationController c_ro;

    public RegisterOrganizationUI() throws FileNotFoundException {
        String name = read.nextLine();
        String email = read.nextLine();
        String NIF = read.nextLine();
        String street = read.nextLine();
        String doorNumber = read.nextLine();
        String locality = read.nextLine();
        String nameC = read.nextLine();
        String emailC = read.nextLine();
        String phoneNumberC = read.nextLine();
        String nameM = read.nextLine();
        String emailM = read.nextLine();
        String phoneNumberM = read.nextLine();
        Organization org = c_ro.newOrganization(name, email, NIF, street, doorNumber, locality, nameC, emailC, phoneNumberC, nameM, emailM, phoneNumberM);
        System.out.println("Confirms?");
        boolean choice = read.nextBoolean();
        if (choice) {
            if (c_ro.registaOrganization()) {
                System.out.println("Operation Successfull");
            }
        }
    }
}
