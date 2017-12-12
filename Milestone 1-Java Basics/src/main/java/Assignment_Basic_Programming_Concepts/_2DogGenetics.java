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
public class _2DogGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random randoBaby = new Random();

        System.out.println("What's your dog's name?");
        Scanner myScanner = new Scanner(System.in);
        String doggy = myScanner.nextLine();

        String[] breeds = { //Created this string to store different type of dog breeds as an array
            "Pitbull", "Yorkie", "Great Dane", "Bulldog", "Shih-Tzu", "Scottish Terrier", "Wheaten", "Pug", "Collie"
        };
        
        /*Below i created variables to store random numbers up to 100. 
        Each variable below it subtracts from the one above it so all the numbers can add up to 100        
        */
        int firstCount = randoBaby.nextInt(101 /*+ 1 - 1) + 1*/); //To exclude zero
        int secondCount = randoBaby.nextInt(101 - firstCount);
        int thirdCount = randoBaby.nextInt(101 - firstCount - secondCount);
        int fourthCount = randoBaby.nextInt(101 - firstCount - secondCount);
        int fifthCount = randoBaby.nextInt(101 - firstCount - secondCount - thirdCount - fourthCount);
        
        //I created this array to list out all the variables when i eventually output the results via the for loop
        int[] randomPercentage = {firstCount, secondCount, thirdCount, fourthCount, fifthCount};

        System.out.println("Ok your dog " + doggy + "'s" + " breed makeup is: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(randomPercentage[i] + "% " + breeds[i]);

            //Create an array that holds the random percentages
//        int[] randomPercentage = new int[100];
//        
//        for (int i = 1; i < randomPercentage.length; i++) { //Iterate through ane array of 100 numbers
//            randomPercentage[i] = (int) (Math.random() * 100);
//            
//            System.out.println(randomPercentage[i] + "%" );
//            
//        }
//            System.out.println("");
        }

        //Methods below
    }
}
