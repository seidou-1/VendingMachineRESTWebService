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
public class Container { //This is the class
    
    private int noOfRounds; //Variables for constructor go here
    
    private int ties = 0;
    private int userWins = 0;
    private int computerWins = 0;
    private int rounds = 0;
    private int overallRoundsContinued = 0;
    private String  continueOn = "";

    public String getContinueOn() {
        return continueOn;
    }
    

    public int getRounds() {
        return rounds;
    }
    
    
    public Container (){ //Constructor
   
    
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }

    public void setNoOfRounds(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }
    
    
    
    private static Scanner myScanner = new Scanner(System.in); //Instantiating a scanner
    
    
    //I can't just create a String method, take in a string, convert it to an int, and return the int. Since i created a String method
    //I have to do a two step approach. First take in a string and return a string. Then pass that to the next method as a string and 
    //parse that to return an int
    public  String getStringInput (String message){ 
        System.out.println(message); //I guess i have to println that long text so i can then put a scanner on it
        String stringVersionOfNoOfRounds = myScanner.nextLine();
        return stringVersionOfNoOfRounds; //now i have the user's input as a string value. Stored in variable stringVersionOfNoOfRounds
    }

    //The purpose of this fromStringToInt method is to convert the user's input on how many rounds they want to play into an int
    public  int fromStringToInt (String thisCanbeWhatevs){//This takes in a string. thisCanbeWhatevs is just a placeholder and can honestly be called anything
         String forConversionToInt = getStringInput (thisCanbeWhatevs); //Get the string the user inputted in the above method. Store it in String variable called forConversionToInt. The thisCanbeWhatevs argument name has no bearing. It just takes the value from the getStringInput String
         int noOfRounds = Integer.parseInt(forConversionToInt); //take the user's input value ... stored in variable forConversionToInt and parse\convert that into an int. Store it in the variable noOfRounds
         return noOfRounds; //I'm storing the value` the user inputted in userInput so i can then reuse that userInput value somewhere else
    }
    
    public  void validRoundScope(int roundScope){
         if ((noOfRounds >=1) && (noOfRounds<=10)) {
//                if (noOfRounds >= 1 && noOfRounds <= 10) { //This logic ensures the user picks a number between 1-10
                    System.out.println("");
                    System.out.println("Ok great we'll play for  " + noOfRounds + " rounds!!");
                    System.out.println("");

                } else { //If not, it'll prompt the user to select again
                    System.out.println("");
                    System.out.println("Nope! can't play less than 1 round or more than 10 rounds");

                }
         
    }
    
    Computer forComputerSelection = new Computer();
    Person forUserInput = new Person();
    
    public void decideWhoWon () {
        
        System.out.println(" Since you picked " + forUserInput.getuserInput() + " and I picked " + forComputerSelection.getComputerSelects() + "\n");
        
        if (forUserInput.getuserInput().equals (forComputerSelection.getComputerSelects())) {
                    System.out.println(" It's a draw! Go again ");
                    System.out.println("");
                    ties++;
                } else {

                    switch (forComputerSelection.getComputerSelects()) { //comparing from the computer
                        case 1: //if computer selects rock
                            /*Rock*/ if (forUserInput.getuserInput().equals("paper")) { //if user picks paper
                                System.out.println(" Paper Wins.. You won ");
                                userWins++;
                            } else {
                                System.out.println("  Rock Wins.. I won ");
                                computerWins++;
                            }
                            break;

                        /*Paper*/ case 2: //if computer selects paper
                            if (forUserInput.getuserInput().equals ("scissors")) { //if user picks scissors
                                System.out.println(" Scissors Wins.. You won ");
                                userWins++;

                            } else {
                                System.out.println("  Paper Wins.. I won "); //if user picks rock
                                computerWins++;
                            }
                            break;
                        /*Scissors*/
                        case 3://if computer picks Scissors
                            if (forUserInput.getuserInput().equals("rock")) { //if user picks rock
                                System.out.println(" Rock wins.. You won ");
                                System.out.println("");
                                userWins++;

                            } else {
                                System.out.println(" Scissors wins.. I won ");
                                System.out.println("");
                                computerWins++;
                            }
                            break;

                    }
                    }
                rounds++; //The number of rounds increment to keep track of how many rounds have progressed
                System.out.println("****************");
                System.out.println("Your wins: " + userWins);
                System.out.println("My wins: " + computerWins);
                System.out.println("****************");
                System.out.println("");

                //This displays the number of rounds nicely formatted
                
                
                //Here i need to instantiate Container so i can use it below:
                Container myContainer = new Container();
                
                if (rounds != myContainer.getNoOfRounds() + overallRoundsContinued) {
                  
                    System.out.println("");
                
                } else {
//                    break; //this if for the while loop later
                      System.out.println("I should break");
                }
                
                System.out.println(" So far we've played " + (rounds + overallRoundsContinued) + " rounds total");
            System.out.println(" Would you lke to continue? (y/n)");
            System.out.println("");
//                        Scanner roundsContinue = new Scanner(System.in); 
            continueOn = myScanner.next();

            switch (continueOn) {
                case "y":
                    System.out.println(" Great we'll continue on ");
                    overallRoundsContinued++;
                    rounds -= rounds;
                    break;

                case "n":
                    System.out.println(" Alright we'll end here ");
                    break;
                default:
                    System.out.println(" Please select 'y' for Yes or 'n' for No");
            }
        
        
    }
    
    public void calculateFinalScores(){
        System.out.println("");
        System.out.println(" \n Here Are The Scores: \n \n Number Of Total Rounds Played: " + (rounds + overallRoundsContinued) + "\n Your Wins:"  + userWins + "\n Computer Wins: " + computerWins + "\n Ties: " + ties);

    }
    
    
    
    
}


 