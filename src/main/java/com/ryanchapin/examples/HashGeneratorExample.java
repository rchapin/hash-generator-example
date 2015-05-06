package com.ryanchapin.examples;

import java.io.Console;

import com.ryanchapin.util.HashGenerator;
import com.ryanchapin.util.HashGenerator.HashAlgorithm;

public class HashGeneratorExample {
   
   public static final char EXIT_CHAR = '0';
   
   public static void deleteArray(char[] arr) {
      for (int i = 0; i < arr.length; i++) {
         arr[i] = (char) 0x00;
      }
   }
   
   public static boolean checkForExitChar(char[] arr) {
      boolean retVal = false;
      if (arr.length == 1 && arr[0] == '0') {
         retVal = true;
      }
      return retVal;
   }
   
   public static void main(String[] args) throws Exception {
    
      Console console = System.console();
      if (console == null) {
         throw new Exception("Console is unavailable");
      }
      
      System.out.println("Create hashes of salted passwords");
      
      boolean keepRunning = true;
      runningLoop:
      while (keepRunning) {
      
         char[] salt = null;;
         int saltCount = 0;
         while (saltCount < 1 || saltCount > 16) {
            salt = console.readPassword("Enter 1-16 chars to be used as salt. To quit, enter '0'");
            if (checkForExitChar(salt)) {
               break runningLoop;
            }
            saltCount = salt.length;
         }

         char[] passwd = null;
         int passwdCount = 0;
         while (passwdCount < 8 || passwdCount > 32) {
            passwd = console.readPassword("Enter 8 - 32 character password. To quit, enter '0'");
            if (checkForExitChar(passwd)) {
               break runningLoop;
            }
            passwdCount = passwd.length;
         }

         char[] saltedPassword = new char[(saltCount + passwdCount)];
         System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
         System.arraycopy(passwd, 0, saltedPassword, salt.length, passwd.length);
         deleteArray(salt);
         deleteArray(passwd);
         
         String hashedPasswd = HashGenerator.createHash(saltedPassword, HashAlgorithm.SHA256SUM);
         deleteArray(saltedPassword);
         System.out.println("hashedPasswd = " + hashedPasswd);
      }
      
      System.out.println("Exiting...");
   }
}
