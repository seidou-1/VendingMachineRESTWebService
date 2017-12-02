
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop
 */
public class FieldDay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        
        System.out.println("What is your last name? ");
        userInput = myScanner.next();
        
        String redDragons = " Red Dragon's";
        String darkWizards = " Dark Wizards";
        String movingCastles = " Moving Castles";
        String snitches = " Golden Snitches";
        String guards = " Night Guards";
        String  blackHoles = "Black Holes";
        
        if (userInput.compareTo("Baggins")<0) {
            System.out.println("You belong in " + redDragons);
        }
        
        if (userInput.compareTo("Baggins")>0 && userInput.compareTo("Dresden")<0) {
            System.out.println("You are on team " + darkWizards);
            
        }
        
        if (userInput.compareTo("Dresden")>0 && userInput.compareTo("Howl")<0) {
            System.out.println("You are on team " + movingCastles);
        }
        
        if (userInput.compareTo("Howl")>0 && userInput.compareTo("Potter")<0) {
            System.out.println("You are on team " + snitches);
        }
        
        if (userInput.compareTo ("Potter")>0 && userInput.compareTo("Vimes")<0) {
            System.out.println("You belong on the team " + guards);
        }
        
        if (userInput.compareTo("Vimes")>0) {
            System.out.println("You are on team " + blackHoles);
        }
        System.out.println("Good luck on the games my G! ");

        
//        System.out.println(bagginsReturn);
//          
//        int dresdenReturn = userInput.compareTo("Dresden");
//        System.out.println(dresdenReturn);
//        
//        int howlReturn = userInput.compareTo("Howl");
//        System.out.println(howlReturn);
//        
//        int potterReturn = userInput.compareTo("Potter");
//        System.out.println(potterReturn);
//        
//        int vimesReturn = userInput.compareTo("Vimes");
//        System.out.println(vimesReturn);
//        
        
            
        }
       
                
        
    }
    

