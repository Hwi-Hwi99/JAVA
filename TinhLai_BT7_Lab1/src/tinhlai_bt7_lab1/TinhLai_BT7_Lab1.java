/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tinhlai_bt7_lab1;

import java.util.Scanner;

public class TinhLai_BT7_Lab1 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số tiền vay: ");
        double tienVay = input.nextDouble();
        System.out.print("Nhập thời hạn vay (năm): ");
        int thoiHan = input.nextInt();

        double laiSuatThang;
        double tienLaiThang;
        double tienGocThang;
        double tienHangThang;
        double tongTien;

        System.out.printf("%-15s %-25s %-1s%n", "Mức lãi suất:", "Số tiền hàng tháng:", "Tổng tiền trả:");

        for (double laiSuat = 5.0; laiSuat <= 8.0; laiSuat += 0.125)     
        {   
            laiSuatThang = laiSuat / 100 / 12;
            tienLaiThang = tienVay * laiSuatThang;
            tienGocThang = tienVay / thoiHan / 12;
            tienHangThang = tienGocThang + tienLaiThang;
            tongTien = tienHangThang * thoiHan * 12;

            System.out.printf("%-15.3f %-25.2f %-15.2f%n", laiSuat, tienHangThang, tongTien);
        }
        System.out.println();
        input.close();
    }
}
