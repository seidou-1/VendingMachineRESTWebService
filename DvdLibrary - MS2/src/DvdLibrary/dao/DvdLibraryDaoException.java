/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.dao;

/**
 *
 * @author laptop
 */

//Extending the Exception interface
public class DvdLibraryDaoException extends Exception { 
    
    public DvdLibraryDaoException (String message){ //This constructor takes just a string message
        super(message);
        
        /*
        This first constructor is for scenarios where something is wrong in the application 
        but it isn’t caused by another exception. Like the wrong data type was inputted via a scanner.
        */
    }
    
    public DvdLibraryDaoException (String message, Throwable cause){ //This constructor also takes a string message but also a throwable cause
        super(message, cause); //I'm calling super here so the parent constructor initialize the object
        
        /*
        This constructor is for cases where something is wrong with the application 
        that is caused by another exception in the underlying implementation
        */
    }
    
}
