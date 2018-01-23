/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineDao;

import VendingMachineDto.Products;
import java.util.List;
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
    Initialize the Dao to the implementation
    */
    
    Dao theDao = new DaoFileImpl();
    
    public DaoTest() {
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
     * Test of getProduct method, of class Dao.
     */
    @Test
    public void testGetProduct() throws Exception {
        
        
    }

    /**
     * Test of getAllProducts method, of class Dao.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        
        
        theDao.getAllProducts();
        
        assertEquals(3, theDao.getAllProducts().size());
        
            
        }
    }

//    public class DaoImpl implements Dao {
//
//        public Products getProduct(String productID) throws PersistenceException {
//            return null;
//        }
//
//        public List<Products> getAllProducts() throws PersistenceException {
//            return null;
//        }
//    }
    

