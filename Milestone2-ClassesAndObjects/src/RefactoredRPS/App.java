/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredRPS;

/**
 *
 * @author laptop
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        Container rockPaperScissorsObject = new Container(); //Instantiate to access the method
        
        String message = "*******************************************\n Let's play a game or Rock, Paper, Scissors. \n \n How many rounds do you want to play? \n Pick between 1 and 10 rounds \n";
        String howManyRounds = "How many rounds do you want to play? \n Pick between 1 and 10 rounds \n";
        int noOfRounds=rockPaperScissorsObject.fromStringToInt(rockPaperScissorsObject.getStringInput(howManyRounds));
        
        rockPaperScissorsObject.setNoOfRounds(noOfRounds);//This is accessing the setNoOfRounds method within the Container class
        
        //First do starts
          
        do {
             rockPaperScissorsObject.getStringInput(message); //Initial designs
         
       //*********
        
        
         
         
         rockPaperScissorsObject.getStringInput(howManyRounds); //This is to loop over to make sure the user select the correct rounds
         
         do { //Second do starts to validate correct number of rounds
             rockPaperScissorsObject.setNoOfRounds(noOfRounds);
            
        } while (rockPaperScissorsObject.getNoOfRounds() < 1 || rockPaperScissorsObject.getNoOfRounds() > 10);
         
        Person theUserPlaying = new Person(); //Instantiating the object so i can use the methods
         
        do {
             theUserPlaying.userRPSChoice(); //Calling the Person userRPSChoice method within the Person class
            
        } while (theUserPlaying.getvalid() == false); // This will keep looping until the user selects exatly "rock" "paper" or "scissors"
        
        //Instantiating the Computer class object so i can call it's method.
        Computer theComputerSelection = new Computer();
        
        theComputerSelection.computerSelection(); //Calling this method to let computer select RPS
        
        //Switch to decide who won:        
        rockPaperScissorsObject.decideWhoWon();
        
        do { //This is going to continue to ask the user to select RPS and have the computer select RPS as long as....
            theUserPlaying.userRPSChoice();
            theComputerSelection.computerSelection();
            
        } while (rockPaperScissorsObject.getRounds() < rockPaperScissorsObject.getNoOfRounds()); //the current round# is less than the specified noOfRounds set by the user
        //noOfRounds 
        
      } while (rockPaperScissorsObject.getContinueOn().equalsIgnoreCase("y"));   //continue is yes
    }
    
    
    
}
