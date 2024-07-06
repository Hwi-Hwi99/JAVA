/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

public class Cylinder extends Circle 
{
    private double height = 1.0;

    public Cylinder() { super(); }
    public Cylinder(double radius) 
    {
        super(radius);
    }

    public Cylinder(double radius, double height) 
    {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) 
    {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() { return height; }
    public double getVolume() 
    {
        return getArea() * height;
    }
    
    public void setHeight(double height) 
    {
        this.height = height;
    }
    
    @Override
    public String toString() 
    {
        return "Cylinder[height=" + height + ", " + super.toString() + "]";
    }
}