/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.objectoriented;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author peuvi
 */
public class CA1ObjectOriented {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new FileReader("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\students.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\status.txt"));
           
            while (sc.hasNextLine()) {
               String[] names = sc.nextLine().split("\\s");
               String firstName = names[0];
               String secondName = names[1];
               int numClasses = Integer.parseInt(sc.nextLine());
               String studentNumber = sc.nextLine();
            }

            
            sc.close();
        } catch (Exception e) {
            System.out.println("e");
        }

    }

    private static boolean isValidData(String firstName, String secondName, int numClasses, String studentNumber){
    
        if (!firstName.matches("[a-zA-z]*")) {
            System.out.println("Invalid first name: " + firstName);
            return false;
        }
        
        if (!secondName.matches("[a-zA-Z0-9]*")) {
            System.out.println("Invalid second name: " + secondName);
            return false;
        }
        
        if (numClasses <1 || numClasses > 8 ) {
            System.out.println("Invalid number of classes: " + numClasses);
            return false;
        }
        if (!studentNumber.matches("\\d{2}[a-zA-Z]{2}\\d+")) {
            System.out.println("Invalid student number: " + studentNumber);
            return false;
        
        }
         return true;
        
        }
    
    
    
    
    private static String studentWorkload(int numClasses) {
    
        if (numClasses == 1) {
        return "Very light";
        }
        
        if (numClasses == 2) {
        return "Light";
        }
        
        if (numClasses >= 3  && numClasses <=5) {
        return "Part time";
        }
        
        else {
        return "Full time";
        }
    
    }

    
    
    

}

