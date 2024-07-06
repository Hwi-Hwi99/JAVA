/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

public class Dog extends Animal 
{
    public Dog(String name) 
    {
        super(name);
    }

    @Override
    public void greets() 
    {
        System.out.println(getName() + " says: Woof");
    }

    public void greets(Dog another) 
    {
        System.out.println(getName() + " says: Woooof to " + another.getName());
    }
}
