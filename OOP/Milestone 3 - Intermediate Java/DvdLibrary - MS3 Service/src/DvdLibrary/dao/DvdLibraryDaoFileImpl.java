/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.dao;

import DvdLibrary.dto.DvdLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author laptop
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    //creating these two variable sto serve as constants i'll use for marshalling-unmarshalling
    public static final String ROSTER_FILE = "collection.txt";
    public static final String DELIMITER = "::";

    private Map<String, DvdLibrary> myDvdLibrary = new HashMap<>();//This hashmap will be used to manipulate the dvd objects

    @Override
    public DvdLibrary addDvd(String title, DvdLibrary Dvd)  //DvdLibrary is actually just one Dvd and Dvd is the actual library
        
        throws DvdLibraryPersistenceException{
        
        DvdLibrary newDvd = myDvdLibrary.put(title, Dvd); //This creates an instance of a dvd and stores it in the HashMap
        writeCollection();
        
        return newDvd;
    }

    @Override
    public DvdLibrary removeDvd(String title) 
            throws DvdLibraryPersistenceException{
        DvdLibrary removedDvd = myDvdLibrary.remove(title);
        writeCollection();
        return removedDvd;
    }

    @Override
    public List<DvdLibrary> getAllDvds() 
            throws DvdLibraryPersistenceException {
        loadCollection();
        return new ArrayList<DvdLibrary>(myDvdLibrary.values());
    }

    @Override
    public DvdLibrary editDvdInfo(String title, DvdLibrary Dvd) 
            throws DvdLibraryPersistenceException{
        myDvdLibrary.remove(title);
        DvdLibrary newDvd = myDvdLibrary.put(title, Dvd);
        writeCollection();
        return newDvd;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DvdLibrary diaplayParticularDvd(String title) 
            throws DvdLibraryPersistenceException{
        loadCollection();
        return myDvdLibrary.get(title);

    }

    @Override
    public DvdLibrary searchByTitle(String title) 
        
        throws DvdLibraryPersistenceException{
        loadCollection();
        return myDvdLibrary.get(title);
        }
        
    

    private void loadCollection() throws DvdLibraryPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryPersistenceException(
                    "Could not load DVD collection data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on the DELIMITER

        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of DVDs
            // Ia m using the "title" which is currentTokens[0] as the map key for the DVD object.
            // I also have to pass the "title" into the DVD constructor

            DvdLibrary currentDvd = new DvdLibrary(currentTokens[0]);
            // Setting the remaining vlaues on currentStudent manually below:

            currentDvd.setDirectorsName(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setReleaseDate(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserNote(currentTokens[5]);

            // Put currentDvd into the map using "title" as the key
            myDvdLibrary.put(currentDvd.getTitle(), currentDvd);

        }
        // close scanner
        scanner.close();
    }

    private void writeCollection() throws DvdLibraryPersistenceException {

        /*
        
          * Writes all students in the roster out to a ROSTER_FILE. See loadCollection
          * for file format.
          * @throws ClassRosterDaoException if an error occurs writing to the file
        
        This method writes the student information from memory to a file. It follows 
        the Data Marshaling and Unmarshaling algorithm.
        
        Here i am not handling the IOException - but translating it to an application 
        specific exception and then simple throwing it (i.e. 'reporting' it) 
        to the code that called it.  It is the responsibility of the calling code to 
        handle any errors that occur.
         
         */
        
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryPersistenceException(
                    "Could not save student data.", e);
        }

        /*
          Write out the Dvd objects to the roster file.
        
         I could just grab the student map, get the Collection of DVDs and iterate over them 
         but since i already created a method that gets a List of DVDs i'll just reuse the List.
         */
        List<DvdLibrary> myDvdLibrary = this.getAllDvds();

        for (DvdLibrary currentDvd : myDvdLibrary) {
            // write the DVD object to the file
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserNote());

            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
