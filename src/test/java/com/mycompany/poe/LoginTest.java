/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * @author lab_services_student
 */
public class LoginTest {
    
    public LoginTest() {
    }
    @Test
    public void testCheckUserName() {
        Login login = new Login();

        // Test case: Username is correctly formatted
        String username1 = "kyl_1";
        Boolean expected=true;
         Boolean actual=login.checkUserName(username1, username1, username1);
        Assertions.assertEquals(expected,actual);

      
    }
     @Test
 public void testfalseCheckUserName() {
        Login login = new Login();
   
   // Test case: Username incorrectly formatted
        
         Boolean expected=false;
        String username2 = "kyle!!!!!!!";
        Boolean actual=login.checkUserName(username2, username2, username2);
        Assertions.assertEquals(expected,actual);   
}
    @Test
    public void testCheckUserPasswordComplexity() {
        Login login = new Login();

        // Test case: Password meets the complexity requirements
         Boolean expected=true;
        
        String password1 = "Ch&&sec@ke99!";
         Boolean actual=login.checkUserPasswordComplexity(password1);
        Assertions.assertEquals(expected,actual); 

      
    
}
     @Test
    public void testfalseCheckUserPasswordComplexity() {
        Login login = new Login();
      // Test case: Password does not meet the complexity requirements
       Boolean expected=true;
        String password2 = "password";
          Boolean actual=login.checkUserPasswordComplexity(password2);
      Assertions.assertEquals(expected,actual); 
    }
    
    
}
