/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDto;

import java.math.BigDecimal;

/**
 *
 * @author laptop
 */
public enum Money {
    

    TENDOLLARS (new BigDecimal ("10.00")),
    FIVEDOLLARS (new BigDecimal ("5.00")),
    DOLLARS (new BigDecimal ("1.00")),
    QUARTERS (new BigDecimal ("0.25")),
    DIMES (new BigDecimal ("0.10")),
    NICKELS (new BigDecimal ("0.05")),
    PENNIES (new BigDecimal ("0.01"));
    
    BigDecimal Mula;
    
    //Constructor
    Money(BigDecimal Mula){
        this.Mula=Mula;
    }
    
    //Getter
    public BigDecimal getMula(){
        return Mula;
    }
}
