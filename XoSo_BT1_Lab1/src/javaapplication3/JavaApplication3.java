/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.Scanner;

public class JavaApplication3 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        //Người chơi nhập số dự đoán
        System.out.print("Nhập số dự đoán (gồm 2 chữ số): ");
        int soNhap = input.nextInt();
        
        //Số ngẫu nhiên
        //int ranDom = (int) (Math.random() * 100);
        int ranDom = 95;
        
        //Lấy 2 chữ số hàng đơn vị và chục của số dự đoán và số ngẫu nhiên
        int soNhap1 = soNhap / 10;
        int soNhap2 = soNhap % 10;
        int ranDom1 = ranDom / 10;
        int ranDom2 = ranDom % 10;
        
        System.out.println("Số dự đoán là: " + soNhap1 + soNhap2);
        System.out.println("Kết quả số ngẫu nhiên là: " + ranDom1 + ranDom2);
        
        //Check if else
        if (soNhap == ranDom) {
            System.out.println("Chúc mừng bạn đã trúng giải $10.000");
        }
        else if (soNhap1 == ranDom2 && soNhap2 == ranDom1) {
            System.out.println("Chúc mừng bạn đã trúng giải $3000");
        }
        else if (soNhap1 == ranDom1 || soNhap1 == ranDom2 || soNhap2 == ranDom1 || soNhap2 == ranDom2) {
            System.out.println("Chúc mừng bạn đã trúng giải $1000");
        }
        else {
            System.out.println("Rất tiếc bạn không trúng thưởng.");
        }
    }
}
