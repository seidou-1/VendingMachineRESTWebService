/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersController;

import FlooringOrdersDTO.Order;
import FlooringOrdersServiceLayer.DataValidationException;
import FlooringOrdersServiceLayer.InvalidDateException;
import FlooringOrdersServiceLayer.OrderNotFoundException;
import FlooringOrdersServiceLayer.Service;
import FlooringOrdersUI.View;
import java.time.LocalDate;
import java.util.List;

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

        try {

            while (keepGoing) {
                switch (printMenuAndGetSelection()) {

                    case 1:
                    //display orders
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                    //remove an order
                    case 5:
                    //save an order
                    case 6:
                        exitBanner();
                        keepGoing = false;
                        break;

                }
            }

        } catch (DataValidationException | OrderNotFoundException | InvalidDateException e) {
            myView.displayErrorMessage(e.getMessage());
        }
    }

    //Methods below
    private int printMenuAndGetSelection() {

        return myView.printMenuAndGetSelection();
    }

    private void exitBanner() {
        myView.exitBanner();
    }

    private void addOrder() throws
            DataValidationException,
            InvalidDateException {
        Order placement = myView.setUsersOrder(myService.getOrderNumber());//Prompts the user to input info
        //Display current order
        myView.displayCurrentOrder(placement);
        boolean usersChoice = myView.areYouSure();//Returns boolean true or false
        if (usersChoice) {
            myService.addOrder(placement);
            myView.displayCreateSuccessBanner();
        } else {
            myView.thankYouBanner();
        }
    }

//    private void displayAllOrders {
////    return myService.
//}
    private void editOrder() throws OrderNotFoundException {
        LocalDate usersDate = myView.getUsersDate(); //Have the user input the date 
        int usersOrderNumber = myView.getUsersOrderNumber();//Have the user enter the order number

        //Returns the list or an exception gets thrown:
        Order tempOrder = myService.checkIfOrderNumberExists(usersDate.toString(), usersOrderNumber).get(0); //THis auto checks the order method first
        //If this doesn't throw an exception, only one order element will be returned in the index slot 0 (as a single order)

        //if the user types enter, no changes made
        //if the user enters something, the value of that field is changed
        myView.setUsersOrderForEditing(tempOrder); //maybe?

        //Call Service method to validate correct big data format is inputted
        //Or have it in the UserIO to validate correct big data format is inputted
    }

}
