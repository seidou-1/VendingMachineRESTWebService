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
public class StayPositive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner radarsAndScanners = new Scanner(System.in);
        int theirInput;
        
        do {
            System.out.println("Hey man give me a number between 1 and 50");
            theirInput = radarsAndScanners.nextInt();
                
                    if (theirInput < 50) 
                    {
                        for (int i = (theirInput); i > 0; i--)
                            
                            System.out.print(" " + i); 
                        
                    } 
                    
                    else if (theirInput > 50) {
                        
                    System.out.println(theirInput + " is not between 1 and 50 now is it? Try again");
//                    break;
                    }
                           
            } while (theirInput > 50);

                    
    }  
}