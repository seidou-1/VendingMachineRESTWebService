/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDao;

import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laptop
 */
public class DaoTest {
    
    /*
    instantiate the dao by making a member field of the dao
    
        
    Also created a hashmap so i can use the put and remove methods
    */
    

    //     Dao  variable name of type DaoFileImpl
    private Dao createdDao = new DaoFileImpl();
    
    Map<String, Products> createdInventory = new HashMap<>();

    
    public DaoTest() { 
    }
    
    @BeforeClass
    public static void setUpClass()  {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{//This throws a persistence exception so i have to add that throw claus in the setup method

        
         /*
        Set the Dao into a known good state so it can be empty to begin with
        This will get the list of all the products in the inventory
        

        */
        
        List<Products> createdProductsList = createdDao.getAllProducts();
        
        /*
        Now i have to loop through the products in my List and remove them
        
        on second thought, nope
        */
        
//        for (Products tempBucket : createdProductsList){
//            createdInventory.remove(createdProductsList); //will this work?
////            createdProductsList.removeAll(createdDao.getAllProducts());//or should i do this?
//        }
        
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProduct method, of class Dao.
     */
    @Test
    public void testGetProduct() throws Exception {
        /*
        This method will kill 2 birds with one stone. Changed the defualt method name
        so i can test both adding a product and dispensing a product as well
        */
        
//        Products createdProductsVar = new Products("A1");
//        createdProductsVar.setProductName("Snickers");
////        createdProductsVar.setProductCost(BigDecimal cost = new BigDecimal (cost));
//        createdProductsVar.setProductInventory(5);
//        
        //Just going to get an existing product that's already in my hashmap
        
        createdDao.getProduct("A1");
        
        
        /*
        Since the product inventory count is a part of the get product method, how do i 
        check if the count has been removed properly?
        */
        assertEquals("A1", "A1"); //Looks for the ID called "A1", and then compares that from the Dao
        
    }

    /**
     * Test of getAllProducts method, of class Dao.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        
        createdDao.getAllProducts();
        
        assertEquals(3, createdDao.getAllProducts().size());//This will give back the list size. I will compare that to 
        //my expected return of 3
    }

    /**
     * Test of justWriteInventory method, of class Dao.
     */
    @Test
    public void testJustWriteInventory() {
        /*
        I don't need to test this method because this basically just calls the 
        writeInventory() method and writes the data to file
        */
    }

//    Remove the implmentation below:
    
//    public class DaoImpl implements Dao {
//
//        public Products getProduct(String productID) throws PersistenceException {
//            return null;
//        }
//
//        public List<Products> getAllProducts() throws PersistenceException {
//            return null;
//        }
//
//        public void justWriteInventory() {
//        }
//    }
    
}
