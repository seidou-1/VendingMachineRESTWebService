/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author laptop
 */
public enum Money {
//    HUNDREDDOLLARS (new BigDecimal ("100.00")),
//    FIFTYDOLLARS (new BigDecimal ("50.00")),
//    TWENTYDOLLARS (new BigDecimal ("20.00")), 
//    TENDOLLARS (new BigDecimal ("10.00")),
    FIVEDOLLARS (new BigDecimal ("5.00")),
    ONEDOLLARS (new BigDecimal ("1.00")),
    HALFDOLLARS (new BigDecimal ("0.50")),
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
