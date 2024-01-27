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
                String fullNameLine = sc.nextLine();

                if (fullNameLine.isEmpty()) {
                    sc.nextLine();
                    sc.nextLine();
                    
                    continue;  
                }

                String numClassesLine = sc.nextLine();
                String studentIdLine = sc.nextLine();

                if (!isValidName(fullNameLine)) {
                    System.out.println("Invalid name format: " + fullNameLine);
                    System.out.println("Please enter a valid full name with only letters for the first name, followed by a single space, and the second name can include letters and/or numbers.");
                    continue;
                }

                if (!isValidnumClasses(numClassesLine)) {
                    System.out.println("Invalid number of classes format: " + numClassesLine);
                    System.out.println("Provide a valid number of classes. It should be an number between 1 and 8");
                    continue;
                }

                if (!isValidStudentID(studentIdLine)) {
                    System.out.println("Invalid student ID format: " + studentIdLine);
                    System.out.println("Should be at least 6 characters long.\n" + "Start with 2 numbers.\n" + "Followed by 1 to 3 letters.\n" + "End with numbers.");
                    continue;
                }

                int numClasses = Integer.parseInt(numClassesLine);
                String studentNumber = studentIdLine;
                String[] names = fullNameLine.split(" ");

                studentDataOutput(writer, studentNumber, names[1], numClasses);
            }

            sc.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

