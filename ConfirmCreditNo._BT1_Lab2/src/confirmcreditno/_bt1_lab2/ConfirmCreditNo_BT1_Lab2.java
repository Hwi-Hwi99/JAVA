/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package confirmcreditno._bt1_lab2;


public class ConfirmCreditNo_BT1_Lab2 
{
    //Ktra số thẻ hợp lệ?
    public static boolean soTheHopLe(long soThe) 
    {
        if (!ktrDoDai(soThe) || !ktrTienTo(soThe)) { return false; }
        int sum = sumOfDoubleEvenPlace(soThe) + sumOfOddPlace(soThe);
        return sum % 10 == 0;
    }

    //Ktra độ dài số thẻ (13 - 16)
    public static boolean ktrDoDai(long soThe) 
    {
        int length = getSize(soThe);
        return length >= 13 && length <= 16;
    }

    //Ktra tiền tố số thẻ (bắt đầu bằng 4-5-37-6)
    public static boolean ktrTienTo(long soThe) 
    {
        return prefixMatched(soThe, 4) || prefixMatched(soThe, 5) || prefixMatched(soThe, 37) || prefixMatched(soThe, 6);
    }

    //Tổng các số vị trí chẵn * 2
    public static int sumOfDoubleEvenPlace(long soThe) 
    {
        int sum = 0;
        String numStr = Long.toString(soThe);
        for (int i = numStr.length() - 2; i >= 0; i -= 2) 
        {
            int num = Character.getNumericValue(numStr.charAt(i)) * 2; //Nhân đôi các chữ số ở vị trí chẵn (tính từ phải qua trái, bắt đầu từ vị trí thứ 2).
            sum += getDigit(num); //Tổng các chữ số của kết quả nhân đôi nếu nó lớn hơn hoặc bằng 10.
        }
        return sum;
    }

    //Lấy chữ số đơn từ kết quả nhân đôi
    public static int getDigit(int num) 
    {
        if (num < 9) { return num; } //Trả về chính số đó nếu nhỏ hơn 10
        return num / 10 + num % 10; //Cộng các chữ số lại nếu số đó lớn hơn hoặc bằng 10
    }

    //Tổng các số vị trí lẻ (tính từ phải qua trái, bắt đầu từ vị trí đầu tiên).
    public static int sumOfOddPlace(long soThe) 
    {
        int sum = 0;
        String numStr = Long.toString(soThe);
        for (int i = numStr.length() - 1; i >= 0; i -= 2) 
        {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return sum;
    }

    //Ktra tiền tố của số thẻ có khớp với d không?

    public static boolean prefixMatched(long number, int d) 
    {
        return getPrefix(number, getSize(d)) == d;
    }

    //Lấy độ dài (Trả về số chữ số của số d)
    public static int getSize(long d) 
    {
        return Long.toString(d).length();
    }

    //Lấy tiền tố
    public static long getPrefix(long number, int k) 
    {
        if (getSize(number) > k) //Lấy k chữ số đầu tiên của số number.
        {
            return Long.parseLong(Long.toString(number).substring(0, k));
        }
        return number; //Nếu số chữ số của number ít hơn hoặc bằng k, trả về chính số đó.
    }
    
    public static void main(String[] args) 
    {
        long soThe1 = 4388576018402626L;
        long soThe2 = 4388576018410707L;

        System.out.println("Số thẻ tín dụng (1): " + soThe1 + " là " + (soTheHopLe(soThe1) ? "Hợp lệ" : "Không hợp lệ"));
        System.out.println("Số thẻ tín dụng (2): " + soThe2 + " là " + (soTheHopLe(soThe2) ? "Hợp lệ" : "Không hợp lệ"));
    }
}
    