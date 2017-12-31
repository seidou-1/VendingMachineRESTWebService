/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListExamples;

import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class RemovingElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //create an ArrayList of string objects
        ArrayList<String> myStringList = new ArrayList<>();
        
        //add a string object to our list
        myStringList.add("My first string");
        
        //add another string object to our list
        myStringList.add("My second string");
        
        //ask the list how big it is
        System.out.println("List size after adding two strings: " + myStringList.size());
        
        //remove the second string object frmo our list. Remember that the index starts at 0 instead of 1
        myStringList.remove(0);
        
        //ask the list how big it is
        System.out.println("List size after removing last string: " + myStringList.size());
        
        //As a test, i'm going to remove another element and see what happens:
        
        myStringList.remove(0); // Gives this the same result... 1 remaining. Hmmm.
    }
    
}
