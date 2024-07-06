/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpass;

public class TestPass 
{
    public static boolean isValidPassword(String password)
    {
        //khởi tạo giá trị mặc định là false
        boolean result = false;
        
        //kiếm tra null và độ dài
        if (password == null || password.length() < 8)
        {
            return result;
        }
       
        int digitCount = 0;//digitCount đếm số lượng chữ số
        
        //Duyệt từng ký tự
        for (int i = 0; i < password.length(); i++)
        {
            char c = password.charAt(i); //lấy từng ký tự
            
            //kiểm tra ký tự
            if (!Character.isLetterOrDigit(c)) { return result; } //nếu không phải số hoặc chữ
            if (Character.isDigit(c)) { digitCount++; } //nếu là chữ số => digitCount++
        }
        //kiểm tra số
        if (digitCount >= 2) { result = true;}
        return result;
    }
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String[] passwords = {"abc12345", "validPassword123", "passw0rd!", "short1", "noDigitHere", "12345678"};
        
        //kiểm tra từng nguồn mật 
        for (String pwd: passwords)
        {
           boolean result = isValidPassword(pwd);
           System.out.println("Mật khẩu: '" + pwd + "' hợp lệ không? =>" + result);
        }
    }
}