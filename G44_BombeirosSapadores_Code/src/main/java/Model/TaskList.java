/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiagopereira
 */
public class TaskList implements Serializable {

    /**
     * list of tasks
     */
    private List<Task> taskList;

    /**
     * constructor that intializes the list of tasks as an AraayList
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }
    
    //======================================================================================================================================================

    /**
     * adds a task to the task list
     *
     * @param t
     * @return 
     */
    public boolean addTask(Task t) {
        return taskList.add(t);
    }

    /**
     * removes a task from the task list
     *
     * @param t
     * @return 
     */
    public boolean removeTask(Task t) {
        return taskList.remove(t);
    }
      /**
     * creates a new task with the following parameters:
     *
     * @param idTask
     * @param description
     * @param timeTask
     * @param costHour
     * @param taskCategory
     * @return
     */
    public Task newTask(String idTask, String description, int timeTask, double costHour, String taskCategory) {

        Task task = new Task(idTask, description, timeTask, costHour, taskCategory);

        if (validateTask(task) == true) {
            return task;
        } else {
            return null;
        }
    }

    /**
     * method that validates if a task already exists or not
     *
     * @param task
     * @return
     */
    public boolean validateTask(Task task) {
        for (Task e : taskList) {
            if (task.getIdTask().equals(e.getIdTask())) {
                return false;
            }
        }
        return true;

    }

    /**
     * method that regists a task in the system
     *
     * @param task
     * @return
     */
    public boolean registersTask(Task task) {
        if (validateTask(task) == true) {
            addTask(task);
            return true;
        } else {
            return false;
        }
    }
    
    //======================================================================================================================================================

    /**
     * returns the task list
     *
     * @return
     */
    public List<Task> getTaskList() {
        return taskList;
    }

  
    
}
