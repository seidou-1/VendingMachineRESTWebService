/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShapesAndPerimeters;

/**
 *
 * @author laptop
 */
public abstract class Shape {
     
    //instance variable
    protected String shapeColor; //or should this be private String shapeColor?

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double area(); //This is the template. I have to extend this and make changes to it in my other shapes.   
    
    public abstract double perimeter();

    
}
