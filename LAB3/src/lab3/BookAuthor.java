/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

public class BookAuthor 
{
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public BookAuthor(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = 0;
    }

    public BookAuthor(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        String result = "Book[" + name + ", ";
        for (int i = 0; i < authors.length; i++) {
            result += authors[i].toString() + (i < authors.length - 1 ? ", " : "");
        }
        result += ", price=" + price + ", qty=" + qty + "]";
        return result;
    }
}
