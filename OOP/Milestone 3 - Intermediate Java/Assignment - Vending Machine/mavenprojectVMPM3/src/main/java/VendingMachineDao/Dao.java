/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDao;

import VendingMachineDto.Products;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface Dao {
    
    //get a product
    //get all products
    //hasMap
    
   Products getProduct(String productID) throws PersistenceException;
   
   List <Products> getAllProducts() throws PersistenceException;
   
   void justWriteInventory(); 
}
