/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
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
public class DaoFileImpl implements Dao{

    public static final String ORDERS_FILE = "orders.txt";
    public static final String DELIMITER = "::";

    
    Map<Integer, Order> inventory = new HashMap<>(); 
    
//    int orderNumber = 0;
    
    @Override
    public  List<Order> displayAllOrders() {
       return new ArrayList<>(inventory.values());
    }

    @Override
    public Order addOrder(int orderNumber, Order order) {//Remove orderNumber later
        Order newOrder =inventory.put(order.getOrderNumber(), order);
        return newOrder;
    }

    @Override
    public List <Order> editOrder(LocalDate date, int orderNumber) {
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
    public Order removeOrder(LocalDate date, String orderNumber) {
        Order removedOrder = inventory.remove(orderNumber); //Add code to remove based on date
        return removedOrder;
    }
    
//    private int incrementOrderNumber(){
//        orderNumber++;
//        return orderNumber;
//    }
    
//    @Override
//    public Order dispalyOrder(LocalDate date, String orderNumber) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    private void loadCollection() throws PersistenceException{
//        Scanner scanner;
//        
//        try {
//        scanner = new Scanner(new BufferedReader(new FileReader(ORDERS_FILE)));
//    } catch (FileNotFoundException e) {
//        throw new PersistenceException("Could not load Orders from memory ", e);
//    }
//        
//        String currentLine;
//        
//        String[] currentTokens;
//        
//        while (scanner.hasNext()){
//            
//            currentLine = scanner.nextLine();
//            
//            currentTokens = currentLine.split(DELIMITER);
//            
//            Order currentOrder = new Order(parseInt(currentTokens[0]));//Order#
//            
//            currentOrder.setCustomerName(currentTokens[1]);
////            currentOrder.setState(currentTokens[1]);
//            currentOrder.setTaxClass(currentTokens[1]);
//            
//            /*
//            
//            */
//            
//        }
//        
//    }
    
}
