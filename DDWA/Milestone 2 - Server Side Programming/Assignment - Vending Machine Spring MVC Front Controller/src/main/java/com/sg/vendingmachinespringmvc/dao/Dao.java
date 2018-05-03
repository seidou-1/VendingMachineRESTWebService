/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Products;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface Dao {
    
    //Get a product
    //Hashmap
    
   Products getProduct(String productID) throws PersistenceException;
   
   List <Products> getAllProducts() throws PersistenceException;
   
   BigDecimal getBalance();
   
   void setBalance(BigDecimal adder);
   
   void setBalance();
   
   Products getitemTracker();
   
   void setItemTracker(String id);
       
}
