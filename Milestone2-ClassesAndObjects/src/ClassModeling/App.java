/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

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
        
        //*****************For House Option 1*************************
        HouseClassOption1 myCrib = new HouseClassOption1();/*This instantiates the HouseClassOption1 class thereby
        calling the default constructor. This step is NECESSARY */
        
        /*Option B: with the default constructor, in order to set values, i have to invoke the setter methods*/
        
        myCrib.setTerrain("riggid ");
        myCrib.setLatitude(" 38.518124 ");
        myCrib.setLongitude(" -112.050844 ");       
        myCrib.coordinates();
 
        //************************************************************
        
        //*****************For House Option 2*************************
        
        
        HouseClassOption2 mySecondCrib = new HouseClassOption2(); //Instantiating HouseClassOption2
        
        mySecondCrib.setLandscape("Very Patchy");
        mySecondCrib.setPerimeter(2323);
        mySecondCrib.setSqFeet(2500);
        
        mySecondCrib.mapRendering();
        //************************************************************
        
        //*****************For Airplane Option 1**********************
        
        AirPlaneAirTraffic myFirstAirplane = new AirPlaneAirTraffic();
        
        myFirstAirplane.setCarrier("Delta");
        myFirstAirplane.setManufacturer("Boeing");
        
        //************************************************************
        
        //*****************For Airplane Option 2**********************
        
        AirPlaneFlightSimulator mySecondAirplane = new AirPlaneFlightSimulator("Bob", "Leutenant");
        
        mySecondAirplane.getPilotName();
        mySecondAirplane.getPilotRank();
        
        //************************************************************
        
        //******************For Car Inventory ************************
        
        CarInventorySystem myFirstWhip = new CarInventorySystem("Challenger", 2018, "DSKJL2HK");
        
        myFirstWhip.getModel();
        myFirstWhip.getVinNumber();
        myFirstWhip.getYear();
        
        //************************************************************
        
        //******************For Car Video Game ************************
        CarVideoGame mySecondWhip = new CarVideoGame();
        
        mySecondWhip.setGame("Rockstar Games");
        mySecondWhip.setPrimaryWeapon("Bazooka");
        mySecondWhip.getGame();
        mySecondWhip.getTopSpeed();
        
        //************************************************************
         
        
        //******************For Ice Cream************************
        
        //************************************************************
    }
    
}
