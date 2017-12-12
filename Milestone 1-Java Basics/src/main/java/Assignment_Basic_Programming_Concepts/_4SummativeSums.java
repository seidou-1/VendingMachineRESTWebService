/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_Basic_Programming_Concepts;

import java.util.Arrays;

/**
 *
 * @author laptop
 */
public class _4SummativeSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // each of these 3 arrays hold the range of values
        int[] firstSet = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] secondSet = {999, -60, -77, 14, 160, 301};
        int[] thirdSet = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,140, 150, 160, 170, 180, 190, 200, -99};
        
        //The method does all the work. Just calling it here:
        System.out.println("First Set Array Sum: " + arrayResults(firstSet));
        System.out.println("Second Set Array Sum: " + arrayResults(secondSet));
        System.out.println("Third Set Array Sum: " + arrayResults(thirdSet));
        
    }
    
    //Methods Below

    public static int arrayResults(int[] allArrays) {
        int adder = 0; //this is a placeholder so i can hold the result of all the arrays 

        for (int i = 0; i < allArrays.length; i++) {
            adder += allArrays[i]; //this sums up the individual numbers in each array and passes it to the variable adder
        }

        return adder; //i then use that to return the value of the arrays
    }

}


/* I wrote this code originally. It works but it's a bit redundant. Redid it better above.
    public static void arrayResults(){
        int firstSetSum = 0;
        int secondSetSum = 0;
        int thirdSetSum =0 ;
        
        int[] firstSet =  {1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] secondSet =  {999, -60, -77, 14, 160, 301};
        int[] thirdSet = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
        
        System.out.println("First Set: ");
        for (int i = 0; i < firstSet.length; i++) {
            Arrays.sort(firstSet); 
            System.out.print(" " + (firstSet[i]));
            firstSetSum+=(firstSet[i]);  
            }
         
        System.out.println("");
        System.out.println("First Set Array Sum: " + firstSetSum);
        System.out.println("");
        System.out.println("Second Set: ");
        for (int j = 0; j < secondSet.length; j++) {
            
            Arrays.sort(secondSet); 
            System.out.print(" " + secondSet[j]);
            secondSetSum+=(secondSet[j]);
        }
        System.out.println("");
        System.out.println("Second Set Array Sum: " + secondSetSum);
        System.out.println("");
        System.out.println("Third Set: ");
        
        for (int k = 0; k < thirdSet.length; k++) { 
            Arrays.sort(thirdSet); 
            System.out.print(" " + thirdSet[k]);
            thirdSetSum+=(thirdSet[k]);
            
        }
        System.out.println("");
        System.out.println("Third Set Array Sum: " + thirdSetSum);
       
}
}

*/