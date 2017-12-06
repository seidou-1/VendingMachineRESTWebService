/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise7_Fors;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class _6TwoForsAndTenYearsAgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i)); //This one is easier to understand
        }

        System.out.println("\nI can count backwards using a different way too...");

        for (int i = year; i >= year - 20; i-=20 { //I'm going to have to get back to this one
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
    
}
