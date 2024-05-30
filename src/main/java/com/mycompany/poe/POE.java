/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class POE {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

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
        }
    }
    }

