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
public class DoOrDoNotPt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean doIt;
        boolean iPressedAnything = true;
        boolean justStart = true;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
//        String myInput = input.ne;
        String myInput = input.nextLine();
        
      
        
        if (myInput == "y") {
            doIt = true; // DO IT!
        } else if (myInput == "n") {
            doIt = false; //I didn't do it
        }
          else if (myInput !="y" && myInput !="n"){
            iPressedAnything = true; // DONT YOU DARE!
        }
        
        outter:
         while (justStart){
             
             if (myInput !="y" && myInput !="n") {
                System.out.println("I didn't do it");  
                 
                 
             }
                else if (myInput == "y") {
                 System.out.println("I did it");
                
                 
             } else if (myInput == "n") { // will not evaluate to true
                 System.out.println("I know you said not to but i did anyway");
                
                 
             } 
                break outter;
                 
             }
//             System.out.println("I didn't do it");
             
//             if (!myInput){
//                 System.out.println("I know you said not to but i did anyway");
//                 break outter;
//             }
//        
        
        }
    }
