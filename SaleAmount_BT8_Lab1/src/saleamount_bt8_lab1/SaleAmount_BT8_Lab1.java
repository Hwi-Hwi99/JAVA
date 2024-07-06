/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package saleamount_bt8_lab1;

public class SaleAmount_BT8_Lab1 
{    
    public static void main(String[] args) 
    {
        final double LUONG_CO_BAN = 5 * 12; // Lương cơ bản 1 năm ($5 mỗi tháng)
        final double MUC_TIEU_LUONG = 30000;
        final double MUC_TIEU_LUONG_THUC_TE = MUC_TIEU_LUONG - LUONG_CO_BAN; // Số tiền cần từ hoa hồng

        double soTienBanToiThieu = 0;
        double hoaHong = 0;
        double soTienBanHienTai = 0;

        while (soTienBanHienTai < MUC_TIEU_LUONG_THUC_TE) 
        {
            soTienBanToiThieu += 0.01;

            if (soTienBanToiThieu <= 5000) 
            {
                hoaHong = soTienBanToiThieu * 0.08;
            } 
            else if (soTienBanToiThieu <= 10000) 
            {
                hoaHong = 5000 * 0.08 + (soTienBanToiThieu - 5000) * 0.10;
            } 
            else 
            {
                hoaHong = 5000 * 0.08 + 5000 * 0.10 + (soTienBanToiThieu - 10000) * 0.12;
            }

            soTienBanHienTai = hoaHong;
        }

        System.out.printf("Số tiền bán hàng tối thiểu: $%.2f%n", soTienBanToiThieu);
        System.out.printf("Số tiền hoa hồng: $%.2f%n", hoaHong);
    }
}