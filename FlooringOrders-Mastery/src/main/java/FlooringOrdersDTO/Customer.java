/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop
 */
public class Customer {
    
    private String phoneNumber; 
    
    private Order currentOrder;
    
    private List<Order> orders = new ArrayList<>();
    
    /*
    Constructor below will serve as the setter
    */
     public Customer(String phoneNumber, Order currentOrder) {
        this.phoneNumber = phoneNumber;
        this.currentOrder = currentOrder;
        orders.add(currentOrder);
    }
    
     /*
     Getters
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /*
    addOrder - set the order
    
    allOrders - return an array list of all the orders
    */

    public void addOrder(Order currentOrder){
        orders.add(currentOrder);
    }
   
    public List<Order> allOrders(){
        return orders;
//        return new ArrayList<>(orders); test later
    }
    
    
    
 
    
}
