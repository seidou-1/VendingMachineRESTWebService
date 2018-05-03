
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
public class TriviaNight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        
                
        
        int answer1 = 4;
        int answer2 = 2;
        int answer3 = 3;
        int userInput;
        
        int howManyRight = 0;
        
        //****************************************
        System.out.println("First Question!");
        
        System.out.println("What is the lowest level programming language?");
        System.out.println("1) Source Code              2)Assembly Language");
        System.out.println("3) C#                       4)Machine Code");
        userInput = (int) myScanner.nextInt();
        
        if (userInput == answer1) {
        System.out.println("You are correct");
        howManyRight++;
        
        } else {
        System.out.println("Nope that's wrong");
        System.out.println("You've got " + howManyRight + " right");
        }
        //****************************************
        System.out.println("Second Question!");
        
        System.out.println("Website security CAPTCHA forms are descended from the work of?");
        System.out.println("1) Grace Hopper              2)Alan Turing");
        System.out.println("3) Charles Babbage           4)Larry Page");
        userInput = (int) myScanner.nextInt();
        
        if (userInput == answer2) {
        System.out.println("You are correct");
        howManyRight++;
        System.out.println("You've got " + howManyRight + " right so far");
        
        } else {
        System.out.println("Nope that's wrong");
        System.out.println("You've got " + howManyRight + " right");
        }
        
        //****************************************
        System.out.println("Third Question!");
        
        System.out.println("Which of these Sce-Fi Ships was once slated for a full-size replica in Las Vegas?");
        System.out.println("1) Serenity                 2)The Battlestar Galactica");
        System.out.println("3) The USS Enterprise       4)The Millenium Falcon");
        userInput = (int) myScanner.nextInt();
        
        if (userInput == answer3) {
        System.out.println("You are correct");
        howManyRight++;
        System.out.println("You've got " + howManyRight + " right. You answerd them all correctly!");
        
        } else {
        System.out.println("Nope that's wrong");
        System.out.println("You've got " + howManyRight + " right");
        
                
    }
    }
    
    
    
    
    
    
    
    
}
