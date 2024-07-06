/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

public abstract class Animal 
{
    private String name;

    public Animal(String name) 
    {
        this.name = name;
    }
    public String getName() 
    {
    return name;
    }

    public abstract void greets();
}
