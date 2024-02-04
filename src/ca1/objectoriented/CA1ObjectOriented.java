/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.objectoriented;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author peuvi
 */
public class CA1ObjectOriented {
     // Regular expression for name validation
    public static final String NAME_REQUIREMENTS = "^[a-zA-Z]+ [a-zA-Z0-9]+$";
     // Regular expression for number of classes validation
    public static final String NCLASSES_REQUIREMENTS = "^[1-8]$";
     // Regular expression for student_id validation
    public static final String STUDENT_ID_REQUIREMENTS = "^[2-9]\\d{1}[a-zA-Z]{2,4}(1\\d{2}|200|[1-9]\\d?)$";

    // Takes a name as input and returns true if it matches the defined name validation.
    public static boolean isValidName(String fullNameLine) {
        return fullNameLine.matches(NAME_REQUIREMENTS);
    }
    
    // Takes the number of classes as input and returns true if it matches the defined number of classes validation.
    public static boolean isValidnumClasses(String numClassesLine) {
        return numClassesLine.matches(NCLASSES_REQUIREMENTS);
    }

    // Takes a student_id as input and returns true if it matches the defined student_id validation. 
    // if statement to check if lenght is at least 6 characters.
    public static boolean isValidStudentID(String studentIdLine) {
        if (studentIdLine.length() < 6) {
            return false;
        }
        return studentIdLine.matches(STUDENT_ID_REQUIREMENTS);
    }

    // Sets the workload according to the number of classes.
    public static String studentWorkload(int numClasses) {
    
        if (numClasses == 1) {
            return "Very light";
        }

        if (numClasses == 2) {
            return "Light";
        }

        if (numClasses >= 3 && numClasses <= 5) {
            return "Part time";
        } else {
            return "Full time";
        }

    }

    // Method to outputting the student data in the required format.
    public static void studentDataOutput(BufferedWriter writer, String studentNumber, String secondName, int numClasses) throws IOException {    
        writer.write(studentNumber + " – " + secondName + " " + "\n" + studentWorkload(numClasses) + "\n");
    }

}
