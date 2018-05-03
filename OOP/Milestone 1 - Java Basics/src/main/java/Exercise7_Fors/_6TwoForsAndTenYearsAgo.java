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
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        //original for loop:
        //for (int i = year; i >= year - 10; i--)
        for (int i = year; i >= year - 100; i-=10) { /*i changed the termination to be 100 years from the users input. I 
                                                /*I also changed the increment to -=10 to go back down by 10 years at a time
                                                */
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}