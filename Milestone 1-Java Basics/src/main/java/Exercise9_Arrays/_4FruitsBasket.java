/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise9_Arrays;

//import java.util.Random;

/**
 *
 * @author laptop
 */
public class _4FruitsBasket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int appleCounter = 0;
        int orangeCounter = 0;
        
        int appleIndex;
        int orangeIndex;
//        int sum = appleCounter + orangeCounter;

        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange",
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple",
            "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange",
            "Apple", "Orange", "Orange"};

        for (int i = 0; i < fruit.length; i++) {


            if (fruit[i] == "Apple") {
                appleCounter++;
                appleIndex = i;
                System.out.println("Index# " + i + "\t" + fruit[i]);
                
            } 
            
            if (fruit[i] == "Orange") {
                orangeCounter++;
                orangeIndex = i;
                System.out.println("Index# " + i + "\t" + fruit[i]);
//            }
            
            

        }
        
    }   System.out.println("");
        System.out.println("Number Of Apples: " + appleCounter);//This is printing out the number of times apple appears
        System.out.println("Number Of Oranges: " + orangeCounter);
        System.out.println("");
        System.out.println("Number Of Fruits: " + (appleCounter + orangeCounter));
        
        

//    public static void applesOut(){
//        System.out.println("" + orangeIndex);
//    }
//    
//    int appleArray = {appleCounter};
//                
//    int orangeArray = {}
                
                
} 
    
    
}
//create a variable that increments each time an orange is there. Same for apple
//                            int index; // created this variable as a placeholder to store the value of i
//                                index = i; 
//                                
//                            int apple;
