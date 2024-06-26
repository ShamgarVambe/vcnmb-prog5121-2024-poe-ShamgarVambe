package com.mycompany.poe;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Task {
    
    public static boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;//This method checks if the length of the task description is less than or equal to 50 characters.
    }

     public static String createTaskId(String taskName, String taskDeveloperDetails,int taskNum) {//It takes the first two characters of the task name in uppercase, concatenates them with the task number and the last three characters of the developer details in uppercase.
        return taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase() +":"+ taskNum +":"+taskDeveloperDetails.substring(Math.max(taskDeveloperDetails.length() - 3, 0)).toUpperCase();//Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
    }
     
    public static String printTaskDetails(String taskStatus, String taskDeveloperDetails, String taskName, int taskNum, String taskDescription, String taskId, int taskDuration) {//This method constructs a string containing all task details including status, developer details, task name, task number, description, task ID, and duration.
        String taskDetails = "\nStatus: " + taskStatus + "\nDeveloper Details: " + taskDeveloperDetails + "\nTask Name: " + taskName + "\nTask number: " + taskNum + "\nDescription: " + taskDescription + "\nTask ID: " + taskId + "\nDuration: " + taskDuration ;
        JOptionPane.showMessageDialog(null, taskDetails);
        return taskDetails;
        
    }
    
     // Method to show the task with the longest duration
    public void showLongestTask(String[] taskDevelopers, int[] taskDurations) {
        int longestDuration = 0;
        String longestTaskDev = "";

        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestTaskDev = taskDevelopers[i];
            }
        }

        JOptionPane.showMessageDialog(null, "Task with Longest Duration:\nTask Developer: " + longestTaskDev + "\nDuration: " + longestDuration + " minutes");
    }
    
   public void deleteTask(String[] taskNames, String[] taskDevelopers, int[] taskDurations, String[] taskStatus, String taskToDelete) {
       

        boolean found = false;
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equals(taskToDelete)) {
                // Deletion logic
                if (taskNames[i] != null && taskNames[i].equals(taskToDelete)) {
            // Set the deleted task's values to zero
            taskNames[i] = null;
            taskDevelopers[i] = null;
            taskDurations[i] = 0;
            taskStatus[i] = null;
            found = true;
            break;
        }
            }
        }

        if (found) {
        // Perform deletion and display success message
        JOptionPane.showMessageDialog(null, "Task deleted: " + taskToDelete);
    } else {
        // Display error message if task not found
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
   }
   public void showAllTasks(String[] taskNames, String[] taskStatus, String[] taskDevelopers, int[] taskDurations) {//shows all the tasks in the system
        StringBuilder allTasksBuilder = new StringBuilder();//(geekforgeeks,2019)
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null) {
                allTasksBuilder.append("Task Name: ").append(taskNames[i])
                              .append("\nTask Status: ").append(taskStatus[i])
                              .append("\nDeveloper: ").append(taskDevelopers[i])
                              .append("\nTask Duration: ").append(taskDurations[i]).append(" minutes")
                              .append("\n\n");                                //The code builds a string with task details by appending task name, status, developer, and duration to a StringBuilder.  The append() method is used to concatenate these values to the allTasksBuilder StringBuilder object, creating a single string that can be displayed to the user.


            }
        }
        JOptionPane.showMessageDialog(null, allTasksBuilder.toString(), "All Tasks", JOptionPane.INFORMATION_MESSAGE);
}
   
   
}
    
    


//Reference
    //docs.oracle.com. (2024). Java Platform, Standard Edition Java API Reference. [online] Available at: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html#substring(int). [Accessed 22 May 2024]

//Farrell,J.2023.JAVA PROGRAMMING.10th ED.Boston:Cengage