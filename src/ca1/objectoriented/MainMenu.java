/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class MainMenu {

    // Displays the main menu and handles the user input
    public void showMenu() {
        try {
            // Creating a scanner for user input and a BufferedWriter for writing to "status.txt" 
            // The 'true' parameter is to open the file in append mode so we can keep adding students to the file
            Scanner sc = new Scanner(System.in);
            BufferedWriter writer = new BufferedWriter(new FileWriter("status.txt", true));

            while (true) {
                // Main menu options
                System.out.println("Welcome to the Student System");
                System.out.println("1. Read data from local file");
                System.out.println("2. Add data via console");
                System.out.println("3. Exit");
                System.out.println("Please enter the number corresponding to the desired option: ");

                int choice = getOption(sc);
                // Get user choice and handle it using a switch statement
                switch (choice) {
                    case 1:
                        // Read data from local file using my reader mathod and writing to my 'status.txt' file after closing the menu using my writer
                        readDataFromFile(writer);
                        break;
                    case 2:
                        //Read data from user Input using the scanner and it will write to my 'status.txt' file after closing the menu using my writer
                        addDataViaConsole(sc, writer);
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        
                        writer.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Gets the user option 
    private int getOption(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    // Reads student data from a file and validates it using CA1ObjectOriented methods
    private void readDataFromFile(BufferedWriter writer) throws IOException {
    try (Scanner sc = new Scanner(new FileReader("students.txt"))) {
        int counter = 1;

        while (sc.hasNextLine()) {
            String fullNameLine = sc.nextLine();
 
            // Skip blank lines and the next two lines if it finds a blank name, so it won't read any other type of data as the student's name
            if (fullNameLine.isEmpty()) {
                sc.nextLine();
                sc.nextLine();
                continue;
            }

            String numClassesLine = sc.nextLine();
            String studentIdLine = sc.nextLine();

            //Made to validate the read data using the validations defined on my CA1ObjectedOriented 
            if (!CA1ObjectOriented.isValidName(fullNameLine) || !CA1ObjectOriented.isValidnumClasses(numClassesLine) || !CA1ObjectOriented.isValidStudentID(studentIdLine)) {
                
                // If any validation fails it will print a message about invalid data, skip to the next set of data, and increment the counter
                System.out.println(counter + ": " + "Invalid data in the file. Skipping.");
                counter++;
                continue;
            }

            // Parsing the number of classes obtained from my numClassesLine
            int numClasses = Integer.parseInt(numClassesLine);
            
            // Extracting the student number obtained from my studentIdLine
            String studentNumber = studentIdLine;
            
            // Extracting the student name obtained from my fullNameLine and spliting it in a array [2] by using a space as the delimiter
            String[] names = fullNameLine.split(" ");

            // Output valid data to the writer
            CA1ObjectOriented.studentDataOutput(writer, studentNumber, names[1], numClasses);
            
            // Displaying information about a student read from my 'students.txt' file
            System.out.println(counter + ": " + "Read from file: " + studentNumber + " – " + names[1] + " " + CA1ObjectOriented.studentWorkload(numClasses));
            // Incrementing the counter to keep track of the sequence number for the next line of data
            counter++;
        }
    } catch (IOException e) {
        System.out.println("Error reading data from file: " + e.getMessage());
    }
}


    // Method created to get the user input with a prompt using my scanner
    private String getInput(String prompt, Scanner sc) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    // Adds student data via console input and validates it
    private void addDataViaConsole(Scanner sc,BufferedWriter writer) throws IOException {

        while (true) {
            String fullNameLine = getInput("Enter the first and last name separated by one single space. (or type 'exit' to stop):", sc);

            if (fullNameLine.equalsIgnoreCase("exit")) {
                break;
            }

            String numClassesLine = getInput("Enter number of classes,a number between 1 to 8:", sc);
            String studentIdLine = getInput("Enter student ID:" + "\n" + "- First 2 numbers should start with 20 or higher" + "\n" + "- The 3rd and 4th characters (and possibly 5th) being a letter" + "\n" + "- The number after the letters must be between 1 and 200" , sc);

            // Validate console input and add data to the writer if it's valid based on my CA1ObjectedOriented validations
            if (CA1ObjectOriented.isValidName(fullNameLine) && CA1ObjectOriented.isValidnumClasses(numClassesLine) && CA1ObjectOriented.isValidStudentID(studentIdLine)) {

                // Parsing the number of classes obtained from my numClassesLine
                int numClasses = Integer.parseInt(numClassesLine);
                
                // Extracting the student number obtained from my studentIdLine
                String studentNumber = studentIdLine;
                
                // Extracting the student name obtained from my fullNameLine and spliting it in a array [2] by using a space as the delimiter
                String[] names = fullNameLine.split(" ");

                // Output valid data to the writer
                CA1ObjectOriented.studentDataOutput(writer, studentNumber, names[1], numClasses);
            } else {
                System.out.println("Student data invalid. Please try again.");
            }
        }
    }

}
