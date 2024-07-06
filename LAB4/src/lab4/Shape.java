/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

public abstract class Shape 
{
    protected String color = "red";
    protected boolean filled = true;
        
    public Shape() {}
    public Shape(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }
    public String getColor()
    {
        return this.color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isFilled() 
    {
        return this.filled;
    }

    public void setFilled(boolean filled) 
    {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() 
    {
        return "Shape[color = " + color + ", filled = " + filled + "]";
    }
}
