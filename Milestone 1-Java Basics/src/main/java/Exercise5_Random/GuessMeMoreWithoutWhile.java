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
public class GuessMeMoreWithoutWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final int MAX_NUMBER = 5; //This assigns a variable to random so i can reuse that variable later on. Giving this variable a value of -100
        final int MIN_NUMBER = 1; // same as above
        
        int randoBaby = new Random().nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
        int theirGuessMatch;
        
        //This is the formula i need below. Rather than doign the math, i jsut assigned literals\values for in and max so i can change it anytime
        //new Random().nextInt((max - min) + 1) + min; //This just instantiates Random
        
        Scanner myScanner = new Scanner(System.in);
    
        
            System.out.println("Pick a number between 1 and 5");
            theirGuessMatch = myScanner.nextInt(); //Assigning a variable to myScanner so i can reuse it later on
            
            
            if (theirGuessMatch == randoBaby) {
            System.out.println("Ayy you guessed correct!!!");
   
           } else if (theirGuessMatch < randoBaby) {
               System.out.println("********************");
               System.out.println("You guessed too Low! ");
               System.out.println("Your Guess: " + theirGuessMatch); 
               System.out.println("********************");
               System.out.println("");
               System.out.println("Give it another go! ");
               
                
            } else if (theirGuessMatch > randoBaby) {
               System.out.println("*********************");
               System.out.println("You guessed too High! ");
               System.out.println("********************");
               System.out.println("Your Guess: " + theirGuessMatch); 
               System.out.println("");
               System.out.println("Give it another shot! ");
    }
            if (theirGuessMatch != randoBaby) {
                
                System.out.println("This is your second chance. Pick a number between 1 and 5");
                theirGuessMatch = myScanner.nextInt(); //Assigning a variable to myScanner so i can reuse it later on
            
            }
            
            if (theirGuessMatch < randoBaby) {
               System.out.println("********************");
               System.out.println("You guessed too Low! ");
               System.out.println("Your Guess: " + theirGuessMatch); 
               System.out.println("********************");
               System.out.println("");
               System.out.println("Sorry you only get two tries ");
            
        }   else if (theirGuessMatch > randoBaby) {
               System.out.println("*********************");
               System.out.println("You guessed too High! ");
               System.out.println("********************");
               System.out.println("Your Guess: " + theirGuessMatch); 
               System.out.println("");
               System.out.println("Sorry i only gave you two tries. You're out! ");
    
}
}
}
