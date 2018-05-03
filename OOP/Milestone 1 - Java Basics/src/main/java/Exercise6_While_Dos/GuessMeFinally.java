/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_While_Dos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class GuessMeFinally {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        
        //Changed the program to request a number between 1 and 5 instead of between -100 and 100
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 5;
        
        int randoBaby = new Random().nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;//Instead of defining a number myself, i just had the random method choose one for me.

        int theirGuess;
        int numberOfAttempts = 1;
        
        do {
            
        System.out.println("Pick a number between 1 and 5. Betcha can't guess it! ");
        theirGuess = myScanner.nextInt();
        
                 
                if (theirGuess < randoBaby) {
                    System.out.println("Your Guess: " + theirGuess);
                    System.out.println("Too Low! Try again!!");
                    numberOfAttempts++;
                 
                } else if (theirGuess > randoBaby) {
                    System.out.println("Your Guess: "+ theirGuess);
                    System.out.println("Too High! Try again!!");
                    numberOfAttempts++;

                } 
                
                if (theirGuess == randoBaby && numberOfAttempts == 1){
                    System.out.println("Your Guess: " + theirGuess);
                    System.out.println("Yup you got it right with one try!!"); 
                    numberOfAttempts++;
                    break;
                } else if (theirGuess == randoBaby)
                {
                    System.out.println("Finally! It's about time you got it right! It only took you " + numberOfAttempts + " tries"); 
                }

            } while (theirGuess != randoBaby); 
            
           } 
               
             
      
    }
    


