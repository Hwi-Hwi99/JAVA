/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

public class BigDog extends Dog 
{
    public BigDog(String name) 
    {
        super(name);
    }

    @Override
    public void greets() 
    {
        System.out.println(getName() + " says: Wooow");
    }

    public void greets(Dog another) 
    {
        System.out.println(getName() + " says: Woooooow to " + another.getName());
    }

    public void greets(BigDog another) 
    {
        System.out.println(getName() + " says: Wooo000000w to " + another.getName());
    }
}
