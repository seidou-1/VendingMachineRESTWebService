/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import VendingMachineDto.Products;
import VendingMachineServiceLayer.DataValidationException;
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

    public void printMenuOnly(List<Products> values) {

        myIO.print("***Vending Machine Menu***");

        for (Products myProducts : values) {
            myIO.print(myProducts.getProductId() + " "
                    + myProducts.getProductName() + " $"
                    + myProducts.getProductCost() + " --> Inventory: "
                    + myProducts.getProductInventory()
            );
        }
        myIO.print(values.size() + 1 + " Exit \n");

        //Display user's current balance
    }

    public void displayUsersBalance(BigDecimal usersBalance) {
        myIO.print("Current balance: " + usersBalance + "\n");

    }

    public void exitMessage() {
        myIO.print("Thank You. Goodbye!!");
    }

    public BigDecimal userInsertCash() {
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
//                } else if (userInput.intValue()<1) {
//                    validInput = false;
//                    System.out.println("Invalid amount. Try again.\n");

                }
                
                else {
                    validInput = true;
                    System.out.println("Invalid input. Try again.\n");
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

    public String userSelectionIDAllCaps() {
        String upperCase = myIO.readString("Select an item i.e. A1");
        return upperCase.toUpperCase();
    }

    public String userSelectionIDAllCapsFaultTolerant() throws DataValidationException {
        boolean validInput = false;
        String userInput = "";
        do {

            try {
                userInput = myIO.readString("Select an item i.e. A1");

                if (userInput.equalsIgnoreCase("a1") 
                    || userInput.equalsIgnoreCase("a2") 
                    || userInput.equalsIgnoreCase("a3")){
                 
                    validInput = true;
                    
                    return userInput.toUpperCase();
                    
                }else {
                    validInput = false;
                    throw new DataValidationException("Select one of the options above, try again. \n");
                        }
            } catch (DataValidationException e) {
                System.out.println(e.getMessage());
            }

        } while (!validInput);

        return userInput;
    }

    public void displayCalculatedChange(String message) {
        myIO.print(message);

    }

    public void displayOutOfStock() {
        myIO.print("¯\\_(ツ)_/¯\n");
    }
}
