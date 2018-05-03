/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.service;

/**
 *
 * @author laptop
 */
public class DvdLibraryDuplicateNameException extends Exception {
    
    public DvdLibraryDuplicateNameException (String message){
        super (message);
    }
    
    public DvdLibraryDuplicateNameException (String message, Throwable cause){
        
    }
    
}
