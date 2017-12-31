package ArrayListExamples;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop
 */
public class VisitingAllElement_EnhancedForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //create an ArrayList of string objects
        ArrayList<String> myArrayList = new ArrayList<>();
        
        //add another string object to the list
        myArrayList.add("My first string ");
        
        //add another string object to the list
        myArrayList.add("My second string");
        
        //add another string object to the list
        myArrayList.add("My third string");
        
        //add another string object to the list
        myArrayList.add("My fourth string ");
        
        //ask the list how big it is
        System.out.println("List size: " + myArrayList.size());
        
        //print every Sting in the list with an enhanced for loop
        
        for (String enhancedForLoop : myArrayList) {
            System.out.println(enhancedForLoop);
            
        }
    }
    
}
