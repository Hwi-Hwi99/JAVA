/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

public class Circle 
{
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}

    public Circle(double radius) 
    {
        this.radius = radius;
    }
    public Circle(double radius, String color) 
    {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() { return radius; }
    public String getColor() { return color; }
    public double getArea() 
    {
        return Math.PI * radius * radius;
    }
    
    public void setRadius(double radius) 
    {
        this.radius = radius;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }
    
    @Override
    public String toString() 
    {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}
