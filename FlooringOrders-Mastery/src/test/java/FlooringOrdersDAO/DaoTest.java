/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersDAO;

import FlooringOrdersDTO.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author laptop
 */
public class DaoTest {
    
    /*
    Instantiate the dao by making a member field of the dao
    */
    
    private Dao createdDao;
    
    public DaoTest() throws PersistenceException {
        this.createdDao = new ProductionDaoFileImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws PersistenceException{
        /*
        Enhanced for loop to clear all elements in the hashmap
        
        Creating an ArrayList and connecting it to my existing dao
        */
            List<Order> listOfOrders = createdDao.displayAllOrders();                     

        for (Order tempBucket : listOfOrders){
//            createdDao.removeOrder(LocalDate.MAX, 0)
//            createdDao.removeOrder(tempBucket.getDate(),tempBucket.getOrderNumber());

//        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate usersDateParsed = LocalDate.parse("2018/02/11", format);

            createdDao.removeOrder(tempBucket.getOrderNumber());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of displayAllOrders method, of class Dao.
     */
    @Test
    public void testDisplayAllOrders() throws Exception {
    }

    /**
     * Test of addOrder method, of class Dao.
     */
    @Test
    public void testAddOrder() throws Exception {
         
        
        Order myOrder = new Order(1);
        
        myOrder.setArea(new BigDecimal("322"));
        myOrder.setCustomerName("crilo pillow");
        myOrder.setDate(LocalDate.now());
        myOrder.setGrandTotal(new BigDecimal("100"));
        myOrder.setLaborCost(new BigDecimal("322"));
        myOrder.setMaterialCost(new BigDecimal("200")); 
        myOrder.setProductClass("Carpet"/*myOrder.getProductClass().getProductName()*/);
        myOrder.setTaxClass("OH"); 
        myOrder.setTaxCharged(new BigDecimal("322")); 
        
        createdDao.addOrder(myOrder.getOrderNumber(), myOrder);
        
        assertEquals(1, createdDao.displayAllOrders().size()); //Always get the size
        
        //Everytime i called the displayAllOrders it reloads the elements in my hashmap
    }

    /**
     * Test of editOrder method, of class Dao.
     */
    @Test
    public void testEditOrder() {
    }

    /**
     * Test of removeOrder method, of class Dao.
     */
    @Test
    public void testRemoveOrder() throws Exception{
        //Instantiating a date object and assigning it as a variable to reuse below
//        assertEquals(0, createdDao.displayAllOrders().size()); //check that the order got added correctly


        LocalDate date = LocalDate.of(2018, 02, 12);
        
        Order myOrder = new Order(1);
        
        myOrder.setArea(new BigDecimal("322"));
        myOrder.setCustomerName("crilo pillow");
        myOrder.setDate(date);
        myOrder.setGrandTotal(new BigDecimal("100"));
        myOrder.setLaborCost(new BigDecimal("322"));
        myOrder.setMaterialCost(new BigDecimal("200")); 
        myOrder.setProductClass("Carpet"/*myOrder.getProductClass().getProductName()*/);
        myOrder.setTaxClass("OH"); 
        myOrder.setTaxCharged(new BigDecimal("322")); 
        
        createdDao.addOrder(myOrder.getOrderNumber(), myOrder); 

        createdDao.removeOrder(1);
        
        
        assertEquals(0, createdDao.displayAllOrders().size());
    }

    /**
     * Test of justSaveToFile method, of class Dao.
     */
    @Test
    public void testJustSaveToFile() {
    }

//    public class DaoImpl implements Dao {
//
//        public List<Order> displayAllOrders() throws PersistenceException {
//            return null;
//        }
//
//        public Order addOrder(int orderNumber, Order order) throws PersistenceException {
//            return null;
//        }
//
//        public List<Order> editOrder(LocalDate date, int orderNumber) {
//            return null;
//        }
//
//        public Order removeOrder(LocalDate date, int orderNumber) {
//            return null;
//        }
//
//        public void justSaveToFile() {
//        }
//    }
    
}
