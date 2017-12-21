/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredRPS;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class Person {
    
//    private int noOfRounds;
    private int rounds;
    private String userInput;
    private String rock;
    private String paper;
    private String scissors;
    private boolean valid = false;

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    
    public String getuserInput(){
        return userInput;
    }
    
    public void setuserInput(){
        this.userInput = userInput;
    }
    
    public boolean getvalid(){
        return valid;
    }
    
    private static Scanner myScanner = new Scanner(System.in);

    public String userRPSChoice(){
            
            System.out.println("*******");
                    System.out.println("Round: " + (rounds + 1));
                    System.out.println("*******");
                    System.out.println("   Pick one of the following:");
                    System.out.println("");
                    System.out.println("   Rock                Paper");
                    System.out.println("           Scissors");
                    System.out.println("");

                    System.out.println("What's your pick? ");
                    userInput = myScanner.nextLine();
                     
                
                    valid = userInput.equalsIgnoreCase("rock")||userInput.equalsIgnoreCase("paper")||userInput.equalsIgnoreCase("scissors");
                
                System.out.println("Ok you picked " + userInput);
                 return userInput;
}
    }