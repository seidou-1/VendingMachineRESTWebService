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
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Square mySquare = new Square(5);         
        mySquare.setShapeColor("blue");
        System.out.println("The perimeter of the square is " + mySquare.perimeter() + " with an area of " + mySquare.area() + " and the color is " + mySquare.getShapeColor());
        
        Circle myCircle = new Circle(5);
        myCircle.setShapeColor(" orange ");
        System.out.println(" The perimeter of the circle is " + myCircle.perimeter() + " with an area of " + myCircle.area() + " and the color is" + myCircle.getShapeColor());


    }
    
}
