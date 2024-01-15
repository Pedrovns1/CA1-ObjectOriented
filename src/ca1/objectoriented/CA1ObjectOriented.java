/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1.objectoriented;

import java.io.FileReader;
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

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (Exception e) {
            System.out.println("e");
        }

    }

}
