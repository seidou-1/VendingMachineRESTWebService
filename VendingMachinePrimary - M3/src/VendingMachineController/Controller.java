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
import VendingMachineServiceLayer.Service;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laptop
 */
public class Controller {

    private Service myService;
    private View myView;
    private Change myChange;

    public Controller(Service myService, View myView, Change myChange) {
        this.myService = myService;
        this.myView = myView;
        this.myChange = myChange;
    }

    public void run() throws PersistenceException {

//        Products getTheUsersProduct = productSelection();
        boolean keepGoing = true;

        /*
        First we need to get all the inventory list items via the service. Returning it as a list
        and display it to the user
         */
//        List<Products> myList = myService.getAllProducts();

        /*
        Then i'm presenting that list to the user via the view 
        and waiting for the user's input

         */
//        String menuSelection = myView.printMenuAndGetSelection(myList);
        while (keepGoing) {

//            myView.printMenuAndGetSelection(myList);
//
//            switch (userInsert) {
//                case :
//                    "Exit";
//                    break;
//            }
            printMenu();//First display the menu

            BigDecimal userInsert = userInsertCash();
//Prompting the user to input cash through a big decimal prompt
/*
Big Decimal checks if the user inputted a string equivalent of a number

If so:
It will accept the users input as a string

If not:
It will reprompt the user to try again

If the user's BigString input is "exit" the BigString value becomes null and 
the program exits
             */

            if (userInsert == null) {
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
                /*
                        Program reads from right to left.
                        It calls userSelectionID() first and assigns that to the
                        userSelection variable.
                 */
                String userSelection = userSelectionID();
                
                Products getProductSelection = productSelection(userSelection);

                //calculateChange takes a Product data type. So i took that the user slection
                //was and inserted it into a Products getProductSelection variable
                //and then pass that variable into the calculateChange class
                String changeCalculated = myChange.calculateChange(userInsert, getProductSelection);
                
                displayCalculatedChange("Your change is " + changeCalculated);
                
                inventoryReducer(userSelection);
                

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

    //This method returns the product based on the user's ID input
    private Products productSelection(String userSelectionID) throws PersistenceException {
        
     return myService.getProduct(userSelectionID);
        
        }
        
        /*
        Here i am capturing what the user inputted as the selection
        and getting the product ID that matches the users input
         */
    
    /*
    This method reduces the inventory of the item the users selected
    */
    private void inventoryReducer (String userSelectionID) throws PersistenceException {
        
        //Got the users SelectionID and stored it into a Products object
        //                      ServiceLayer, Method,  Paramater
        Products usersProduct = myService.getProduct(userSelectionID);
        
        /*
        If the inventory of the product is <=0, subtract 1
        */
        if (usersProduct.getProductInventory()<=0) {
            
            
            
//        return myService.(userSelectionID)-1;
        
        
        } else {
            
            int inventoryCount = usersProduct.getProductInventory();
            inventoryCount--;
            
            /*
            At this point it's just floating in memory. So i have to
            set the inventory value back into the object
            */
            usersProduct.setProductInventory(inventoryCount);
            myService.justWriteInventory();
            System.out.println("Item Remaining Inventory: " + inventoryCount);

        }
        
        /*
        Here i am capturing what the user inputted as the selection
        and getting the product ID that matches the users input
         */
        
    }
    
//    private Products inventoryTracker (String usersItemSelection) throws PersistenceException {
//        return myService.getProduct(usersItemSelection);
//        }

    private void exit() {
        myView.exitMessage();
    }

    //This method prints the menu and returns the products from the service layer as well
    private void printMenu() throws PersistenceException {
        myView.printMenuAndGetSelection(myService.getAllProducts());
    }

    private void displayCalculatedChange(String message) throws PersistenceException {
        myView.displayCalculatedChange(message);
    }

}
