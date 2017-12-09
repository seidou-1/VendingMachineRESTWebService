/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_Basic_Programming_Concepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
       
        
    public static void main(String[] args) {
        // TODO code application logic here
      
        
    }
    
        
    
    //Methods Here
    
    public static int computerDecisionMaker(int userInput){ //Method for deciding who wins the battle of R, P, S
        int computerWins = 0;
        int userWins = 0;
        int rounds = 0;
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 3;
        Random randomizer =new Random();
        int computerSelects = (int)randomizer.nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
//          int theirGuess = (int) myScanner.nextInt();
        
//        int convertToRandomNumber = randocolor.nextInt(colors.length);
        
        switch (userInput) {
            case 1:
    /*Rock*/             if (userInput == 2) { //if user picks paper
                             System.out.println("Paper Wins.. User won");
                             userWins++;

                         } else if (userInput == computerSelects) { //if user and computer pick the same
                             System.out.println("It's a draw! Go again");

                         } else  {
                             System.out.println("Rock Wins.. Computer won");
                             computerWins++;
                         }

  /*Paper*/  case 2:     if (userInput == 3) { //if user picks scissors
                             System.out.println("Scissors Wins.. User won");
                             userWins++;

                         } else if (userInput == computerSelects) {
                             System.out.println("It's a draw! Go again");

                         } else {
                             System.out.println("Paper Wins!.. Computer won"); //if user pick rock
                             computerWins++;
                         }
 /*Scissors*/case 3:     if (userInput == 1) { //if user picks rock
                             System.out.println("Rock wins.. User won");
                              userWins++;

                         } else if (userInput == computerSelects) {
                             System.out.println("It's a draw! Go again");

                         } else {
                             System.out.println("Scissors won.. Computer won");
                             computerWins++;
                         }
                           rounds++;
                           
                        }
        return userInput;
                          
    }
    
    public static int userStartsPlaying (int pick){
        System.out.println("*******************************************");
        System.out.println("Let's play a game or Rock, Paper, Scissors.");
        System.out.println(" ");
        System.out.println("        Pick one of the following:");
        System.out.println("");
        System.out.println("  '1' for Rock               '2' for Paper"); 
        System.out.println("             '3' for Scissors");
        
        Scanner radarsAndScanners = new Scanner(System.in);
        pick = (int) radarsAndScanners.nextInt();
        
//        int pick = radarsAndScanners.nextInt();
        
        if (pick>=1 && pick<=3) { //number selected has to be between 1 and 3
            System.out.println("You picked: " + pick);
        } else {
            System.out.println("pick either 1 for Rock, 2 for Paper, or 3 for Scissors!");
        } 
        return pick;
    }
    
    
    
    
    
    
    
    
    
}
