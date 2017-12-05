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
public class BewareTheKraken2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        int depthDivedInFt = 0;
        String theirInput;

        Scanner myScanner = new Scanner(System.in);
        
        boolean finished = true;
        
        outer://labeled this first for loop as outer so i can select it to break into afterwards
        for (int depthDivedInFt = 0; depthDivedInFt < 36200 /*&& !finished*/; depthDivedInFt+=1000) {
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            in: //labeled this if statement so i can target it later to break out of
            if (depthDivedInFt == 18100) {
                System.out.println("We're at the half way point.... 18,100 feet. Do you want to continue?");
                theirInput = myScanner.next();
                inner:
                    if (theirInput.equals("n")) {
                        System.out.println("You have swam: " + depthDivedInFt);
//                        finished = !true; Thought i needed this but i don't
                        break outer; //selected to break out of the outer loop
                    } 
                  } 
                }
//                      System.out.println("You have swam: " + depthDivedInFt);
        }    
    }


        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
//        while(depthDivedInFt < 36200){
//            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
//
//            if(depthDivedInFt == 20000){
//                System.out.println("Hey man, we'er at 20,000 feet. Running... Out.. Of.. Oxygen....");
//                System.out.println("Do you want to get out?");
//                String theirInput = myScanner.next();
//                
//                    if (theirInput == "n") {
//                    break;
//                    } 
//                
//            }   
//
//            // I can swim, really fast! 500ft at a time!
//            depthDivedInFt += 1000;
//        }
//        
//    }
    

