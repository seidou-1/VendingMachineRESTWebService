/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersUI;

import FlooringOrdersDTO.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author laptop
 */
public class View {

    UserIO myIO;

    public View(UserIO myIO) {
        this.myIO = myIO;
    }

    public int printMenuAndGetSelection() {

        myIO.print("**** SWG Corp. Flooring Menu ****");
        myIO.print("1. Display Orders");
        myIO.print("2. Add an Order");
        myIO.print("3. Edit an Order");
        myIO.print("4. Remove an Order");
        myIO.print("5. Save Current Work");
        myIO.print("6. Exit");

        return myIO.readInt("Select one of the options above [i.e. 1 - 6]", 1, 6);

    }

    public void displayAllOrders(List<Order> List) {//This actually displays a single order - refactor later
        for (Order bucket : List) {

            myIO.print(
//                    "\nr~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                    "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°-- --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
//
//                    +"\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~"
                    +
                    "\n Order Number: "
                    + bucket.getOrderNumber() 
                    + " | Name: "
                    + bucket.getCustomerName() 
                    + " | Area: "
                    + bucket.getArea() + " Sq. Ft. " 
                    + " | State: "
                    + bucket.getTaxClass()  
                    + " | State Tax: " //The actual state i.e. OH
                    + bucket.getTaxClass().getStatesTax() 
                    + " | Product: " //Gets the corresponding tax for OH
                    + bucket.getProductClass() 
                    + " | Cost Per Sq. Ft: $"
                    + bucket.getProductClass().getCostPerSqFt() 
                    + " | Labor Cost Per Sq Ft: $"
                    + bucket.getProductClass().getlaborCostPerSqFt() 
                    + " | Tax Charged (cost * State tax rate %): $"
                    + bucket.getTaxCharged() 
                    + " | Grand Total: $"
                    + bucket.getGrandTotal()
//                    +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                    + "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"

//                    +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
            );

        }

    }
    
    public void displayCurrentOrder(Order placement) {

        System.out.println(
                
//               "\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                "\nOrder Summary: \n"
             + "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°-- --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
//               +"\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~"
               + 
              "\n Order Number: " + placement.getOrderNumber()
                + " Name: "
                + placement.getCustomerName()
                + " | Area: "
                + placement.getArea() + " Sq. Ft. "
                + " | Material: "
                + placement.getProductClass().getProductName()
                + " | Cost Per Sq. Ft: $"
                + placement.getProductClass().getCostPerSqFt()
                + " | Labor Cost Per Sq. Ft: $"
                + placement.getProductClass().getlaborCostPerSqFt()
                + " | State: "
                + placement.getTaxClass().getStateAbbreviation() //Can also just print out just TaxClass
                + " | State Tax: %"
                + placement.getTaxClass().getStatesTax().multiply(new BigDecimal("100"))
                + " | Tax Charged (cost * State tax rate %): $"
                + placement.getTaxCharged()
                + " | Grand Total: $"
                + placement.getGrandTotal()
//                +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~"
                + "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
//                +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~"
        
                );

    }
    
    public void displayAllOrdersAsAlist (List <Order> theOrders) {
        for (Order bucket : theOrders){
            
            myIO.print(
            
            "Order number: "
            + bucket.getCustomerName()
                    + bucket.getArea()
                    + bucket.getDate()
            
            
            
            
            
            
            
            );
            
             
            
        }

    //This takes in a list and prints out each element with the properties
//        LocalDate.stream()
//                .forEach(s -> );
//        
//        dells.stream()
//               .forEach(s -> System.out.println(s.getName()));
//
//        
//        
        
    }
    /*
    I'm setting the DTO with what the user inputted
    I should set it to the enum version. The set should be the get of the enum
    
    Because if i just set it to what the user types in, it doesn't match the case sensitive
    
    i.e. user types in "pa" and in the DTO, it gets the value of it and converts it to uppercase
    
    The .. i'm setting it by the the enum name, not by the setter (String).
    
    i should set it by the setter (String)
    
    ................
    
    im setting the String name of the enum 
    
    Set:
    1. im typing in the name as "in"
    2. then i'm sending that to the DTO to convert it to "IN"
    
    Edit:
    1. getting "IN"
    */

    public Order setUsersOrder(int orderNumber) {
        String name = myIO.readString("Enter first and last name");
        BigDecimal area = myIO.readBigDecimal("Enter your Area (Sq. Ft)");
        String state = myIO.readString("Enter State [i.e. OH, PA, MI, or IN]");
        String product = myIO.readString("What material do you prefer [i.e. Carpet, Laminate, Tile, or Wood]?");
        LocalDate date = LocalDate.now(); //Refactor this later and move it to the constructor
         
        Order currentOrder = new Order(orderNumber); //Trying to auto set the order#
//        Product currentProduct = new Product(); //Instantiating product 
        currentOrder.setCustomerName(name);
        currentOrder.setArea(area);
        currentOrder.setTaxClass(state);//This gets the enum value of state, and the tax rate just by them entering state
        currentOrder.setProductClass(product);//This gets the enum value of product. 3 values as well!!!!!!
        currentOrder.setDate(date);
//        currentOrder.setTaxCharged(area);
        
        
//        currentOrder.setTaxClass(currentOrder.getTaxClass().getStateAbbreviation());


        //Option A but the view does too much:
//        CalculatedTotals myTotal = new CalculatedTotals();
//        
//        myTotal.calculateTotals(currentOrder);
        //Option B
        currentOrder.calculateTotals();

        return currentOrder;

//        currentOrder.setTaxCharged(state);
        //Is there a way to set the State of the Dto by getting the enum value
        //Set the tax charged
        //Set the material cost
        //Set the labor cost
        //Set the grandTotal
    }

    public Order setUsersOrderForEditing(Order order) {
        String ifItsEmpty = "";
        
        //Below overloaded method doesn't take in the order.get stuff
        myIO.print("Type in changes or hit enter to keep it as is\n");
        String nameSetter = (myIO.readString("Current First and Last Name: " + order.getCustomerName() + ""));
        String areaSetter = (myIO.readString("Current Sq. Ft: " + order.getArea())  + "" );
        String stateSetter = (myIO.readString("Current State: " + order.getTaxClass()/*.getStateAbbreviation()*/ + ""));
        String productSetter = (myIO.readString("Current Product: " + order.getProductClass()/*.getProductName()*/ + ""));

        //Asks if the name needs to be changed
        if (nameSetter.trim().length()!=0) {
            order.setCustomerName(nameSetter);
//            if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0
        } else {order.setCustomerName(order.getCustomerName());}
        
        //Asks if the Area needs to be changed
        if (areaSetter.trim().length()!=0){ //If they enter information
            order.setArea(new BigDecimal(areaSetter)); //Set it to what they entered
        } else {order.setArea(order.getArea());} //otherwise set it to the orignal value
        
        //Asks if the State needs to be changed
        if (stateSetter.trim().length()!=0){
            order.setTaxClass(stateSetter);
        } else {order.setTaxClass(order.getTaxClass().getStateAbbreviation());}
        
        //Asks if the Product needs to be changed
        if (productSetter.trim().length()!=0){ 
            order.setProductClass(productSetter);
        } else {order.setProductClass(order.getProductClass().getProductName());}
        
        return order;
    }

//    public String confirmSelection() {
//        return myIO.readString("Are you sure you want to enter this order in? Y/N");
//        /*
//        Pass this response to a switch statement to persist or not
//         */
//    }

    public void displayCreateSuccessBanner() {
        myIO.readString("Order successfully created. Hit enter to continue");
    }
    
    public void displayEditedSuccessfullyBanner(){
        myIO.readString("Your order has been successfully edited. Hit enter to continue");
    }

    public void exitBanner() {
        myIO.print("GoodBye!!");
    }

    public boolean areYouSure() {
        boolean userSelection = false;
        int usersChoice = myIO.readInt("Are you sure you sure you want to commit? ['1' for yes, '2' for no]", 1, 2); //refactor later to ignore uppercase
        if (usersChoice == 1) {
            userSelection = true;
        } //Automatically returns false if they select 2
        return userSelection;
    }

    public void thankYouBanner() {
        myIO.readString("Thank you!! Press enter to continue");
    }

    
    
    //Enhanced for loop method to display all

    public LocalDate getUsersDate() { //Pass a paramater here?
         LocalDate usersDate = myIO.readLocalDate("Enter a date in the format MM/dd/yyyy");
         return usersDate;
         
    }

    public int getUsersOrderNumber() {
        return myIO.readInt("Enter order number");
    }
    
    public void displayErrorMessage(String errorMessage){
        myIO.print("=== ERROR ===");
        myIO.print(errorMessage);
    }

    public void displayRemovedSuccessfullyBanner() {
        myIO.readString("Order successfully removed. Press enter to continue.");
    }

    public void displayWorkedSavedSuccessfullyBanner() {
        myIO.readString("Work successfully saved.Press enter to continue. ");
    }

    public void displayMessage(String msg) {
        myIO.print(msg);
    }

}
