/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineServiceLayer;

import VendingMachineDao.Dao;
import VendingMachineDao.PersistenceException;
import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laptop
 */
public class ServiceImpl implements Service {

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

    @Override
    public void justWriteInventory() {
        myDao.justWriteInventory();
    }

    @Override
    public boolean checkIfMoneyIsEnough(BigDecimal userMoney, Products selectedProduct) throws InsufficientFundsException {
        try {

            if (selectedProduct.getProductCost().compareTo(userMoney) > 0) {
                //If evaluates to true and throws the exception
                throw new InsufficientFundsException("Error: You don't have enough dough bro\"\n");

            } else {
                return true;
            }

        } catch (InsufficientFundsException e) {
            /*
            This is telling the catch to grab an exception of type InsufficientFundsException
            this instantiates the class using the letter e
            */
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean inventoryAvailability(BigDecimal usersMoney, Products selectedProduct) throws InventoryAvailabilityException {

        try {
            if (selectedProduct.getProductInventory() == 0) {
                throw new InventoryAvailabilityException("Out of stock! your $ " + usersMoney + "has been refunded back to you");
            } else {
                return true;//Return true means i have enough inventory and will return true
            }
        } catch (InventoryAvailabilityException e) {
            System.out.println(e.getMessage());//This will throw the above out of stock message
            //This small e is instantiating the exception
            return false;
        }

    }
//            System.out.println(e.);

    @Override
    public int reduceInventory(Products selectedProduct) {
        //Should i load inventory first? Include a similar dao method?
        int remainingInventory = selectedProduct.getProductInventory();
        remainingInventory--;
        myDao.justWriteInventory();
        return remainingInventory;
        
    }
    
    


}

//Here
//InventoryAvailabilityException
//    public Products inventoryTracker (String usersItemSelection) throws PersistenceException {
//        
//        loadInventory();
//        myDao.getProduct(usersItemSelection);
//        }
//        

