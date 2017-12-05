/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise7_Fors;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class _4ForTimesFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
//        int whatNumber;
//        int i = 0;
//        int theirInput;
        Scanner myScanner = new Scanner (System.in);
        int theirInput = myScanner.nextInt();
        int piggyBackToGetOutOfLoop = 0;
        
        
        System.out.println("What times tables do you want me to do? ");
        theirInput = myScanner.nextInt();
        
            
        do {
            
                for (int i = 0; i < 12; i++) {
                    piggyBackToGetOutOfLoop++;

                    int correctAnswer = theirInput *i;    

                    System.out.println("What is " + theirInput + " * " + i + " ?");
                    theirInput = myScanner.nextInt();//capturing their input here



                if (theirInput == correctAnswer) {
                    System.out.println("That is correct");

                } else  {
                    System.out.println("That is NOT correct");
                        }
        
    }
            } while (piggyBackToGetOutOfLoop <=12);
    
}
}
