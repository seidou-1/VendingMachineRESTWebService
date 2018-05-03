/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersController;

import FlooringOrdersDAO.PersistenceException;
import FlooringOrdersDTO.Customer;
import FlooringOrdersDTO.Order;
import FlooringOrdersServiceLayer.DataValidationException;
import FlooringOrdersServiceLayer.InvalidDateException;
import FlooringOrdersServiceLayer.OrderDateNotFoundException;
import FlooringOrdersServiceLayer.OrderNumberNotFoundException;
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
//        List<Customer> myCustomer = myService.getAllCustomers(); //Provides a list of all customers
//        
//        for (Customer tempBucket : myCustomer){
//            System.out.println(tempBucket);
//        }

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
            } //catch (exitException){
            // break;
            //}
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

//        Order myOrder = new Order(myView.getUsersOrderNumber());
        
        //Now i have to create a view that takes in a List of data type Order
        //Print out the list with each value
        myView.displayAllOrders(validatedOrder);
        
//        myView.displayCurrentOrder(placement);
//        myView.displayAllOrdersAsAlist(validatedOrder);

    }

    private void addOrder() throws
            DataValidationException,
            InvalidDateException,
            PersistenceException {

        Order placement = null;
        try {
            String usersPhoneNumber = myView.getPhoneNumber();
            Customer myCustomer = myService.getCustomer(usersPhoneNumber);
            if (myCustomer != null) {//means the customer exists

                System.out.println("Welcome back " + myCustomer.getCustomerName() + ". Here are your previous orders: " + myCustomer.numberOfCustomerOrders());
                myView.displayOrderSummary(); //banner

                for (Order bucketOrder : myCustomer.allOrders()) { //going through all elements in the Order object
                    myView.displayCurrentOrder(bucketOrder);//displaying each order
                }
                /*
                After finding the user's order history, the below will prompt 
                the user to enter their new order. 
                I'm setting the order # by getting the size of all elements of my Dao
                and then adding 1 to it:
                */
                placement = myView.setUsersOrder(myService.getOrderNumber(), true, myCustomer, usersPhoneNumber);//Customer exists. No need for all fields
                
                //add to checkIfStateExists
            } else { //customer does not exist. Boolean false
                do {
                    placement = myView.setUsersOrder(myService.getOrderNumber(), false, myCustomer, usersPhoneNumber);//Prompts the user to input all fields (name, state, etc)
                } while (!validateOrderData(placement)); //Continue to prompt the user if they don't fill in all the required fields properly
            }
        } catch (DataValidationException e) {
            myView.displayMessage(e.getMessage());
        }

        myView.displayOrderSummary();//Banner
        
        /*
        After the user places their new order, this nicely formats their order
        with nice spacing and all:
        */
        myView.displayCurrentOrder(placement);
        boolean usersChoice = myView.areYouSure();// Do you want to commit the order? Returns boolean true or false
        if (usersChoice) { //if boolean returns true - meaning yes 
            myService.addOrder(placement); //adds the order to the Hashmap
            myView.displayCreateSuccessBanner(); //Banner
        } else {
            myView.thankYouBanner();//If they don't want to commit, display thank you banner
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

//        try {
            Customer myCustomer = myService.getCustomer(validatedOrder.getPhoneNumber());
//            do {
                currentOrder = myView.setUsersOrderForEditing(validatedOrder, myCustomer.applyDiscount()); //maybe?
//            } while (!validateOrderData(currentOrder));
//        } catch (DataValidationException e) {
//            myView.displayMessage(e.getMessage());

//        }

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
