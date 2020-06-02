/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class TaskList {

    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }
    
    public void addTask(Task t){
       taskList.add(t);
   }
   
   public void removeTask(Task t){
       taskList.remove(t);
   }
   
   public List<Task> getTaskList(){
       return taskList;
   }
}
