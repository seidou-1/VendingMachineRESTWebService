/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.service;

import DvdLibrary.dao.DvdLibraryDao;
import DvdLibrary.dao.DvdLibraryPersistenceException;
import DvdLibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author laptop
 */
public class DvdLibraryServiceLayerImpl implements DvdLibraryServiceLayer{
    
    DvdLibraryDao dao;
    
    public DvdLibraryServiceLayerImpl (DvdLibraryDao dao){ //This is saying, this implementation will use this particular Dao
        this.dao = dao;
    }

    @Override
    public void createDvd(DvdLibrary dvd) throws DvdLibraryDuplicateNameException, DvdLibraryDataValidationException, DvdLibraryPersistenceException {
        //First check to see if there is already a Dvd with that same title
        //If so, just throw the DvdLibraryDuplicateNameException
        
        //whatever name the user inputs, go to the map and check to see if you can get that title. Meaning, if that name
        //isn't null, that means that title exists in the map already
        if (dao.diaplayParticularDvd(dvd.getTitle()) != null) { 
            throw new DvdLibraryDuplicateNameException ("ERROR: Could not create Dvd. Dvd title " + dvd.getTitle() + " already exists");  
        }
        
        /*
        And while we're here, let's also use the method i created at the very bottom 
        to also validate that the fields are filled proper. Because if it passes the above if statement (skips it),
        all the fields could still not be filled in 
   
        */
        
        validateDvdData(dvd); //validates all fields are filled in
        
        /*
        and if it passes the above two method checks, we will now persist the data to the Dao with the below method:
        */
        
        dao.addDvd(dvd.getTitle(), dvd);
        
    }

    @Override
    public List<DvdLibrary> getAllDvds() throws DvdLibraryPersistenceException {
        /*
        Since this method doesn't really have business validation logic to check,
        we'll just call the Dao to retrieve all the Dvds
        */
        return dao.getAllDvds();
    }

    @Override
    public DvdLibrary displayParticularDvd(String title) throws DvdLibraryPersistenceException {
        /*
        Also since this method doesn't really have business validation logic to check,
        we'll just call the Dao to retrieve all the Dvds
        */
        
        return dao.diaplayParticularDvd(title);
    }

    @Override
    public DvdLibrary removeDvd(String title) throws DvdLibraryPersistenceException {
        /*
        Also since this method doesn't really have business validation logic to check,
        we'll just call the Dao to retrieve all the Dvds
        */
        return dao.removeDvd(title);
    }

    @Override
    public DvdLibrary editDvdInfo(String title, DvdLibrary Dvd) throws DvdLibraryDuplicateNameException, DvdLibraryDataValidationException, DvdLibraryPersistenceException {
        
        /*
        Since the editDvdInfo method behind the scenes removes the dvd and then asks the user to add
        brand new field values (for a new dvd entry), i'm going to call the dao to remove the 
        respective dvd title passed by the user
        */
            dao.removeDvd(title);
            
            if (dao.diaplayParticularDvd(Dvd.getTitle()) != null) { 
            throw new DvdLibraryDuplicateNameException ("ERROR: Could not create Dvd. Dvd title " + Dvd.getTitle() + " already exists");  
        }
            
        /*
        The dvd should be removed at this point so then i'm just going to do another check to ensure the user inputted all the fields    
        */
       
//        validateDvdData(Dvd);
        
//        if (dao.editDvdInfo(dao.diaplayParticularDvd(title))!=null){
//        
//        if (dao.editDvdInfo(Dvd.getTitle(), Dvd != null)) { 
//            throw new DvdLibraryDuplicateNameException ("ERROR: Could not create Dvd. Dvd title " + dvd.getTitle() + " already exists");  
//        }
            
            validateDvdData(Dvd); //validates all fields are filled in
        
  
            return dao.addDvd(Dvd.getTitle(), Dvd);
            
        
    }
    
    private void validateDvdData(DvdLibrary dvd) throws DvdLibraryDataValidationException {
        
        //In this method i'm not using the unique identifier "Title" in the if statements. I'll use the unique identifier in a different method
        if (dvd.getDirectorsName()==null||dvd.getDirectorsName().trim().length() == 0
          ||dvd.getMpaaRating()==null||dvd.getMpaaRating().trim().length() == 0
          ||dvd.getReleaseDate()==null||dvd.getReleaseDate().trim().length()== 0
          ||dvd.getStudio()==null||dvd.getStudio().trim().length() == 0
          ||dvd.getUserNote()==null||dvd.getUserNote().trim().length() == 0) {
            
            throw new DvdLibraryDataValidationException ("ERROR: All fields [Director's name, MpaaRating, Release Date, Studio, and User Note are required");
            
        }
        
    }
    
    
    
}
