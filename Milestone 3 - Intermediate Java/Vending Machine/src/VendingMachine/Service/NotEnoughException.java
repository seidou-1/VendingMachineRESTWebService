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

//exception to be thrown when not enough money is deposited for an item
public class NotEnoughException extends Exception{
    
    private String message;
    private double balance;
    
    public NotEnoughException (String message, double balance){
        this.message = message;
        this.balance = balance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getMessage(){
        return message + balance;
    }
    
    
    
}
