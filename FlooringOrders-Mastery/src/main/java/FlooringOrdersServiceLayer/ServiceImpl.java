/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersServiceLayer;

import FlooringOrdersDAO.Dao;
import FlooringOrdersDTO.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service {
    
    private Dao myDao;
    
    
    
    public ServiceImpl(Dao myDao){
        this.myDao = myDao;
    }

    @Override
    public List<Order> displayAllOrders() {
        return myDao.displayAllOrders();
    }

    @Override
    public Order addOrder(Order order) { 
        return myDao.addOrder(order.getOrderNumber(), order);

    }
    
    @Override
    public int getOrderNumber (){
        return myDao.displayAllOrders().size()+1;
    }

    @Override
    public Order editOrder(LocalDate date, String orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(LocalDate date, String orderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
