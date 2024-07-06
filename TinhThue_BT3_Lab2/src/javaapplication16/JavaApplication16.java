/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication16;

import java.util.Scanner;

public class JavaApplication16 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập tình trạng nộp đơn (0: Độc thân, 1: Kết hôn / Goá, 2: Kết hôn khai riêng, 3: Chủ hộ): ");
        int trangThai = input.nextInt();
        System.out.print("Nhập thu nhập phải chịu thuế: $");
        float thuNhapChiThue = input.nextFloat();

        float tax = 0;
        
        switch (trangThai) 
        {
            case 0:
                if (thuNhapChiThue <= 8350) 
                {
                    tax = thuNhapChiThue * 0.1f;
                } 
                else if (thuNhapChiThue <= 33950) 
                {
                    tax = 8350 * 0.1f + (thuNhapChiThue - 8350) * 0.15f;
                } 
                else if (thuNhapChiThue <= 82250) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (thuNhapChiThue - 33950) * 0.25f;
                } 
                else if (thuNhapChiThue <= 171550) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (82250 - 33950) * 0.25f + (thuNhapChiThue - 82250) * 0.28f;
                } 
                else if (thuNhapChiThue <= 372950) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (82250 - 33950) * 0.25f + (171550 - 82250) * 0.28f + (thuNhapChiThue - 171550) * 0.33f;
                } 
                else 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (82250 - 33950) * 0.25f + (171550 - 82250) * 0.28f + (372950 - 171550) * 0.33f + (thuNhapChiThue - 372950) * 0.35f;
                }
                break;
            case 1:
                if (thuNhapChiThue <= 16700) 
                {
                    tax = thuNhapChiThue * 0.1f;
                } 
                else if (thuNhapChiThue <= 67900) 
                {
                    tax = 16700 * 0.1f + (thuNhapChiThue - 16700) * 0.15f;
                } 
                else if (thuNhapChiThue <= 137050) 
                {
                    tax = 16700 * 0.1f + (67900 - 16700) * 0.15f + (thuNhapChiThue - 67900) * 0.25f;
                } 
                else if (thuNhapChiThue <= 208850) 
                {
                    tax = 16700 * 0.1f + (67900 - 16700) * 0.15f + (137050 - 67900) * 0.25f + (thuNhapChiThue - 137050) * 0.28f;
                } 
                else if (thuNhapChiThue <= 372950) 
                {
                    tax = 16700 * 0.1f + (67900 - 16700) * 0.15f + (137050 - 67900) * 0.25f + (208850 - 137050) * 0.28f + (thuNhapChiThue - 208850) * 0.33f;
                } 
                else 
                {
                    tax = 16700 * 0.1f + (67900 - 16700) * 0.15f + (137050 - 67900) * 0.25f + (208850 - 137050) * 0.28f + (372950 - 208850) * 0.33f + (thuNhapChiThue - 372950) * 0.35f;
                }
                break;
            case 2:
                if (thuNhapChiThue <= 8350) 
                {
                    tax = thuNhapChiThue * 0.1f;
                } 
                else if (thuNhapChiThue <= 33950) 
                {
                    tax = 8350 * 0.1f + (thuNhapChiThue - 8350) * 0.15f;
                } 
                else if (thuNhapChiThue <= 68525) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (thuNhapChiThue - 33950) * 0.25f;
                } 
                else if (thuNhapChiThue <= 104425) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (68525 - 33950) * 0.25f + (thuNhapChiThue - 68525) * 0.28f;
                } 
                else if (thuNhapChiThue <= 186475) 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (68525 - 33950) * 0.25f + (104425 - 68525) * 0.28f + (thuNhapChiThue - 104425) * 0.33f;
                } 
                else 
                {
                    tax = 8350 * 0.1f + (33950 - 8350) * 0.15f + (68525 - 33950) * 0.25f + (104425 - 68525) * 0.28f + (186475 - 104425) * 0.33f + (thuNhapChiThue - 186475) * 0.35f;
                }
                break;
            case 3:
                if (thuNhapChiThue <= 11950) 
                {
                    tax = thuNhapChiThue * 0.1f;
                } 
                else if (thuNhapChiThue <= 45500) 
                {
                    tax = 11950 * 0.1f + (thuNhapChiThue - 11950) * 0.15f;
                } 
                else if (thuNhapChiThue <= 117450) 
                {
                    tax = 11950 * 0.1f + (45500 - 11950) * 0.15f + (thuNhapChiThue - 45500) * 0.25f;
                } 
                else if (thuNhapChiThue <= 190200) 
                {
                    tax = 11950 * 0.1f + (45500 - 11950) * 0.15f + (117450 - 45500) * 0.25f + (thuNhapChiThue - 117450) * 0.28f;
                } 
                else if (thuNhapChiThue <= 372950) 
                {
                    tax = 11950 * 0.1f + (45500 - 11950) * 0.15f + (117450 - 45500) * 0.25f + (190200 - 117450) * 0.28f + (thuNhapChiThue - 190200) * 0.33f;
                } 
                else 
                {
                    tax = 11950 * 0.1f + (45500 - 11950) * 0.15f + (117450 - 45500) * 0.25f + (190200 - 117450) * 0.28f + (372950 - 190200) * 0.33f + (thuNhapChiThue - 372950) * 0.35f;
                }
                break;
            default:
                System.out.println("Không thuộc các trạng thái trên!");
                return;
        }
        System.out.printf("Thuế thu nhập cá nhân = $%.2f%n", tax);
    }
}
