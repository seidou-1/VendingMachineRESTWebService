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
public class Change {
    
    /*
    The purpose of this class is to calculate the change of the amount of money
    the user inputted and subtract that from the cost of the item
    
    And then break the change down into different coin amounts
    */
    
    public String calculateChange (BigDecimal usersMoney, Products selectedProduct){
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
        String getCostOfItem = selectedProduct.getProductCost();
        
        //Getting the big decimal version of what the users money
        BigDecimal usersCash = usersMoney;
//                = new BigDecimal(usersMoney);
        
        BigDecimal selectedProductConverted = new BigDecimal (selectedProduct.getProductCost());
        
        BigDecimal calculation = usersCash.subtract(selectedProductConverted);
        
        //This takes the calculaiton and converts it to a string
        String convertertsBackToString = calculation.toString();
        
        
        /*
        Quarters nicks dimes calculation
        
        subtract inventory
        
        Add a while loop to check if money is enough and throw an error if not
        */
        
        return convertertsBackToString;
        
    }
    
}
