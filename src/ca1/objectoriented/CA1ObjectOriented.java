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
    
    public static final String NAME_REQUIREMENTS = "^[a-zA-Z]+ [a-zA-Z]+$";
    public static final String NCLASSES_REQUIREMENTS = "^[1-8]$";
    public static final String STUDENT_ID_REQUIREMENTS = "\\d{2}[a-zA-Z]{2,5}\\d+";
   
    
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new FileReader("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\students.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\status.txt"));
           
            while (sc.hasNextLine()) {
               String fullName = sc.nextLine();
               String[] names = fullName.split("\\s", 2);              
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

    private static boolean isValidName(String fullNameLine) {
        return fullNameLine.matches(NAME_REQUIREMENTS);
    }

    private static boolean isValidnumClasses(String numClassesLine) {
        return numClassesLine.matches(NCLASSES_REQUIREMENTS);
    }

    private static boolean isValidStudentID(String studentIdLine) {
        return studentIdLine.matches(STUDENT_ID_REQUIREMENTS);
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

