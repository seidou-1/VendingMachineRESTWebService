/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_Basic_Programming_Concepts;

/**
 *
 * @author Kenny
 */
 


import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class _3HealthyHearts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //created this age variable of float data type so i can use it later to pass the calculated percentage value to it
        float age;
        age = heartRateCalculation("What is your age?");
        
        //below is the math that calculates the heart rate
        float maxHeartRate = 220-age;
        double minHeartRateZone = .50*maxHeartRate;
        double maxHeartRateZone = .85*maxHeartRate;
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
        System.out.println("Your target HR Zone is " + minHeartRateZone + "%"+ " - " + maxHeartRateZone + "% beats per minute");
        
    }
    //Methods below
    public static float heartRateCalculation (String prompt){
        Scanner myScanner = new Scanner(System.in);
//        int age = myScanner.nextInt();
        System.out.println(prompt); //This value gets printed back onto "String prompt"
        String input = myScanner.nextLine();
        float floatVal = Float.parseFloat(input); //i used this to convert the user's input into decimal numbers to give it a more realistic percentage value
        return floatVal; //this return allows me to call the method above with this respective code block executing
        }
    
}

