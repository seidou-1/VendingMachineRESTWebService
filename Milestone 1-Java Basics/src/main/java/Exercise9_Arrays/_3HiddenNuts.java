/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise9_Arrays;

import java.util.Random;

/**
 *
 * @author laptop
 */
public class _3HiddenNuts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();//creating a randomizer
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut"; /*assigning a variable to randomizer. 
        Having randomizer loop through an index of 100 elements randomly and storing "Nut" in one of the indexes */
        System.out.println("The nut has been hidden...");
        
        
        
        for (int i = 0; i < hidingSpots.length; i++) {
            
            if (hidingSpots[i]==("Nut")) {
                int index; // created this variable as a placeholder to store the value of i
                index = i; 
                System.out.println(index);
                System.out.println("Found it! It's in spot# " + index);
                
                

                
            }
            
        }
        
    }
    
}
