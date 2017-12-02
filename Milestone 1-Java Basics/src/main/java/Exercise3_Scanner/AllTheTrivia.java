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
public class AllTheTrivia {
    public static void main(String[] args) {
        
     Scanner radarsAndScanners = new Scanner (System.in);
     String fact1;
     String fact2;
     String fact3;
     
        System.out.println("What's the biggest planet in the Milky Way? ");
        fact1 = radarsAndScanners.next();
        
        System.out.println("Who is the highest album selling pop star of all time? ");
        fact2 = radarsAndScanners.next();
        
        System.out.println("What is the largest continent? ");
        fact3 = radarsAndScanners.next();
        
        System.out.println("Huh! " + fact2 + " is the largest continent. ");
        System.out.println(" And " + fact1 + " is the highest album selling pop star of all time. ");
        System.out.println(" Let's not forget " + fact3 + " is the biggest planet in the Milky way ");
        
    }
}
