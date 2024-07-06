/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

public class Invoice 
{
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) 
    {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }
    
    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public double getAmount() { return amount; }
    
    public int getCustomerId() 
    {
        return customer.getId();
    }
    public String getCustomerName() 
    {
        return customer.getName();
    }
    
    public double getAmountAfterDiscount() 
    {
        return amount - (amount * customer.getDiscount() / 100.0);
    }
    
    public void setCustomer(Customer customer) 
    {
        this.customer = customer;
    }
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    @Override
    public String toString() 
    {
        return "Invoice[id = " + id + ", customer = " + customer.toString() + ", amount = " + amount + "]";
    }
}

