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
public class CreationandAddingElements {
    
    public static void main(String[] args) {
        
        //Code here
        
        //Create an ArrayList of String objects
        ArrayList<String> stringList = new ArrayList<>();
        
        //Ask the list how big it is
        System.out.println("List size before adding any Strings " + stringList.size());
        
        //Add a String object to our list
        stringList.add("My first string ");
        
        //Ask the list how big it is
        System.out.println("List size after adding one String: " + stringList.size());
        
        //Add another String object to our list
        stringList.add("My second String");
        
        //Ask the list how big it is
        System.out.println("List size after adding two Strings: " + stringList.size());
        
    }
    
}
