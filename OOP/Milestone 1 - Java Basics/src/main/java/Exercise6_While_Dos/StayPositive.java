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
                
                    if (theirInput <= 50) 
                    {
                        for (int i = (theirInput); i > 0; i--) //This is to print the numbers backwards from their input counting down
                        
                        {
                            System.out.print(" " + i); //Just print out i
                            if (i % 10 ==0) { //This line checks if the number has reached 10 spaces. If so, break the line and start a new
                                System.out.println("\n"); //This is the break line
                                
                            }
                        }
                        System.out.println("\n" +"\n" + "Whoaaaa better stop there roger rabbit!");
                        
                    } 
                    
                    else if (theirInput > 50) { //This does something if the user inputs a number above 50
                    System.out.println("");
                    System.out.println(theirInput + " is not between 1 and 50 now is it? Try again!!");
                    System.out.println("");//Space it out
                    }
                           
            } while (theirInput > 50);

                    
    }  
}