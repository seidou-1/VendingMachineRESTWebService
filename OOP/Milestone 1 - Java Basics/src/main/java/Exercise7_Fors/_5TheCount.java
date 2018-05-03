/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise7_Fors;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class _5TheCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Start at: ");
        int startAt = myScanner.nextInt();
        
        System.out.println("Stop at: ");
        int stopAt = myScanner.nextInt();
        
        System.out.println("Count by: ");
        int countBy = myScanner.nextInt();
        
        for (int i = startAt; i <= stopAt; i+=countBy) { //wow all i had to do was add the ++ operator!! now it works
            
        
            System.out.print(i + ""); //I used print instead of println because i wanted numbers to print horizontally instead of vertically
            
            if (i%3 == 0) {
                System.out.println("- Ah ah ah!"); //went back to printing vertically using println
                
            }
            
            
            
        }
    }
    
}
