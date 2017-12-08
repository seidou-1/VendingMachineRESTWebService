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
public class LovesMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        
        
        System.out.println("Pick a number");
        int userInput = myScanner.nextInt();
        
        //Change this to a while loop
        for (int i = 0; i < userInput; i++) { //As long as the user inputs a number. Perform this operation up until that number
            
            
            
            if (i % 2 == 0) {
                
                System.out.println("She Loves Me!! " + i);
                System.out.println("******************");
                
            } else if (i % 2 ==1) {
                System.out.println("She Loves Me Not!! " + i);
            }
            
            
            
        }
        
    }
    
}
