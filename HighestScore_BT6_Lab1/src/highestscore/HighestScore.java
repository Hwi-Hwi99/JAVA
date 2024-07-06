/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package highestscore;

import java.util.Scanner;
public class HighestScore
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        //Yêu cầu nhập số học sinh
        System.out.print("Nhập số lượng học sinh: ");
        int numberOfStudents = input.nextInt();
        
        //Biến để lưu tên và điểm của học sinh có điểm cao nhất
        String topStudentName = "";
        double topScore = -1; //khởi tạo giá trị nhỏ hơn điểm thấp nhất
        
        //Lặp qua từng học sinh để nhập thông tin và tìm highscore
        for (int i = 0; i < numberOfStudents; i++)
        {
            //Yêu cầu nhập tên hs
            System.out.print("Nhập họ và tên học sinh: ");
            String name = input.next();
            //Yêu cầu nhập điểm hs
            System.out.print("Nhập điểm của học sinh " + name + ": ");
            double score = input.nextDouble();
            
            //Kiểm tra điểm của hs hiện tại cao hơn điểm cao nhất hiện tại
            if (score > topScore)
            {
                topScore = score;
                topStudentName = name;
            }
        }
        
        //Hiển thị tên học sinh có điểm cao nhất
        System.out.println("Học sinh có điểm cao nhất là: " + topStudentName + " với điểm số là: " + topScore);
        input.close();
    }
}
