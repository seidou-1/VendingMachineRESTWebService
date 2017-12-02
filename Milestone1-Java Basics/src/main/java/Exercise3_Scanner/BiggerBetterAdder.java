/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3_Scanner;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class BiggerBetterAdder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner waterBottle = new Scanner(System.in);
        int number1; 
        int number2;
        int number3;
        
        System.out.println("Give me an integer");
        //number1 = waterBottle.nextDouble();
        number1 = (int) waterBottle.nextInt();
        
        System.out.println("Give me another integer");
        number2 = (int) waterBottle.nextInt();
        
        System.out.println("Ok one last integer, i promise");
        number3 = (int) waterBottle.nextInt();
        
        System.out.println("The numbers you gave me are: ");
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
    }
    
}
