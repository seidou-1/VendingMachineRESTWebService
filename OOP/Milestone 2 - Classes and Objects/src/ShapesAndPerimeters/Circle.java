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
public class Circle extends Shape {
    
    protected double radius;

    public Circle(double radius) { //Constructor taking in a double
        this.radius = radius;
    }
    
 

    @Override
    public double area() {
    //    
    return (Math.PI * Math.pow(radius, 2)); //This returns radius to the power of 2. Meaning radius squared.
            }
 

    @Override
    public double perimeter() {
    //    
    return (2*Math.PI) * radius; //Math.PI is the java way of writing PI. The formula for perimiter of  circle is as such.
    
    }
}
