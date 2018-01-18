/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dto;

/**
 *
 * @author laptop
 */
public enum MoneyEnums {
    
    PENNY("1"), NICKEL("5"), DIME("10"), QUARTER ("25"), DOLLAR ("100");
    //Placed them all as strings because big decimal is more precise with strings
    
    private String denomination;
    
    private MoneyEnums (String denomination){//constructor so i can reference the class level variable
        this.denomination = denomination;
    }
    
    public String getDenomination(){
        return denomination;
    }
    
}
