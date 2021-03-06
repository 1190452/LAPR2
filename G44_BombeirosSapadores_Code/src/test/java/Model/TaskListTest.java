/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class TaskListTest {
    
    /**
     * Test of addTask method, of class TaskList.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task t = new Task();
        TaskList instance = new TaskList();
        boolean expResult = true;
        boolean result = instance.addTask(t);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of removeTask method, of class TaskList.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Task t = new Task();
        TaskList instance = new TaskList();
        instance.addTask(t);
        boolean result=instance.removeTask(t);
        boolean expResult=true;
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of newTask method, of class TaskList.
     */
    @Test
    public void testNewTask() {
        System.out.println("newTask");
        String idTask = "t1";
        String description = "task1";
        int timeTask = 0;
        double costHour = 0.0;
        String taskCategory = "programing";
        TaskList instance = new TaskList();
        
        Task expResult = new Task(idTask, description, timeTask, costHour, taskCategory);
        Task result = instance.newTask(idTask, description, timeTask, costHour, taskCategory);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTask method, of class TaskList.
     */
    @Test
    public void testValidateTask() {
        System.out.println("validateTask");
        Task task = new Task();
        TaskList instance = new TaskList();
        boolean expResult = true;
        boolean result = instance.validateTask(task);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registersTask method, of class TaskList.
     */
    @Test
    public void testRegistersTask() {
        System.out.println("registersTask");
        Task task = new Task();
        TaskList instance = new TaskList();
        boolean expResult = true;
        boolean result = instance.registersTask(task);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTaskList method, of class TaskList.
     */
    @Test
    public void testGetTaskList() {
        System.out.println("getTaskList");
        TaskList instance = new TaskList();
        List<Task> expResult = new ArrayList<>();
        List<Task> result = instance.getTaskList();
        assertEquals(expResult, result);
        
    }
    
}
