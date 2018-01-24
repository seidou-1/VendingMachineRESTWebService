/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laptop
 */
public class View {

    //The purpose of this class is to talk to the IO to capture the users' input
    private UserIO myIO;

    public View(UserIO myIO) {
        this.myIO = myIO;
    }

    public void printMenuAndGetSelection(List<Products> values) {

        myIO.print("***Vending Machine Menu***");

        for (Products myProducts : values) {
            myIO.print(myProducts.getProductId() + " "
                    + myProducts.getProductName() + " $"
                    + myProducts.getProductCost());

        }
        myIO.print(values.size() + 1 + " Exit ");

//        return myIO.readString("Select one of the options");
    }

    public void exitMessage() {
        myIO.print("Thank You. Goodbye!!");
    }

    public BigDecimal userInsertCash()  {
        //Throws exception if a non number is inputted

        BigDecimal userInput = null;
        boolean validInput = true;
        //
        do {
            String input = myIO.readString("Please insert money or select Exit");

            try { //This will catch a number format exception

                userInput = new BigDecimal(input);
                validInput = false;//This skips over the catch clause if a proper value is inputted

            } catch (NumberFormatException e) {

                if (input.equalsIgnoreCase("exit")) {
                    validInput = false;
                    break;
                } else {
                    System.out.println("Invalid input. Try again. \n");
                    /*
                    If the user does not enter a string equivalent of a number and
                    they did not enter "exit", they will be prompted with an invalid
                    input message
                    */
                }

            }
        } while (validInput);

        //Check if the user inputted correct $ amount, create a big decimal
        //if the user enters exit, leave
        //if invalid input thorw an exceptino and try again
        return userInput;//Returns the big decimal of what they typed in
        
        /*
        If the user entered exit, then the return value of big decimal is null
        because it never enters the try catch
        */

    }

    public String userSelectionID() {
        return myIO.readString("Select an item i.e. A1");
    }
    
    public void displayCalculatedChange(String message){
        myIO.print(message);
        
    }
    
    public void displayOutOfStock(){
         myIO.print("¯\\_(ツ)_/¯\n");
    }
}
