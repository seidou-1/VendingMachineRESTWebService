/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface Dao {
    
    
    List <Order> displayAllOrders () throws PersistenceException;
    
    Order addOrder(int orderNumber, Order order) throws PersistenceException;
    /*
    Add an order will ask the user for each piece of order data. 
    At the end, it will display a summary of the data entered and 
    ask the user to commit (Y/N). If yes, the data will be written 
    to the orders list. If no, the data will be discarded and the user 
    returned to the main menu.
    */
    
    List <Order> editOrder (LocalDate date, int orderNumber);
    
    Order removeOrder (/*LocalDate date,*/ int orderNumber);
    
    boolean justSaveToFile();
    
//        Order dispalyOrder(LocalDate date, String orderNumber);

   
}
