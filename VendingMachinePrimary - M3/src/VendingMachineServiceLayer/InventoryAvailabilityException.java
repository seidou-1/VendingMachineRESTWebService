/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineServiceLayer;

/**
 *
 * @author laptop
 */
public class InventoryAvailabilityException extends Exception{
    
     public InventoryAvailabilityException (String message){
        
        super (message);
    }
    
    public InventoryAvailabilityException (String message, Throwable cause) {
        
        super (message, cause);
                
    }
    
}
