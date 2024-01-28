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

    public void showMenu() {
        try {
            Scanner sc = new Scanner(System.in);
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\status.txt", true));

            while (true) {
                System.out.println("Welcome to the Student System");
                System.out.println("1. Read data from local file");
                System.out.println("2. Add data via console");
                System.out.println("3. Exit");
                System.out.print("Please enter the number corresponding to the desired option: ");

                int choice = getOption(sc);

                switch (choice) {
                    case 1:
                        readDataFromFile(writer);
                        break;
                    case 2:
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

    private int getOption(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void readDataFromFile(BufferedWriter writer) {
        try {
            Scanner sc = new Scanner(new FileReader("C:\\Users\\peuvi\\Documents\\NetBeansProjects\\CA1-ObjectOriented\\students.txt"));

            while (sc.hasNextLine()) {
                String fullNameLine = sc.nextLine();

                if (fullNameLine.isEmpty()) {
                    sc.nextLine();
                    sc.nextLine();
                    continue;
                }

                String numClassesLine = sc.nextLine();
                String studentIdLine = sc.nextLine();

                if (!CA1ObjectOriented.isValidName(fullNameLine) || !CA1ObjectOriented.isValidnumClasses(numClassesLine) || !CA1ObjectOriented.isValidStudentID(studentIdLine)) {
                    System.out.println("Invalid data in the file. Skipping.");
                    continue;
                }

                int numClasses = Integer.parseInt(numClassesLine);
                String studentNumber = studentIdLine;
                String[] names = fullNameLine.split(" ");

                CA1ObjectOriented.studentDataOutput(writer, studentNumber, names[1], numClasses);
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }

    private String getInput(String prompt, Scanner sc) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private void addDataViaConsole(Scanner sc, BufferedWriter writer) throws IOException {

        while (true) {
            String fullNameLine = getInput("Enter the first and last name separated by one single space. (or type exit to stop):", sc);
            String numClassesLine = getInput("Enter number of classes:", sc);
            String studentIdLine = getInput("Enter student ID:", sc);

            if (CA1ObjectOriented.isValidName(fullNameLine) && CA1ObjectOriented.isValidnumClasses(numClassesLine) && CA1ObjectOriented.isValidStudentID(studentIdLine)) {

                int numClasses = Integer.parseInt(numClassesLine);
                String studentNumber = studentIdLine;
                String[] names = fullNameLine.split(" ");

                CA1ObjectOriented.studentDataOutput(writer, studentNumber, names[1], numClasses);
            } else {
                System.out.println("Student data invalid. Please try again.");
            }
        }
    }

}
