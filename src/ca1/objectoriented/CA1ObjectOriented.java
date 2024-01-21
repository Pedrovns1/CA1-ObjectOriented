/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.objectoriented;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
               String fullName = sc.nextLine();
               String[] names = fullName.split("\\s", 2);
               
               if (names.length <2) {
                   System.out.println("Invalid second name. The second name must be separated by a single space from the first name: " + fullName);
                   break;
               }
               
               String firstName = names[0];
               String secondName = names[1];
               int numClasses = Integer.parseInt(sc.nextLine());
               String studentNumber = sc.nextLine();
            
               if (isValidData(firstName, secondName, numClasses, studentNumber)) {
                    studentDataOutput(writer, studentNumber, secondName, numClasses);
                }
            
            }

            
            sc.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("e");
        }

    }

    private static boolean isValidData(String firstName, String secondName, int numClasses, String studentNumber){
    
        if (!firstName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid first name. The first name must contain only letters:"  + firstName);
            return false;
        }
        
        if (!secondName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid second name. The second name must be separeted by a single space from the first name: " + secondName);
            return false;
        }
        
        if (numClasses <1 || numClasses > 8 ) {
            System.out.println("Invalid number of classes. The number of classes must be between 1 and 8:" + numClasses);
            return false;
        }
        if (!studentNumber.matches("\\d{2}[a-zA-Z]{2,5}\\d+")) {
            System.out.println("Invalid student number. Ensure the student number is at least 6 characters long, starting with 2 numbers, followed by 1, 2 or possibly 3 letters, and ending with numbers." + studentNumber);
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

    
    private static void studentDataOutput (BufferedWriter writer, String studentNumber, String secondName, int numClasses) throws IOException {
    
    writer.write(studentNumber + " – " + secondName + " " + "\n" + studentWorkload(numClasses) + "\n");
    }
    
    
    

}

