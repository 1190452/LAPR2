/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tiagopereira
 */
public class Transaction {
    private Task task;
    
    public Transaction(Task task){
        this.task = task;
    }
    
    public Transaction(){
        task = new Task();
    }
    
}
