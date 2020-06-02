/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.CreateTaskController;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class CreateTaskUI {
    Scanner read = new Scanner(System.in);
    private CreateTaskController ctask_controller;
    
    public CreateTaskUI(){
        ctask_controller = new CreateTaskController();   
        System.out.println("Introduce the id, brief description, time duration (in hours), cost per hour (in euros), and the category");
        String id = read.next();
        String bd = read.nextLine();
        int td = read.nextInt();
        double ch = read.nextDouble();
        String ct = read.nextLine();
        ctask_controller.newTask(id, bd, td, ch, ct);
    }
    
    
    
}
