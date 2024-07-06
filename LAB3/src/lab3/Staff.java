/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

public class Staff extends Person 
{
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) 
    {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() { return school; }
    public double getPay() { return pay; }
    
    public void setSchool(String school) 
    {
        this.school = school;
    }
    public void setPay(double pay) 
    {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + ", school = " + school + ", pay = " + pay + "]";
    }
}

