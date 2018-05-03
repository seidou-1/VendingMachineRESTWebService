/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise5_Random;

import java.util.Random;

/**
 *
 * @author laptop
 */
public class CoinFlipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random coinFlip = new Random(3);

        
        if (coinFlip.equals(1)) { //.equals() works because var.equals is for objects and strings.
            System.out.println("You got Heads! ");
            
        } else if (coinFlip.equals(2)) {
            System.out.println("You got Tails! ");
            
        } else {
            System.out.println("Some other number");
            

            
        }
        
        //NONE OF THESE THAT I TRIED WORK... WHY??? I WAS TRYING TO USE A SWITCH BUT APPARENTLY CAN'T CONVERT RANDOM TO INT :(
        

//        stuff = Integer.parseInt(coinFlip);
        
//        int converterBaby = Integer.valueOf(coinFlip);

//        int number = (int)(Math.random(conFlip); 
        
//       long converterBaby = Long.parseLong(coinFlip);
        
//        int converterBaby = Integer.parseInt(coinFlip);

//        int i = (Integer) coinFlip;
//        int i = (int) coinFlip;

//        int i =Integer.valueOf(coinFlip);
        
//        
//            if (coinFlip = 1) {
//                System.out.println("ds");


//        switch (coinFlip){
//            case 1:
//                System.out.println("You got HEADS!!");
//            break;
//            
//            case 2:
//                System.out.println("You got TAILS!");
//            break;
//            
//            default: System.out.println("Cannot compute");
//        }
    }
    
}
