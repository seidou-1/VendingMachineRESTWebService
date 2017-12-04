/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_While_Dos;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class RollerCoaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        String stopRiding = "n";
        
        int loopsLooped = 0;
        
        
        
        while (keepRiding.equals("y")) /*As per exercise, no need to change this to a check for "n" because the existing
                                        the existing while loop takes care of that logic already. It'll just stop
            
                                        */        

        {
                System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
                System.out.print("Want to keep going? (y/n) :");
                keepRiding = userInput.nextLine();
                loopsLooped++;

               
        }

                System.out.println("Wow, that was FUN!");
                System.out.println("We looped that loop " + loopsLooped + " times!!");
        }
    
}
