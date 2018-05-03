/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise8_Methods;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author laptop
 */
public class _4BarelyControlledChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        
      
        
        String animal = chosenAnimal();
        String color = chosenColor();
        String colorAgain = chosenColor();
        int weight = chosenNumber();
        int distance = chosenNumber();
        int number = chosenNumber();
        int time = chosenNumber();
        
        System.out.println("Once, when I was very small...");
        
        System.out.println("I was chased by a " + color + ", " + weight + " lb " + " miniatrue " + animal + " for ever " + distance + " miles!! "  );
        
        System.out.println("I had to hide in a field of over " + number + " " + colorAgain + " poppies for nearly " + time + " hours until it left me alone! ");
        
        System.out.println("\nIt was QUITE the experience, " + "let me tell you!");
        
        
    }   
        //Methods here:
            public static int chosenNumber() {
            final int MIN_NUMBER = 1;
            final int MAX_NUMBER = 10;
            int randoBaby = new Random().nextInt((MAX_NUMBER - MIN_NUMBER) +1) + MIN_NUMBER;
            return randoBaby;
            }
            
            public static String chosenColor(){
            
//
//            Random randomGenerator = new Random();
//            Color color = new Color(randomGenerator.nextInt(0xFFFFFF));
//            System.out.println(color);
//            
//            String colors[] = {"Red", "Blue", "Green"};
//            int randoBabyColor = new Random().nextInt(colors.length);
//            int red = randomGenerator.nextInt(256);
//            int green = randomGenerator.nextInt(256);
//            int blue = randomGenerator.nextInt(256);

               Random randocolor = new Random();
               String colors[] = {"Red", "Orange", "Blue","Green"};
               String color = "";            
               
               int convertToRandomNumber = randocolor.nextInt(colors.length);
               
               color = colors[convertToRandomNumber];
               return color;
            }
            
            
            public static String chosenAnimal(){
                Random randomizer = new Random();
                String animals[] = {"Cat","Dog","Penguin"};
                String animal = "";
               
                int convertToRandomNumber = randomizer.nextInt(animals.length);
                
                animal = animals[convertToRandomNumber];
                return animal;
            }
            
            
        
}
    
    

//            new Color((int)(Math.random() * 0x1000000));
//            Color randomColour = new Color(red,green,blue);        
//            numbers[i] = Integer.parseInt(numberStrs[i]);
//            int[] colorLength = new int[colors.length];
//            int[] arr = chosenColor(colors);
//            System.out.println(colors[new Random().nextInt(colors.length)]);
//            Random randomizer = new Random();
//                int animalAsInt = animals.parseInt(animal);