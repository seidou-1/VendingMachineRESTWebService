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
//    boolean sufficientFunds = true;
    private int tenDollars = 0,
            fiveDollars = 0,
            oneDollar = 0,
            quarters = 0,
            dimes = 0,
            nickels = 0,
            pennies = 0;
    
    private BigDecimal usersBalance = new BigDecimal ("0.00");

    public BigDecimal getUsersBalance() {
        return usersBalance;
    }

    public void setUsersBalance(BigDecimal usersBalance) {
        this.usersBalance = usersBalance;
    }

    public int getTenDollars() {
        return tenDollars;
    }

    public int getFiveDollars() {
        return fiveDollars;
    }

    public int getOneDollar() {
        return oneDollar;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
    
    

    public BigDecimal calculateChange(BigDecimal usersMoney, Products selectedProduct) {
        /*
        This takes in two variables:
        1. the money the user puts in
        2. the product they selected
         */
 
        
        /*
        This takes what the user inputted and looks up the product cost of it and 
        assigns it to a BigDecimal
        */
        BigDecimal getCostOfItem = selectedProduct.getProductCost();

        //This takes the usersMoney argument and assigns it to a BigDecimal variable
        BigDecimal usersCash = usersMoney;

        //This takes the cash the user inserted and subtracts it from the product cost
        BigDecimal calculation = usersCash.subtract(getCostOfItem);

        //Created anoter BigDecimal and assigned it to calcualtion

        BigDecimal remainingAmount = calculation;
        
        /*
            Filling up as much of each of the denominations as possible.
            i.e. how many times can i fill $10, $5, $1, etc..
         */
        while (remainingAmount.compareTo(Money.TENDOLLARS.getMula()) >= 0) {
            tenDollars++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("10.00"));
        }
        while (remainingAmount.compareTo(Money.FIVEDOLLARS.getMula()) >= 0) {
            fiveDollars++;
            remainingAmount = remainingAmount.subtract(Money.FIVEDOLLARS.Mula);
        }

        while (remainingAmount.compareTo(Money.DOLLARS.getMula()) >= 0) {
            oneDollar++;
            remainingAmount = remainingAmount.subtract(Money.DOLLARS.Mula);
        }

        while (remainingAmount.compareTo(Money.QUARTERS.getMula()) >= 0) {
            quarters++;
            remainingAmount = remainingAmount.subtract(Money.QUARTERS.Mula);
        }

        while (remainingAmount.compareTo(Money.DIMES.getMula()) >= 0) {
            dimes++;
            remainingAmount = remainingAmount.subtract(Money.DIMES.Mula);
        }
        while (remainingAmount.compareTo(Money.NICKELS.getMula()) >= 0) {
            nickels++;
            remainingAmount = remainingAmount.subtract(Money.NICKELS.Mula);
        }
        
        pennies = (int) remainingAmount.multiply(new BigDecimal("100")).doubleValue();        
  
//        pennies = (int) (remainingAmount.doubleValue() *(100));        

        return calculation; 

    }
    
//    BigDecimal moneyCalculation(BigDecimal dough, Money enums){
//        
//        
//    while (dough.compareTo(enums.Mula) >= 0) {
//            fiveDollars++;
//            dough = dough.subtract(enums.Mula);
//        }
//    
//    }
}

