/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

public class Cat extends Animal 
{
    public Cat(String name) 
    {
        super(name);
    }

    @Override
    public void greets() 
    {
        System.out.println(getName() + " says: Meow");
    }
}
