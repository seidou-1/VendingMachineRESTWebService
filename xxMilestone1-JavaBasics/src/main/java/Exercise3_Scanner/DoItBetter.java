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
public class DoItBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner pumpPumpPumpItUp = new Scanner(System.in);
        
        int milesTheyCanRun;
        int hotDogs;
        int languages;
        
        System.out.println("So, how many miles can you run? ");
        milesTheyCanRun = (int) pumpPumpPumpItUp.nextInt();
        System.out.println("That's cool and all but i can run " + milesTheyCanRun*2 + " miles!");
        
        System.out.println("Ok well how many hot dogs can you eat? ");
        hotDogs = (int) pumpPumpPumpItUp.nextInt();
        System.out.println(" loll i can eat " + hotDogs*2 + " hot dogs at a time.");
        
        System.out.println("What about languages? How many can you speak? ");
        languages = (int) pumpPumpPumpItUp.nextInt();
        System.out.println("Man with my mouth closed i can speak " + languages*2 + " languages at a time.");
    }
    
}
