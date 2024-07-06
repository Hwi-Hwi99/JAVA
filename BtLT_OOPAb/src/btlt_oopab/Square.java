/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btlt_oopab;

public class Square extends Rectangle
{
    public Square() {}
    public Square(double side) 
    {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) 
    {
        super(side, side, color, filled);
    }

    public double getSide() 
    {
        return width;
    }
    public void setSide(double side) 
    {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double side) 
    {
        setSide(side);
    }

    @Override
    public void setLength(double side) 
    {
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square[Rectangle[Shape[color = this.color, filled = this.filled], this.width = side, this.length = side]";
    }
}
