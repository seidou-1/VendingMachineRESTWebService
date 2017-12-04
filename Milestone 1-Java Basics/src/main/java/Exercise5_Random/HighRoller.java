/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise5_Random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class HighRoller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        /*int rollResult = .... I took this out because i can declare and assign to 
        the Random funciton in the same breath. Ala line 35.
        */
        
        System.out.println("TIME TO ROOOOOOLLLL THE DICE!");
        
        System.out.println("What are the number of sides the dice has? ");
        int userNumberOfSides = myScanner.nextInt();
        
        diceRoller.nextInt(userNumberOfSides);
        
        System.out.println("I rolled a " + userNumberOfSides);
        
        if (userNumberOfSides == 1) {
            
            System.out.println("You rolled a critical failure!");
            
        } //try using.nextDouble()
    }
    
}
