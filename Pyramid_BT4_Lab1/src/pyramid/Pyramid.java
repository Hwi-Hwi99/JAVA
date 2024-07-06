/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pyramid;

import java.util.Scanner;

public class Pyramid 
{    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n;
        
        //Nhập số nguyên từ 1 đến 15
        do
        {
            System.out.print("Nhập số nguyên từ 1 đến 15: ");
            n = input.nextInt();
        } while (n < 1 || n > 15); 
        
        //In Kim tự tháp
        for (int i = 1; i <= n; i++) //chạy từ 1 -> n tạo từng dòng
        {
            //Khoảng cách để căn giữa
            for (int j = n; j > i; j--) //khoảng trắng căn giữa kim tự tháp
            {
                System.out.print("  ");
            }
            
            //In dãy số từ i xuống 1
            for (int j = i; j >= 1; j--)
            {
                System.out.print(j + " ");
            }
            
            //In dãy số từ 2 đến i
            for (int j = 2; j <= i; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        input.close();
    }
}
