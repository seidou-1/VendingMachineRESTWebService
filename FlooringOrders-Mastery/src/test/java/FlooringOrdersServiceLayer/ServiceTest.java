/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrdersServiceLayer;

import org.junit.After;
import org.junit.AfterClass;
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

    /*
    The service layer test relies on the auditDaoStubImpl so i have to
    instantiate an auditDao of flavor auditDaoStubImpl
     */
    private Service myService;
    
    public ServiceTest(){
//        Dao myDao = new FlooringOrderDaoStubImpl(); //The Dao will be of flavor stub Dao
//        FlooringOrderAuditDao myAuditDao = new FlooringOrderAuditDaoStubImpl(); //The Audit will be of flavor stubImpl
//
//        myService = new ServiceImpl(myDao, myAuditDao); //Service layer will be of flavor these two

        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    
        myService = 
        ctx.getBean("Service", ServiceImpl.class);
        //All dependencies are now handles in the XML
    }
 

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        /*
        Levelset to get some data in the hashmap
        */
//       LocalDate date = LocalDate.of(2018, 02, 12);
//
//        Order onlyOrder = new Order(1);
//        
//        
//        onlyOrder.setArea(new BigDecimal("322"));
//        onlyOrder.setCustomerName("crilo pillow");
//        onlyOrder.setDate(date);
//        onlyOrder.setGrandTotal(new BigDecimal("100"));
//        onlyOrder.setLaborCost(new BigDecimal("322"));
//        onlyOrder.setMaterialCost(new BigDecimal("200")); 
//        onlyOrder.setProductClass("Carpet"/*onlyOrder.getProductClass().getProductName()*/);
//        onlyOrder.setTaxClass("OH"); 
//        onlyOrder.setTaxCharged(new BigDecimal("322")); 
//        
//        myService.addOrder(onlyOrder);
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of displayAllOrders method, of class Service.
     */
    @Test
    public void testDisplayAllOrders() throws Exception {
    }

    /**
     * Test of addOrder method, of class Service.
     */
    @Test
    public void testAddOrder() throws Exception {
    }

    /**
     * Test of editOrder method, of class Service.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of removeOrder method, of class Service.
     */
    @Test
    public void testRemoveOrder() throws Exception {
    }

    /**
     * Test of getOrderNumber method, of class Service.
     */
    @Test
    public void testGetOrderNumber() throws Exception {
    }

    /**
     * Test of checkIfOrderNumberExists method, of class Service.
     */
    @Test
    public void testCheckIfOrderNumberExists() throws Exception {
        
        /*
        retrieve an order where the ID is something different from the hashmap
        */
        
//        LocalDate date = LocalDate.of(2018, 02, 12);
//
//        Order onlyOrder = new Order(1);
//        
//        
//        onlyOrder.setArea(new BigDecimal("322"));
//        onlyOrder.setCustomerName("crilo pillow");
//        onlyOrder.setDate(date);
//        onlyOrder.setGrandTotal(new BigDecimal("100"));
//        onlyOrder.setLaborCost(new BigDecimal("322"));
//        onlyOrder.setMaterialCost(new BigDecimal("200")); 
//        onlyOrder.setProductClass("Carpet"/*onlyOrder.getProductClass().getProductName()*/);
//        onlyOrder.setTaxClass("OH"); 
//        onlyOrder.setTaxCharged(new BigDecimal("322")); 
//        
//        myService.addOrder(onlyOrder);

//        Order myOrder = myService.
//        
//        if (onlyOrder.getOrderNumber()!= null){
//            
//        }
        
        /*
        ...Check this method...
        
        */
        
    }

    /**
     * Test of checkIfOrderDateExists method, of class Service.
     */
    @Test
    public void testCheckIfOrderDateExists() throws Exception {
    }

    /**
     * Test of validateOrderData method, of class Service.
     */
    @Test
    public void testValidateOrderData() throws Exception {
    }

    /**
     * Test of justSaveToFile method, of class Service.
     */
    @Test
    public void testJustSaveToFile() throws Exception {
    } 

}
