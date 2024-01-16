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

}
