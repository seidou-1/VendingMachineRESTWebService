/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.dao;

import DvdLibrary.dto.DvdLibrary;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author laptop
 */
public class DvdLibraryDaoTest {
    
Map <String, DvdLibrary> myDvds = new HashMap<>();

    
    public DvdLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testAddDvd() throws Exception {
        
        
         DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         
         assertEquals(1, myDvds.size());
                 
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testRemoveDvd() throws Exception {
         DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         myDvds.remove("Matrix");
         
         assertEquals(0, myDvds.size());
        
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         
         
         
         DvdLibrary myDvd2 = new DvdLibrary("cars");
         myDvd.setDirectorsName("james");
         myDvd.setMpaaRating("c+");
         myDvd.setReleaseDate("Summer 2016");
         myDvd.setStudio("disney");
         myDvd.setUserNote("It was ok");
        
           myDvds.put("cars", myDvd);
           
           assertEquals (2, myDvds.size());

    }

    /**
     * Test of editDvdInfo method, of class DvdLibraryDao.
     */
    @Test
    public void testEditDvdInfo() throws Exception {
        DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         myDvds.remove("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         
         assertEquals (1, myDvds.size());


    }

    /**
     * Test of diaplayParticularDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testDiaplayParticularDvd() throws Exception {
        DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         myDvds.get("Matrix");
         
         assertEquals (1, myDvds.size());
         
    }

    /**
     * Test of searchByTitle method, of class DvdLibraryDao.
     */
    @Test
    public void testSearchByTitle() throws Exception {
        
        DvdLibrary myDvd = new DvdLibrary("Matrix");
         
         myDvd.setDirectorsName("Robert");
         myDvd.setMpaaRating("A+");
         myDvd.setReleaseDate("Summer 2017");
         myDvd.setStudio("Pixar");
         myDvd.setUserNote("It was great");
         
         myDvds.put("Matrix", myDvd);
         myDvds.get("Matrix");
         
         assertEquals (1, myDvds.size());
        
        
    }

    
    
}
