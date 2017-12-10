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
public class RockPaperScissorsSandBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("*******************************************");
        System.out.println("Let's play a game or Rock, Paper, Scissors.");
        System.out.println(" ");
        
        System.out.println("How many rounds do you want to play?");
        System.out.println("Pick between 1 and 10 rounds");
        Scanner roundsScanner = new Scanner(System.in);
//        int noOfRounds;
//        noOfRounds = roundsScanner.nextInt();
        int noOfRounds = (int) roundsScanner.nextInt();
        
        
        if (noOfRounds>=1 && noOfRounds>=10 ) {
        System.out.println("Ok great we'll play for  " + noOfRounds);
            
        } else {
            System.out.println("Nope! can't play less than 1 round or more than 10 rounds");
        }
            
        //Put a while loop in here somewhere to ask the user to try again
        
        
        System.out.println("        Pick one of the following:");
        System.out.println("");
        System.out.println("  '1' for Rock               '2' for Paper"); 
        System.out.println("             '3' for Scissors");
        System.out.println("");
        
        String conversion = userStartsPlaying("What's your pick?");
    }
    
     public static String userStartsPlaying(String prompt) {
        Scanner myScanner = new Scanner (System.in);
        String userInput = "";
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        
        if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) { //number selected has to be between 1 and 3
            System.out.println("Ok you picked: ");
            
            switch(userInput){
                case "1": System.out.print(userInput + " Rock");
                    break;
                case "2": System.out.print(userInput + " Paper");
                    break;
                case "3": System.out.print(userInput + " Scissors");
                    break;
            }
        } else {
            System.out.println("Hey man pick either 1 for Rock, 2 for Paper, or 3 for Scissors!!!");
        } 
         
        return userInput;
    
}
    //This method creates a randomizer for the computer of RPS. It then takes the usersInput and compares it to see who wins.
     public static void computerDecisionMaker(userStartsPlaying(userInput)){ //Method for deciding who wins the battle of R, P, S
//        /*int finalUserInput*/
//         Method2 (method1 (method1argument))
         
        int passedValue = userStartsPlaying(userInput); //this retrieves the pick value from the userStartsPlaying method
        int computerWins = 0;
        int userWins = 0;
        int rounds = 0;
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 3;
        Random randomizer =new Random();
        int computerSelects = (int)randomizer.nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
        
        switch (passedValue) {
            case 1:
    /*Rock*/             if (passedValue == 2 && computerSelects == 2) { //if user picks paper
                             System.out.println("Paper Wins.. User won");
                             userWins++;

                         } else if (passedValue == computerSelects) { //if user and computer pick the same
                             System.out.println("It's a draw! Go again");

                         } else  {
                             System.out.println("Rock Wins.. Computer won");
                             computerWins++;
                         }

  /*Paper*/  case 2:     if (passedValue == 3 && computerSelects == 2) { //if user picks scissors
                             System.out.println("Scissors Wins.. User won");
                             userWins++;

                         } else if (passedValue == computerSelects) {
                             System.out.println("It's a draw! Go again");

                         } else {
                             System.out.println("Paper Wins!.. Computer won"); //if user pick rock
                             computerWins++;
                         }
 /*Scissors*/case 3:     if (passedValue == 1 && computerSelects == 3) { //if user picks rock
                             System.out.println("Rock wins.. User won");
                              userWins++;

                         } else if (passedValue == computerSelects) {
                             System.out.println("It's a draw! Go again");

                         } else {
                             System.out.println("Scissors won.. Computer won");
                             computerWins++;
                         }
                           rounds++;
                           
                        }
                        System.out.println("So far we've played " + rounds);
                        System.out.println("Would you lke to continue?");
                        Scanner roundsContinue = new Scanner(System.in); 
                        String continueOn = roundsContinue.next();
                        
                        //Another while loop here
                        
//        return finalUserInput;
                          
    }
        
}

