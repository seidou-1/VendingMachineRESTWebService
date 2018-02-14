/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop
 */
public class FlooringOrderDaoStubImpl implements Dao{
    
    /*
    The purpose of this is since we're checking to see if the business rules will hold true,
    we need an actual product to check the business rules against
    
    since this is a test of the stub Dao, three things that need to be present here
    are:
    
    a member field of type Student 
    
    an array list
    
    a constructor for all fields to be created\set
    */
    
    private Order onlyOrder;
    private List<Order> orderList = new ArrayList<>();
    
    public FlooringOrderDaoStubImpl(){
        
        LocalDate date = LocalDate.of(2018, 02, 12);

        onlyOrder = new Order(1);
        
        
        onlyOrder.setArea(new BigDecimal("322"));
        onlyOrder.setCustomerName("crilo pillow");
        onlyOrder.setDate(date);
        onlyOrder.setGrandTotal(new BigDecimal("100"));
        onlyOrder.setLaborCost(new BigDecimal("322"));
        onlyOrder.setMaterialCost(new BigDecimal("200")); 
        onlyOrder.setProductClass("Carpet"/*onlyOrder.getProductClass().getProductName()*/);
        onlyOrder.setTaxClass("OH"); 
        onlyOrder.setTaxCharged(new BigDecimal("322")); 
        
        orderList.add(onlyOrder);
        
    }

    @Override
    public List<Order> displayAllOrders() throws PersistenceException {
        return orderList;
    }

    @Override
    public Order addOrder(int orderNumber, Order order) throws PersistenceException {
        return onlyOrder;
    }

    @Override
    public List<Order> editOrder(LocalDate date, int orderNumber) {
        return orderList;
    }

    @Override
    public Order removeOrder(/*LocalDate date,*/ int orderNumber) {
        return onlyOrder;
    }

    @Override
    public boolean justSaveToFile() {
        //Do nothing
        return true;
    }
    
}
