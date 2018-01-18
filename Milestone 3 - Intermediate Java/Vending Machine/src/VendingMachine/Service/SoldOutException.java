/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

/**
 *
 * @author laptop
 */
public class SoldOutException extends Exception{
    
    private String message;

    public SoldOutException(String message) {
//        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
