/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineServiceLayer;

import VendingMachineDao.Dao;
import VendingMachineDao.PersistenceException;
import VendingMachineDto.Products;
import java.util.List;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service{
    
    Dao myDao;

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
    
    public void justWriteInventory() {
        myDao.justWriteInventory();
    }
    
//    public Products inventoryTracker (String usersItemSelection) throws PersistenceException {
//        
//        loadInventory();
//        myDao.getProduct(usersItemSelection);
//        }
//        
    }
    
    
    

