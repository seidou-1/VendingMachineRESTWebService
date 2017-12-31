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
public class Square extends Shape {
     
//I am extending the Shape class.
//Whenever you have an abstract class like Shape that has abstract methods like get perimeter and get area,
//I have to implement those abstract methods manually because it's a CONTRACT. Either that or my square class has to also be abstract
    
//Here i am declaring my local variables:
    protected double side;

    public Square (double side) { //Constructor taking in a double
        this.side = side;
    }
 
//Now i am implementing the perimeter and area methods:
    
    @Override
    public double perimeter(){
        return (4*side); //Implementing the perimeter method for a square
    }

    @Override
    public double area() { 
        return (side * side); //Implementing the area method for a square
    }
   
}

    
//Truth be told i could've also used this type of Constructor:
//    public Square(){
//        this.side = 22;
//        
//    }
