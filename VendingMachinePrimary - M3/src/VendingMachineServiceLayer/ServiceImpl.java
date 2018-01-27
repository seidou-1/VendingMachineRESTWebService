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
                throw new InventoryAvailabilityException("\n Out of stock! your $ " + usersMoney + " has been refunded back to you \n" + " ¯\\_(ツ)_/¯ \n");
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

        /*
        Two ways of doing this. First way is calling the get product inventory of the user's
        selectedProduct argumen
        
        And then subtracting 1 from that value
        
        And then writing it back to the file
        */
        int remainingInventory = selectedProduct.getProductInventory();
        remainingInventory--;


        selectedProduct.setProductInventory(remainingInventory);//Set this back to the hashmap
        myDao.justWriteInventory();
        
        System.out.println(selectedProduct.getProductName() + " \n \n Remaining Inventory: " + remainingInventory);

        return remainingInventory;


        /*
        Option 2 below is overloading the setInventory setter in my dto
        that second overloaded method gets the inventory and just subtracts 1 from it
        
        I call it here and then just write back to the inventory
        */

//        selectedProduct.setProductInventory();//Set this back to the hashmap
//        myDao.justWriteInventory();
//
//        return selectedProduct.getProductInventory();

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

