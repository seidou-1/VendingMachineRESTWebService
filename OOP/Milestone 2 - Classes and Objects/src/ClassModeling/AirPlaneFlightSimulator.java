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
public class AirPlaneFlightSimulator {
    
    private String pilotName;
    private String pilotRank;
    private int minSpeed;
    private int maxSpeed;

    public AirPlaneFlightSimulator(String pilotName, String pilotRank) {
        this.pilotName = pilotName;
        this.pilotRank = pilotRank;
    }

    
    
    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(String pilotRank) {
        this.pilotRank = pilotRank;
    }

    public int getMinSpeed() {
        return minSpeed;
    }
    
    //keeping min and max sped to read only
    

//    public void setMinSpeed(int minSpeed) {
//        this.minSpeed = minSpeed;
//    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

//    public void setMaxSpeed(int maxSpeed) {
//        this.maxSpeed = maxSpeed;
//    }
    
    
    
}
