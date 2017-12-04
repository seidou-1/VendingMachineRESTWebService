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
        
        Scanner myScanner = new Scanner(System.in);
        
        boolean shouldI = true;
        
        System.out.println("Should I do it?");
        myScanner.next();
        
        String convertedVersionOfBoolean = String.valueOf(shouldI);//Captures y or n from boolean
        
        
        while (convertedVersionOfBoolean.equals("y") ) //As long as shouldI = true or they pick y. 
        {
            
            
            
            System.out.println("Wheeeee. Rollercoasters are fun.");
            System.out.println("Do it again?");
            shouldI = myScanner.nextLine();
//            myScanner.next();
            
//            if (convertedVersionOfBoolean.equals("n")) {
//                System.out.println("I did it anyway");
//                break;
//                
//            }
        }
        
        System.out.println("That was fun.");
        
        
        
        
//            switch (convertedVersionOfBoolean)
//            {
//            case "y": System.out.println("I did it! ");
//                break;
//            case "n": System.out.println("I didt it ANYWAYS!");
//                break;
//            }
        
        
        
//         return convertedVersionOfBoolean ? "true" : "false";

        
//        while ()
        
        
        
    }
    
}
