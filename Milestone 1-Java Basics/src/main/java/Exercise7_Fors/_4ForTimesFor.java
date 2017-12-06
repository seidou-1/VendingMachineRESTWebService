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
public class _4ForTimesFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int correctAnswerIncrement = 0;
        Scanner myScanner = new Scanner (System.in);
        
        System.out.println("What times table do you want me to do? ");
        int theirTimesTableInput = myScanner.nextInt();
        
        for (int i = 0; i <= 12; i++) {
            System.out.println("What is " + theirTimesTableInput + " * " + i + " ?");
            int theirAnswerInput = myScanner.nextInt();//needed to create another input Scanner because the first one kept getting used in the loop
            int correctAnswer = (theirTimesTableInput * i);//Had to place this as a local varibale because it wouldn't know what "i" is
            
            if (theirAnswerInput == correctAnswer) {
                System.out.println("");
                System.out.println("** That is correct! ** ");
                System.out.println("");
                correctAnswerIncrement++;
                
            } else {
                System.out.println("");
                System.out.println("Nope. The correct answer is: " + correctAnswer);
                System.out.println("");
            }
            
        }
        
            System.out.println("You got " + correctAnswerIncrement + " correct");
                if (correctAnswerIncrement < 6) {
                    System.out.println("You should study more bro! ");
            
        } else if (correctAnswerIncrement >= 10) {
                    System.out.println("Congratulations on getting over 90% right! ");
            
        }
        
    }
    
}
