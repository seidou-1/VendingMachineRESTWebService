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

        //call the view class userInsertCash() method (for how much money they inserted)
        //call the view class userSelectionID() method (for which product they selected)
        //subtract the cost of the item from the amount of money they inserted
        /*
        I have to create a big decimal version of both the usersMoney 
                            AND
        The selectedProduct
         */
//        BigDecimal usersMoneyConverted = new BigDecimal(usersMoney);
        BigDecimal getCostOfItem = selectedProduct.getProductCost();

        //Getting the big decimal version of what the users money
        BigDecimal usersCash = usersMoney;
//                = new BigDecimal(usersMoney);

//        BigDecimal selectedProductConverted = new BigDecimal(selectedProduct.getProductCost());
        BigDecimal calculation = usersCash.subtract(getCostOfItem);

        //This takes the calculaiton and converts it to a string
//        String convertertsBackToString = calculation.toString(); //Why do i have to convertBackToString
        /*
        Logic here that talks to the controller to check if 
         */
//        } else {
//            System.out.println("Out of stock! " + usersMoney + " has been refunded to you");
//        }
        //Here
//                return "Your change is " + convertertsBackToString;
        BigDecimal remainingAmount = calculation;
//          remainingAmount = remainingAmount % "100";

        /*
            Filling up as much of each of the denominations as possible.
            i.e. how many times can i fill $10, $5, $1, etc..
         */
        while (remainingAmount.compareTo(new BigDecimal("10.00")) >= 0) {
            tenDollars++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("10.00"));
        }
        while (remainingAmount.compareTo(new BigDecimal("5.00")) >= 0) {
            fiveDollars++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("5.00"));
        }

        while (remainingAmount.compareTo(new BigDecimal("1.00")) >= 0) {
            oneDollar++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("1.00"));
        }

        while (remainingAmount.compareTo(new BigDecimal("0.25")) >= 0) {
            quarters++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("0.25"));

        }

        while (remainingAmount.compareTo(new BigDecimal("0.10")) >= 0) {
            dimes++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("0.10"));

        }
        while (remainingAmount.compareTo(new BigDecimal("0.05")) >= 0) {
            nickels++;
            remainingAmount = remainingAmount.subtract(new BigDecimal("0.05"));
        }
        
//        pennies = (int) remainingAmount.multiply(new BigDecimal("100")).doubleValue();        

//        double a = remainingAmount.doubleValue();
        
        pennies = (int) (remainingAmount.doubleValue() *(100));        

//        System.out.println("\n Your change is: ");

        return calculation;
//                
//                while (remainingAmount.compareTo(Money.DIMES.getMula())>0){
//            while (remainingAmount.compareTo(Money.DIMES.getMula())>0){
//              
//          } else if (remainingAmount.compareTo(Money.NICKELS.getMula())>0){
//              
//          } else if (remainingAmount.compareTo(Money.PENNIES.getMula())>0){
//              
//          }
//          
//        
//        double dollarsAmount = remainingAmount /100;
//        remainingAmount = remainingAmount % 100;
//        
//        double quartersAmount = remainingAmount /25;
//        remainingAmount = remainingAmount %25;
//        
//        double dimesAmount = remainingAmount /10;
//        remainingAmount = remainingAmount %10;
//        
//        double nickelsAmount = remainingAmount /5;
//        remainingAmount = remainingAmount %5;
//        
//        double penniesAmount = remainingAmount;
        

        /*
        Quarters nicks dimes calculation
        
        subtract inventory
        
        Add a while loop to check if money is enough and throw an error if not
         */
//        Scanner myScanner = new Scanner(System.in);
//    
//        System.out.println(input);//this is for the user to see what's going on 
//        String userInput = myScanner.nextLine();
//        double numberConverted = Double.parseDouble(userInput); 
//        System.out.println("The value you entered is: " + numberConverted);
//        
//        remainingAmount = remainingAmount %1;
//        return remainingAmount
//
//        System.out.println("Total change = " + "$ " + dollarsAmount + "\n Quarters:" + quartersAmount + "\n Dimes: " + dimesAmount + "\n Nickels:" + nickelsAmount + "\n Pennies: " + penniesAmount);
//        
//        
    }
}
//    
//    public String checkIfMoneyIsEnough (BigDecimal userMoney, Products selectedProduct){
//
//}

//int inventoryRemaining = selectedProduct.getProductInventory();
//            inventoryRemaining--;
//
//            //Replace with a try catch here:
//                    if (inventoryRemaining <= 0) {
//                        sufficientFunds = false;
//                        System.out.println("Out of stock");
//                    }
