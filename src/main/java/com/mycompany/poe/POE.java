/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
public class POE {

    public static void main(String[] args) {
       
        /*Scanner scanner = new Scanner(System.in);

        String passPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

        System.out.println("Please enter your name:");//promps user to enter their name
        String name = scanner.nextLine();

        System.out.println("Please enter your surname:");//promps user to enter their surname
        String surname = scanner.nextLine();

        String username;
        do {
            System.out.println("Please enter your username (must be no longer than five characters and contain an underscore):");
            username = scanner.nextLine();
        } while (username.length() > 5 || !username.contains("_"));  // Username validation loop

        String password;
        do {
            System.out.println("Please enter your password (at least 8 characters, containing at least one lowercase, one uppercase, one digit, and one special character):");
            password = scanner.nextLine();
        } while (!password.matches(passPattern));  // Password validation loop using String.format

        Login login = new Login();  //Create a new instance of the Login class.
        if (login.checkUserName(name, surname, username))
        System.out.println("Username successfully captured.");{//Checks if the checkUserName method of the Login class returns true for the given name, surname, and username
            if (login.checkUserPasswordComplexity(password)) {//Checks if the checkUserPasswordComplexity method of the Login class returns true for the given password
                System.out.println("Password successfully captured.");
                if (login.LoginUser(scanner, username, password)) {
                System.out.println("Welcome, " + login.getName() + " " + login.getSurname()+" "+"Its great to see you again");//Print a welcome message that includes the user's name and surname
                } else {
                   System.out.println("Username or password incorrect please try again.");//Print an error message indicating that the username or password is incorrect.
                }
            }
        }*/
     Task task = new Task();        
int OPTION = 0;

JOptionPane.showMessageDialog(null, "WELCOME TO EASY KANBAN"); //(Farrel.J.2023)

// Declare the arrays outside the loop
String[] task_developers = new String[100];
String[] task_Names = new String[100];
String[] task_IDs = new String[100];
 int[] task_Durations = new int[10];
String[] task_Status = new String[100];

String longestTaskDeveloper = "";

String longestTaskDuration = "";

while (OPTION != 3) {
    // Prompt the user for an option
    String input = JOptionPane.showInputDialog("Select an option:\n1 - Add tasks\n2 - Show Report\n3 - Quit");
    OPTION = Integer.parseInt(input);//(Farrel.J.2023)  I am referencing Ineger.parseInt()
        
    if (OPTION == 1) {
        // Add tasks
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));//(Farrel.J.2023)

        for (int i = 1; i <= numTasks; i++) {
            // Prompt the user for task details
            String taskName = JOptionPane.showInputDialog("Enter task name " + i + ":");
            task_Names[i-1] = taskName;// I deducted 1 because my loop starts at one but arrays begin at zero 0.
            
            String taskDescription = JOptionPane.showInputDialog("Enter task description for Task " + i + ":");//(Farrel.J.2023) I am referencing JOptiobPane
            String taskDeveloperDetails = JOptionPane.showInputDialog(null, "Write the developer details for Task " + i + ":");
            task_developers[i-1] = taskDeveloperDetails;
             
            String taskDurationInput = JOptionPane.showInputDialog(null, "Enter the task duration for Task " + i + " (in minutes):");
                    int taskDuration = Integer.parseInt(taskDurationInput);
                    task_Durations[i-1] = taskDuration;
            String taskStatus = JOptionPane.showInputDialog(null, "Enter the task status for Task" + i + ":" + " \nTO DO \nDONE \nDOING ");
            task_Status[i-1] = taskStatus;
            int taskNum = i - 1; //calculates the task number
            
            // Handle the task
            if (task.checkTaskDescription(taskDescription)) { //tests legth of task description
                String taskId = task.createTaskId(taskName, taskDeveloperDetails, taskNum);
                task_IDs[i] = taskId;
                System.out.println("Task added: " + taskDescription);
                System.out.println("Task ID: " + taskId);
                task.printTaskDetails(taskStatus, taskDeveloperDetails, taskName, taskNum, taskDescription, taskId, taskDuration); //prints out the task details
            
             
            } else {
                // Task name exceeds the length limit
                JOptionPane.showMessageDialog(null, "Task description exceeds the length limit of 50 characters.");//error message if the task decription is more than 50 words
            }
        }
    }
    else if (OPTION == 2) {
        // Show Report
        int reportOption = 0;
        while (reportOption != 6) {
            String reportInput = JOptionPane.showInputDialog("Select a report option:\n1 -Search for task with task name \n2 - Show DONE tasks \n3 - Longest task duration \n4 - Delete Task  \n5 - Show all tasks \n6 - Task assigned to developer \n7- Back ");
            reportOption = Integer.parseInt(reportInput);

            if (reportOption == 1) {
                // Show Tasks with Status DONE
                  boolean findTaskName = false;
        String searchTaskName = JOptionPane.showInputDialog("Enter a task name to search for:");

        for (int i = 0; i < task_Names.length; i++) {
            if (task_Names[i] != null && task_Names[i].equals(searchTaskName)) {
                // Match found
                String name = task_Names[i];
                String developer = task_developers[i];
                String status = task_Status[i];
                
                // Output the developer and task status
                JOptionPane.showMessageDialog(null, "Developer: " + developer + "\nTask Status: " + status + "\nTask Name: " + name);
                findTaskName = true;
            }
        }

        if (!findTaskName) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }
      if (reportOption == 2) {     
           StringBuilder doneTasksBuilder = new StringBuilder(); //GeeksforGeeks. (2018)
        boolean foundDoneTasks = false;

        for (int i = 0; i < task_Names.length; i++) {
            if (task_Names[i] != null && task_Status[i].equals("DONE")) {
                doneTasksBuilder.append("Task Name: ").append(task_Names[i]).append("\n").append("DEVELOPER: ").append(task_developers[i]).append("\n").append("Task Duration: ").append(task_Durations[i]).append("\n");
                foundDoneTasks = true;
            }
        }

        if (foundDoneTasks) {
            JOptionPane.showMessageDialog(null, doneTasksBuilder.toString(), "Tasks with Status DONE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks with status DONE found.", "Tasks with Status DONE", JOptionPane.INFORMATION_MESSAGE);
        }
    }
      else if (reportOption == 3) {
                        // Show Task with Longest Duration
                        task.showLongestTask(task_developers, task_Durations);
                    }
      
       else if (reportOption == 4) {
           //delete a task
           
         String taskToDelete = JOptionPane.showInputDialog("Enter the name of the task to delete:");
                task.deleteTask(task_Names, task_developers, task_Durations, task_Status, taskToDelete);
           
       }
           
       else if (reportOption == 5) {
                // Show All Tasks
                task.showAllTasks(task_Names, task_Status, task_developers, task_Durations);
            }
      
         else if (reportOption == 6) {
                boolean findDevName = false;//search for for task developer is assigned to
        String searchDevName = JOptionPane.showInputDialog("Search for developer tasks");

        for (int i = 0; i < task_developers.length; i++) {
            if (task_developers[i] != null && task_developers[i].equals(searchDevName)) {
                // Match found
                String name = task_Names[i];
                String developer = task_developers[i];
                String status = task_Status[i];
                
                // Output the developer and task status
                JOptionPane.showMessageDialog(null, "Developer: " + developer + "\nTask Status: " + status + "\nTask Name: " + name);
                findDevName = true;
            }
        }

        if (!findDevName) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
       
         }
       else {
           break;//(GeeksforGeeks, 2019) This piece of code stops the loop
           
       }
            
        
      
      }
    }
    }
}
}

//Referece
//GeeksforGeeks. [online] 29 Oct. Available at: https://www.geeksforgeeks.org/stringbuilder-appendcodepoint-method-in-java-with-examples/ [Accessed 12 Jun. 2024].
//GeeksforGeeks. (2019). Break statement in Java. [online] Available at: https://www.geeksforgeeks.org/break-statement-in-java/. /[Accessed 14 Jun. 2024].‌
