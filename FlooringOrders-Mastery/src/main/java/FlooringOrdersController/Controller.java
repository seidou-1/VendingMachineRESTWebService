/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersController;

import FlooringOrdersDAO.PersistenceException;
import FlooringOrdersDTO.Order;
import FlooringOrdersServiceLayer.DataValidationException;
import FlooringOrdersServiceLayer.InvalidDateException;
import FlooringOrdersServiceLayer.OrderDateNotFoundException;
import FlooringOrdersServiceLayer.OrderNumberNotFoundException;
import FlooringOrdersServiceLayer.Service;
import FlooringOrdersUI.View;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laptop
 */
public class Controller {

    private View myView;
    private Service myService;

    //Constructor
    public Controller(View myView, Service myService) {
        this.myView = myView;
        this.myService = myService;
    }

    public void run() {
        boolean keepGoing = true;
//        int menuSelection = 1;

        while (keepGoing) {
            try {

                switch (printMenuAndGetSelection()) {

                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        saveCurrentWork();
                        break;
                    case 6:
                        exitBanner();
                        keepGoing = false;
                        break;

                }
            } catch (DataValidationException
                    | OrderDateNotFoundException
                    | OrderNumberNotFoundException
                    | InvalidDateException
                    | PersistenceException e) {
                myView.displayErrorMessage(e.getMessage());
            }
        }

    }

    //Methods below
    private int printMenuAndGetSelection() {

        return myView.printMenuAndGetSelection();
    }

    private void displayOrders() throws
            OrderDateNotFoundException,
            PersistenceException {
        
        LocalDate usersDate = myView.getUsersDate(); //Gets the date from the user 
//        int usersOrderNumber = myView.getUsersOrderNumber();//Gets the order number from the user

        //I have a method that auto filters based on date - checkIfOrderDateExists()
        //This returns a list: 
        List<Order> validatedOrder = myService.checkIfOrderDateExists(usersDate); //THis auto checks the order method first

        //Now i have to create a view that takes in a List of data type Order
        //Print out the list with each value
        myView.displayAllOrders(validatedOrder);
//        myView.displayAllOrdersAsAlist(validatedOrder);

    }

    private void addOrder() throws
            DataValidationException,
            InvalidDateException,
            PersistenceException {

        Order placement = null;
        try {
            do {
                //Will continue to prompt the user for as long as they enter an invalid field
                placement = myView.setUsersOrder(myService.getOrderNumber());//Prompts the user to input info

                //checkIfStateExists
            } while (!validateOrderData(placement));
        } catch (DataValidationException e) {
            myView.displayMessage(e.getMessage());
        }

        //Get a list and filter it to display the current order
        myView.displayCurrentOrder(placement);
        boolean usersChoice = myView.areYouSure();//Returns boolean true or false
        if (usersChoice) { //if boolean returns true - meaning yes 
            myService.addOrder(placement); //add the order
            myView.displayCreateSuccessBanner();
        } else {
            myView.thankYouBanner();
        }
    }

    private void editOrder() throws
            OrderDateNotFoundException,
            OrderNumberNotFoundException,
            PersistenceException {

        /* 
        //If this doesn't throw an exception, only one order element will be returned in the index slot 0 (as a single order)
        
        //if the user types enter, no changes made
        //if the user enters something, the value of that field is changed
         */
        LocalDate usersDate = myView.getUsersDate(); //Gets the date from the user 
        int usersOrderNumber = myView.getUsersOrderNumber();//Gets the order number from the user

        //Add checkIfOrderDateExists method below:
        //Returns the list or an exception gets thrown:
        Order validatedOrder = myService.checkIfOrderNumberExists(usersDate, usersOrderNumber).get(0); //THis auto checks the order method first

        Order currentOrder = null;

        try {
            do {
                currentOrder = myView.setUsersOrderForEditing(validatedOrder); //maybe?
            } while (!validateOrderData(currentOrder));
        } catch (DataValidationException e) {
            myView.displayMessage(e.getMessage());

        }

        myView.displayCurrentOrder(currentOrder);
        //Call Service method to validate correct big data format is inputted
        //Or have it in the UserIO to validate correct big data format is inputted

        myView.displayEditedSuccessfullyBanner();
    }

    private void removeOrder() throws
            OrderDateNotFoundException,
            OrderNumberNotFoundException,
            PersistenceException {

        LocalDate usersDate = myView.getUsersDate(); //get the date from the user
        int usersOrderNumber = myView.getUsersOrderNumber(); //get the order from the user

        Order validatedOrder = myService.checkIfOrderNumberExists(usersDate, usersOrderNumber).get(0);

        myView.displayCurrentOrder(validatedOrder);

        boolean usersChoice = myView.areYouSure();//Returns boolean true or false

        if (usersChoice) { //if boolean returns true - meaning yes 
            Order removeTheOrder = myService.removeOrder(/*usersDate, */usersOrderNumber);
            myView.displayRemovedSuccessfullyBanner();
        } else {
            myView.thankYouBanner();
        }
    }

    private boolean validateOrderData(Order order) throws DataValidationException {
        return myService.validateOrderData(order);
    }

    private void exitBanner() {
        myView.exitBanner();
    }

    private void saveCurrentWork() throws PersistenceException {
        boolean didItSave = myService.justSaveToFile();

        if (didItSave == true) {
            myView.displayWorkedSavedSuccessfullyBanner();
        }

    }

}
