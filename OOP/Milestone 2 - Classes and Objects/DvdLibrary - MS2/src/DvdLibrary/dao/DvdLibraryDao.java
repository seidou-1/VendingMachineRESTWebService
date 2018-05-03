/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.dao;

import DvdLibrary.dto.DvdLibrary;
import java.util.List;
import java.util.Set;

/**
 *
 * @author laptop
 */
public interface DvdLibraryDao {
    
    DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
    
        /*
    Title
Release date
MPAA rating
Director's name
Studio
User rating or note (allows user to enter additional information, e.g., "Good family movie")
     */
    
    //Add a Dvd to the collection
    DvdLibrary addDvd (String title, DvdLibrary Dvd)//This takes a type DvdLibrary with a variable that can be anything
            
            throws DvdLibraryDaoException;
    
    //Allow the user to remove a DVD from the collection
    DvdLibrary removeDvd (String title)
            throws DvdLibraryDaoException;

    //Allow the user to list the DVDs in the collection
    List <DvdLibrary> getAllDvds()
            throws DvdLibraryDaoException;
    
    //Allow the user to edit the information for an existing DVD in the collection
    //I think the implementation should be  HashMap<String, Integer> populations = new HashMap<>();
    //And then populations.put("USA", 200000000);
    DvdLibrary editDvdInfo (String title, DvdLibrary Dvd)
            throws DvdLibraryDaoException;

    //Allow the user to display the information for a particular DVD
    //I think i have to use HashMap<String, Integer> populations = new HashMap<>();
    
        /*
        // get the Set of keys from the map
        Set<String> keys = populations.keySet();

        // print the keys and associated values to the screen
        for (String k : keys) {
        System.out.println("The population of " + k + " is " + populations.get(k));
        */
    DvdLibrary diaplayParticularDvd(String title)
            throws DvdLibraryDaoException;
    
    //Allow the user to search for a DVD by title
    //I think i have to use the same as above
    DvdLibrary searchByTitle(String title)
            throws DvdLibraryDaoException;
    
    //Load the DVD library from a file
    
    
    /*
  


Save the DVD library back to the file when the program completes
Allows the user to add, edit, or delete many DVDs in one session
    */
    
}
