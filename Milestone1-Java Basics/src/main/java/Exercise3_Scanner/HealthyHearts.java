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
public class HealthyHearts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner heartRateBoii = new Scanner (System.in);
        
//        int theirAge = 1; //I gave theirAge a value of zero just to satisfy the compiler since in java, a variable must have a value before its value is used.
        int theirAge;
        double lowerPercentageHR = .50;
        double higherPercentageHR = .85;
//        double theirHR = (.50*theirAge);
//        double heartRate = (220-theirAge);
        
        System.out.println("How old are you? ");
        theirAge = (int) heartRateBoii.nextInt();
        
        System.out.println("Your heart rate should be " + (220-theirAge) + " beats per minute");
        
        System.out.println("The target heart rate zone is " + (lowerPercentageHR * (220-theirAge)) + " - " + (higherPercentageHR * (220-theirAge)) + " beats per minute");
        
      //This is the not the best approach but..  
      //I could not figure out how to declare a variable without assigning a variable to it and then use that variable within another variable.
      //It seems Java wants you to assign a value to a variable before you can call it within another variable
        
    }
    
}
