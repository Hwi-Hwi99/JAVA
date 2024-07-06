/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chiasolonnhat_bt3_lab1;

import java.util.Scanner;

public class ChiaSoLonNhat_BT3_Lab1 {

    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        //Yêu cầu nhập số nguyên n1, n2
        System.out.print("Nhập số nguyên n1: ");
        int n1 = input.nextInt();
        System.out.print("Nhập số nguyên n2: ");
        int n2 = input.nextInt();
        
        //số k chia hết cho cả 2
        int min = Math.min(n1, n2);
        int k = 1;
        for (int i = 1; i <= min; i++)
        {
            if (n1 % i == 0 && n2 % i == 0)
            { k = i; }
        }
        System.out.println("Số k lớn nất mà cả 2 số nguyên (n1, n2) chia hết: " + k);
    }
}
