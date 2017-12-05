/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_While_Dos;

import java.util.Random;

/**
 *
 * @author laptop
 */
public class LazyTeenager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int didntItellYou = 0;
        
        final int MIN_NUMBER = 5;
        final int MAX_NUMBER = 100;
        int lenientChance;
        
        
        
       
                /*
                //each time it runs through the loop, the multiplier multiplies chance by 5%
                
                //max = 15.
                do randomizedNumber to the multiples of 5 until it reaches 100.
                the random is actually picking between 5 and 100% chance. So should we be lenient and give him a 20% chance or a 100% chance.
        
                    maybe try the Do.Math random function
                */
        outter:
        do {    
               lenientChance = new Random().nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
               System.out.println("Clean your room! " + lenientChance + "%  chance");
               didntItellYou++;
               
               inner:   
               if (didntItellYou == 15) {
                   System.out.println("");
                   System.out.println("Ok i gave you 15 chances!! Mad face >:-( " + "\n");
                   System.out.println("Now you are grounded now and i'm taking your PlayStation away!!!");
               break;
                }
               
               else if (lenientChance == 100 && didntItellYou !=15) {
                   System.out.println("");
                   System.out.println("Ok i'm cleaning my room but i'm not eating my peas!!");
                        }
            
            
        } while (lenientChance!=100);
        
//        System.out.println("Ok i'll clean my room but i'm not eating the peas");
            
    } 
    
}



//            for (int i = 0; i < 15; i++) {
//                
//                System.out.println("Clean your room!");
//                didntItellYou++;
//                
//                inner:
//                if (didntItellYou == 15) {
//                    break in;
//                }
//            