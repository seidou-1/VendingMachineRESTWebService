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
public class _1ForAndTwentyBlackbirds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int birdsInPie = 0;
        for (int i = 0; i < 24; i++) { /*All i changed was the stop condition. I increased it from 20 to 24. The birdsInPie++ 
            piggy backs off the while loop so i can use it to display the final number at the end.                                            
                                            */
        System.out.println("Blackbird #" + i + " goes into the pie!");
            
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
}
    

