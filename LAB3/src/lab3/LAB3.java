/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3;

public class LAB3 
{
    public static void main(String[] args) 
    {
        System.out.println("TEST 1: BOOK - AUTHOR:");
        System.out.println("Book - Author:");
        Author author = new Author("Tan Ah Teck", "teck@nowhere.com", 'M');
        Book book = new Book("Java for dummies", author, 19.99, 10);
        System.out.println(book);
        System.out.println("");
        System.out.println("Book - Authors:");
        Author author1 = new Author("Tan Ah Teck", "teck@nowhere.com", 'M');
        Author author2 = new Author("John Doe", "john@nowhere.com", 'M');
        Author[] authors = {author1, author2};
        BookAuthor bookauthor = new BookAuthor("Java for dummies", authors, 19.99, 10);
        System.out.println(bookauthor);
        
        System.out.println("-------------------------------------------------");
        System.out.println("TEST 2: CUSTOMER - INVOICE:");
        //Create Customer
        Customer customer = new Customer(1, "John Doe", 10);
        //Create Invoice
        Invoice invoice = new Invoice(101, customer, 200.0);
        //Print the customer and invoice details
        System.out.println(customer);
        System.out.println(invoice);
        //Print the amount after discount
        System.out.println("Amount after discount: " + invoice.getAmountAfterDiscount());
        
        System.out.println("-------------------------------------------------");
        System.out.println("TEST 3: CIRCLE - CYLINDER:");
        //Create Circle: r = 1.0, color = màu đỏ
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println("Area of circle: " + circle.getArea());
        //Create Cylinder: r = 1.0, h = 1.0, color = màu đỏ
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        System.out.println("Volume of cylinder: " + cylinder.getVolume());   
        
        System.out.println("-------------------------------------------------");
        System.out.println("TEST 4: PERSON - STUDENT - STAFF:");
        //Create Person object
        Person person = new Person("Alice", "123 Main St");
        System.out.println(person.toString());
        //Create Student object
        Student student = new Student("Bob", "456 Elm St", "Computer Science", 2, 15000.0);
        System.out.println(student.toString());
        //Create Staff object
        Staff staff = new Staff("Charlie", "789 Oak St", "Math Department", 50000.0);
        System.out.println(staff.toString());
    }
}
