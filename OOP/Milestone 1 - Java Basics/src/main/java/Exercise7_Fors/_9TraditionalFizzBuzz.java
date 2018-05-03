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
public class _9TraditionalFizzBuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        
        int incrementor = 0;
        
        System.out.println("Pick a number my G: ");
        int userInput = myScanner.nextInt();
     
              
        for (int i = 0; i <15; i++) {
            
            if (incrementor == userInput && i==15) {
                break;
                
            }
            
            else if (i%3==0 && i%5 ==0) {
                System.out.println(i + " Fizz Buzz");
                incrementor++;
                
            } else if (i%5 ==0 ) {
                System.out.println(i + " Buzz");
                incrementor++;
                
            } else if (i%3 ==0) {
                System.out.println(i + " Fizz ");
                incrementor++;
            }  else {
                System.out.println(i);
            }
            
        }
//        } 
        
        System.out.println("TRADITION!!" + incrementor + " instances of Fizz, Buzz, or Fizz Buzz");
    } 
    
}
