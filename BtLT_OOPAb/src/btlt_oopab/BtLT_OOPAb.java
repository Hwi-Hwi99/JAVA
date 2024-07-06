/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package btlt_oopab;

/**
 *
 * @author ddhmac
 */
public class BtLT_OOPAb {

    public static void main(String[] args) 
    {
        // Testing Circle
        Circle circle = new Circle(5.0, "blue", false);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Testing ResizableCircle
        ResizableCircle resizableCircle = new ResizableCircle(5.0);
        System.out.println(resizableCircle);
        resizableCircle.resize(50); // resize by 50%
        System.out.println("After resizing: " + resizableCircle);
        System.out.println("Area: " + resizableCircle.getArea());
        System.out.println("Perimeter: " + resizableCircle.getPerimeter());

        // Testing Rectangle
        Rectangle rectangle = new Rectangle(2.0, 3.0, "green", true);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Testing Square
        Square square = new Square(4.0, "yellow", false);
        System.out.println(square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
    }
}
