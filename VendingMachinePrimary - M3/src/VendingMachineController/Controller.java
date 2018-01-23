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
            printMenu();
            
            BigDecimal userInsert = userInsertCash();

            if (userInsert == null) {
                keepGoing = false;
                exit();
                break;


            } else {
                        /*
                        Program reads from right to left.
                        It calls userSelectionID() first and assigns that to the
                        userSelection variable.
                        */
                        String userSelection = userSelectionID();
                        
            Products getProductSelection = productSelection(userSelection);

            String changeCalculated = myChange.calculateChange(userInsert, getProductSelection);
            
            displayCalculatedChange("Your change is "+ changeCalculated);
            
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

    private void exit() {
        myView.exitMessage();
    }

    //This method prints the menu and returns the products from the service layer as well
    private void printMenu() throws PersistenceException {
        myView.printMenuAndGetSelection(myService.getAllProducts());
    }
    
    private void displayCalculatedChange(String message) throws PersistenceException{
        myView.displayCalculatedChange(message);
    }

}