/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise9_Arrays;

import java.util.Arrays;

/**
 *
 * @author laptop
 */
public class _5SimpleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

//        int[] wholeNumbers = new int[24];
        int[] wholeNumbers = new int[firstHalf.length + secondHalf.length];
        int counter = 0;
        
        
        for (int i = 0; i < firstHalf.length; i++) {
            wholeNumbers[i] = firstHalf[i];
            counter++; 
        }
        
        for (int i = 0; i < secondHalf.length; i++) {
            wholeNumbers[counter++] = secondHalf[i];
        }
        System.out.println("Here you go - all nice and ordered: ");
        for (int i = 0; i < wholeNumbers.length; i++) {
            Arrays.sort(wholeNumbers);
            
            System.out.print(" " + wholeNumbers[i]);
        }
        
    }
    
}
