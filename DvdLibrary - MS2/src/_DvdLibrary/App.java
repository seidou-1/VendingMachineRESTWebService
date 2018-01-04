/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _DvdLibrary;

import DvdLibrary.controller.DvdLibraryController;
import DvdLibrary.dao.DvdLibraryDao;
import DvdLibrary.dao.DvdLibraryDaoFileImpl;
import DvdLibrary.ui.DvdLibraryView;
import DvdLibrary.ui.UserIO;
import DvdLibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author laptop
 */
public class App {

    public static void main(String[] args) {
        //DvdLibraryController myController = new DvdLibraryController();
        
        /*
            I'm using dependency injection here so i removed the hard coded reference above
        */

        
        UserIO myUserIO = new UserIOConsoleImpl(); //creating a UserIOConsoleImpl object and assigning it to the variable myUserIO

        DvdLibraryView viewsFromThe6 = new DvdLibraryView(myUserIO); //Declared and instantiated a DvdLibraryView object, passing the myUserIO variable created above into the constructor.
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl(); //Declared a DvdLibraryDao variable called myDao and initialized it with a DvdLibraryDaoFileImpl reference.
        
        DvdLibraryController myController = new DvdLibraryController(myDao,viewsFromThe6);
 
        myController.run();
       
    }

}
