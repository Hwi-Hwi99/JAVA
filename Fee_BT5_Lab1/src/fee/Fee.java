/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fee;

public class Fee 
{    
    public static void main(String[] args) 
    {
        double feeHienTai = 10000;
        double percentIncreaseYear = 0.05;
        double fee10Years = feeHienTai;
        
        //Mảng lưu học phí hàng năm trong 15 năm
        double[] feeHangNam = new double[14];
        
        //Tính học phí cho từng năm và lưu
        for (int i = 0 ; i < 14; i++)
        {
            feeHangNam[i] = fee10Years;
            fee10Years *= (1 + percentIncreaseYear);
        }
        
        //Hiển thị học phí trong 10 năm đầu
        System.out.println("Học phí trong 14 năm đầu tiên: ");
        for (int i = 1; i < 14; i++)
        {
            System.out.printf("Năm %d: $%.2f%n", i + 1, feeHangNam[i]);
        }
        
        //Tổng chi phí của 4 năm từ năm thứ 11
        double tongFee4NamSauNamThu10 = sum(feeHangNam, 10, 13);
        System.out.printf("Tổng học phí của 4 năm đầu tiên bắt đầu từ năm thứ 11: $%.2f%n", tongFee4NamSauNamThu10);
    }
    
    public static double sum(double[] array, int start, int end)
    {
        double total = 0;
        for (int i = start; i <= end; i++)
        {
            total += array[i];
        }
        return total;
    }
}
