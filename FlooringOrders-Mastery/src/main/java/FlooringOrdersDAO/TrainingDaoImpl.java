/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Customer;
import FlooringOrdersDTO.Order;
import FlooringOrdersServiceLayer.DataValidationException;
import FlooringOrdersServiceLayer.InvalidDateException;
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
public class TrainingDaoImpl implements Dao {

    public TrainingDaoImpl() throws PersistenceException {
        loadInventory();
    }

    public static final String ORDERS_FILE = "orders.txt";
    public static final String DELIMITER = "::";
    public static final String COMMA = ",";
    public static final String TILDE = "~";

    Map<Integer, Order> inventory = new HashMap<>();

    Map<String, Customer> customerOrders = new HashMap<>();

//    int orderNumber = 0;
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
                .filter(s -> s.getDate().equals(date)) //Also add filter ofr orderNumber?
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
//     try {
//            writeInventory();
////            loadInventory();
//
//        } catch (PersistenceException ex) {
//            System.out.println("Could not write to inventory test..");
//        }

//        System.out.println("\n Unable to save. Switch to Production mode to save.\n");
        return false;

    }

    private void loadInventory() throws PersistenceException {
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
                
            currentOrder.setTotalCostPerSqFt(new BigDecimal(currentTokens[5]));

            currentOrder.setTotalLaborCostPerSqFt(new BigDecimal(currentTokens[6]));
 
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

//    private void writeInventory() throws PersistenceException {
//          PrintWriter out;
//          
//          try {
//               out = new PrintWriter(new FileWriter(ORDERS_FILE));
//          } catch (IOException e) {
//              throw new PersistenceException("Error - cannot save intentory data.", e);
//          }
//          
//          List <Order> inventory = this.displayAllOrders();
//          
//          for (Order tempBucket : inventory){
//              
//              out.println(tempBucket.getOrderNumber() + DELIMITER //Order number
//                      
//                      + tempBucket.getCustomerName() + DELIMITER //Name
//                      
//                      + tempBucket.getArea() + DELIMITER //Area
//                      
//                      + tempBucket.getTaxClass() + DELIMITER //State Abbreviation
//                      
//                      + tempBucket.getTaxClass().getStatesTax() + DELIMITER //Tax should i get the ".getStatesTax()" also? - it's up to me
//                      
//                      + tempBucket.getProductClass().getProductName() + DELIMITER //Material
//                      
//                      + tempBucket.getDate());  //Date
//               
//                    out.flush(); 
//          }
//            out.close();
    @Override
    public void addCustomer(String phoneNumber, Customer currentCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomer(String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
