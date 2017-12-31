/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;

/**
 *
 * @author laptop
 */
public class DoesItWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Person myPerson = new Person();
        double returnedValue;
        
        returnedValue = myPerson.readDouble("Pick number between", 1, 10);
        
        System.out.println("The number you entered is: " + returnedValue);
        
    }
    
}
