/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine;

import VendingMachine.Controller.VendingMachineController;
import VendingMachine.Dao.VendingMachineDao;
import VendingMachine.Dao.VendingMachineDaoImpl;
import VendingMachine.Ui.UserIO;
import VendingMachine.Ui.UserIOConsoleImpl;
import VendingMachine.Ui.VendingMachineView;

/**
 *
 * @author laptop
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UserIO myIO = new UserIOConsoleImpl();//Instantiating a UserIO implementation type of file
        VendingMachineView myView = new VendingMachineView(myIO); //the view will use the file implementation above
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        
        VendingMachineController myController = new VendingMachineController (myDao, myView);

        
//        VendingMachineDao myDaoImpl = new VendingMachineDaoFileImpl(myView, myDaoImpl);
        
        
        myController.run();
    }
    
}
