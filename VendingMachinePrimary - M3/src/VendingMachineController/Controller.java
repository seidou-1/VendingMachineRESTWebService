/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineController;

import UI.View;
import VendingMachineDao.PersistenceException;
import VendingMachineDto.Change;
import VendingMachineDto.Products;
import VendingMachineServiceLayer.InsufficientFundsException;
import VendingMachineServiceLayer.InventoryAvailabilityException;
import VendingMachineServiceLayer.Service;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laptop
 */
public class Controller {

    boolean keepGoing = true;

    private Service myService;
    private View myView;
    private Change myChange;

    public Controller(Service myService, View myView, Change myChange) {
        this.myService = myService;
        this.myView = myView;
        this.myChange = myChange;
    }

    public void run() throws
            PersistenceException,
            InventoryAvailabilityException,
            InsufficientFundsException {

        /*
        1. First display the menu and display the products to the user
        
        2. Prompt the user insert money
            Create a BigDecimal data type called userInsert. Assign that to
            userInsertCash() which has logic that prompts the user to input 
            cash through a big decimal prompt.
        
            That userInsertCash() has logic that checks if the user inputted 
            a string equivalent of a number

            If so:
            It will accept the users input money as a BigDecimal equivalent to string 

            If not:
            It will reprompt the user to try again

            If the user's BigString input is "exit" the BigString value becomes null and 
            the program exits right away
        
        3. Get the user's item selection
        4. Check if the item is in stock
        5. Check if the user inserted enough money
        6. Buy the item
            
            

         */
        while (keepGoing) {

            printMenu();//First display the menu

            BigDecimal userInsert = userInsertCash(); //Gets the user's money

            if (userInsert == null) { //As long as the user didn't type "exit"
                keepGoing = false;
                exit();
                break;

                /*
If the user did not type exit, that means they passed the BigString requirements

And now...

1.Create a new Products variable and the value of that is what the user inputted
for their product selection "Products getProductSelection"
                
2.Calculate Change is a method from the Change class. It takes in the money
the user inserted as well as the cost of the item
                
In order to get what the user inserted, i pass the above product Selection variable to it
and as far as the money they inputted, that would be the Big Decimal userInsert variable
"BigDecimal userInsert = userInsertCash();"
                 */
            } else {
                Products getProductSelection = productSelection(userSelectionID()); //gets the user's item selection

                if (checkIfMoneyIsEnough(userInsert, getProductSelection)) {
                    
                    if (inventoryAvailability(userInsert, getProductSelection)) {
                        
                        reduceInventory(getProductSelection); //Reduce the product inventory
                        
                        String changeCalculated = myChange.calculateChange(userInsert, getProductSelection); //

                        displayCalculatedChange(/*"Your change is " +*/changeCalculated);
                    }

                }

//            {
                //obtains the user's productID selection and assigns it as a BigData data type
                /*
                 calculateChange takes a Product data type. So i took that the user slection
                 was and inserted it into a Products getProductSelection variable
                 and then pass that variable into the calculateChange class
                 */
//                reduceInventory(userSelection);
            }

        }

//        if (parseInt(menuSelection) == myList.size()+ 1) {
//            
//            myView.exitMessage();
//        } else {
//            
//            //method to allow user to purchase items based on (menuSelection) return
//        }
//
    }

    /*
    These two methods below match the view methods
     */
    private BigDecimal userInsertCash() {
        return myView.userInsertCash();
    }

    private String userSelectionID() {
        return myView.userSelectionID();
    }

    private Products productSelection(String userSelectionID) throws PersistenceException {

        return myService.getProduct(userSelectionID);

    }

    private void exit() {
        myView.exitMessage();
    }

    private void printMenu() throws PersistenceException {
        myView.printMenuOnly(myService.getAllProducts());
    }

    private void displayCalculatedChange(String message) throws PersistenceException {
        myView.displayCalculatedChange(message);
    }

    public boolean checkIfMoneyIsEnough(BigDecimal userMoney, Products selectedProduct) throws InsufficientFundsException {
        try {

            if (selectedProduct.getProductCost().compareTo(userMoney) > 0) {
                //If evaluates to true and throws the exception
                throw new InsufficientFundsException("Error: You don't have enough dough bro\"\n");

            } else {
                return true;
            }

        } catch (InsufficientFundsException e) {
            /*
            This is telling the catch to grab an exception of type InsufficientFundsException
            this instantiates the class using the letter e
             */
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean inventoryAvailability(BigDecimal usersMoney, Products selectedProduct) throws InventoryAvailabilityException {

        return myService.inventoryAvailability(usersMoney, selectedProduct);
    }

    public int reduceInventory(Products selectedProduct) {
        //Should i load inventory first? Include a similar dao method?
        return myService.reduceInventory(selectedProduct);

    }

//      private void inventoryReducer (String userSelectionID) throws PersistenceException { 
//    //Should this be an int return instead?
//    /*
//    The purpose of this class is to reduce the inventory count of the item
//    the user selected
//    */
//
//                    
//        //Got the users SelectionID and stored it into a Products object
//        //                      ServiceLayer, Method,  Paramater
//        Products usersProduct = myService.getProduct(userSelectionID);
//        
//        /*
//        If the inventory of the product is <=0, subtract 1
//        */
//        if (usersProduct.getProductInventory()<=0) {
//             
//            myView.displayOutOfStock();
//        
//        } else {
//            
//            int inventoryCount = usersProduct.getProductInventory();
//            inventoryCount--;
//            
//            /*
//            At this point it's just floating in memory. So i have to
//            set the inventory value back into the object
//            */
//            usersProduct.setProductInventory(inventoryCount);
//            myService.justWriteInventory();
////            return "Item Remaining Inventory: " + inventoryCount;
//            System.out.println(usersProduct.getProductName() + " Remaining Inventory: " + inventoryCount);
//        }
//        
//        /*
//        Here i am capturing what the user inputted as the selection
//        and getting the product ID that matches the users input
//         */
//        
//    }
}
