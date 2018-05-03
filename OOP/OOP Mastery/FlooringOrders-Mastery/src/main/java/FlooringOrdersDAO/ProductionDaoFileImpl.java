/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Customer;
import FlooringOrdersDTO.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author laptop
 */
public class ProductionDaoFileImpl implements Dao {

    /*
    The purpose of this class is to implement all the Daos
    and then persist everything from the hashmap into the text file
     */
    

    public LocalDate date = LocalDate.now();
    
//    public String ORDERS_FILE = "ORDERS_" + date.toString() + ".txt";
    
    public static final String ORDERS_FILE = "orders.txt";
    public static final String CUSTOMERS_FILE = "customers.txt";
    public static final String DELIMITER = "::";
    public static final String COMMA = ",";
    public static final String TILDE = "~";
    

//        Key    Value 
    Map<Integer, Order> inventory = new HashMap<>();
    
    
//    Hashmap below is for customer class 
    Map <String, Customer> customerOrders = new HashMap<>();
    
    public ProductionDaoFileImpl() throws PersistenceException {
        loadInventory();
    }
    
    @Override
    public List<Order> displayAllOrders() throws PersistenceException {
//        loadInventory();
        return new ArrayList<>(inventory.values());
    }
//    
//    //Testing:
//        public Map<Integer, List<Order> > checkIfOrderDateExistsAsAmap(LocalDate date ){
//            return inventory.values()
//                      .stream()
//                .filter(s -> s.getDate().equals(date)) //Also add filter ofr orderNumber?
//                .collect(Collectors
////                        .toMap(keyMapper, valueMapper).toList());
//                 
//        }

    @Override
    public Order addOrder(int orderNumber, Order order) throws
            //            
            //            DataValidationException,
            //            InvalidDateException,
            PersistenceException {//Remove orderNumber later
        Order newOrder = inventory.put(order.getOrderNumber(), order);
        return newOrder;
    }

    @Override
    public List<Order> editOrder(LocalDate date, int orderNumber) {
        /*
1. ask user for date and order number
2. display field values for each property
3. allow the user to hit enter if they don't want to make any changes
4. if the user does want to make changes, allow them to type it in for that field
         */

        List<Order> orderDate = inventory.values()
                .stream()
                .filter(s -> s.getDate().equals(date))
                .collect(Collectors.toList());
        return orderDate;
    }

    @Override
    public Order removeOrder(/*LocalDate date,*/int orderNumber) {
        Order removedOrder = inventory.remove(orderNumber); //Add code to remove based on date
        return removedOrder;
    }

    @Override
    public boolean justSaveToFile() {
        try {
            writeInventory();
//            loadInventory();
    
        } catch (PersistenceException ex) {
            System.out.println("Could not write to inventory test..");
        }

        return true;
        /*
        I made this method a boolean because it'll be easier for me to check
        true or false when i write to my audit txt file
         */
    }

    private void loadInventory() throws PersistenceException {
        /*
        This stores the data in memory
         */
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ORDERS_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Could not load inventory from file", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Order currentOrder = new Order(parseInt(currentTokens[0])); //Order + Order Number

            currentOrder.setCustomerName(currentTokens[1]); //Name

//            currentOrder.setArea(new BigDecimal(currentTokens[2])); //Area

            currentOrder.setTaxClass(currentTokens[2]); //State

            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));//State Tax%

//            currentOrder.setProductClass(currentTokens[4]); //Product, Area, maybe Tilde
            
            String[] currentTalisman = currentTokens[4].split(TILDE);//Product, Area, maybe Tilde
            
            for(String bucket : currentTalisman){//Loops through each Talisman i.e. (Wood,432)
                String[] splitter = bucket.split(COMMA);//Index 0 is wood, index 1 is area
                //Now this needs to be added to the hashmap:
                currentOrder.setProductsToHashMap(splitter[0], new BigDecimal(splitter[1]));
            }
                
            currentOrder.setTotalCostPerSqFt(new BigDecimal(currentTokens[5]));//Total Cost Per Sq Ft

            currentOrder.setTotalLaborCostPerSqFt(new BigDecimal(currentTokens[6]));// Total Labor Cost Per Sq Ft
 
            currentOrder.setTaxCharged(new BigDecimal(currentTokens[7])); //Total Tax
 
            currentOrder.setGrandTotal(new BigDecimal(currentTokens[8])); //Grand Total

            currentOrder.setDate(LocalDate.parse(currentTokens[9]));//Date

            currentOrder.setPhoneNumber(currentTokens[10]);//PhoneNumber
             
            Customer myCustomer = new Customer(parseInt(currentTokens[0]), currentOrder, currentTokens[10], currentTokens[2]);
            
            if (customerOrders.containsKey(myCustomer.getPhoneNumber())) { //Check to see if the customer's entered # exists
                 Customer currentCustomer = customerOrders.get(myCustomer.getPhoneNumber()); //I'm getting the phone number which is the key
                 currentCustomer.addOrder(currentOrder);
  
                 customerOrders.put(myCustomer.getPhoneNumber(), currentCustomer);//adds all the orders for the current customer
            } else { //if the number doesn't exist
                myCustomer.setCustomerName(currentOrder.getCustomerName());
//                myCustomer.setState(currentOrder.getTaxClass());
                customerOrders.put(myCustomer.getPhoneNumber(), myCustomer);//creates a new customer
                
            }

            inventory.put(currentOrder.getOrderNumber(), currentOrder);//Put everything in hashmap  
            
            
        }
        scanner.close();

    }

    private void writeInventory() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDERS_FILE));
        } catch (IOException e) {
            throw new PersistenceException("Error - cannot save intentory data.", e);
        }

        List<Order> inventory = this.displayAllOrders();

        for (Order tempBucket : inventory) {

            out.println(tempBucket.getOrderNumber() + DELIMITER //Order number 0

                    + tempBucket.getCustomerName() + DELIMITER //Name 1
 
                    + tempBucket.getTaxClass() + DELIMITER //State 2

                    + tempBucket.getTaxClass().getStatesTax() + DELIMITER //Tax 3

                    + tempBucket.displayFormat() + DELIMITER//Product,Area, maybe Tilde 4

//                    + tempBucket.getProductClass().getProductName() + DELIMITER //Product

                    + tempBucket.getTotalCostPerSqFt() + DELIMITER // Total Cost Per St Ft 5
//                    + tempBucket.getProductClass().getCostPerSqFt() + DELIMITER // 

                    + tempBucket.getTotalLaborCostPerSqFt() + DELIMITER // Total Labor Cost Per Sq Ft. 6
//                    + tempBucket.getProductClass().getlaborCostPerSqFt() + DELIMITER // 

                    + tempBucket.getTaxCharged() + DELIMITER //TotalTax 7
//                    + tempBucket.getTaxCharged() + DELIMITER //TotalTax

                    + tempBucket.getGrandTotal() + DELIMITER //Grand Total 8

                    + tempBucket.getDate() + DELIMITER //Date 9
            
                    + tempBucket.getPhoneNumber()); //Phone Number 10

            out.flush();
        }
        out.close();
    }
    
    private void loadCustomer() throws PersistenceException{
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(CUSTOMERS_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("Could not load inventory from file", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            System.out.println(currentTokens);

//            Customer myCustomer = new Customer (currentTokens[0], currentTokens[1], currentTokens[2]); //Order Number

    }
    
    
    }
    

    

    private void writeCustomer()throws PersistenceException{
        
    }
    
    public void addCustomer (String phoneNumber, Customer currentCustomer){
        customerOrders.put(phoneNumber, currentCustomer);
    }
    
    public Customer getCustomer (String phoneNumber){
        return customerOrders.get(phoneNumber);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerOrders.values());
    }
}
