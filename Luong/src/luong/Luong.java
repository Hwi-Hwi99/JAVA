/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package luong;

import java.util.Scanner;

/**
 *
 * @author ddhmac
 */

public class Luong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

         // Nhập thông tin từ người dùng
        System.out.print("Nhập tên nhân viên: ");
        String tenNhanVien = input.nextLine();

        System.out.print("Nhập số giờ làm việc trong một tuần: ");
        double soGioLamViec = input.nextDouble();

        System.out.print("Nhập tỷ lệ thanh toán hàng giờ: ");
        double tyLeThanhToan = input.nextDouble();

        System.out.print("Nhập tỷ lệ khấu trừ thuế liên bang (phần trăm): ");
        double tyLeKhauTruLienBang = input.nextDouble();

        System.out.print("Nhập tỷ lệ khấu trừ thuế của tiểu bang (phần trăm): ");
        double tyLeKhauTruTieuBang = input.nextDouble();

        // Tính lương trước thuế
        double luongTruocThue = soGioLamViec * tyLeThanhToan;

        // Tính thuế liên bang và tiểu bang
        double thueLienBang = luongTruocThue * (tyLeKhauTruLienBang / 100);
        double thueTieuBang = luongTruocThue * (tyLeKhauTruTieuBang / 100);

        // Tính lương sau thuế
        double luongSauThue = luongTruocThue - thueLienBang - thueTieuBang;

         // In bảng sao kê
        System.out.println("\nBảng sao kê bảng lương");
        System.out.println("===============================");
        System.out.println("Tên nhân viên: " + tenNhanVien);
        System.out.println("Số giờ làm việc trong một tuần: " + soGioLamViec);
        System.out.println("Tỷ lệ thanh toán hàng giờ: $" + tyLeThanhToan);
        System.out.println("Lương trước thuế: $" + luongTruocThue);
        System.out.println("Thuế liên bang: $" + thueLienBang);
        System.out.println("Thuế của tiểu bang: $" + thueTieuBang);
        System.out.println("Lương sau thuế: $" + luongSauThue);
        System.out.println("===============================");
        
        input.close();
    }
    
}
