/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDto;

import java.math.BigDecimal;
import java.util.Scanner;

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

    public BigDecimal getUsersBalance() {
        return usersBalance;
    }

    public void setUsersBalance(BigDecimal usersBalance) {
        this.usersBalance = usersBalance;
    }


    public String calculateChange(BigDecimal usersMoney, Products selectedProduct) {
        
        String tempString = "";
        
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
        
        return "Total change is: $" + usersBalance + "" + "Denomination Breakdown: \n" + tempString; //This wil display the quanity of each enum

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

//    

////        while (remainingAmount.compareTo(Money.TENDOLLARS.getMula()) >= 0) {
////            tenDollars++;
////            remainingAmount = remainingAmount.subtract(new BigDecimal("10.00"));
////        }
////        while (remainingAmount.compareTo(Money.FIVEDOLLARS.getMula()) >= 0) {
////            fiveDollars++;
////            remainingAmount = remainingAmount.subtract(Money.FIVEDOLLARS.Mula);
////        }
////
////        while (remainingAmount.compareTo(Money.DOLLARS.getMula()) >= 0) {
////            oneDollar++;
////            remainingAmount = remainingAmount.subtract(Money.DOLLARS.Mula);
////        }
////
////        while (remainingAmount.compareTo(Money.QUARTERS.getMula()) >= 0) {
////            quarters++;
////            remainingAmount = remainingAmount.subtract(Money.QUARTERS.Mula);
////        }
////
////        while (remainingAmount.compareTo(Money.DIMES.getMula()) >= 0) {
////            dimes++;
////            remainingAmount = remainingAmount.subtract(Money.DIMES.Mula);
////        }
////        while (remainingAmount.compareTo(Money.NICKELS.getMula()) >= 0) {
////            nickels++;
////            remainingAmount = remainingAmount.subtract(Money.NICKELS.Mula);
////        }
////        
////        pennies = (int) remainingAmount.multiply(new BigDecimal("100")).doubleValue();        
////  
////        pennies = (int) (remainingAmount.doubleValue() *(100));        
//        return calculation;
//
//    }
    }
}
//    

