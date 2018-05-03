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
public class BookLibraryCataloging {
    
    private String retailer;
    private int placementNumber;
    
    public BookLibraryCataloging(){ //Constructor
        
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public int getPlacementNumber() {
        return placementNumber;
    }

    public void setPlacementNumber(int placementNumber) {
        this.placementNumber = placementNumber;
    }
    
    
    
}
