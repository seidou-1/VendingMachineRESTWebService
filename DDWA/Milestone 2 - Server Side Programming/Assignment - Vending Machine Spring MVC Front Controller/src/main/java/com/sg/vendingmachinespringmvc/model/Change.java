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
public class Change {
    
    /*
    The purpose of this class is to calculate the change of the amount of money
    the user inputted and subtract that from the cost of the item
    
    And then break the change down into different coin amounts
     */

    
    private BigDecimal usersBalance = new BigDecimal("0.00");
    private BigDecimal usersBalanceAfterBreakdown;
    String tempString = "";

    public BigDecimal getUsersBalance() {
        return usersBalance;
    }

    public void setUsersBalance(BigDecimal usersBalance) {
        this.usersBalance = usersBalance;
    }


    public String calculateChange(BigDecimal usersMoney, Products selectedProduct) {
        
        
        
        BigDecimal getCostOfItem = selectedProduct.getProductCost();

        BigDecimal usersCash = usersMoney;

        usersBalanceAfterBreakdown = usersCash.subtract(getCostOfItem);

        for (Money enums : Money.values()) {
            /*
            This will output a string each time and display the denominations
            as well as the quantity of each denomination
             */
            tempString += loopThroughMoney(enums);
        } 
        
        return /*"Total change is: $" + usersBalance + "\n" +*/ "Denomination Breakdown: \n" + tempString; //This wil display the quanity of each enum

//        usersBalanceAfterBreakdown
        
        
    }

    public String loopThroughMoney(Money enums) {

        int tempQuantity = 0; //This variable will be used to return the value at the end
        while (usersBalanceAfterBreakdown.compareTo(enums.Mula) >= 0) {
            /*
            Dynamically take in the reamining balance
            as well as the enums
             */
            tempQuantity++;
            usersBalanceAfterBreakdown = usersBalanceAfterBreakdown.subtract(enums.Mula);
        }
        return enums + " : " + tempQuantity + "\n";

    }
    
    @Override
        public String toString(){
            return this.tempString;
            
        }
    
}
