/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _VendingMachine;

import VendingMachineController.Controller;
import VendingMachineDao.PersistenceException;
import VendingMachineDao.VendingMachineAuditDao;
import VendingMachineDao.VendingMachineAuditDaoFileImpl;
import VendingMachineServiceLayer.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author laptop
 */
public class App {

    public static void main(String[] args) throws PersistenceException, InventoryAvailabilityException, InsufficientFundsException, DataValidationException {

//        //Using this particular implementation of the Dao 
//       Dao hashMap = new DaoFileImpl();
//       
//       //Using this particular implementation of the userIO
//       UserIO userIO = new UserIOImpl();
//       
//       //Passing this particular userIO impl to the view
//       View theView = new View(userIO);
//       
//       //Adding the service layer
//       Service theService = new ServiceImpl(hashMap);
//       
//       Change theChange = new Change();
//       
//       //Also instantiating the controller
//       Controller theController = new Controller (theService, theView, theChange);
//       
//       theController.run();

    VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller
                = ctx.getBean("controller", Controller.class);
        controller.run();

    }

}
