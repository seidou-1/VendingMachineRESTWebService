/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapExample;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author laptop
 */
public class ListingAllTheKeys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap<String, Integer> populations = new HashMap<>();
       
    // add the first country
    populations.put("USA", 313000000);
       
    // add the next country
    populations.put("Canada", 34000000);
       
    // add another country
    populations.put("United Kingdom", 63000000);
       
    // add another country
    populations.put("Japan", 127000000);
       
    // ask the map for its size - it will be 4
    System.out.println("Map size is: " + populations.size());
       
    // get the Set of keys from the map
    Set<String> keys = populations.keySet();
       
    // print the keys to the screen - is the order they are printed
    // what you would expect?
    for (String k : keys) {
        System.out.println(k);
    }
    }
    
}
