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
public class CarInventorySystem {
    
    private String model;
    private int year;
    private String vinNumber;

    public CarInventorySystem(String model, int year, String vinNumber) {
        this.model = model;
        this.year = year;
        this.vinNumber = vinNumber;
    }
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    //Keeping the VIN read only so it can't be set
    
//    public void setVinNumber(String vinNumber) {
//        this.vinNumber = vinNumber;
//    }
    
    
    
}
