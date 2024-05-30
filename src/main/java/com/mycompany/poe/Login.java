package com.mycompany.poe;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Login {//Farrel.J.2023
    private String username;
    private String password;
    private String name;
    private String surname;

    public boolean checkUserName(String name, String surname, String username) {//checkUserName: This method validates the username input by the user and stores it in the Login object.
        Scanner scanner = new Scanner(System.in);
        while (username.length() > 5 || !username.contains("_")) {//It outputs this message if the user enters a username more than 5 letters or doesnt contain a underscore and then it loops username
            System.out.println("Username is not formatted correctly. Please enter a username no longer than five characters and containing an underscore: ");
            username = scanner.nextLine();
        }
        
          // Set the name,surname and usernmae fields in the Login object // (Stack Overflow,2024)
        this.name = name;
        this.surname = surname;
        this.username = username;
        // Return true to indicate successful validation
        return true;
    }
//check if the password is correctly formatted and store it in the Login object
    public boolean checkUserPasswordComplexity(String password) {
        String passPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";//baeldung, W. (2024)   // Check if the password is correctly formatted
        Scanner scanner = new Scanner(System.in);//Farrel.J.2023
 // Loop until the password matches the pattern
        while (!password.matches(passPattern)) {
            System.out.println("Password is not correctly formatted. Please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character:");
            password = scanner.nextLine();
        }

        this.password = password;
        return true;
    }
//register a user by prompting for name, surname, username, and password
     public String registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your surname:");
        String surname = scanner.nextLine();

        String username;
        do {  //(w3schools, 2024.)    This loop will execute if the condition is true.
            System.out.println("Please enter your username (must be no longer than five characters and contain an underscore):");
            username = scanner.nextLine();
        } while (username.length() > 5 || !username.contains("_"));

        String password;
        do {
            System.out.println("Please enter your password (at least 8 characters, containing at least one lowercase, one uppercase, one digit, and one special character):");
            password = scanner.nextLine();
        } while (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$")); // Check if the password is correctly formatted

        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

        return "Registration successful!";
    }
    
    public boolean LoginUser(Scanner scanner, String username, String password) {
        String username2 = "";
        String password2 = "";

        System.out.println("Please enter The user name you registered with:");  // Prompt the user to re-enter their username
        username2 = scanner.nextLine();
        System.out.println("Please enter the password you registered with:");  // Prompt the user to re-enter their password
        password2 = scanner.nextLine();

        if (username2.equals(username) && password2.equals(password)) { //(ioflood.com. (2024))// Check if the entered username and password match the stored values
// Return true if the input username and password match the stored username and password, false otherwise
            return true;
        } else {
            return false;
        }
    }

    // Getter and setter methods for the name, surname, username, and password fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//Stack Overflow. (n.d.). Java Login program using a class. [online] Available at: https://stackoverflow.com/questions/25599047/java-login-program-using-a-class.
//Mkyong.com. (2024). Java regex validate username examples. [online] Available at: https://mkyong.com/regular-expressions/how-to-validate-username-with-regular-expression/.
//ioflood.com. (2024). Java .equals() Method: A Detailed Tutorial. [online] Available at: https://ioflood.com/blog/dot-equals-method-java/ [Accessed 9 Apr. 2024].
//baeldung, W. (2024) Regular expression for password validation in Java, Baeldung. Available at: https://www.baeldung.com/java-regex-password-validation (Accessed: 9 April 2024). 
////Farrel.J.2023.JAVA Programming.Tenth Edition.Boston:Cengage

