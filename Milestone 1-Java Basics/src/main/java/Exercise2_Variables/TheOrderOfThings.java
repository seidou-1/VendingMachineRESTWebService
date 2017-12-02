/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercize2_Variables;

/**
 *
 * @author laptop
 */
public class TheOrderOfThings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "platinum";
        purpose = "good";

        noun = "dragons";

        // Using the + with strings, doesn't add it concatenates! (sticks them together)
//        System.out.println(number + opinion + size + age + shape + color
//                + origin + material + purpose + noun); 
        
        System.out.println(number + " " + age + " "  + opinion + " " +  noun + " " + size + " " + shape + " " + color + " " + purpose + " " + material + " " + origin); 
        //This one sounds better
    }
    
}
