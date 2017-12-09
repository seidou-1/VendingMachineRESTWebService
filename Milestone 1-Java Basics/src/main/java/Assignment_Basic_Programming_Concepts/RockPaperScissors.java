/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_Basic_Programming_Concepts;

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
        int user = 0;
        int userWins = 0;
    }
    
    //Methods Here
    
    public static computerDecisionMaker(int userInput){
        switch (int userInput) {
            case 1:
    /*Rock*/             if (userInput == 2) { //if user picks paper
                             System.out.println("Paper Wins.. User won");
                             userWins++;

                         } else if (userInput == computerSelects) { //if user and computer pick the same
                             System.out.println("It's a draw! Go again");

                         } else  {
                             System.out.println("Rock Wins.. Computer won");
                         }

  /*Paper*/  case 2:     if (userInput == 3) { //if user picks scissors
                             System.out.println("Scissors Wins.. User won");
                             userWins++;

                         } else if (userInput == computerSelects) {
                             System.out.println("It's a draw! Go again");

                         } else {
                             System.out.println("Paper Wins!.. Computer won"); //if user pick rock
                         }
 /*Scissors*/case 3:     if (userInput == 1) { //if user picks rock
                             System.out.println("Rock wins..");

                         } else if (userInput == computerSelects) {
                             System.out.println("It's a draw! Go again"); 

                         } else {
                             System.out.println("Scissors won.. Computer won");
                         }
                           return a; 
                        }
    }
    
    
    
    
    
    
    
    
    
}
