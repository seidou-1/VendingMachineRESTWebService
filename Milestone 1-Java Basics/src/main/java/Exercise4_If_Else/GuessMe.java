
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
public class GuessMe {

    public static void main(String[] args) {
        
        int pickedInteger = 7;
        Scanner myScanner = new Scanner (System.in);
        
        
        System.out.println("Guess my number");
        int theirGuess = (int) myScanner.nextInt();
        
        if (theirGuess == pickedInteger) {
            System.out.println("Your guess: " + theirGuess);
            System.out.println("Wow, nice guess that was it.");
            
        } else if (theirGuess < pickedInteger) {
            System.out.println("Your guess: " + theirGuess);
            System.out.println("Nice try, that was too low. I chose " + pickedInteger);
            
        } else {
            System.out.println("Your guess: " + theirGuess);
            System.out.println("Nah that was too high. I guessed " + pickedInteger);
        }
        
        
    }
}
    
