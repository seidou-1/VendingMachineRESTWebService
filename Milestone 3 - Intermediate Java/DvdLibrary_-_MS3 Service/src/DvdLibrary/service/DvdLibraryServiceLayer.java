/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.service;

import DvdLibrary.dao.DvdLibraryPersistenceException;
import DvdLibrary.dto.DvdLibrary;
import java.util.List;

/**
 *
 * @author laptop
 */
public interface DvdLibraryServiceLayer {
    
    void createDvd (DvdLibrary dvd) throws
            DvdLibraryDuplicateNameException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
    
    List<DvdLibrary> getAllDvds() throws
            DvdLibraryPersistenceException; //This is a pass through method because there really isn't any business logic. 
            
    
    DvdLibrary displayParticularDvd (DvdLibrary dvd) throws
            DvdLibraryPersistenceException;
    
    DvdLibrary removeDvd (String title) throws
            DvdLibraryPersistenceException;
    
    DvdLibrary editDvdInfo (String title, DvdLibrary Dvd) throws //This IS NOT a pass through method because i'm removing and creating
            DvdLibraryDuplicateNameException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException;
}
