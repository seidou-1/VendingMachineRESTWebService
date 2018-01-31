/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDao;

import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author laptop
 */
public class VendingMachineDaoStubImpl implements Dao{
    
    /*
    Here we'll add a class level variable for the Products object
    
    And also an ArrayList
    
    Then initialze both via a constructor
    
    The purpose of this is since we're checking to see if the business rules will hold true,
    we need an actual product to check the student rules against
    */
    
    Products onlyProduct;
    
    List <Products> listProductsList = new ArrayList<>();
    Map<String, Products> createdInventory = new HashMap<>();

    
    VendingMachineDaoStubImpl(){
        onlyProduct = new Products ("A1");
        onlyProduct.setProductName("Snickers");
        onlyProduct.setProductCost(new BigDecimal ("1.50"));
        
        createdInventory.put("A1", onlyProduct); //Used a hashmap put method here since i don't have an add method
        
    }

    @Override
    public Products getProduct(String productID) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Products> getAllProducts() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void justWriteInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
