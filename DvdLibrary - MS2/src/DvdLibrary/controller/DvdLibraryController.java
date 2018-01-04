/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.controller;

import DvdLibrary.dao.DvdLibraryDao;
import static DvdLibrary.dao.DvdLibraryDao.myDao;
import DvdLibrary.dao.DvdLibraryDaoException;
import DvdLibrary.dao.DvdLibraryDaoFileImpl;
import DvdLibrary.dto.DvdLibrary;
import DvdLibrary.ui.DvdLibraryView;
import DvdLibrary.ui.UserIO;
import DvdLibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author laptop
 */
public class DvdLibraryController {

//    private UserIO io = new UserIOConsoleImpl();
    /*      Since UserIOConsoleImpl implements UserIO,
            UserIOConsoleImpl becomes a child of the UserIO class. And so i can create a UserIO object
            and call all of the implemented methods from UserIOConsoleImpl class, such as ".print"
    
            But since all references to UserIO are gone from the controller, I removed the UserIO member field.
     */

    /*
    
    I'm removing these two hard coded references below so i can use dependency injection instead
    DvdLibraryView view = new DvdLibraryView();

    DvdLibraryDao myDao = new DvdLibraryDaoFileImpl(); //Dao is a child and DaoFileImpl
    
    */
    
    DvdLibraryDao myDao;
    DvdLibraryView view;
            
    public DvdLibraryController(DvdLibraryDao myDao, DvdLibraryView view){ //constructor
        this.myDao= myDao; //this means the paramaters are going to be mapped to the myDao class declaration above
        this.view = view; //this means the paramaters are going to be mapped to the view class declaration above
    }
    
    public void run() {
        /*
                The run method will ask for the user selection and then route the request 
                to a private controller method.  These private controller methods 
                will then orchestrate the work required to fulfill the user’s requested action.
         */
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            /*
            Here i added a try-catch block to the controller’s run method so 
            the code can react to the DvdLibraryDaoExceptions that potentially 
            get thrown by the user's selection.  When an exception is encountered, 
            it’ll just tell the "view" to print out the error message.
            */
            
        outter:
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createDvd();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    displayDvds();
                    break;
                case 5:
                    viewSpecificDvd();
                    break;
                case 6:
                    viewSpecificDvd();
                    break;
                case 7:
                    exitMessage();
                    //Exit application
                    keepGoing = false;
                    break outter;
                default:
                    unknownCommand();
            }

            
        }
//            exitMessage();
//        io.print("GOOD BYE");
    } catch (DvdLibraryDaoException e){
        view.displayErrorMessage(e.getMessage());
    }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
        /* created this method that will get called to get the menuSelection in the run method of this class 
                
                Then i made a call to printlnMenuAndGetSelection() on the view member which got instantiated from the DvdLibraryView class
         */
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.diaplayCreateDvdEntry();
        DvdLibrary myDvdLibrary = view.getNewDvdInfo();
        myDao.addDvd(myDvdLibrary.getTitle(), myDvdLibrary);
        view.displayCreateDvdEntrySuccessful();
    
    }

    private void displayDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DvdLibrary> releaseDate = myDao.getAllDvds();
        view.displayAllDvds(releaseDate);
    }

    private void viewSpecificDvd() throws DvdLibraryDaoException {
        view.displayParticularDvdBanner();
        String specificDvd = view.getDvdByChoice();
        DvdLibrary Dvd = myDao.diaplayParticularDvd(specificDvd);
        view.displayParticularDvd(Dvd);
    }

    private void removeDVD() throws DvdLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDvdByChoice();
        myDao.removeDvd(title);
        view.displayDvdRemovedSuccessBanner();
    }

    public void editDvd() throws DvdLibraryDaoException {
        view.displayEditBanner();
        String specificDvd = view.whichDvdToEdit();
        myDao.removeDvd(specificDvd);
        DvdLibrary myDvdLibrary = view.getNewDvdInfo();
        myDao.addDvd(myDvdLibrary.getTitle(), myDvdLibrary);
        view.displayEditBannerSuccess();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
