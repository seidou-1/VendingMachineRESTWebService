/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.ui;

import DvdLibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author laptop
 */
public class DvdLibraryView {

    /*Since UserIO is an interface, you can't instantiate an interface. 
    So i have to instantiate the implementing class instead... UserIOConsoleImpl();    
    
    UserIO io = new UserIOConsoleImpl();
    
    But now I'm removing these two hard coded references below so i can use dependency injection instead: 
    */
    private UserIO io;
    
    public DvdLibraryView(UserIO io){
        this.io = io; //this means the paramaters are going to be mapped to the view class declaration above
    
    }
    
    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Add a DVD to collection");
        io.print("2. Remove a DVD from collection");
        io.print("3. Edit information from a DVD in the collection");
        io.print("4. List the DVD's in the collection");
        io.print("5. Display information for a particular DVD");
        io.print("6. Search for a DVD by title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);

    }

    /*
     private String title;
    private Double mpaaRating;
    private String releaseDate;
    private String directorsName;
    private String studio;
    private String userNote;
     */
    public DvdLibrary getNewDvdInfo() {
        String title = io.readString("Enter Title");
        String releaseDate = io.readString("Enter release date");
        String directorsName = io.readString("Enter Director's name");
        String mpaaRating = io.readString("Enter Rating");
        String studio = io.readString("Enter Studio");
        String userNote = io.readString("userNote");
        DvdLibrary currentDvd = new DvdLibrary(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setStudio(studio);
        currentDvd.setUserNote(userNote);
        return currentDvd;

    }

    public void diaplayCreateDvdEntry() {
        io.print("**** Add DVD ****");
    }

    public void displayCreateDvdEntrySuccessful() {
        io.readString("DVD entry successfully entered. Please hit enter to continue");
    }

    public void displayAllDvds(List<DvdLibrary> Dvd) {

        Dvd.forEach (currentDvdLibrary -> {//super enhanced for each
            io.print(currentDvdLibrary.getTitle() + " : "
                    + currentDvdLibrary.getDirectorsName() + " : "
                    + currentDvdLibrary.getMpaaRating() + " : "
                    + currentDvdLibrary.getReleaseDate() + " : "
                    + currentDvdLibrary.getStudio() + " : "
                    + currentDvdLibrary.getUserNote());
        });

        io.print("Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayParticularDvdBanner() {
        io.print("=== Display Particular DVD ===");
    }

    public String getDvdByChoice() {
        return io.readString("Which DVD title would you like to search for?");

    }

    public void displayParticularDvd(DvdLibrary currentDvdLibrary) {
        if (currentDvdLibrary != null) {
            io.print(currentDvdLibrary.getTitle() + " : "
                    + currentDvdLibrary.getDirectorsName() + " : "
                    + currentDvdLibrary.getMpaaRating() + " : "
                    + currentDvdLibrary.getReleaseDate() + " : "
                    + currentDvdLibrary.getStudio() + " : "
                    + currentDvdLibrary.getUserNote());

        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayDvdRemovedSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayEditBanner() {
        io.print("=== Edit DVD ===");
    }

    public String whichDvdToEdit() {
        return io.readString("Which Dvd would you like to edit? Search by title");
    }

    public void displayEditBannerSuccess() {
        io.print("DVD successfully Edited.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMessage){
        io.print("=== ERROR ===");
        io.print(errorMessage);
    }

}
