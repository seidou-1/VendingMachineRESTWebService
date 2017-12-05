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
public class _3ForTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner (System.in);
        
        System.out.println("What number should i do a times tables for? ");
        int userInput = myScanner.nextInt();
        
        for (int i = 0; i < 15; i++) {
            
            System.out.println(userInput + " * " + i + " is: " + (i * userInput) );
            
        }
        
    }
    
}
