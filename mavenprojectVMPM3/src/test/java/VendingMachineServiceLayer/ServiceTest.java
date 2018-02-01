/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineServiceLayer;

import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author laptop
 */
public class ServiceTest {

    private Service createdService;

    List<Products> listProductsList = new ArrayList<>();
    Map<String, Products> createdInventory = new HashMap<>();

    /*
    Create a constructor below to assign the dao to the VendingMachineDaoStubImpl created 
    in the step before
    
    Should the below be in my constructor or no?
     */
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Service myService = ctx.getBean("VendingMachineService", Service.class);

    public ServiceTest() {

        /*
        Since i created an AOP, I can now comment out the manual injections
        and replace them with the XML versions
         */
//      Dao createdDao = new VendingMachineDaoStubImpl();
//      VendingMachineAuditDao createdAuditDao = new VendingMachineAuditDaoStubImpl();
//      
//      createdService = new ServiceImpl(createdDao, createdAuditDao);
//      
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Service myService = ctx.getBean("VendingMachineService", Service.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        for (Products tempBucket : listProductsList) {
//            createdInventory.remove(listProductsList); //will this work?
//            createdProductsList.removeAll(createdDao.getAllProducts());//or should i do this?
//        }
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getProduct method, of class Service.
     */
//    @Test
//    public void testGetProduct() throws Exception {
//
////        Products snickers = new Products ("A1");
////        snickers = new Products ("A1");
////        snickers.setProductName("Snickers");
////        snickers.setProductCost(new BigDecimal ("1.50"));
////        
////        createdInventory.put("A1", snickers); //Used a hashmap put method here since i don't have an add method
////        
////        assertEquals("A1", snickers.getProductId());
//    }

    /**
     * Test of getAllProducts method, of class Service.
     */
//    @Test
//    public void testGetAllProducts() throws Exception {
//
//        Products snickers = new Products("A1");
//        snickers.setProductName("Snickers");
//        snickers.setProductCost(new BigDecimal("1.50"));
//        snickers.setProductInventory(1);
//        
//        createdInventory.put("A1", snickers); //Used a hashmap put method here since i don't have an add method
//        
//        
//        assertEquals(snickers.getProductInventory(), snickers.getProductInventory());
//
//    }
//
//    /**
//     * Test of reduceInventory method, of class Service.
//     */
//    @Test
//    public void testReduceInventory() {
//    }
//
//    /**
//     * Test of checkIfMoneyIsEnough method, of class Service.
//     */
//    @Test
//    public void testCheckIfMoneyIsEnough() throws Exception {
//    }
//
//    /**
//     * Test of inventoryAvailability method, of class Service.
//     */
//    @Test
//    public void testInventoryAvailability() throws Exception {
//    }

//    public class ServiceImpl implements Service {
//
//        public Products getProduct(String productID) throws PersistenceException {
//            return null;
//        }
//
//        public List<Products> getAllProducts() throws PersistenceException {
//            return null;
//        }
//
//        public int reduceInventory(Products selectedProduct) {
//            return 0;
//        }
//
//        public boolean checkIfMoneyIsEnough(BigDecimal userMoney, Products selectedProduct) throws InsufficientFundsException {
//            return false;
//        }
//
//        public boolean inventoryAvailability(BigDecimal userMoney, Products selectedProduct) throws InventoryAvailabilityException {
//            return false;
//        }
//    }
}
