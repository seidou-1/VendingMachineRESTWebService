/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringOrders;

import FlooringOrdersController.Controller;
import FlooringOrdersDAO.Configuration;
import FlooringOrdersDAO.PersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author laptop
 */
public class App {

    public static void main(String[] args) throws PersistenceException {

//        UserIO myUserIO = new UserIOImpl();
//
//        View myView = new View(myUserIO);//The view takes a particular IOimplementation
//
//        Dao myDao = new DaoFileImpl();
//        
//        FlooringOrderAuditDao myAuditDao = new FlooringOrderAuditDaoFileImpl();
//
//        Service myService = new ServiceImpl(myDao, myAuditDao);//This takes a particular Dao implmenetation
//
//        Controller myController = new Controller(myView, myService); //This constructor takes a view and a service
//
//        myController.run();

        String configurationType = Configuration.getMode();//Since this is a static method, i don't need to instantiate the class to use the getMode method
        //I can just call the class directly
        
        System.out.println("\n"+configurationType + "\n");

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Controller controller = 
           ctx.getBean(configurationType+"Controller", Controller.class);
        
        controller.run();

    }

}
