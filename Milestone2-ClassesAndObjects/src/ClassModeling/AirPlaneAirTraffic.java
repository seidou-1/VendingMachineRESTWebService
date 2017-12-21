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
public class AirPlaneAirTraffic {
    
    private int topSpeed;
    private String manufacturer;
    private String carrier;

    public AirPlaneAirTraffic() {
    }
        
    
    
    public int getTopSpeed() {
    return topSpeed;
    }

    //I'm going to set topSpeed as read only so that when the object is built, it can't be manipulated
    
//    public void setTopSpeed(int topSpeed) {
//        this.topSpeed = topSpeed;
//    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
    
    
}


