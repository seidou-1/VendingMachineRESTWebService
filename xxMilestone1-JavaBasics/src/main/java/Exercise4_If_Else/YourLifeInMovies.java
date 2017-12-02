
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
public class YourLifeInMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner (System.in);
        int theirYear;
        String theirName;
        
        System.out.println("Hey, lets play a game. What's your name? ");
        theirName = myScanner.next();
        
        System.out.println("Ok " + theirName + ", What year were you born? ");
        theirYear = myScanner.nextInt();
        
        if (theirYear <= 2005) {
            System.out.println("Pixar's UP came out half a decade ago. ");
            
        }
        if (theirYear <= 1995) {
            System.out.println("The first Harry Potter came out over 15 years ago.");
            
        }
        if (theirYear <= 1985) {
            System.out.println("Space Jam came out not last decade, but the one before THAT!");
            
        }
        if (theirYear <= 1975) {
            System.out.println("The original Jurassic Park release is closer to the lunar landing, than today");
            
        }
        if (theirYear <= 1965) {
            System.out.println("MASH has been around for almost half a century!");
        }
        
    }
    
}
