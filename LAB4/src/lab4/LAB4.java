/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4;

import java.util.Date;

public class LAB4 
{
    public static void main(String[] args) 
    {
        System.out.println("----------TESTING SHAPE----------");
        System.out.println("    CIRCLE:");
        Circle circle = new Circle(5.0, "blue", false);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("    RESIZABLECIRCLE:");
        ResizableCircle resizableCircle = new ResizableCircle(5.0);
        System.out.println(resizableCircle);
        resizableCircle.resize(50); // resize by 50%
        System.out.println("After resizing: " + resizableCircle);
        System.out.println("Area: " + resizableCircle.getArea());
        System.out.println("Perimeter: " + resizableCircle.getPerimeter());
        System.out.println("    RECTANGLE:");
        Rectangle rectangle = new Rectangle(2.0, 3.0, "green", true);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println("    SQUARE:");
        Square square = new Square(4.0, "yellow", false);
        System.out.println(square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("----------TESTING MOVABLE----------");
        MovableCircle circle1 = new MovableCircle(0, 0, 1, 1, 5);
        circle1.moveUp();
        circle1.moveRight();
        System.out.println("Circle position: (" + circle1.getX() + ", " + circle1.getY() + ")");
        System.out.println("Circle radius: " + circle1.getRadius());
        System.out.println("----------TESTING ANIMAL----------");
        Animal cat = new Cat("Whiskers");
        Animal dog = new Dog("Buddy");
        Animal bigDog = new BigDog("Max");
        cat.greets(); // Output: Whiskers says: Meow
        dog.greets(); // Output: Buddy says: Woof
        bigDog.greets(); // Output: Max says: Wooow
        Dog dog2 = new Dog("Fido");
        ((Dog) dog).greets(dog2); // Output: Buddy says: Woooof to Fido
        BigDog bigDog2 = new BigDog("Rocky");
        ((BigDog) bigDog).greets(bigDog2); // Output: Max says: Wooo000000w to Rocky
        Dog dog3 = new Dog("Ren");
        ((Dog) bigDog).greets(dog3); // Output: Max says: Woooooow to Ren
        System.out.println("----------TESTING CUSTOMER----------");
        DiscountRate discountRate = new DiscountRate();
        //Create customers and visits
        Customer customer1 = new Customer("Hiệp Đỗ");
        customer1.setMember(true);
        customer1.setMemberType("Gold");
        Visit visit1 = new Visit(customer1, new Date(), "Visit 1");
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);
        Customer customer2 = new Customer("Quang Huy");
        customer2.setMember(true);
        customer2.setMemberType("Premium");
        Visit visit2 = new Visit(customer2, new Date(), "Visit 2");
        visit2.setServiceExpense(150);
        visit2.setProductExpense(75);
        Customer customer3 = new Customer("Bảo Bảo");
        customer3.setMember(true);
        customer3.setMemberType("Silver");
        Visit visit3 = new Visit(customer3, new Date(), "Visit 3");
        visit3.setServiceExpense(200);
        visit3.setProductExpense(100);

        //Calculate and print discounts
        System.out.println("    Service Discounts:");
        System.out.println("Gold: " + discountRate.getServiceDiscountRate("Gold"));
        System.out.println("Premium: " + discountRate.getServiceDiscountRate("Premium"));
        System.out.println("Silver: " + discountRate.getServiceDiscountRate("Silver"));
        System.out.println("    Product Discounts:");
        System.out.println("Gold: " + discountRate.getProductDiscountRate("Gold"));
        System.out.println("Premium: " + discountRate.getProductDiscountRate("Premium"));
        System.out.println("Silver: " + discountRate.getProductDiscountRate("Silver"));
        //Print visit details
        System.out.println("    Visit Details:");
        System.out.println(visit1);
        System.out.println(visit2);
        System.out.println(visit3);
    }
}
