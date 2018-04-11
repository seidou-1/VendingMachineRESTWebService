/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.Dao;
import com.sg.vendingmachinespringmvc.dao.PersistenceException;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Products;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service{
    
    private Dao myDao;
//    private Service myService;

    @Inject
    public ServiceImpl(Dao myDao) {
        this.myDao = myDao;
    }
    
    

    @Override
    public Products getProduct(String productID) throws PersistenceException {
        return myDao.getProduct(productID);
    }

    @Override
    public List<Products> getAllProducts() throws PersistenceException {
        return myDao.getAllProducts();
    }

    @Override
    public BigDecimal getBalance() {
        return myDao.getBalance();
    }

    @Override
    public void setBalance(BigDecimal adder) {
        myDao.setBalance(adder);
    }

    @Override
    public void setBalance() {
        myDao.setBalance();
    }

    @Override
    public Products getitemTracker() {
        return myDao.getitemTracker();
    }

    @Override
    public void setItemTracker(String id) {
        myDao.setItemTracker(id);
    }
    
    @Override
    public String makePurchase (Products product, BigDecimal balance) throws InvalidSelection, SoldOutException, InsufficientFundsException{
        
        Change myChange = new Change();
        
        if (product ==null) { //Did they select an item?
            throw new InvalidSelection ("Please select a product first");
        }
        
        if (product.getProductInventory()<=0){ //Check if the item is in stock
            throw new SoldOutException("Item is sold out");
        }
        
        if (balance.compareTo(product.getProductCost())>0) { //Check if they have enough money
            product.setProductInventory();
            
            

            return myChange.calculateChange(balance, product);      
        } else {
            throw new InsufficientFundsException("Please insert $" + (product.getProductCost().subtract(balance)) + " more");
        }
        
        

    }
    
}
