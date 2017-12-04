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
public class MaybeItLovesMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int MIN_NUMBER = 13;
        final int MAX_NUMBER = 89;
        
        int randoBaby = new Random().nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
      
         for (int i = 0; ; i++) {
            
                if (i%2 == 0) {
                    System.out.println("She LOVES ME!!! ");

                } else if (i%2 == 1) {
                    System.out.println("She loves me NOT!!! ");

                }
                if (i == randoBaby) {
                    break;
                
                 
             } else if (i == randoBaby-1) {
                    System.out.println("Oh, wow! It really LOVES me!");
                 
                }
                
             }
                System.out.println("AWWWWW, bummer");
            }

}

        
   
    

