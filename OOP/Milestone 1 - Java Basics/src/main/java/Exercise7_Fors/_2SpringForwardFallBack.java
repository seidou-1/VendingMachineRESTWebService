/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise7_Fors;

/**
 *
 * @author laptop
 */
public class _2SpringForwardFallBack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println("It's Spring...!");
        /*for (int i = 0; i < 10; i++)*/ //In this loriginal oop the start range is 0 and the stop range is 10 
            for (int i = 10; i != 0; i--) /*This exercise requires you to Update loop #1 so that it prints out the 
                same range as loop #2, but only change the start or stopping points.
                The only way i can think of doing that is switching the start and stop range and changing the stop condition to !=
                */
        { 
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) { //In this loop the start range is 10 and the stop range is 0 because it's counting down
            System.out.print(i + ", ");
        }
    }
    
}
