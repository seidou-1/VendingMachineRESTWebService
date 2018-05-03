/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersServiceLayer;

import FlooringOrdersDAO.PersistenceException;
import FlooringOrdersDTO.Customer;
import FlooringOrdersDTO.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface Service {
    
    List <Order> displayAllOrders (String date) throws PersistenceException;
    
    Order addOrder(Order orderNumber) throws
            DataValidationException,
            InvalidDateException,
            PersistenceException;
    /*
    Add an order will ask the user for each piece of order data. 
    At the end, it will display a summary of the data entered and 
    ask the user to commit (Y/N). If yes, the data will be written 
    to the orders list. If no, the data will be discarded and the user 
    returned to the main menu.
    */
    
    Order editOrder (Order order) throws
            PersistenceException,
            InvalidDateException;
    
    Order removeOrder (/*LocalDate date,*/ int orderNumber)throws PersistenceException;
    
//        Order dispalyOrder(LocalDate date, String orderNumber);

    public int getOrderNumber()throws PersistenceException;

//    public void checkIfOrderNumberExists(String toString, int usersOrderNumber);
    
    public List <Order> checkIfOrderNumberExists(LocalDate date, int orderNumber) throws 
            OrderNumberNotFoundException,
            OrderDateNotFoundException,
            PersistenceException;
    
    public List<Order> checkIfOrderDateExists (LocalDate date) throws 
            OrderDateNotFoundException,
            PersistenceException;

    public boolean validateOrderData(Order order) throws DataValidationException;
    
    public boolean justSaveToFile() throws PersistenceException;
    
    public List<Customer> getAllCustomers();
    
    public Customer getCustomer (String phoneNumber);

            
   
    
}
