/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Validations;
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

    public Task newTask(String idTask, String description, int timeTask, double costHour, String taskCategory) {
        Task task = new Task(idTask, description, timeTask, costHour, taskCategory);
        
        if(validateTask(task)==true){
            return task;
        }else{
            return null;
        }
    }

    private boolean validateTask(Task task) {
        for(Task e : taskList){
            if(task.equals(e)){
                return false;
            }
        }
        return true;
           
    }

    public boolean registersTask(Task task) {
        if(validateTask(task)==true){
            taskList.add(task);
            return true;
        }else{
            return false;
        }
    }
}
