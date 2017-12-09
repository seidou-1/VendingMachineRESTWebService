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
public class _6FruitSalad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                        int Banana = 0;
                        int Raspberry = 0;
                        int Strawberry = 0;
                        
        
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", 
                        "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", 
                        "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", 
                        "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", 
                        "Satsuma Orange", "Watermelon", "Snozzberry"};
                        
                        for (int i = 0; i < fruit.length; i++) {
                        
                            if (fruit[i] == "Banana") {
                                Banana++;
                                Banana = i;
//                                System.out.println("Index# " + i + "\t" + fruit[i]);
                                System.out.println("Number Of Banana's:\t" + Banana);
                                
                            }
                            
                            if (fruit[i] == "Raspberry") {
                                Raspberry++;
                                Raspberry = i;
                                System.out.println("Number Of Raspberry's:\t" + Raspberry);
                            }
                            
                            if (fruit[i] == "Strawberry") {
                                Strawberry++;
                                Strawberry = i;
                                System.out.println("Number Of Strawberry's:\t" + Strawberry);
                            }
                            
                            
                            
                            }
                         
                        
                        int sum = Banana + Raspberry + Strawberry;
                        System.out.println("Total number of fruits: " + sum);
        
//                            Arrays.sort(fruit);
//                            for (String str : fruit) {
//                            System.out.println(str);
//                            }
                            
//                        String[] fruitSalad;
                        
                        
    
    
}
}
