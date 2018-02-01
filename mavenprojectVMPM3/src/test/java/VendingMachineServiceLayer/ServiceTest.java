/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineServiceLayer;

import VendingMachineDao.Dao;
import VendingMachineDao.PersistenceException;
import VendingMachineDao.VendingMachineAuditDao;
import VendingMachineDao.VendingMachineAuditDaoStubImpl;
import VendingMachineDao.VendingMachineDaoStubImpl;
import VendingMachineDto.Products;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author laptop
 */
public class ServiceTest {
    
    private Service createdService;
    
    /*
    Create a constructor below to assign the dao to the VendingMachineDaoStubImpl created 
    in the step before
    */
    
    public ServiceTest() {
      Dao createdDao = new VendingMachineDaoStubImpl();
      VendingMachineAuditDao createdAuditDao = new VendingMachineAuditDaoStubImpl();
      
      createdService = new ServiceImpl(createdDao, createdAuditDao);
      
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProduct method, of class Service.
     */
    @Test
    public void testGetProduct() throws Exception {
    }

    /**
     * Test of getAllProducts method, of class Service.
     */
    @Test
    public void testGetAllProducts() throws Exception {
    }

    /**
     * Test of reduceInventory method, of class Service.
     */
    @Test
    public void testReduceInventory() {
    }

    /**
     * Test of checkIfMoneyIsEnough method, of class Service.
     */
    @Test
    public void testCheckIfMoneyIsEnough() throws Exception {
    }

    /**
     * Test of inventoryAvailability method, of class Service.
     */
    @Test
    public void testInventoryAvailability() throws Exception {
    }

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
