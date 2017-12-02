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
public class MiniMadLibs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    Scanner madLib = new Scanner(System.in);
    
    String noun1;
    String adjective1;
    String noun2;
    int number1;
    String adjective2;
    
    String noun3;
    String noun4;
    String noun5;
    
    String verbPresentTense;
    String sameVerbButPastTense;
    
        System.out.println("Give me a noun ");
        noun1 = madLib.next();
        
        System.out.println("Give me an adjective ");
        adjective1 = madLib.next();
        
        System.out.println("Give me another noun ");
        noun2 = madLib.next();
        
        System.out.println("Give me a number");
        number1 = madLib.nextInt();
        
        System.out.println("Give me another adjective ");
        adjective2 = madLib.next();
        
        System.out.println("This is going to be annoying. I need 3 more nouns. Go ");
        noun3 = madLib.next();
        
        System.out.println("Another..");
        noun4 = madLib.next();
        
        System.out.println("Last noun i promise..");
        noun5 = madLib.next();
        
        System.out.println("Ok now i need a verb");
        verbPresentTense = madLib.next();
        
        System.out.println("For real, i promise this is it. Give me the same verb as before but in past tense");
        sameVerbButPastTense = madLib.next();
        
        System.out.println("Here's a mad lib for you..");
        System.out.println(noun1 + ":" + " the " + adjective1 + "frontier. " + " These are the voyages of the starship " + 
                noun2 + ". It's a " + number1 + " year mission: to explore strange " + adjective2 + noun3 + ", to seek out " +
                adjective2 + noun4 + " and " +  adjective2  + noun5 + " to boldly " + verbPresentTense + " where no one has "
                + sameVerbButPastTense + " before."
                
                );
        
    }

    
} 
