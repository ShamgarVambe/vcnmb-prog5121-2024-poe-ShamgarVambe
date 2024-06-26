package com.mycompany.poe;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class TaskTest {
    Task task = new Task();
    
    public TaskTest() {
    }
   /*  @Test
    public void testCheckTaskDescription() { 
        assertTrue(task.checkTaskDescription("Task successfully captured"));
       
    }
    
          @Test
           public void testFalseCheckTaskDescription() {
               assertFalse(task.checkTaskDescription("Please enter a task description of less than 50 characters"));
    }
           


  @Test
    public void testGenerateTaskId() {
        String taskName = "Login feature";
        String taskDeveloperDetails = "Robyn Harrison";
        int taskNum = 123;

        String expectedTaskId = "LO:123:SON";
        String actualTaskId = task.createTaskId(taskName, taskDeveloperDetails, taskNum);

        assertEquals(expectedTaskId, actualTaskId);
    }
    
    */
    
 
    
    

    @Test
    public void testDeveloperArray() {
        Task task = new Task();

        String expected = "Mike Smith\nEdward Harrison\nSamantha Paulson\nGlenda Oberholzer\n";
        String actual = "";

        for (int i = 0; i < developerName.length; i++) {
            actual += developerName[i] + "\n";
        }

        assertEquals(expected, actual);
    }

   @Test
    public void testLongestTask() {
        Task task = new Task();

        String expected = "\nDeveloper: Glenda Oberholzer\nTask Duration: 11";
        String actual = task.showLongestTask(developerName, taskDurations);

        assertEquals(expected, actual);
    }

   
    @Test
    public void testTaskAssignedToDeveloper() {
        Task task = new Task();

        String expected = "\nTask Name: Create Reports\nTask Status: Done";
        String actual = task.getTaskAssignedToDeveloper(developerName, taskName, statusOfTask, "Samantha", "Paulson");

        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task();

        String expected = "Task has been deleted.";
        String actual = task.deleteTask(taskName, developerName, taskDurations, statusOfTask, "Create Reports");

        assertEquals(expected, actual);
    }

  

}

    
    
}
    


