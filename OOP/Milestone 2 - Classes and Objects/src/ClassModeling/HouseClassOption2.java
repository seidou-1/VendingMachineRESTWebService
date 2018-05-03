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
public class HouseClassOption2 {
    
    private int sqFeet;
    private int perimeter;
    private String landscape;
    
    HouseClassOption2(){ //This is the constructor
        
    }

    public int getSqFeet() {
        return sqFeet;
    }

    public void setSqFeet(int sqFeet) {
        this.sqFeet = sqFeet;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }
    
    public void mapRendering (){
        System.out.println("Your perimeter is: " + perimeter + " sq feet " + " and current landscape is " + landscape + " with a sqFeet of " + sqFeet + " sq feet");
    }
  
    
}
