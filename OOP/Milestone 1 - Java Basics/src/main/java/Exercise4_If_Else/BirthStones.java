/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise4_If_Else;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class BirthStones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        int theirNumber;
        
        System.out.println("Give me a number");
        theirNumber = myScanner.nextInt();
        
        if (theirNumber == 1) {
        System.out.println("January's birth stone is Garnet");
            
        } else if (theirNumber == 2) {
            System.out.println("February's birth stone is Amethyst");
            
        } else if (theirNumber == 3) {
            System.out.println("March's birth stone is Aquamarine");
        } else if (theirNumber == 4) {
            System.out.println("April's birth stone is Diamond");
        } else if (theirNumber == 5) {
            System.out.println("May's birth stone is Emerald");
        } else if (theirNumber == 6) {
            System.out.println("June's birth stone is Pearl");
        } else if (theirNumber == 7) {
            System.out.println("July's birth stone is Ruby");        
        } else if (theirNumber == 8) {
            System.out.println("August's birth stone is Peridot");
        } else if (theirNumber == 9) {
            System.out.println("September's birth stone is Sapphire");
        } else if (theirNumber == 10) {
            System.out.println("October's birth stone is Opal");
        } else if (theirNumber == 11) {
            System.out.println("November's birth stone is Topaz");
        } else if (theirNumber == 12) {
            System.out.println("December's birth stone is Turquoise");
        } else  {
            System.out.println("You didn't select a month between 1 and 12. " + theirNumber + " doesn't match a month. Goodbye!");
        }
    }
    
}
