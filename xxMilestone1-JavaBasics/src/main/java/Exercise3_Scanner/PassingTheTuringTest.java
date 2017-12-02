/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3_Scanner;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class PassingTheTuringTest {
    
    public static void main(String[] args) {
    
    Scanner mcLovin = new Scanner(System.in);

    int number1;
    int myFavNumber = 9;
    String theirFavFood;
    String theirFavMovie;
    String theirName;
    String youThere;
    
    String myFavMovie = "saw";
    String myName = "Mo";
    
        System.out.println("Wtsup! Is anyonyone there? ");
        youThere = mcLovin.next(); //captures any random thing they input
        
        System.out.println("Oh, ok. Well what's your name? ");
        theirName = mcLovin.next();
        
        System.out.println("loll wow that is the most common name in my family. ");
        System.out.println("Alright well since we're here, tell me your favorite food. ");
        theirFavFood = mcLovin.next();
        
        System.out.println("Im actually allergic to " + theirFavFood + " but i'll let you pass. My favorite food is everything else though!");
        
        System.out.println("I love the movie " + myFavMovie + " its such an awesome flick. What's your fav movie?");
        theirFavMovie = mcLovin.next();
        
        System.out.println("Ok how about numbers? My fav number is " + myFavNumber + ". What about you?");
        number1 = (int) mcLovin.nextInt();
        
        System.out.println("Nice. We have a lot in common. You and i both have a " + theirName + " in the family. " );
 
        System.out.println("We also both like " + theirFavMovie + " and I also kinda have a thing for the number " + number1 + "! weird i know. ");
        System.out.println("Anyway, nice chatting with ya " + theirName + " I gotta go now. Chow!");
    
    
}
}
