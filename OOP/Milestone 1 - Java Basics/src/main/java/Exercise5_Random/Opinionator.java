package Exercise5_Random;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop
 */
public class Opinionator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide FOR ME!");

        int x = randomizer.nextInt(6); //This was the bug. Changed it from 5 to 6 so it can include the last condition. Because it starts counting from 0 not 1.

        System.out.println("The number we chose was: " + x);

        if (x == 0) { 
            System.out.println("Llamas are the best!");
        } else if (x == 1) {
            System.out.println("Dodos are the best!");
        } else if (x == 2) {
            System.out.println("Woolly Mammoths are DEFINITELY the best!");
        } else if (x == 3) {
            System.out.println("Sharks are the greatest, they have their own week!");
        } else if (x == 4) {
            System.out.println("Cockatoos are just so awesomme!");
        } else if (x == 5) {
            System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
        } 

        System.out.println("Thanks Random, maybe YOU'RE the best!");
        
    }
    
}
