/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersUI;

import FlooringOrdersDTO.Customer;
import FlooringOrdersDTO.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        myIO.print("\n\n**** SWG Corp. Flooring Menu ****");
        myIO.print("1. Display Orders");
        myIO.print("2. Add an Order");
        myIO.print("3. Edit an Order");
        myIO.print("4. Remove an Order");
        myIO.print("5. Save Current Work");
        myIO.print("6. Exit");

        return myIO.readInt("Select one of the options above [i.e. 1 - 6]", 1, 6);

    }

    /*
    I'm setting the DTO with what the user inputted
    I should set it to the enum version. The set should be the get of the enum
    
    B`ecause if i just set it to what the user types in, it doesn't match the case sensitive
    
    i.e. user types in "pa" and in the DTO, it gets the value of it and converts it to uppercase
    
    The .. i'm setting it by the the enum name, not by the setter (String).
    
    i should set it by the setter (String)
    
    ................
    
    im setting the String name of the enum 
    
    Set:
    1. im typing in the name as "in"
    2. then i'm sending that to the DTO to convert it to "IN"
  
     */
    public String getPhoneNumber() {
        return myIO.readString("What is your phone number?");
    }

    public Order setUsersOrder(int orderNumber, boolean customerFound, Customer myCustomer, String phoneNumber) /*throws DataValidationException*/{
    /*
        Here i'm telling the setUsersOrder method what to expect. If i pass 
        a boolean argument that is false, it will prompt the user for name and state
        
        if the boolean argument passed through is true, it will skip asking the user
        for a name and state
    */
        String name = "";
        String state = "";
        boolean addAdditional = true;
        boolean exit = false;
        boolean qualifyDiscount = false;
        
        Order currentOrder = new Order(orderNumber); 

    
        if (customerFound == false) {  //Meaning customer was not found
            
            name = myIO.readString("Enter first and last name");
            state = myIO.readString("Enter State [i.e. OH, PA, MI, or IN]");
            myCustomer = new Customer(orderNumber, currentOrder, phoneNumber, state);

        } else {
            /*
            In this else statement, the customer was found and boolean becomes true
            So there is no need to promp the user asking them for their name and state
            
            Instead, the below two two lines will just get the name and state
            through the Customer object getter
            */
            name = myCustomer.getCustomerName();
            state = myCustomer.getState();
        }
         
        /*
        Creating a hashmap here for the purposes of storing any additional line items
        the customer wants to add to their order
        */
        //    Product, Area
        Map <String, BigDecimal> additionalItems = new HashMap<>();
         
        while (addAdditional){
        BigDecimal area = myIO.readBigDecimal("Enter your Area (Sq. Ft)"); //key
        String product = myIO.readString("What material do you prefer [i.e. Carpet, Laminate, Tile, or Wood]?"); //value
        
        additionalItems.put(product, area); //After asking, i'm going to put into the hashmap
                 
        String addMoreLineItems = myIO.readString("Do you want to add additional line items to your order?");
        
            switch (addMoreLineItems.toUpperCase()){
                
                case "YES":
                case "Y":
                    addAdditional = true;
                    break;
                case "NO":
                case "N":
                    addAdditional = false;
                    break;
                case "EXIT":
                    //throw new exitException("Goodbye");
                    exit = true;
                default:
//                    throw new DataValidationException("Invalid input. Type yes, no, or exit");                  
            }  
        }

        LocalDate date = LocalDate.now(); //Refactor this later and move it to the constructor

        /*
        //Controller got the order# from the dao.displayAllOrders.size + 1. 
        Controller passed that value to this setOrders method:
        */
        currentOrder.setCustomerName(name);
        
        
        /*
        In my Order DTO, I created a field called additionalItems
        That field is a HashMap that takes in a String and a BigDecimal
        I then set the key and value of that hashmap with the
        "product" and "area" i stashed in the additionalItems hashmap above 
        
        so essentially, this additionalItems hashmap is transitory for the Order
        object hashmap 
        */
        currentOrder.setPhoneNumber(phoneNumber);
        currentOrder.setAdditionalItems(additionalItems);//Gives me both AREA and PRODUCT!
        currentOrder.setTaxClass(state);//This gets the enum value of state, and the tax rate just by them entering state
        currentOrder.setDate(date);

        /*
        Last thing i'm doing here is taking all this information and
        calling the calculateTotals method of my Order DTO. Remember all of the stuff
        above i retrieved retrieved values from user prompts
        
        I then passed them over to the Order DTO (by setting everything). The Order DTO now
        is filled with data in each of the properties. Calculate Totals does all the math
        But it relies on a boolean flag to determine if a discount should be applied
        
        I get that boolean flag from the applyDiscount method of my Customer class
        applyDiscount loops through the List of orders and checks the size of the List
        
        If the List size is 5 or more, an apply discount of 10% will be given
        
        the view is passing orders to the Customer object's
        */
        currentOrder.calculateTotals(myCustomer.applyDiscount());
        
        
        
        return currentOrder;

        
//             if (addMoreLineItems.equalsIgnoreCase("yes")||addMoreLineItems.equalsIgnoreCase("y")) {
//                 addAdditional = true;
//             }
         
        
        //prompt if they want to add an additional line item
        //if yes, addAdditional = true
        //}
        
        
        //call method that checks add additional
//        System.out.println(currentOrder.displayFormat()); Commented this out otherwise it'll display after order summary
        
    }
//    
//    public Order setOrderSetters(Order order){
//        
//    }
   
    

    public Order setUsersOrderForEditing(Order order, boolean discount) {
        String ifItsEmpty = "";

        Map <String, BigDecimal> editItems = order.getAdditionalItems();
        
        for (String bucket : editItems.keySet()) {//Loop through all the products
        myIO.print("\nEditing current area of " + bucket + ". Type in changes or hit enter to keep it as is. \n");
        String areaSetter = (myIO.readString("Current Sq. Ft: " + editItems.get(bucket) + ""));
        
        if (areaSetter.trim().length() != 0) {
            while (true){
                try {
                    editItems.put(bucket, new BigDecimal(areaSetter));
                    break;//will only reach this break statement if it successfully put item in hashmap
                } catch (Exception e) {
                    myIO.print("\nPlease enter proper numerical value"); 
                    areaSetter = (myIO.readString(" Current Sq. Ft: " + editItems.get(bucket) + ""));
                }
            }
        }  
        
        }
            order.calculateTotals(discount);
        
        //Below overloaded method doesn't take in the order.get stuff
//        myIO.print("Type in changes or hit enter to keep it as is\n");
//        String nameSetter = (myIO.readString("Current First and Last Name: " + order.getCustomerName() + ""));
//        String stateSetter = (myIO.readString("Current State: " + order.getTaxClass()/*.getStateAbbreviation()*/ + ""));
//        String productSetter = (myIO.readString("Current Product: " + order.getProductClass()/*.getProductName()*/ + ""));

        //Asks if the name needs to be changed
//        if (nameSetter.trim().length() != 0) {
//            order.setCustomerName(nameSetter);
////            if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0
//        } else {
//            order.setCustomerName(order.getCustomerName());
//        }
//
//        //Asks if the Area needs to be changed
//        if (areaSetter.trim().length() != 0) { //If they enter information
//            order.setArea(new BigDecimal(areaSetter)); //Set it to what they entered
//        } else {
//            order.setArea(order.getArea());
//        } //otherwise set it to the orignal value
//
//        //Asks if the State needs to be changed
//        if (stateSetter.trim().length() != 0) {
//            order.setTaxClass(stateSetter);
//        } else {
//            order.setTaxClass(order.getTaxClass().getStateAbbreviation());
//        }
//
//        //Asks if the Product needs to be changed
//        if (productSetter.trim().length() != 0) {
//            order.setProductClass(productSetter);
//        } else {
//            order.setProductClass(order.getProductClass().getProductName());
//        }  

        return order;
    }

    public void displayAllOrders(List<Order> List) {//This actually displays a single order - refactor later
        for (Order bucket : List) {

            myIO.print(
                    //                    "\nr~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                    "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°-- --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
//
//                    +"\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~"
                    + "Order Number: "
                    + bucket.getOrderNumber()
                    + " | Name: "
                    + bucket.getCustomerName()
                    + " | Area: "
                    + bucket.displayFormat() + " Sq. Ft. "
//                    + bucket.getArea() + " Sq. Ft. "
//                    + " | State: "
//                    + bucket.getTaxClass()
//                    + " | State Tax: " //The actual state i.e. OH
//                    + bucket.getTaxClass().getStatesTax()
//                    + " | Product: " //Gets the corresponding tax for OH
//                    + bucket.getProductClass()
//                    + " | Cost Per Sq. Ft: $"
//                    + bucket.getLaborCostPerSqFt()
//                    + bucket.getProductClass().getCostPerSqFt()
                    + " | Total Cost Per Sq. Ft: "
                            
                    + bucket.getTotalCostPerSqFt()
                            
                    + " | Total Labor Cost Per Sq Ft: $"
                    + bucket.getTotalLaborCostPerSqFt()
//                    + bucket.getProductClass().getlaborCostPerSqFt()
                    + " | Tax Charged (cost * State tax rate %): $"
                    
                    + "| State: " 
                    + bucket.getTaxClass().getStateAbbreviation() //Can also just print out just TaxClass
                    + "| State Tax: "
                    + bucket.getTaxClass().getStatesTax()
                    + "| Tax Charged: $"                            
                    + bucket.getTaxCharged()
                    + " | Grand Total: $"
                    + bucket.getGrandTotal()
                    //                    +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                    + "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
            //                    +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
            );

        }

    }
    
    public void displayOrderSummary(){
        myIO.print("\n Order Summary: ");
    }

    public void displayCurrentOrder(Order placement) {

        System.out.println(
                //               "\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~~"
                
                 "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°-- --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
//               +"\n~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~~"
//                + "\n Order Number: " + placement.getOrderNumber()
//                + " Name: "
//                + placement.getCustomerName()
//                + " | Area: "
//                + placement.getArea() + " Sq. Ft. "
//                + " | Material: "
//                + placement.getProductClass().getProductName()
//                + " | Cost Per Sq. Ft: $"
//                + placement.getProductClass().getCostPerSqFt()
//                + " | Labor Cost Per Sq. Ft: $"
//                + placement.getProductClass().getlaborCostPerSqFt()
//                + " | State: "
//                + placement.getTaxClass().getStateAbbreviation() //Can also just print out just TaxClass
//                + " | State Tax: %"
//                + placement.getTaxClass().getStatesTax().multiply(new BigDecimal("100"))
//                + " | Tax Charged (cost * State tax rate %): $"
//                + placement.getTaxCharged()
//                + " | Grand Total: $"
//                + placement.getGrandTotal()
                  + placement.toString()
                //                +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~"
                + "\n --°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°--°"
        //                +"~~~~***~~~~***~~~~***~~~~***~~~~***~~~~***~~"

        );

    }
//    
//    public void displayAllOrdersAsAlist (List <Order> theOrders) {
//        for (Order bucket : theOrders){
//            
//            myIO.print(
//            
//            "Order number: "
//            + bucket.getCustomerName()
//                    + bucket.getArea()
//                    + bucket.getDate()
//            
//            
//            
//            
//            
//            
//            
//            );
//            
//             
//            
//        }
//  
//    }

    public void displayCreateSuccessBanner() {
        myIO.print("Order successfully created.");
    }

    public void displayEditedSuccessfullyBanner() {
        myIO.print("Your order has been successfully edited.");
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
        myIO.print("Thank you!! ");
    }

    //Enhanced for loop method to display all
    public LocalDate getUsersDate() { //Pass a paramater here?
        LocalDate usersDate = myIO.readLocalDate("Enter a date in the format MM/dd/yyyy");
        return usersDate;

    }

    public int getUsersOrderNumber() {
        return myIO.readInt("Enter order number");
    }

    public void displayErrorMessage(String errorMessage) {
        myIO.print("=== ERROR ===");
        myIO.print(errorMessage);
    }

    public void displayRemovedSuccessfullyBanner() {
        myIO.print("Order successfully removed.");
    }

    public void displayWorkedSavedSuccessfullyBanner() {
        myIO.print("Work successfully saved.");
    }

    public void displayMessage(String msg) {
        myIO.print(msg);
    }

}
