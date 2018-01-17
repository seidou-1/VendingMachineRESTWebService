/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dto;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class ChangeDto {
    
    //Method to return change amount
    
    //User inputs dollar amount and it returns change
    
    private double quarters;
    private double dimes;
    private double nickels;
    private double pennies;
    private double dispensedAmount;

    public double getQuarters() {
        return quarters;
    }

    public void setQuarters(double quarters) {
        this.quarters = quarters;
    }

    public double getDimes() {
        return dimes;
    }

    public void setDimes(double dimes) {
        this.dimes = dimes;
    }

    public double getNickels() {
        return nickels;
    }

    public void setNickels(double nickels) {
        this.nickels = nickels;
    }

    public double getPennies() {
        return pennies;
    }

    public void setPennies(double pennies) {
        this.pennies = pennies;
    }

    public double getDispensedAmount() {
        return dispensedAmount;
    }

    public void setDispensedAmount(double dispensedAmount) {
        this.dispensedAmount = dispensedAmount;
    }
    
    
    public void changeCalculated (String input){
    Scanner myScanner = new Scanner(System.in);
    
        System.out.println(input);//this is for the user to see what's going on 
        String userInput = myScanner.nextLine();
        double numberConverted = Double.parseDouble(userInput); 
        System.out.println("The value you entered is: " + numberConverted);
        
        double remainingAmount = numberConverted / 100;
        
        double dollarsAmount = remainingAmount /100;
        remainingAmount = remainingAmount % 100;
        
        double quartersAmount = remainingAmount /25
        
//        return numberConverted;
    
    
}
    
    
    
//    public void deliverChange (double cost, double moneyInserted){
//        
//        this.quarters = ((moneyInserted - cost)/.25);
//        this.dimes = ((moneyInserted - cost)/.10);
//        this.nickels = ((moneyInserted - cost)/.5);
//        this.pennies = ((moneyInserted - cost)/.1); 
//        
//        if (cost < moneyInserted){
//            
//            dispensedAmount = moneyInserted - cost;
//            
//            System.out.println("Your change is: " + dispensedAmount);
//            
//        }
//    }
    
}
