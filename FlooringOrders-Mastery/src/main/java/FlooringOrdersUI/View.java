/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersUI;

import FlooringOrdersDTO.Order;
import java.math.BigDecimal;
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

    public void displayAllOrders(List<Order> List) {
        for (Order bucket : List) {

            myIO.print(
                    "Order Number: "
                    + bucket.getOrderNumber() + " Name: "
                    + bucket.getCustomerName() + " Area: "
                    + bucket.getArea() + " State: "
                    + bucket.getTaxClass() + " State Tax: " //The actual state i.e. OH
                    + bucket.getTaxClass().getStatesTax() + " Product: " //Gets the corresponding tax for OH
                    + bucket.getProductClass() + " Cost Per Sq. Ft: "
                    + bucket.getProductClass().getCostPerSqFt() + " Labor Cost Per Sq Ft: "
                    + bucket.getProductClass().getlaborCostPerSqFt() + " Total Tax: "
                    + bucket.getTaxCharged() + " Grand Total: "
                    + bucket.getGrandTotal()
            );

        }

    }

    public Order setUsersOrder(int orderNumber) {
        String name = myIO.readString("Enter first and last name");
        BigDecimal area = myIO.readBigDecimal("Enter your Sq. Footage");
        String state = myIO.readString("Enter State [i.e. OH, PA, MI, or IN]");
        String product = myIO.readString("What material do you prefer [i.e. Carpet, Laminate, Tile, or Wood]?");

        Order currentOrder = new Order(orderNumber); //Trying to auto set the order#
//        Product currentProduct = new Product(); //Instantiating product 
        currentOrder.setCustomerName(name);
        currentOrder.setArea(area);
        currentOrder.setTaxClass(state);//This gets the enum value of state, and the tax rate just by them entering state
        currentOrder.setProductClass(product);//This gets the enum value of product. 3 values as well!!!!!!

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

    public String confirmSelection() {
        return myIO.readString("Are you sure? Y/N");
        /*
        Pass this response to a switch statement to persist or not
         */
    }

    public void displayCreateSuccessBanner() {
        myIO.readString("Order successfully created. Hit enter to continue");
    }

    public void exitBanner() {
        myIO.print("GoodBye!!");
    }

    public boolean areYouSure() {
        boolean userSelection = false;
        int usersChoice = myIO.readInt("Are you sure ['1' for yes, '2' for no]", 1, 2); //refactor later to ignore uppercase
        if (usersChoice == 1) {
            userSelection = true;
        } //Automatically returns false if they select 2
        return userSelection;
    }

    public void thankYouBanner() {
        myIO.print("Thank you!!");
    }

    public void displayCurrentOrder(Order placement) {

        System.out.println("Order Number: " + placement.getOrderNumber()
                + " Name: "
                + placement.getCustomerName()
                + " Area: "
                + placement.getArea()
                + " Material: "
                + placement.getProductClass().getProductName()
                + " Cost Per Sq. Ft: "
                + placement.getProductClass().getCostPerSqFt()
                + " Labor Cost Per Sq. Ft: "
                + placement.getProductClass().getlaborCostPerSqFt()
                + " State: "
                + placement.getTaxClass().getStateAbbreviation() //Can also just print out just TaxClass
                + " State Tax: "
                + placement.getTaxClass().getStatesTax()
                + " Tax Charged: "
                + placement.getTaxCharged()
                + " Grand Total: "
                + placement.getGrandTotal());

    }

    public LocalDate getUsersDate() {
        myIO.readLocalDate();
        
        return 
    }

}
