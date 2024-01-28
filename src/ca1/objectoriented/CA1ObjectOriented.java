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

    
    public static final String NAME_REQUIREMENTS = "^[a-zA-Z]+ [a-zA-Z0-9]+$";
    public static final String NCLASSES_REQUIREMENTS = "^[1-8]$";
    public static final String STUDENT_ID_REQUIREMENTS = "^[2-9]\\d{1}[a-zA-Z]{2,4}(1\\d{2}|200|[1-9]\\d?)$";

   
    
   

    public static boolean isValidName(String fullNameLine) {
        return fullNameLine.matches(NAME_REQUIREMENTS);
    }

    public static boolean isValidnumClasses(String numClassesLine) {
        return numClassesLine.matches(NCLASSES_REQUIREMENTS);
    }

    public static boolean isValidStudentID(String studentIdLine) {
        if (studentIdLine.length() < 6) {
        return false;
    }
        return studentIdLine.matches(STUDENT_ID_REQUIREMENTS);
    }
    
    
    
    public static String studentWorkload(int numClasses) {
    
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

    
    public static void studentDataOutput (BufferedWriter writer, String studentNumber, String secondName, int numClasses) throws IOException {
    
    writer.write(studentNumber + " – " + secondName + " " + "\n" + studentWorkload(numClasses) + "\n");
    }
    
    
    

}

